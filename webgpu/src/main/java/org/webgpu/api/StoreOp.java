package org.webgpu.api;

import org.webgpu.panama.foreign.webgpu_h;

public enum StoreOp {
    UNDEFINED(webgpu_h.WGPUStoreOp_Undefined()),
    STORE(webgpu_h.WGPUStoreOp_Store()),
    DISCARD(webgpu_h.WGPUStoreOp_Discard()),
    FORCE32(webgpu_h.WGPUStoreOp_Force32());

    private final int value;

    StoreOp(int value) {
        this.value = value;
    }

    public int value() {
        return value;
    }

    public static StoreOp fromValue(int value) {
        for (StoreOp op : values()) {
            if (op.value == value) {
                return op;
            }
        }
        throw new IllegalArgumentException("Invalid value: " + value);
    }
}