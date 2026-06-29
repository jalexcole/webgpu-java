package org.webgpu.api;

import java.util.Arrays;

public enum BlendOperation {
    UNDEFINED(0),
    ADD(1),
    SUBTRACT(2),
    REVERSE_SUBTRACT(3),
    MIN(4),
    MAX(5),
    FORCE32(0x7FFFFFFF);

    private final int value;

    BlendOperation(int value) {
        this.value = value;
    }

    public int value() {
        return value;
    }

    public static BlendOperation fromValue(int value) {
        for (BlendOperation level : BlendOperation.values()) {
            if (level.value == value) {
                return level;
            }
        }
        throw new IllegalArgumentException("Invalid value: " + value + ". Must be one of: " + Arrays.toString(BlendOperation.values()));
    }
}
