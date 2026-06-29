package org.webgpu.api;

import java.util.Arrays;

public enum CullMode {
    UNDEFINED(0),
    NONE(1),
    FRONT(2),
    BACK(3),
    FORCE32(0x7FFFFFFF);

    private final int value;

    CullMode(int value) {
        this.value = value;
    }

    public int value() {
        return value;
    }

    public static CullMode fromValue(int value) {
        for (CullMode level : CullMode.values()) {
            if (level.value == value) {
                return level;
            }
        }
        throw new IllegalArgumentException("Invalid value: " + value + ". Must be one of: " + Arrays.toString(CullMode.values()));
    }
}
