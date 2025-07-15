package org.webgpu.api;

import java.util.Arrays;

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

    public int value() {
        return value;
    }

    public static QueueWorkDoneStatus fromValue(int value) {
        for (QueueWorkDoneStatus level : QueueWorkDoneStatus.values()) {
            if (level.value == value) {
                return level;
            }
        }
        throw new IllegalArgumentException("Invalid value: " + value + ". Must be one of: " + Arrays.toString(QueueWorkDoneStatus.values()));
    }

}