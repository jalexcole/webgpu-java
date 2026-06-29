package org.webgpu.api;

import java.util.Arrays;

public enum CompilationInfoRequestStatus {
    SUCCESS(1),
    CALLBACK_CANCELLED(2);

    private final int value;

    CompilationInfoRequestStatus(int value) {
        this.value = value;
    }

    public int value() {
        return value;
    }

    public static CompilationInfoRequestStatus fromValue(int value) {
        for (CompilationInfoRequestStatus level : CompilationInfoRequestStatus.values()) {
            if (level.value == value) {
                return level;
            }
        }
        throw new IllegalArgumentException("Invalid value: " + value + ". Must be one of: " + Arrays.toString(CompilationInfoRequestStatus.values()));
    }
}
