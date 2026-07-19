package org.webgpu.impl;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;
import java.util.WeakHashMap;

import org.jspecify.annotations.NullMarked;
import org.webgpu.api.Adapter;
import org.webgpu.api.AdapterInfo;
import org.webgpu.api.CallbackMode;
import org.webgpu.api.DeviceDescriptor;
import org.webgpu.api.FeatureName;
import org.webgpu.api.Limits;
import org.webgpu.api.RequestDevice;
import org.webgpu.api.RequestDeviceStatus;
import org.webgpu.api.Status;
import org.webgpu.api.SupportedFeatures;
import org.webgpu.impl.util.StringViewMapper;
import org.webgpu.impl.util.StructTools;
import org.webgpu.panama.WGPURequestDeviceCallback;
import org.webgpu.panama.WGPURequestDeviceCallbackInfo;
import org.webgpu.panama.webgpu_h;

@NullMarked
public final class AdapterImpl implements Adapter, WebGPUObjectImpl {

    private final MemorySegment memorySegment;
    private final Arena arena = Arena.ofAuto();

    private final WeakHashMap<MemorySegment, DeviceImpl> deviceCache = new WeakHashMap<>();

    public AdapterImpl(MemorySegment memorySegment) {
        this.memorySegment = memorySegment;
    }

    @Override
    public Status getLimits(Limits limits) {
        final MemorySegment limitsSegment = StructTools.fetchSegment(limits);
        final int statusCode = webgpu_h.wgpuAdapterGetLimits(this.memorySegment, limitsSegment);
        return Status.values()[statusCode];
    }

    @Override
    public boolean hasFeature(FeatureName feature) {
        return webgpu_h.wgpuAdapterHasFeature(this.memorySegment, feature.value()) == webgpu_h.WGPU_TRUE();
    }

    @Override
    public void getFeatures(SupportedFeatures features) {
        final var featuresPtr = StructTools.fetchSegment(features);
        webgpu_h.wgpuAdapterGetFeatures(this.memorySegment, featuresPtr);
    }

    @Override
    public Status getInfo(AdapterInfo info) {
        final var adapterInfo = StructTools.fetchSegment(info);
        final var statusCode = webgpu_h.wgpuAdapterGetInfo(this.memorySegment, adapterInfo);
        return Status.values()[statusCode];
    }

    public MemorySegment ptr() {
        return this.memorySegment;
    }

    @Override
    public void requestDevice(RequestDevice callback, DeviceDescriptor descriptor) {

        final var deviceDescriptor = StructTools.fetchSegment(descriptor);

        final var callbackInfo = WGPURequestDeviceCallbackInfo.allocate(arena);

        WGPURequestDeviceCallback.Function nativeCallback = (int status, MemorySegment device, MemorySegment message,
                MemorySegment userdata1, MemorySegment userdata2) -> {

            final RequestDeviceStatus statusEnum = RequestDeviceStatus.values()[status];
            final DeviceImpl deviceImpl = new DeviceImpl(device); // Create a DeviceImpl instance with the provided
                                                                  // device
                                                                  // MemorySegment
            deviceCache.put(device, deviceImpl); // Cache the DeviceImpl instance for future use
            callback.apply(statusEnum, deviceImpl, StringViewMapper.map(message));

        };

        WGPURequestDeviceCallbackInfo.mode(callbackInfo, CallbackMode.ALLOW_PROCESS_EVENTS.value());
        
        WGPURequestDeviceCallbackInfo.callback(callbackInfo, WGPURequestDeviceCallback.allocate(nativeCallback, arena));

        webgpu_h.wgpuAdapterRequestDevice(arena, this.memorySegment, deviceDescriptor, callbackInfo);

    }

    public DeviceImpl getCachedDevice(MemorySegment deviceSegment) {
        return deviceCache.get(deviceSegment);
    }

	@Override
	public String toString() {
		return "AdapterImpl [memorySegment=" + memorySegment + "]";
	}
}
