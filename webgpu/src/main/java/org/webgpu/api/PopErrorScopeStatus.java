package org.webgpu.api;

import java.util.Arrays;

public enum PopErrorScopeStatus {
    SUCCESS(1),
    CALLBACK_CANCELLED(2),
    ERROR(3);

    private final int value;

    PopErrorScopeStatus(int value) {
        this.value = value;
    }

    public int value() {
        return value;
    }

    public static PopErrorScopeStatus fromValue(int value) {
        for (PopErrorScopeStatus level : PopErrorScopeStatus.values()) {
            if (level.value == value) {
                return level;
            }
        }
        throw new IllegalArgumentException("Invalid value: " + value + ". Must be one of: " + Arrays.toString(PopErrorScopeStatus.values()));
    }
}