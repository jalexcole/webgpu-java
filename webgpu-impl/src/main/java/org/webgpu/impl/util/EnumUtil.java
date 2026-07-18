package org.webgpu.impl.util;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.ValueLayout;
import java.lang.reflect.Array;
import java.util.Arrays;

public class EnumUtil {
    private EnumUtil() {
        /* This utility class should not be instantiated */
    }

    public static <T extends Enum<T>> MemorySegment packEnum(T[] enums, Arena arena) {
        final int[] ordinals = Arrays.stream(enums).mapToInt(Enum::ordinal).toArray();

        final MemorySegment segment = arena.allocate(ValueLayout.JAVA_INT, ordinals.length);
        for (int i = 0; i < ordinals.length; i++) {
            segment.setAtIndex(ValueLayout.JAVA_INT, i, ordinals[i]);
        }
        return segment;
    }

    @SuppressWarnings("unchecked")
    public static <T extends Enum<T>> T[] unpackEnum(MemorySegment segment, long count, Class<T> enumClass) {
        final int elementCount = (int) count;
        final T[] enums = (T[]) Array.newInstance(enumClass, elementCount);
        for (int i = 0; i < count; i++) {
            int ordinal = segment.getAtIndex(ValueLayout.JAVA_INT, i);
            enums[i] = enumClass.getEnumConstants()[ordinal];
        }
        return enums;
    }
}
