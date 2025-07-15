package org.webgpu.api;

import java.util.Arrays;

public enum FrontFace {
    UNDEFINED(0),
    COUNTER_CLOCKWISE(1),
    CLOCKWISE(2),
    FORCE32(0x7FFFFFFF);

    private final int value;

    FrontFace(int value) {
        this.value = value;
    }

    public int value() {
        return value;
    }

    public static FrontFace fromValue(int value) {
        for (FrontFace level : FrontFace.values()) {
            if (level.value == value) {
                return level;
            }
        }
        throw new IllegalArgumentException("Invalid value: " + value + ". Must be one of: " + Arrays.toString(FrontFace.values()));
    }
}