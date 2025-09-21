package org.webgpu.api;

import java.util.Arrays;

import org.webgpu.panama.foreign.webgpu_h;

public enum PrimitiveTopology {
    UNDEFINED(webgpu_h.WGPUPrimitiveTopology_Undefined()),
    POINT_LIST(webgpu_h.WGPUPrimitiveTopology_PointList()),
    LINE_LIST(webgpu_h.WGPUPrimitiveTopology_LineList()),
    LINE_STRIP(webgpu_h.WGPUPrimitiveTopology_LineStrip()),
    TRIANGLE_LIST(webgpu_h.WGPUPrimitiveTopology_TriangleList()),
    TRIANGLE_STRIP(webgpu_h.WGPUPrimitiveTopology_TriangleStrip()),
    FORCE32(webgpu_h.WGPUPrimitiveTopology_Force32());

    private final int value;

    PrimitiveTopology(int value) {
        this.value = value;
    }

    public int value() {
        return value;
    }

    public static PrimitiveTopology fromValue(int value) {
        for (PrimitiveTopology level : PrimitiveTopology.values()) {
            if (level.value == value) {
                return level;
            }
        }
        throw new IllegalArgumentException(
                "Invalid value: " + value + ". Must be one of: " + Arrays.toString(PrimitiveTopology.values()));
    }
}