package org.webgpu.api;

import org.webgpu.foreign.webgpu_h;

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

    public int value() {
        return value;
    }

    public static TextureSampleType fromValue(int value) {
        for (TextureSampleType sampleType : values()) {
            if (sampleType.value == value) {
                return sampleType;
            }
        }
        throw new IllegalArgumentException("Invalid value: " + value);
    }
}