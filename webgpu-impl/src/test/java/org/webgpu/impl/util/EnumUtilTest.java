package org.webgpu.impl.util;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.ValueLayout;

import org.junit.jupiter.api.Test;

public class EnumUtilTest {
    private enum TestEnum {
        FIRST,
        SECOND,
        THIRD
    }

    @Test
    void testPackEnum() {
        try (Arena arena = Arena.ofConfined()) {
            TestEnum[] values = new TestEnum[] { TestEnum.THIRD, TestEnum.FIRST, TestEnum.SECOND };

            MemorySegment packed = EnumUtil.packEnum(values, arena);

            assertEquals((long) values.length * ValueLayout.JAVA_INT.byteSize(), packed.byteSize());
            assertEquals(TestEnum.THIRD.ordinal(), packed.getAtIndex(ValueLayout.JAVA_INT, 0));
            assertEquals(TestEnum.FIRST.ordinal(), packed.getAtIndex(ValueLayout.JAVA_INT, 1));
            assertEquals(TestEnum.SECOND.ordinal(), packed.getAtIndex(ValueLayout.JAVA_INT, 2));
        }
    }

    @Test
    void testUnpackEnum() {
        try (Arena arena = Arena.ofConfined()) {
            MemorySegment segment = arena.allocate(ValueLayout.JAVA_INT, 3);
            segment.setAtIndex(ValueLayout.JAVA_INT, 0, TestEnum.SECOND.ordinal());
            segment.setAtIndex(ValueLayout.JAVA_INT, 1, TestEnum.THIRD.ordinal());
            segment.setAtIndex(ValueLayout.JAVA_INT, 2, TestEnum.FIRST.ordinal());

            TestEnum[] unpacked = EnumUtil.unpackEnum(segment, 3, TestEnum.class);

            assertArrayEquals(new TestEnum[] { TestEnum.SECOND, TestEnum.THIRD, TestEnum.FIRST }, unpacked);
        }
    }
}
