package org.webgpu.api;

import java.util.Arrays;

public enum RequestAdapterStatus {
    SUCCESS(1),
    CALLBACK_CANCELLED(2),
    UNAVAILABLE(3),
    ERROR(4);

    private final int value;

    RequestAdapterStatus(int value) {
        this.value = value;
    }

    public int value() {
        return value;
    }

    public static RequestAdapterStatus fromValue(int value) {
        for (RequestAdapterStatus level : RequestAdapterStatus.values()) {
            if (level.value == value) {
                return level;
            }
        }
        throw new IllegalArgumentException("Invalid value: " + value + ". Must be one of: " + Arrays.toString(RequestAdapterStatus.values()));
    }
}