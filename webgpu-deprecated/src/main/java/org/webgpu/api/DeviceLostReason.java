package org.webgpu.api;

import java.util.Arrays;

public enum DeviceLostReason {
    UNKNOWN(1), // 0x00000001
    DESTROYED(2), // 0x00000002
    CALLBACK_CANCELLED(3), // 0x00000003
    FAILED_CREATION(4), // 0x00000004
    FORCE32(0x7FFFFFFF); // 0x7FFFFFFF

    private final int value;

    DeviceLostReason(int value) {
        this.value = value;
    }

    public int value() {
        return value;
    }

    public static DeviceLostReason fromValue(int value) {
        for (DeviceLostReason level : DeviceLostReason.values()) {
            if (level.value == value) {
                return level;
            }
        }
        throw new IllegalArgumentException("Invalid value: " + value + ". Must be one of: " + Arrays.toString(DeviceLostReason.values()));
    }
}
