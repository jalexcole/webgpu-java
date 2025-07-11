package org.webgpu.util;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.foreign.Arena;

import org.junit.jupiter.api.Test;

public class StringViewTest {
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
}
