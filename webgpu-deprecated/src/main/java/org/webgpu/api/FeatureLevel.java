package org.webgpu.api;

import java.util.Arrays;

import org.webgpu.panama.foreign.webgpu_h;

public enum FeatureLevel {
    UNDEFINED(0),
    COMPATIBILITY(webgpu_h.WGPUFeatureLevel_Compatibility()),
    CORE(webgpu_h.WGPUFeatureLevel_Core()),
    FORCE32(webgpu_h.WGPUFeatureLevel_Force32());

    private final int value;

    FeatureLevel(int value) {
        this.value = value;
    }

    int value() {
        return this.value;
    }

    public static FeatureLevel fromValue(int value) {
        for (FeatureLevel level : FeatureLevel.values()) {
            if (level.value == value) {
                return level;
            }
        }
        throw new IllegalArgumentException(
                "Invalid value: " + value + ". Must be one of: " + Arrays.toString(FeatureLevel.values()));
    }

}
