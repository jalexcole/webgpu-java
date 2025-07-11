package org.webgpu.api;

import org.webgpu.extract.webgpu_h;

public enum RequestDeviceStatus {
    SUCCESS(webgpu_h.WGPURequestDeviceStatus_Success()),
    // INSTANCE_DROPPED(webgpu_h.WGPURequestDeviceStatus_InstanceDropped()),
    ERROR(webgpu_h.WGPURequestDeviceStatus_Error()),
    // UNKNOWN(webgpu_h.WGPURequestDeviceStatus_()),
                    
    FORCE32(webgpu_h.WGPURequestDeviceStatus_Force32());

    private final int value;

    RequestDeviceStatus(int value) {
        this.value = value;
    }
}