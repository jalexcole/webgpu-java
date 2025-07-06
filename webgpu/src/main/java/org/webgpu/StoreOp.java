package org.webgpu;

import org.webgpu.extract.webgpu_h;

public enum StoreOp {
    UNDEFINED(webgpu_h.WGPUStoreOp_Undefined()),
    STORE(webgpu_h.WGPUStoreOp_Store()),
    DISCORD(webgpu_h.WGPUStoreOp_Discard()),
    FORCE32(webgpu_h.WGPUStoreOp_Force32());

    private final int value;

    StoreOp(int value) {
        this.value = value;
    }
}