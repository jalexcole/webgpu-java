package org.webgpu.api;

import org.webgpu.extract.webgpu_h;

public enum VertexStepMode {
    VERTEX_BUFFER_NOT_USED(0),
    UNDEFINED(webgpu_h.WGPUVertexStepMode_Undefined()),
    VERTEX(webgpu_h.WGPUVertexStepMode_Vertex()),
    INSTANCE(webgpu_h.WGPUVertexStepMode_Instance()),
    FORCE32(webgpu_h.WGPUVertexStepMode_Force32());

    private final int value;

    VertexStepMode(int value) {
        this.value = value;
    }

    public int value() {
        return value;
    }

    public static VertexStepMode fromValue(int value) {
        for (VertexStepMode mode : values()) {
            if (mode.value == value) {
                return mode;
            }
        }
        throw new IllegalArgumentException("Invalid value: " + value);
    }
}