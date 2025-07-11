package org.webgpu.api;

import org.webgpu.extract.webgpu_h;

public enum BufferMapState {
    UNMAPPED(webgpu_h.WGPUBufferMapState_Unmapped()),
    MAPPED(webgpu_h.WGPUBufferMapState_Mapped()),
    PENDING(webgpu_h.WGPUBufferMapState_Pending()),
    FORCE32(webgpu_h.WGPUBufferMapState_Force32());

    private final int value;

    BufferMapState(int value) {
        this.value = value;
    }

    public static BufferMapState set(int value) {
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
