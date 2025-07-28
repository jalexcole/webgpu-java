package org.webgpu.impl;

import static org.webgpu.extract.webgpu_h.WGPUAdapter;
import static org.webgpu.extract.webgpu_h.WGPURequestAdapterStatus_Success;
import static org.webgpu.extract.webgpu_h.wgpuCreateInstance;
import static org.webgpu.extract.webgpu_h.wgpuInstanceCreateSurface;
import static org.webgpu.extract.webgpu_h.wgpuInstanceRelease;
import static org.webgpu.extract.webgpu_h.wgpuInstanceRequestAdapter;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.ValueLayout;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Future;
import java.util.logging.Logger;

import org.jspecify.annotations.Nullable;
import org.lwjgl.system.Pointer;
import org.webgpu.api.Adapter;
import org.webgpu.api.Instance;
import org.webgpu.api.PowerPreference;
import org.webgpu.api.RequestAdapterOptions;
import org.webgpu.api.RequestAdapterStatus;
import org.webgpu.api.WGPU;
import org.webgpu.exceptions.RequestAdaptorError;
import org.webgpu.extract.WGPUChainedStruct;
import org.webgpu.extract.WGPUInstanceDescriptor;
import org.webgpu.extract.WGPURequestAdapterCallback;
import org.webgpu.extract.WGPURequestAdapterCallbackInfo;
import org.webgpu.extract.WGPURequestAdapterOptions;
import org.webgpu.extract.WGPURequestDeviceCallback;
import org.webgpu.extract.WGPUSurfaceDescriptor;
import org.webgpu.util.StringView;

public record InstanceImpl(@SuppressWarnings("preview") MemorySegment ptr, @SuppressWarnings("preview") Arena arena)
        implements Instance {

    private static final Logger logger = Logger.getLogger(InstanceImpl.class.getName());
    // Shared map to track pending adapter requests by requestId
    private static final ConcurrentHashMap<Long, CompletableFuture<Adapter>> pendingAdapterRequests = new ConcurrentHashMap<>();

    @Override
    public void close() throws Exception {
        wgpuInstanceRelease(this.ptr());
    }

    @SuppressWarnings("preview")
    @Override
    public Future<Adapter> requestAdapter(@Nullable final RequestAdapterOptions options)
            throws RequestAdaptorError {

        final CompletableFuture<Adapter> futureAdapter = new CompletableFuture<>();
        final long requestId = java.util.concurrent.ThreadLocalRandom.current().nextLong();
        pendingAdapterRequests.put(requestId, futureAdapter);

        try {
            // Allocate userData1 in the instance's lifetime arena
            MemorySegment userData1Segment = arena.allocate(ValueLayout.JAVA_LONG);
            userData1Segment.set(ValueLayout.JAVA_LONG, 0, requestId);

            WGPURequestAdapterCallback.Function callback = (status, adapterPtr, messagePtr, userData1, userData2) -> {
                final long completedRequestId = userData1.get(ValueLayout.JAVA_LONG, 0);
                final CompletableFuture<Adapter> targetFuture = pendingAdapterRequests.remove(completedRequestId);

                if (targetFuture == null) {
                    logger.severe("Unknown request ID: " + completedRequestId);
                    return;
                }

                String message;
                try (Arena callbackArena = Arena.ofConfined()) {
                    message = (messagePtr != null && messagePtr.address() != 0)
                            ? new StringView(messagePtr).string()
                            : "(no message from native)";
                } catch (Exception ex) {
                    message = "(failed to extract message: " + ex.getMessage() + ")";
                }

                if (status == WGPURequestAdapterStatus_Success()) {
                    logger.info("Adapter received: " + message);
                    targetFuture.complete(new AdapterImpl(adapterPtr, arena));
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

            wgpuInstanceRequestAdapter(
                    arena,
                    this.ptr,
                    options != null ? options.ptr() : MemorySegment.NULL,
                    callbackInfo);

            return futureAdapter;

        } catch (Exception e) {
            pendingAdapterRequests.remove(requestId);
            futureAdapter.completeExceptionally(
                    new RuntimeException("Failed to setup native adapter request: " + e.getMessage(), e));
            return futureAdapter;
        }

    }

}
