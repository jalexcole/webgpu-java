package org.webgpu.api;

import org.webgpu.foreign.webgpu_h;

public enum StencilOperation {
    UNDEFINED(webgpu_h.WGPUStencilOperation_Undefined()),
    KEEP(webgpu_h.WGPUStencilOperation_Keep()),
    ZERO(webgpu_h.WGPUStencilOperation_Zero()),
    REPLACE(webgpu_h.WGPUStencilOperation_Replace()),
    INVERT(webgpu_h.WGPUStencilOperation_Invert()),
    INCREMENT_CLAMP(webgpu_h.WGPUStencilOperation_IncrementClamp()),
    DECREMENT_CLAMP(webgpu_h.WGPUStencilOperation_DecrementClamp()),
    INCREMENT_WRAP(webgpu_h.WGPUStencilOperation_IncrementWrap()),
    DECREMENT_WRAP(webgpu_h.WGPUStencilOperation_DecrementWrap()),
    FORCE32(webgpu_h.WGPUStencilOperation_Force32());

    private final int value;

    StencilOperation(int value) {
        this.value = value;
    }

    public int value() {
        return value;
    }

    public static StencilOperation fromValue(int value) {
        for (StencilOperation operation : values()) {
            if (operation.value == value) {
                return operation;
            }
        }
        throw new IllegalArgumentException("Invalid value: " + value);
    }
}