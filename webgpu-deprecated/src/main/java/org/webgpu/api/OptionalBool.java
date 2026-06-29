package org.webgpu.api;

import java.util.Arrays;

public enum OptionalBool {
    FALSE(0), TRUE(1), UNDEFINED(2);

    private final int value;

    OptionalBool(int value) {
        this.value = value;
    }

    public int value() {
        return value;
    }

    public static OptionalBool fromValue(int value) {
        for (OptionalBool level : OptionalBool.values()) {
            if (level.value == value) {
                return level;
            }
        }
        throw new IllegalArgumentException("Invalid value: " + value + ". Must be one of: " + Arrays.toString(OptionalBool.values()));
    }
}