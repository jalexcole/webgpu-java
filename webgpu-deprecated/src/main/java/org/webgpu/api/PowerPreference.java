package org.webgpu.api;

import java.util.Arrays;

public enum PowerPreference {
    UNDEFINED(0),
    LOW_POWER(1),
    HIGH_PERFORMANCE(2),
    FORCE32(0x7FFFFFFF)
    ;


    private final int value;

    PowerPreference(int value) {
        this.value = value;
    }

    int value() {
        return this.value;
    }
    
    public static PowerPreference fromValue(int value) {
        for (PowerPreference level : PowerPreference.values()) {
            if (level.value == value) {
                return level;
            }
        }
        throw new IllegalArgumentException("Invalid value: " + value + ". Must be one of: " + Arrays.toString(PowerPreference.values()));
    }
    
}