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
            // Shared map to track pending adapter requests by requestId
    private static final ConcurrentHashMap<Long, CompletableFuture<Adapter>> pendingAdapterRequests = new ConcurrentHashMap<>();
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

        CompletableFuture<Adapter> futureAdapter = new CompletableFuture<>();
        long requestId = System.nanoTime(); // Generate unique request ID
        pendingAdapterRequests.put(requestId, futureAdapter);

        try {
            // Arena must outlive the request — allocated from instance's lifetime arena
            MemorySegment userData1Segment = arena.allocate(ValueLayout.JAVA_LONG);
            userData1Segment.set(ValueLayout.JAVA_LONG, 0, requestId);

            WGPURequestAdapterCallback.Function callback = (status, adapterPtr, messagePtr, userData1, userData2) -> {
                long completedRequestId = userData1.get(ValueLayout.JAVA_LONG, 0);
                CompletableFuture<Adapter> targetFuture = pendingAdapterRequests.remove(completedRequestId);

                if (targetFuture == null) {
                    logger.severe("Unknown request ID: " + completedRequestId);
                    return;
                }

                String message;
                try (Arena callbackArena = Arena.ofConfined()) {
                    message = (messagePtr != null && messagePtr.address() != 0)
                            ? new StringView(messagePtr).string()
                            : "(no message from native)";
                }

                if (status == 0) {
                    logger.info("Adapter received: " + message);
                    targetFuture.complete(new AdapterImpl(adapterPtr));
                } else {
                    String err = "Failed to request adapter: " + message;
                    logger.severe(err);
                    targetFuture.completeExceptionally(new RequestAdaptorError(err));
                }
            };

            MemorySegment nativeCallback = WGPURequestAdapterCallback.allocate(callback, arena);
            MemorySegment callbackInfo = WGPURequestAdapterCallbackInfo.allocate(arena);

            WGPURequestAdapterCallbackInfo.nextInChain(callbackInfo, MemorySegment.NULL);
            WGPURequestAdapterCallbackInfo.mode(callbackInfo, 0); // 0 = WGPUCallbackMode_Asynchronous
            WGPURequestAdapterCallbackInfo.callback(callbackInfo, nativeCallback);
            WGPURequestAdapterCallbackInfo.userdata1(callbackInfo, userData1Segment);
            WGPURequestAdapterCallbackInfo.userdata2(callbackInfo, MemorySegment.NULL);

            webgpu_h.wgpuInstanceRequestAdapter(arena, this.ptr, options.ptr(), callbackInfo);

            return futureAdapter;

        } catch (Exception e) {
            pendingAdapterRequests.remove(requestId);
            futureAdapter.completeExceptionally(
                    new RuntimeException("Failed to setup native adapter request: " + e.getMessage(), e));
            return futureAdapter;
        }

    }
    
    public static void main(String[] args) throws RequestAdaptorError, InterruptedException, ExecutionException {
        var instance = WGPU.createInstance(null);
        var adapterFuture = instance.requestAdapter(null);
        adapterFuture.get();
    }

}
