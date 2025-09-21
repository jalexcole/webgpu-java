package org.webgpu.api;

import org.webgpu.foreign.webgpu_h;

public enum ErrorFilter {
    VALIDATION(webgpu_h.WGPUErrorFilter_Validation()),
    OUT_OF_MEMORY(webgpu_h.WGPUErrorFilter_OutOfMemory()),
    INTERNAL(webgpu_h.WGPUErrorFilter_Internal()),
    FORCE32(webgpu_h.WGPUErrorFilter_Force32());

    private final int value;

    ErrorFilter(int value) {
        this.value = value;
    }

    public int value() {
        return value;
    }
}
