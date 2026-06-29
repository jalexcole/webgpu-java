package org.webgpu.api;

import org.webgpu.panama.foreign.webgpu_h;

public enum BufferMapState {
    UNMAPPED(webgpu_h.WGPUBufferMapState_Unmapped()),
    MAPPED(webgpu_h.WGPUBufferMapState_Mapped()),
    PENDING(webgpu_h.WGPUBufferMapState_Pending()),
    FORCE32(webgpu_h.WGPUBufferMapState_Force32());

    private final int value;

    BufferMapState(int value) {
        this.value = value;
    }

    public static BufferMapState fromValue(int value) {
        for (BufferMapState state : BufferMapState.values()) {
            if (state.value == value) {
                return state;
            }
        }
        return null;
    }

    public int value() {
        return value;
    }
}
