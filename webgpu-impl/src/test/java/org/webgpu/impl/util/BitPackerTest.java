package org.webgpu.impl.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.EnumSet;

import org.junit.jupiter.api.Test;

class BitPackerTest {
    private enum SampleFlag {
        A,
        B,
        C
    }

    @Test
    void packsAndUnpacksEnumSets() {
        EnumSet<SampleFlag> input = EnumSet.of(SampleFlag.A, SampleFlag.C);

        long packed = BitPacker.pack(input);

        assertEquals(5L, packed);
        assertEquals(input, BitPacker.unpack(packed, SampleFlag.class));
    }

    @Test
    void unpackZeroReturnsEmptySet() {
        assertTrue(BitPacker.unpack(0, SampleFlag.class).isEmpty());
    }
}
