package org.webgpu.api;

import java.util.Arrays;

public enum CompilationMessageType {
    ERROR(0),
    WARNING(1),
    INFO(2);

    private final int value;

    CompilationMessageType(int value) {
        this.value = value;
    }

    public int value() {
        return value;
    }

    public static CompilationMessageType fromValue(int value) {
        for (CompilationMessageType level : CompilationMessageType.values()) {
            if (level.value == value) {
                return level;
            }
        }
        throw new IllegalArgumentException("Invalid value: " + value + ". Must be one of: " + Arrays.toString(CompilationMessageType.values()));
    }
}
