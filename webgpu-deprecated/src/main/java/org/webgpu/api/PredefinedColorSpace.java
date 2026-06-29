package org.webgpu.api;

import java.util.Arrays;

public enum PredefinedColorSpace {
    SRGB(1),
    DISPLAY_P3(2);

    private final int value;

    PredefinedColorSpace(int value) {
        this.value = value;
    }

    public int value() {
        return value;
    }

    public static PredefinedColorSpace fromValue(int value) {
        for (PredefinedColorSpace level : PredefinedColorSpace.values()) {
            if (level.value == value) {
                return level;
            }
        }
        throw new IllegalArgumentException("Invalid value: " + value + ". Must be one of: " + Arrays.toString(PredefinedColorSpace.values()));
    }


}