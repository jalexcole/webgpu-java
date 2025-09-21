package org.webgpu.api;

import org.webgpu.foreign.webgpu_h;

public enum AdapterType {
    DISCRETE_GPU(webgpu_h.WGPUAdapterType_DiscreteGPU()),
    INTEGRATED_GPU(webgpu_h.WGPUAdapterType_IntegratedGPU()),
    CPU(webgpu_h.WGPUAdapterType_CPU()),
    UNKNOWN(webgpu_h.WGPUAdapterType_Unknown()),
    FORCE32(webgpu_h.WGPUAdapterType_Force32());

    private final int value;

    AdapterType(int value) {
        this.value = value;
    }

    public int value() {
        return value;
    }
}
