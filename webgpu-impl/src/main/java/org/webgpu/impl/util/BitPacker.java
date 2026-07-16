package org.webgpu.impl.util;

import java.util.EnumSet;
import java.util.Set;

import org.jspecify.annotations.NullMarked;
import org.webgpu.api.WGPUBitflag;
import org.webgpu.api.exceptions.WGPUException;

@NullMarked
public class BitPacker {

    @SuppressWarnings("null")
    public static <T extends Enum<T> & WGPUBitflag> long pack(final Set<T> enums) {

        return enums.stream().mapToLong(WGPUBitflag::value).sum();

    }

    public static <T extends Enum<T> & WGPUBitflag> Set<T> unpack(final long packedValue, final Class<T> type) {
        final T[] values = type.getEnumConstants();
        if (values == null) {
            throw new WGPUException("Unable to unpack due to null type");
        }
        if (packedValue == 0 && values.length > 0) {
            return EnumSet.of(values[0]);
        }

        EnumSet<T> result = EnumSet.noneOf(type);
        for (int i = 0; i < values.length; i++) {
            long flag = values[i].value();
            if (flag != 0 && (packedValue & flag) != 0) {
                result.add(values[i]);
            }
        }

        return result;
    }
}
