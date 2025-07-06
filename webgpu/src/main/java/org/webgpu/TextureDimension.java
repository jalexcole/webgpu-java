package org.webgpu;

import org.webgpu.extract.webgpu_h;

public enum TextureDimension {
    UNDEFINED(webgpu_h.WGPUTextureDimension_Undefined()),
    ONE_D(webgpu_h.WGPUTextureDimension_1D()),
    TWO_D(webgpu_h.WGPUTextureDimension_2D()),
    THREE_D(webgpu_h.WGPUTextureDimension_3D()),
    FORCE32(webgpu_h.WGPUTextureDimension_Force32());

    private final int value;

    TextureDimension(int value) {
        this.value = value;
    }
}