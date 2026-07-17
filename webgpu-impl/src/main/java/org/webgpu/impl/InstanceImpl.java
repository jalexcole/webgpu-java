package org.webgpu.impl;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;
import java.util.Objects;

import org.jspecify.annotations.NullMarked;
import org.webgpu.api.CallbackMode;
import org.webgpu.api.FutureWaitInfo;
import org.webgpu.api.Instance;
import org.webgpu.api.InstanceDescriptor;
import org.webgpu.api.RequestAdapter;
import org.webgpu.api.RequestAdapterOptions;
import org.webgpu.api.RequestAdapterStatus;
import org.webgpu.api.SupportedWGSLLanguageFeatures;
import org.webgpu.api.SurfaceDescriptor;
import org.webgpu.api.WGSLLanguageFeatureName;
import org.webgpu.api.WaitStatus;
import org.webgpu.impl.util.StringViewMapper;
import org.webgpu.impl.util.StructTools;
import org.webgpu.panama.WGPURequestAdapterCallback;
import org.webgpu.panama.WGPURequestAdapterCallbackInfo;
import org.webgpu.panama.webgpu_h;

@NullMarked
public class InstanceImpl implements Instance {

    private final MemorySegment memorySegment;

    @SuppressWarnings("null")
    private final Arena arena = Arena.ofShared();

    public InstanceImpl(InstanceDescriptor descriptor) {
        this.memorySegment = webgpu_h.wgpuCreateInstance(StructTools.fetchSegment(descriptor));
    }

    @Override
    public SurfaceImpl createSurface(SurfaceDescriptor descriptor) {
        final var descriptorPtr = StructTools.fetchSegment(descriptor);
        final var surfacePtr = webgpu_h.wgpuInstanceCreateSurface(this.memorySegment, descriptorPtr);
        Objects.requireNonNull(surfacePtr);
        return new SurfaceImpl(surfacePtr);
    }

    @Override
    public void getWGSLLanguageFeatures(SupportedWGSLLanguageFeatures features) {
        final var featuresPtr = StructTools.fetchSegment(features);
        webgpu_h.wgpuInstanceGetWGSLLanguageFeatures(this.memorySegment, featuresPtr);
    }

    @Override
    public boolean hasWGSLLanguageFeature(WGSLLanguageFeatureName feature) {
        return webgpu_h.wgpuInstanceHasWGSLLanguageFeature(memorySegment, feature.value()) == webgpu_h.WGPU_TRUE();
    }

    @Override
    public void processEvents() {
        webgpu_h.wgpuInstanceProcessEvents(memorySegment);
    }

    @Override
    public void requestAdapter(RequestAdapter callback, RequestAdapterOptions options) {
        var requestAdapterOptions = StructTools.fetchSegment(options);

        var callbackInfo = WGPURequestAdapterCallbackInfo.allocate(arena);

        WGPURequestAdapterCallback.Function nativeCallback = (int status, MemorySegment adapter, MemorySegment message,
                MemorySegment userdata1, MemorySegment userdata2) -> {
            RequestAdapterStatus statusEnum = RequestAdapterStatus.values()[status];
            var adapterImpl = new AdapterImpl(adapter); // Create an AdapterImpl instance with the provided adapter
                                                        // MemorySegment

            callback.apply(statusEnum, adapterImpl, StringViewMapper.map(message));

        };

        var callbackSegment = WGPURequestAdapterCallback.allocate(nativeCallback, arena);

        WGPURequestAdapterCallbackInfo.callback(callbackInfo, callbackSegment);
        WGPURequestAdapterCallbackInfo.nextInChain(callbackInfo, MemorySegment.NULL);
        WGPURequestAdapterCallbackInfo.mode(callbackInfo, CallbackMode.WAIT_ANY_ONLY.value()); // Assuming 0 is

        WGPURequestAdapterCallbackInfo.userdata1(callbackInfo, MemorySegment.NULL);
        WGPURequestAdapterCallbackInfo.userdata2(callbackInfo, MemorySegment.NULL);

        webgpu_h.wgpuInstanceRequestAdapter(arena, this.memorySegment, requestAdapterOptions, callbackInfo);
    }

    @Override
    public WaitStatus waitAny(long futureCount, FutureWaitInfo futures, long timeoutNS) {
        final var futuresPtr = StructTools.fetchSegment(futures);
        final var waitStatusCode = webgpu_h.wgpuInstanceWaitAny(this.memorySegment, futureCount, futuresPtr, timeoutNS);
        
        return WaitStatus.values()[waitStatusCode];
    }

}
