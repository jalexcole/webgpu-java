package org.webgpu.api;

import org.webgpu.foreign.webgpu_h;

public enum TextureViewDimension {
    UNDEFINED(webgpu_h.WGPUTextureViewDimension_Undefined()),
    TWO_D(webgpu_h.WGPUTextureViewDimension_2D()),
    TWO_D_ARRAY(webgpu_h.WGPUTextureViewDimension_2DArray()),
    CUBE(webgpu_h.WGPUTextureViewDimension_Cube()),
    CUBE_ARRAY(webgpu_h.WGPUTextureViewDimension_CubeArray()),
    THREE_D(webgpu_h.WGPUTextureViewDimension_3D()),
    FORCE32(webgpu_h.WGPUTextureViewDimension_Force32());

    private final int value;

    TextureViewDimension(int value) {
        this.value = value;
    }

    public int value() {
        return value;
    }

    public static TextureViewDimension fromValue(int value) {
        for (TextureViewDimension dimension : values()) {
            if (dimension.value == value) {
                return dimension;
            }
        }
        throw new IllegalArgumentException("Invalid value: " + value);
    }
}