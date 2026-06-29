package org.webgpu.api;

import java.util.Arrays;

public enum CreatePipelineAsyncStatus {
    SUCCESS(0),
    VALIDATION_ERROR(1),
    INTERNAL_ERROR(2);

    private final int value;

    CreatePipelineAsyncStatus(int value) {
        this.value = value;
    }

    public int value() {
        return value;
    }

    public static CreatePipelineAsyncStatus fromValue(int value) {
        for (CreatePipelineAsyncStatus level : CreatePipelineAsyncStatus.values()) {
            if (level.value == value) {
                return level;
            }
        }
        throw new IllegalArgumentException("Invalid value: " + value + ". Must be one of: " + Arrays.toString(CreatePipelineAsyncStatus.values()));
    }
}
