package org.webgpu.api;

public enum AddressMode {
    UNDEFINED(0),
    CLAMP_TO_EDGE(1),
    REPEAT(2),
    MIRROR_REPEAT(3),
    FORCE32(0x7FFFFFFF);

    private final int value;

    AddressMode(int value) {
        this.value = value;
    }

    public int value() {
        return value;
    }

    public static AddressMode fromValue(int value) {
        switch (value) {
            case 0:
                return UNDEFINED;
            case 1:
                return CLAMP_TO_EDGE;
            case 2:
                return REPEAT;
            case 3:
                return MIRROR_REPEAT;
            default:
                return FORCE32;
        }
    }
}
