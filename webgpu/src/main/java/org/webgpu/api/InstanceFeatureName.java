package org.webgpu.api;

import java.util.Arrays;

public enum InstanceFeatureName {
    TIME_WAIT_ANY(1),
    SHADER_SOURCE_SPIRV(2),
    MILTIPLE_DEVICES_PER_ADAPTER(3);
    
    private final int value;

    InstanceFeatureName(int value) {
        this.value = value;
    }

    public int value() {
        return value;
    }

    public static InstanceFeatureName fromValue(int value) {
        for (InstanceFeatureName level : InstanceFeatureName.values()) {
            if (level.value == value) {
                return level;
            }
        }
        throw new IllegalArgumentException("Invalid value: " + value + ". Must be one of: " + Arrays.toString(InstanceFeatureName.values()));
    }
    
}