package org.webgpu.api;

import java.util.Arrays;

public enum LoadOp {
    UNDEFINED(0),
    LOAD(1),
    CLEAR(2);

    private final int value;

    LoadOp(int value) {
        this.value = value;
    }

    public int value() {
        return value;
    }

    public static LoadOp fromValue(int value) {
        for (LoadOp level : LoadOp.values()) {
            if (level.value == value) {
                return level;
            }
        }
        throw new IllegalArgumentException("Invalid value: " + value + ". Must be one of: " + Arrays.toString(LoadOp.values()));
    }
}