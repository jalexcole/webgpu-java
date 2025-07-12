package org.webgpu.impl;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.ValueLayout;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.logging.Logger;

import org.jspecify.annotations.Nullable;

import org.webgpu.api.Adapter;
import org.webgpu.api.Instance;
import org.webgpu.api.RequestAdapterOptions;
import org.webgpu.api.WGPU;
import org.webgpu.exceptions.RequestAdaptorError;
import org.webgpu.extract.WGPURequestAdapterCallback;
import org.webgpu.extract.WGPURequestAdapterCallbackInfo;
import org.webgpu.extract.webgpu_h;
import org.webgpu.util.StringView;

public record InstanceImpl(@SuppressWarnings("preview") MemorySegment ptr, @SuppressWarnings("preview") Arena arena)
        implements Instance {

    private static final Logger logger = Logger.getLogger(InstanceImpl.class.getName());

    @Override
    public void close() throws Exception {
        webgpu_h.wgpuInstanceRelease(this.ptr());
    }

    @SuppressWarnings("preview")
    @Override
    public Future<Adapter> requestAdapter(@Nullable RequestAdapterOptions options) throws RequestAdaptorError {
        if (options == null) {
            options = new RequestAdapterOptions();
        }
        final ConcurrentHashMap<Long, CompletableFuture<Adapter>> pendingAdapterRequests = new ConcurrentHashMap<>();

        // Create a CompletableFuture that will be completed by the native callback
        CompletableFuture<Adapter> futureAdapter = new CompletableFuture<>();
        
        try { // This arena is for the setup of the request.

            // Generate a unique ID to link the callback to this specific Future
            long requestId = System.nanoTime(); // Simple unique ID, or use UUID.randomUUID().getMostSignificantBits()

            // Store the future in our map, associated with the unique ID
            pendingAdapterRequests.put(requestId, futureAdapter);

            WGPURequestAdapterCallback.Function myAdapterCallback = (status, adapterPtr, messagePtr, userData1,
                    userData2) -> {

                @SuppressWarnings("preview")
                long completedRequestId = userData1.get(ValueLayout.JAVA_LONG, 0); // Read the long from the
                                                                                   // MemorySegment

                // Remove the future from the map as it's being completed
                CompletableFuture<Adapter> targetFuture = pendingAdapterRequests.remove(completedRequestId);

                if (targetFuture == null) {
                    logger.severe("Received callback for unknown request ID: " + completedRequestId);
                    // This could happen if the future was already cancelled or completed by other
                    // means.
                    return;
                }

                String message = "";

                try (@SuppressWarnings("preview")
                Arena arena = Arena.ofConfined()) {
                    message = new StringView(messagePtr).string();
                }

                if (status == 0) { // Assuming 0 means success for WGPUStatus
                    logger.fine("Adapter successfully requested! Message: " + message);
                    // Wrap the native adapter pointer in your Java Adapter object
                    Adapter adapter = new AdapterImpl(adapterPtr); // Assuming Adapter constructor takes MemorySegment
                    targetFuture.complete(adapter); // Complete the Future successfully
                } else {
                    String errorMessage = "Failed to request adapter: " + message;
                    logger.severe(errorMessage);
                    targetFuture.completeExceptionally(new RequestAdaptorError(errorMessage)); // Complete the Future with
                                                                                               // an error
                }
            };

            // 2. Allocate the native stub for our Java callback within the request setup
            // arena
            @SuppressWarnings("preview")
            MemorySegment nativeCallbackPtr = WGPURequestAdapterCallback.allocate(myAdapterCallback, arena);
            System.out.println("Allocated native callback pointer: " + nativeCallbackPtr);

            // 3. Allocate space for the WGPURequestAdapterCallbackInfo struct
            @SuppressWarnings("preview")
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
            @SuppressWarnings("preview")
            MemorySegment userData1Segment = arena.allocate(ValueLayout.JAVA_LONG);
            userData1Segment.set(ValueLayout.JAVA_LONG, 0, requestId);
            WGPURequestAdapterCallbackInfo.userdata1(callbackInfoStruct, userData1Segment);
            System.out.println("Set userdata1 (requestId) to: " + requestId + " at " + userData1Segment);

            // Set 'userdata2' to NULL or another relevant context
            WGPURequestAdapterCallbackInfo.userdata2(callbackInfoStruct, MemorySegment.NULL);
            System.out.println("Set userdata2 to NULL.");

            
            webgpu_h.wgpuInstanceRequestAdapter(arena, this.ptr, options.ptr(), callbackInfoStruct);
            System.out.println("Called wgpuInstanceRequestAdapter natively.");

            
            return futureAdapter;

        } catch (Exception e) {
            // If an error occurs during the setup of the native call, complete the Future
            // exceptionally.
            futureAdapter.completeExceptionally(
                    new RuntimeException("Failed to setup native adapter request: " + e.getMessage(), e));
            return futureAdapter; // Return the now-completed-exceptionally future
        }

    }
    
    public static void main(String[] args) throws RequestAdaptorError, InterruptedException, ExecutionException {
        var instance = WGPU.createInstance(null);
        var adapterFuture = instance.requestAdapter(null);
        adapterFuture.get();
    }

}
