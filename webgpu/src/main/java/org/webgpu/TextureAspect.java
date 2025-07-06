package org.webgpu;

import org.webgpu.extract.webgpu_h;

public enum TextureAspect {
    UNDEFINED(webgpu_h.WGPUTextureAspect_Undefined()),
    ALL(webgpu_h.WGPUTextureAspect_All()),
    STENCIL_ONLY(webgpu_h.WGPUTextureAspect_StencilOnly()),
    DEPTH_ONLY(webgpu_h.WGPUTextureAspect_DepthOnly()),
    FORCE32(webgpu_h.WGPUTextureAspect_Force32());

    public final int value;

    TextureAspect(int value) {
        this.value = value;
    }
}