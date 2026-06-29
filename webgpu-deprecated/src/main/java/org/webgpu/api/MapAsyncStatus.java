package org.webgpu.api;

import java.util.Arrays;

public enum MapAsyncStatus {
    SUCCESS(1),
    CALLBACK_CANCELLED(2),
    ERROR(3),
    ABORTED(4);

    private final int value;

    MapAsyncStatus(int value) {
        this.value = value;
    }

    public int value() {
        return value;
    }

    public static MapAsyncStatus fromValue(int value) {
        for (MapAsyncStatus level : MapAsyncStatus.values()) {
            if (level.value == value) {
                return level;
            }
        }
        throw new IllegalArgumentException(
                "Invalid value: " + value + ". Must be one of: " + Arrays.toString(MapAsyncStatus.values()));
        
    }
}