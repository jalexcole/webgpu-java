package org.webgpu.api;

import java.util.Arrays;

public enum BendFactor {
    UNDEFINED(0),
    ZERO(1),
    ONE(2), SRC(3), ONE_MINUS_SRC(4), SRC_ALPHA(5), ONE_MINUS_SRC_ALPHA(6), DST(7), ONE_MINUS_DST(8), DST_ALPHA(9), ONE_MINUS_DST_ALPHA(10), SRC_ALPHA_SATURATE(11),
    FORCE32(0x7FFFFFFF);

    private final int value;

    BendFactor(int value) {
        this.value = value;
    }

    public int value() {
        return value;
    }

    public static BendFactor fromValue(int value) {
        for (BendFactor level : BendFactor.values()) {
            if (level.value == value) {
                return level;
            }
        }
        throw new IllegalArgumentException("Invalid value: " + value + ". Must be one of: " + Arrays.toString(BendFactor.values()));
    }
}
