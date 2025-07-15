package org.webgpu.api;

import java.util.Arrays;

public enum CompareFunction {
    UNDEFINED(0),
    NEVER(1),
    LESS(2),
    EQUAL(3),
    LESS_EQUAL(4),
    GREATER(5),
    NOT_EQUAL(6),
    GREATER_EQUAL(7),
    ALWAYS(8),
    FORCE32(0x7FFFFFFF);

    private final int value;

    CompareFunction(int value) {
        this.value = value;
    }

    public int value() {
        return value;
    }

    public static CompareFunction fromValue(int value) {
        for (CompareFunction level : CompareFunction.values()) {
            if (level.value == value) {
                return level;
            }
        }
        throw new IllegalArgumentException("Invalid value: " + value + ". Must be one of: " + Arrays.toString(CompareFunction.values()));
    }
}
