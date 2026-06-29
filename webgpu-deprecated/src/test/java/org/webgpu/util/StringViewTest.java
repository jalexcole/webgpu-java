package org.webgpu.util;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.webgpu.api.WGPU;
import org.webgpu.panama.foreign.WGPUStringView;
import org.webgpu.panama.foreign.webgpu_h;

public class StringViewTest {

    Logger logger = LoggerFactory.getLogger(StringViewTest.class.getName());

    @Test
    void testString() {
        try (Arena arena = Arena.ofConfined()) {
            var testString = "test";
            var stringView = new StringView(StringView.of(arena, testString));
            assertTrue(stringView.string().equals(testString));
        }
    }

    @Test
    void testLength() {
        try (Arena arena = Arena.ofConfined()) {
            var testString = "test";
            var stringView = new StringView(StringView.of(arena, testString));
            assertTrue(stringView.length() == testString.length());
        }
    }

    @Test
    void testStringView() {
        try (Arena arena = Arena.ofConfined()) {
            var testString = "test";
            var stringViewPtr = StringView.of(arena, testString);
            var stringView = new StringView(stringViewPtr);
            System.out.println(stringView.string());
            assertTrue(stringView.string().equals(testString));
        }
    }

    @Test
    void mapToString() {
        WGPU.createInstance(null);
        logger.info("Beginning mapToString test...");
        try (Arena arena = Arena.ofConfined()) {
            final var testString = "test";
            final var stringViewPtr = StringView.of(arena, testString);
            final var stringView = new StringView(stringViewPtr);
            final String mappedString = StringView.map(stringViewPtr);
            System.out.println(mappedString);
            logger.info("Mapped string: {}", mappedString);
            assertTrue(mappedString.equals(testString));
        }
    }

    @Test
    void mapToStringWithWGPUStringView() {
        final Arena arena = Arena.ofAuto();
        final var instance = WGPU.createInstance(null);
        logger.info("Beginning mapToStringWithWGPUStringView test...");
        final String testString = "mapToStringWithWGPUStringView";
        final MemorySegment wgpuStringViewPtr = WGPUStringView.allocate(arena);
        WGPUStringView.length(wgpuStringViewPtr, testString.length());
        WGPUStringView.data(wgpuStringViewPtr).reinterpret(testString.getBytes().length);
        final MemorySegment nativeStringData = arena.allocate(testString.getBytes().length);
        nativeStringData.copyFrom(MemorySegment.ofArray(testString.getBytes()));
        WGPUStringView.data(wgpuStringViewPtr, nativeStringData);

        final String mappedString = StringView.map(wgpuStringViewPtr);
        logger.info("Mapped WGPUStringView string: {}", mappedString);
        assertTrue(mappedString.equals(testString));
    }

    @Test
    void mapToStringNullTerminatedWithWGPUStringView() {
        final Arena arena = Arena.ofAuto();
        final var instance = WGPU.createInstance(null);
        logger.info("Beginning mapToStringNullTerminatedWithWGPUStringView test...");

        // When we read the String over the FFI boundary we stop being null-terminated.
        final String testString = "mapToStringNullTerminatedWithWGPUStringView";
        final String testStringNullTerminated = testString + '\0';

        final MemorySegment wgpuStringViewPtr = WGPUStringView.allocate(arena);
        WGPUStringView.length(wgpuStringViewPtr, webgpu_h.WGPU_STRLEN());
        WGPUStringView.data(wgpuStringViewPtr).reinterpret(testStringNullTerminated.getBytes().length);
        final MemorySegment nativeStringData = arena.allocate(testStringNullTerminated.getBytes().length);
        nativeStringData.copyFrom(MemorySegment.ofArray(testStringNullTerminated.getBytes()));
        WGPUStringView.data(wgpuStringViewPtr, nativeStringData);

        final String mappedString = StringView.map(wgpuStringViewPtr);
        logger.info("Mapped WGPUStringView string: {}", mappedString);
        assertTrue(mappedString.equals(testString));
    }
}
