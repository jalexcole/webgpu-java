package org.webgpu;

import org.webgpu.extract.webgpu_h;

public enum TextureSampleType {
    BINDING_NOT_USED(webgpu_h.WGPUTextureSampleType_BindingNotUsed()),
    UNDEFINED(webgpu_h.WGPUTextureSampleType_Undefined()),
    FLOAT(webgpu_h.WGPUTextureSampleType_Float()),
    UNFILTERABLE_FLOAT(webgpu_h.WGPUTextureSampleType_UnfilterableFloat()),
    DEPTH(webgpu_h.WGPUTextureSampleType_Depth()),
    S_INT(webgpu_h.WGPUTextureSampleType_Sint()),
    U_INT(webgpu_h.WGPUTextureSampleType_Uint()),
    FORCE32(webgpu_h.WGPUTextureSampleType_Force32());

    private final int value;

    TextureSampleType(int value) {
        this.value = value;
    }
}