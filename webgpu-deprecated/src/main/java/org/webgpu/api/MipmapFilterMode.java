package org.webgpu.api;

import java.util.Arrays;

public enum MipmapFilterMode {
    UNDEFINED(0),
    NEAREST(1),
    LINEAR(2);

    private final int value;

    MipmapFilterMode(int value) {
        this.value = value;
    }

    public int value() {
        return value;
    }

    public static MipmapFilterMode fromValue(int value) {
        for (MipmapFilterMode level : MipmapFilterMode.values()) {
            if (level.value == value) {
                return level;
            }
        }
        throw new IllegalArgumentException("Invalid value: " + value + ". Must be one of: " + Arrays.toString(MipmapFilterMode.values()));
    }
}