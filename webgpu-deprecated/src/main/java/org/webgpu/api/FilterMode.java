package org.webgpu.api;

import java.util.Arrays;

public enum FilterMode {
    UNDEFINED(0),
    NEAREST(1),
    LINEAR(2),
    FORCE32(0x7FFFFFFF);

    private final int value;

    FilterMode(int value) {
        this.value = value;
    }

    public int value() {
        return value;
    }

    public static FilterMode fromValue(int value) {
        for (FilterMode level : FilterMode.values()) {
            if (level.value == value) {
                return level;
            }
        }
        throw new IllegalArgumentException("Invalid value: " + value + ". Must be one of: " + Arrays.toString(FilterMode.values()));
    }
}
