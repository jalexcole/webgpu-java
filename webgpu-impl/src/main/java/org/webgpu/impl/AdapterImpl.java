package org.webgpu.impl;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.ValueLayout;
import java.util.WeakHashMap;

import org.webgpu.api.Adapter;
import org.webgpu.api.AdapterInfo;
import org.webgpu.api.BackendType;
import org.webgpu.api.DeviceDescriptor;
import org.webgpu.api.FeatureName;
import org.webgpu.api.Limits;
import org.webgpu.api.RequestDevice;
import org.webgpu.api.RequestDeviceStatus;
import org.webgpu.api.Status;
import org.webgpu.api.SupportedFeatures;
import org.webgpu.impl.util.LimitsMapper;
import org.webgpu.impl.util.StringViewMapper;
import org.webgpu.panama.WGPUAdapterInfo;
import org.webgpu.panama.WGPUDeviceDescriptor;
import org.webgpu.panama.WGPULimits;
import org.webgpu.panama.WGPURequestDeviceCallback;
import org.webgpu.panama.WGPURequestDeviceCallbackInfo;
import org.webgpu.panama.webgpu_h;

public final class AdapterImpl implements Adapter, WebGPUObjectImpl {

    private final MemorySegment memorySegment;
    private final Arena arena = Arena.ofAuto();

    private final WeakHashMap<MemorySegment, DeviceImpl> deviceCache = new WeakHashMap<>();

    public AdapterImpl(MemorySegment memorySegment) {
        this.memorySegment = memorySegment;
    }

    @Override
    public Status getLimits(Limits limits) {
        final MemorySegment limitsSegment = WGPULimits.allocate(arena);
        final int statusCode = webgpu_h.wgpuAdapterGetLimits(this.memorySegment, limitsSegment);
        final Status status = Status.values()[statusCode];

        if (status != Status.SUCCESS) {
            return status;
        }

        var maxBindGroups = WGPULimits.maxBindGroups(limitsSegment);
        var maxDynamicUniformBuffersPerPipelineLayout = WGPULimits
                .maxDynamicUniformBuffersPerPipelineLayout(limitsSegment);
        var maxDynamicStorageBuffersPerPipelineLayout = WGPULimits
                .maxDynamicStorageBuffersPerPipelineLayout(limitsSegment);
        var maxSampledTexturesPerShaderStage = WGPULimits.maxSampledTexturesPerShaderStage(limitsSegment);
        var maxSamplersPerShaderStage = WGPULimits.maxSamplersPerShaderStage(limitsSegment);
        var maxStorageBuffersPerShaderStage = WGPULimits.maxStorageBuffersPerShaderStage(limitsSegment);
        var maxStorageTexturesPerShaderStage = WGPULimits.maxStorageTexturesPerShaderStage(limitsSegment);
        var maxUniformBuffersPerShaderStage = WGPULimits.maxUniformBuffersPerShaderStage(limitsSegment);
        var maxUniformBufferBindingSize = WGPULimits.maxUniformBufferBindingSize(limitsSegment);
        var maxStorageBufferBindingSize = WGPULimits.maxStorageBufferBindingSize(limitsSegment);
        var maxVertexBuffers = WGPULimits.maxVertexBuffers(limitsSegment);
        var maxVertexAttributes = WGPULimits.maxVertexAttributes(limitsSegment);
        var maxVertexBufferArrayStride = WGPULimits.maxVertexBufferArrayStride(limitsSegment);

        limits.maxBindGroups(maxBindGroups);
        limits.maxDynamicUniformBuffersPerPipelineLayout(maxDynamicUniformBuffersPerPipelineLayout);
        limits.maxDynamicStorageBuffersPerPipelineLayout(maxDynamicStorageBuffersPerPipelineLayout);
        limits.maxSampledTexturesPerShaderStage(maxSampledTexturesPerShaderStage);
        limits.maxSamplersPerShaderStage(maxSamplersPerShaderStage);
        limits.maxStorageBuffersPerShaderStage(maxStorageBuffersPerShaderStage);
        limits.maxStorageTexturesPerShaderStage(maxStorageTexturesPerShaderStage);
        limits.maxUniformBuffersPerShaderStage(maxUniformBuffersPerShaderStage);
        limits.maxUniformBufferBindingSize(maxUniformBufferBindingSize);
        limits.maxStorageBufferBindingSize(maxStorageBufferBindingSize);
        limits.maxVertexBuffers(maxVertexBuffers);
        limits.maxVertexAttributes(maxVertexAttributes);
        limits.maxVertexBufferArrayStride(maxVertexBufferArrayStride);










        return status;
    }

    @Override
    public boolean hasFeature(FeatureName feature) {
        return webgpu_h.wgpuAdapterHasFeature(this.memorySegment, feature.value()) == webgpu_h.WGPUOptionalBool_True();
    }

    @Override
    public void getFeatures(SupportedFeatures features) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getFeatures'");
    }

    @Override
    public Status getInfo(AdapterInfo info) {
        final var adapterInfo = WGPUAdapterInfo.allocate(arena);

        var status = Status.values()[webgpu_h.wgpuAdapterGetInfo(this.memorySegment, adapterInfo)];

        if (status != Status.SUCCESS) {
            return status;
        }

        final var nextInChain = WGPUAdapterInfo.nextInChain(adapterInfo);

        final var architecture = WGPUAdapterInfo.architecture(adapterInfo);
        final var backendType = WGPUAdapterInfo.backendType(adapterInfo);
        final var deviceID = WGPUAdapterInfo.deviceID(adapterInfo);
        final var description = WGPUAdapterInfo.description(adapterInfo);
        final var device = WGPUAdapterInfo.device(adapterInfo);
        final var subgroupMaxSize = WGPUAdapterInfo.subgroupMaxSize(adapterInfo);
        final var vendor = WGPUAdapterInfo.vendor(adapterInfo);
        final var vendorID = WGPUAdapterInfo.vendorID(adapterInfo);

        info.architecture(StringViewMapper.map(architecture));
        info.backendType(BackendType.values()[backendType]);
        info.deviceID(deviceID);
        info.description(StringViewMapper.map(description));
        info.device(StringViewMapper.map(device));
        info.subgroupMaxSize(subgroupMaxSize);
        info.vendor(StringViewMapper.map(vendor));
        info.vendorID(vendorID);

        return status;
    }

    public MemorySegment ptr() {
        return this.memorySegment;
    }

    @Override
    public void requestDevice(RequestDevice callback, DeviceDescriptor descriptor) {
        final var deviceDescriptor = WGPUDeviceDescriptor.allocate(arena);
        WGPUDeviceDescriptor.nextInChain(deviceDescriptor, MemorySegment.NULL);
        WGPUDeviceDescriptor.label(deviceDescriptor, StringViewMapper.map(descriptor.label(), arena));
        WGPUDeviceDescriptor.requiredFeatureCount(deviceDescriptor, descriptor.requiredFeatures().length);
        final FeatureName[] features = descriptor.requiredFeatures();

        final var featureSegment = arena.allocate(ValueLayout.JAVA_LONG, features.length);
        WGPUDeviceDescriptor.requiredFeatures(deviceDescriptor, featureSegment);
        for (int i = 0; i < descriptor.requiredFeatures().length; i++) {
            featureSegment.setAtIndex(ValueLayout.JAVA_LONG, i, features[i].value());
        }

        final var limits = LimitsMapper.map(descriptor.requiredLimits(), arena);

        WGPUDeviceDescriptor.requiredLimits(deviceDescriptor, limits);

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

        WGPURequestDeviceCallbackInfo.callback(callbackInfo, WGPURequestDeviceCallback.allocate(nativeCallback, arena));

        webgpu_h.wgpuAdapterRequestDevice(arena, this.memorySegment, deviceDescriptor, callbackInfo);

    }

    public DeviceImpl getCachedDevice(MemorySegment deviceSegment) {
        return deviceCache.get(deviceSegment);
    }

}
