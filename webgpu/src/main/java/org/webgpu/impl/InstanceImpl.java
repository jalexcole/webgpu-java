package org.webgpu.impl;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.ValueLayout;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Future;


import org.jspecify.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.webgpu.api.Adapter;
import org.webgpu.api.Instance;
import org.webgpu.api.RequestAdapterOptions;
import org.webgpu.extract.WGPURequestAdapterCallback;
import org.webgpu.extract.WGPURequestAdapterCallbackInfo;
import org.webgpu.extract.webgpu_h;
import org.webgpu.util.StringView;
public record InstanceImpl(MemorySegment ptr, Arena arena) implements Instance {

    private static final Logger logger = LoggerFactory.getLogger(InstanceImpl.class);
    
    @Override
    public void close() throws Exception {
        webgpu_h.wgpuInstanceRelease(this.ptr());
    }

    @Override
    public Future<Adapter> requestAdapter(@Nullable RequestAdapterOptions options) {
        if (options == null) {
            options = new RequestAdapterOptions();
        }
        final ConcurrentHashMap<Long, CompletableFuture<Adapter>> pendingAdapterRequests = new ConcurrentHashMap<>();

        // Create a CompletableFuture that will be completed by the native callback
        CompletableFuture<Adapter> futureAdapter = new CompletableFuture<>();

        // We need an Arena that lives until the native call is made AND the callback struct is consumed.
        // For the callback itself, its native stub needs to be accessible when invoked.
        // It's crucial that the `arena` used to allocate `callbackInfoStruct` and `nativeCallbackPtr`
        // remains alive until the native library has finished using the callback.
        // If `wgpuInstanceRequestAdapter` immediately copies the info, a confined arena might be fine.
        // If it holds onto it, you'd need a shared or longer-lived arena, or explicit management.
        // For simplicity, let's assume `wgpuInstanceRequestAdapter` consumes the info synchronously
        // and that the callback itself can use its own arena if it needs to process data.

        // The best practice here for long-lived callbacks (if the native library holds onto the pointer)
        // is to use `Arena.ofShared()` or have a higher-level Arena manager.
        // For this example, let's proceed with `Arena.ofConfined()` for the setup struct,
        // and ensure the CompletableFuture handles the result. The callback itself will
        // implicitly run in a context where `Arena.global()` could be used if it needs temporary memory,
        // or its own confined arena if it needs more persistent allocations for its immediate processing.

        try { // This arena is for the setup of the request.

            // Generate a unique ID to link the callback to this specific Future
            long requestId = System.nanoTime(); // Simple unique ID, or use UUID.randomUUID().getMostSignificantBits()

            // Store the future in our map, associated with the unique ID
            pendingAdapterRequests.put(requestId, futureAdapter);

            WGPURequestAdapterCallback.Function myAdapterCallback = (status, adapterPtr, messagePtr, userData1, userData2) -> {
                // IMPORTANT: This callback is invoked by a native thread.
                // Any operations touching Java objects (like `CompletableFuture`) must be thread-safe.

                // Retrieve the requestId from userData1.
                // Assuming userData1 is a MemorySegment pointing to a long containing the requestId.
                // Or if we passed the requestId directly as an int/long in the struct if the binding supports it.
                // Let's assume userData1 is the requestId itself, as a MemorySegment representing a long.
                long completedRequestId = userData1.get(ValueLayout.JAVA_LONG, 0); // Read the long from the MemorySegment

                // Remove the future from the map as it's being completed
                CompletableFuture<Adapter> targetFuture = pendingAdapterRequests.remove(completedRequestId);

                if (targetFuture == null) {
                    logger.warn("Received callback for unknown request ID: " + completedRequestId);
                    // This could happen if the future was already cancelled or completed by other means.
                    return;
                }

                String message = "N/A";
                try {
                     // The messagePtr likely points to a native C string.
                     // Use a StringView (or StringViewConverter.stringFromNative) to safely convert.
                     // The arena for this conversion should be temporary (confined) or global.
                     try (Arena tempArena = Arena.ofConfined()) {
                         // stringFromNative would read the native char* and convert it.
                         // Assume messagePtr is a char*
                         // You need a helper function that takes a char* and its length
                         // or iterates until null terminator.
                         message = new StringView(messagePtr).string(); // Or use your StringView directly if it handles char*
                     }
                } catch (Exception e) {
                    logger.error("Error converting native message to String: " + e.getMessage());
                    message = "Error decoding message: " + e.getMessage();
                }


                if (status == 0) { // Assuming 0 means success for WGPUStatus
                    logger.debug("Adapter successfully requested! Message: " + message);
                    // Wrap the native adapter pointer in your Java Adapter object
                    Adapter adapter = new AdapterImpl(adapterPtr); // Assuming Adapter constructor takes MemorySegment
                    targetFuture.complete(adapter); // Complete the Future successfully
                } else {
                    String errorMessage = "Failed to request adapter: " + message;
                    logger.error(errorMessage);
                    targetFuture.completeExceptionally(new RuntimeException(errorMessage)); // Complete the Future with an error
                }
            };

            // 2. Allocate the native stub for our Java callback within the request setup arena
            MemorySegment nativeCallbackPtr = WGPURequestAdapterCallback.allocate(myAdapterCallback, arena);
            System.out.println("Allocated native callback pointer: " + nativeCallbackPtr);

            // 3. Allocate space for the WGPURequestAdapterCallbackInfo struct
            MemorySegment callbackInfoStruct = WGPURequestAdapterCallbackInfo.allocate(arena);
            System.out.println("Allocated WGPURequestAdapterCallbackInfo struct at: " + callbackInfoStruct);

            // 4. Set the fields of the WGPURequestAdapterCallbackInfo struct

            // For 'nextInChain', typically NULL if not chaining structs
            WGPURequestAdapterCallbackInfo.nextInChain(callbackInfoStruct, MemorySegment.NULL);
            System.out.println("Set nextInChain to NULL.");

            // Set the 'mode' (WGPUCallbackMode_Asynchronous is usually 0)
            int WGPUCallbackMode_Asynchronous = 0; // Placeholder value, use actual enum if available
            WGPURequestAdapterCallbackInfo.mode(callbackInfoStruct, WGPUCallbackMode_Asynchronous);
            System.out.println("Set mode to " + WGPUCallbackMode_Asynchronous);

            // Set the 'callback' field with our native callback pointer
            WGPURequestAdapterCallbackInfo.callback(callbackInfoStruct, nativeCallbackPtr);
            System.out.println("Set callback field with our native pointer.");

            // Set 'userdata1' to pass the requestId.
            // We need to allocate a MemorySegment to hold this long.
            MemorySegment userData1Segment = arena.allocate(ValueLayout.JAVA_LONG);
            userData1Segment.set(ValueLayout.JAVA_LONG, 0, requestId);
            WGPURequestAdapterCallbackInfo.userdata1(callbackInfoStruct, userData1Segment);
            System.out.println("Set userdata1 (requestId) to: " + requestId + " at " + userData1Segment);

            // Set 'userdata2' to NULL or another relevant context
            WGPURequestAdapterCallbackInfo.userdata2(callbackInfoStruct, MemorySegment.NULL);
            System.out.println("Set userdata2 to NULL.");

            // 5. Make the actual native WebGPU call
            // This function takes the instance, options, and the callback info struct
            // It typically returns void for asynchronous operations, or some status code.
            // Assuming webgpu_h.wgpuInstanceRequestAdapter does not return a future pointer directly,
            // but rather takes the callback info for async completion.
            webgpu_h.wgpuInstanceRequestAdapter(arena, this.ptr, options.ptr(), callbackInfoStruct);
            System.out.println("Called wgpuInstanceRequestAdapter natively.");

            // Return the CompletableFuture immediately. It will be completed later by the callback.
            return futureAdapter;

        } catch (Exception e) {
            // If an error occurs during the setup of the native call, complete the Future exceptionally.
            futureAdapter.completeExceptionally(new RuntimeException("Failed to setup native adapter request: " + e.getMessage(), e));
            return futureAdapter; // Return the now-completed-exceptionally future
        }
        
    }

}
