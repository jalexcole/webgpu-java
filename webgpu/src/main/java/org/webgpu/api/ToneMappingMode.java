package org.webgpu.api;

import org.webgpu.extract.webgpu_h;

public enum ToneMappingMode {
    STANDARD(webgpu_h.WGPUToneMappingMode_Standard()),
    EXTENDED(webgpu_h.WGPUToneMappingMode_Extended());

    private final int value;

    ToneMappingMode(int value) {
        this.value = value;
    }

    public int value() {
        return value;
    }

    public static ToneMappingMode fromValue(int value) {
        for (ToneMappingMode mode : values()) {
            if (mode.value == value) {
                return mode;
            }
        }
        throw new IllegalArgumentException("Invalid value: " + value);
    }
}

