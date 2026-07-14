package org.webgpu.impl.util;

import java.util.EnumSet;
import java.util.Set;

import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.NullMarked;

@NullMarked
public class BitPacker {

    @SuppressWarnings("null")
    public static <T extends Enum<T>> long pack(Set<T> enums) {
        long packedValue = 0;
        for (T enumValue : enums) {
            packedValue |= 1L << enumValue.ordinal();
        }
        return packedValue;
    }

    public static <T extends Enum<T>> Set<T> unpack(long packedValue, Class<T> type) {
        T[] values = type.getEnumConstants();
        if (values == null) {
            return EnumSet.noneOf(type);
        }
        if (packedValue == 0) {
            return EnumSet.noneOf(type);
        }

        EnumSet<T> result = EnumSet.noneOf(type);
        for (int i = 0; i < values.length; i++) {
            if ((packedValue & (1L << i)) != 0) {
                result.add(values[i]);
            }
        }

        return result;
    }
}
