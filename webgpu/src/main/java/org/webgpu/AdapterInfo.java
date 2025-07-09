package org.webgpu;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;

import org.webgpu.extract.WGPUAdapterInfo;

public class AdapterInfo {
    private MemorySegment adapterInfoPtr;

    AdapterInfo(MemorySegment adapterInfoPtr) {
        this.adapterInfoPtr = adapterInfoPtr;
    }

    public AdapterInfo() {
        try (Arena allocator = Arena.ofConfined()) {
            adapterInfoPtr = WGPUAdapterInfo.allocate(allocator);
        }
    }

    public MemorySegment ptr() {
        return adapterInfoPtr;
    }

    public String vendor() {
        return new StringView(WGPUAdapterInfo.vendor(adapterInfoPtr)).string();
    }

    public String architecture() {
        return new StringView(WGPUAdapterInfo.architecture(adapterInfoPtr)).string();
    }

    public String device() {
        return new StringView(WGPUAdapterInfo.device(adapterInfoPtr)).string();
    }

    public String description() {
        return new StringView(WGPUAdapterInfo.description(adapterInfoPtr)).string();
    }

    public BackendType backendType() {
        var backendType = WGPUAdapterInfo.backendType(adapterInfoPtr);

        if (backendType == BackendType.UNDEFINED.value()) {
            return BackendType.UNDEFINED;
        } else if (backendType == BackendType.WEBGPU.value()) {
            return BackendType.WEBGPU;
        } else if (backendType == BackendType.D3D11.value()) {
            return BackendType.D3D11;
        } else if (backendType == BackendType.D3D12.value()) {
            return BackendType.D3D12;
        } else if (backendType == BackendType.Metal.value()) {
            return BackendType.Metal;
        } else if (backendType == BackendType.Vulkan.value()) {
            return BackendType.Vulkan;
        }

        return BackendType.NULL;
    }

    public AdapterType adapterType() {
        return AdapterType.values()[WGPUAdapterInfo.adapterType(adapterInfoPtr)];
    }

    public int vendorId() {
        return WGPUAdapterInfo.vendorID(adapterInfoPtr);
    }

    public int deviceId() {
        return WGPUAdapterInfo.deviceID(adapterInfoPtr);
    }
}