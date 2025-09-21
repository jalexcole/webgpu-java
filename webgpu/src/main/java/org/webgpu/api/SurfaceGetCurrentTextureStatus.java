package org.webgpu.api;

import org.webgpu.panama.foreign.webgpu_h;

public enum SurfaceGetCurrentTextureStatus {
    SUCCESS_OPTIMAL(webgpu_h.WGPUSurfaceGetCurrentTextureStatus_SuccessOptimal()),
    SUCCESS_SUBOPTIMAL(webgpu_h.WGPUSurfaceGetCurrentTextureStatus_SuccessSuboptimal()),
    TIMEOUT(webgpu_h.WGPUSurfaceGetCurrentTextureStatus_Timeout()),
    OUTDATED(webgpu_h.WGPUSurfaceGetCurrentTextureStatus_Outdated()),
    LOST(webgpu_h.WGPUSurfaceGetCurrentTextureStatus_Lost()),
    ERROR(webgpu_h.WGPUSurfaceGetCurrentTextureStatus_Error()),
    FORCE32(webgpu_h.WGPUSurfaceGetCurrentTextureStatus_Force32());

    private final int value;

    SurfaceGetCurrentTextureStatus(int value) {
        this.value = value;
    }

    public int value() {
        return value;
    }

    public static SurfaceGetCurrentTextureStatus fromValue(int value) {
        for (SurfaceGetCurrentTextureStatus status : values()) {
            if (status.value == value) {
                return status;
            }
        }
        throw new IllegalArgumentException("Invalid value: " + value);
    }
}