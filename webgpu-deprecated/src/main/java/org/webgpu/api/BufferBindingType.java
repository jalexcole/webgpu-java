package org.webgpu.api;

import java.util.Arrays;

public enum BufferBindingType {
    BINDING_NOT_USED(0),
            UNDEFINED(1), UNIFORM(2), STORAGE(3), FORCE32(0x7FFFFFFF);

    private final int value;

    BufferBindingType(int value) {
        this.value = value;
    }

    public int value() {
        return value;
    }

    public static BufferBindingType fromValue(int value) {
        for (BufferBindingType level : BufferBindingType.values()) {
            if (level.value == value) {
                return level;
            }
        }
        throw new IllegalArgumentException("Invalid value: " + value + ". Must be one of: " + Arrays.toString(BufferBindingType.values()));
    }
}
