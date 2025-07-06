package org.webgpu;

import org.webgpu.extract.webgpu_h;

public enum QueueWorkDoneStatus {
    SUCCESS(webgpu_h.WGPUQueueWorkDoneStatus_Success()),
    // INSTANCE_DROPPED(webgpu_h.WGPUQueueWorkDoneStatus_InstanceDropped()),
    ERROR(webgpu_h.WGPUQueueWorkDoneStatus_Error()),

    // UNKNOWN(webgpu_h.WGPUQueueWorkDoneStatus_Unknown()),
    FORCE32(webgpu_h.WGPUQueueWorkDoneStatus_Force32());
            
    private final int value;

    QueueWorkDoneStatus(int value) {
        this.value = value;
    }

}