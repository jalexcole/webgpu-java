package org.webgpu;

import org.webgpu.extract.webgpu_h;

public enum Status {
    Success(webgpu_h.WGPUStatus_Success()),
    Error(webgpu_h.WGPUStatus_Error()),
    Force32(webgpu_h.WGPUStatus_Force32());

    private final int value;

    Status(int value) {
        this.value = value;
    }

    public int value() {
        return value;
    }
}