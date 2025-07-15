package org.webgpu.api;

import java.util.Arrays;

public enum IndexFormat {

    UNDEFINED(0),
    UINT16(1),
    UINT32(2);

    private int value;

    IndexFormat(int value) {
        this.value = value;
    }

    public int value() {
        return value;
    }

    public static IndexFormat fromValue(int value) {
        for (IndexFormat level : IndexFormat.values()) {
            if (level.value == value) {
                return level;
            }
        }
        throw new IllegalArgumentException("Invalid value: " + value + ". Must be one of: " + Arrays.toString(IndexFormat.values()));
    }
    
}