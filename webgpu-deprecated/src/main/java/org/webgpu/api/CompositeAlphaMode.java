package org.webgpu.api;

import java.util.Arrays;

public enum CompositeAlphaMode {
    AUTO(0),
    Opaque(1),
    Premultiplied(2),
    UNPREMULTIPLIED(3);

    private final int value;

    CompositeAlphaMode(int value) {
        this.value = value;
    }

    public int value() {
        return value;
    }

    public static CompositeAlphaMode fromValue(int value) {
        for (CompositeAlphaMode level : CompositeAlphaMode.values()) {
            if (level.value == value) {
                return level;
            }
        }
        throw new IllegalArgumentException("Invalid value: " + value + ". Must be one of: " + Arrays.toString(CompositeAlphaMode.values()));
    }
}
