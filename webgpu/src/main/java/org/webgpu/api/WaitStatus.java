package org.webgpu.api;

import org.webgpu.extract.webgpu_h;

public enum WaitStatus {
    SUCCESS(webgpu_h.WGPUWaitStatus_Success()),
    TIMED_OUT(webgpu_h.WGPUWaitStatus_TimedOut()),
    ERROR(webgpu_h.WGPUWaitStatus_Error());

    private final int value;

    WaitStatus(int value) {
        this.value = value;
    }

    public int value() {
        return value;
    }

    public static WaitStatus fromValue(int value) {
        for (WaitStatus waitStatus : WaitStatus.values()) {
            if (waitStatus.value == value) {
                return waitStatus;
            }
        }
        return null;
    }

}