package org.webgpu.api;

import java.lang.foreign.MemorySegment;

import org.webgpu.foreign.webgpu_h;

public enum SampleBindingType {
    BINDING_NOT_USED(webgpu_h.WGPUSamplerBindingType_BindingNotUsed()),
    UNDEFINED(webgpu_h.WGPUSamplerBindingType_Undefined()),
    FILTERING(webgpu_h.WGPUSamplerBindingType_Filtering()),
    NON_FILTERING(webgpu_h.WGPUSamplerBindingType_NonFiltering()),
    COMPARISON(webgpu_h.WGPUSamplerBindingType_Comparison()),
    FORCE32(webgpu_h.WGPUSamplerBindingType_Force32());

    private final int value;

    SampleBindingType(int value) {
        this.value = value;
    }

    public int value() {
        return value;
    }

    public static SampleBindingType fromValue(int value) {
        for (SampleBindingType type : values()) {
            if (type.value == value) {
                return type;
            }
        }
        throw new IllegalArgumentException("Invalid value: " + value);
    }
    
}