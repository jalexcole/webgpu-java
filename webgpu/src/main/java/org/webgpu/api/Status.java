package org.webgpu.api;

import org.webgpu.extract.webgpu_h;

public enum Status {
    SUCCESS(webgpu_h.WGPUStatus_Success()),
    ERROR(webgpu_h.WGPUStatus_Error()),
    Force32(webgpu_h.WGPUStatus_Force32());

    private final int value;

    Status(int value) {
        this.value = value;
    }

    public int value() {
        return value;
    }

    public static Status fromValue(int value) {
        for (Status status : values()) {
            if (status.value == value) {
                return status;
            }
        }
        throw new IllegalArgumentException("Invalid value: " + value);
    }
}