package org.webgpu.api;

import java.util.Arrays;

import org.webgpu.extract.webgpu_h;

public enum FeatureLevel {
    UNDEFINED(webgpu_h.WGPUFeatureLevel_Undefined()),
    COMPATIBILITY(webgpu_h.WGPUFeatureLevel_Compatibility()),
    CORE(webgpu_h.WGPUFeatureLevel_Core()),
    FORCE32(webgpu_h.WGPUFeatureLevel_Force32());
    

    private int value;

    FeatureLevel(int value) {
        this.value = value;
    }

    int value() {
        return this.value;
    }
    
    private static FeatureLevel fromValue(int value) {
        for (FeatureLevel level : FeatureLevel.values()) {
            if (level.value == value) {
                return level;
            }
        }
        throw new IllegalArgumentException("Invalid value: " + value + ". Must be one of: " + Arrays.toString(FeatureLevel.values()));
    }

}
