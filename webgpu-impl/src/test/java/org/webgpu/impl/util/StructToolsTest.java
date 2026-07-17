package org.webgpu.impl.util;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.lang.foreign.MemorySegment;

import org.junit.jupiter.api.Test;
import org.webgpu.api.AdapterInfo;

public class StructToolsTest {

    @Test
    public void testFetchSegment() {
        AdapterInfo descriptor = new AdapterInfo();
        final var infoPtr = StructTools.fetchSegment(descriptor);
        assertNotNull(infoPtr);
        assertNotEquals(infoPtr, MemorySegment.NULL);
    }

    @Test
    public void testPlaceSegmentRoundTrip() {
        AdapterInfo original = new AdapterInfo();
        MemorySegment segment = StructTools.fetchSegment(original);

        AdapterInfo wrapped = StructTools.placeSegment(segment, AdapterInfo.class);

        assertNotNull(wrapped);
        assertSame(segment, StructTools.fetchSegment(wrapped));
    }
}
