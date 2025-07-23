package org.webgpu.api;

public enum ToneMappingMode {
    STANDARD(0),
    EXTENDED(1);

    private final int value;

    ToneMappingMode(int value) {
        this.value = value;
    }

    public int value() {
        return value;
    }

    public static ToneMappingMode fromValue(int value) {
        for (ToneMappingMode mode : values()) {
            if (mode.value == value) {
                return mode;
            }
        }
        throw new IllegalArgumentException("Invalid value: " + value);
    }
}

