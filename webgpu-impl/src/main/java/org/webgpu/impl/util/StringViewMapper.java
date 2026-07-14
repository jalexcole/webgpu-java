package org.webgpu.impl.util;

import java.io.ByteArrayOutputStream;
import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.ValueLayout;
import java.nio.charset.StandardCharsets;

import org.jspecify.annotations.NullMarked;
import org.webgpu.panama.WGPUStringView;
import org.webgpu.panama.webgpu_h;

@NullMarked
public class StringViewMapper {
    private StringViewMapper() {
        /* This utility class should not be instantiated */
    }


    public static String map(MemorySegment stringViewPtr) {
        final long length = WGPUStringView.length(stringViewPtr);
        final String string;
        // If `length` is WGPU_STRLEN, the string is NULL-terminated.
        if (length == webgpu_h.WGPU_STRLEN()) {
            final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            int offset = 0;
            byte b;

            while ((b = WGPUStringView.data(stringViewPtr).get(ValueLayout.JAVA_BYTE, offset)) != 0) {
                byteArrayOutputStream.write(b);
                offset++;
            }

            string = new String(byteArrayOutputStream.toByteArray(), StandardCharsets.UTF_8);
        } else {
            byte[] dataArray = new byte[(int) length];
            for (int i = 0; i < length; i++) {
                byte b = WGPUStringView.data(stringViewPtr).get(ValueLayout.JAVA_BYTE, i);
                dataArray[i] = b;
            }

            string = new String(dataArray, StandardCharsets.UTF_8);
        }

        return string;
    }


    public static MemorySegment map(String string) {
        final Arena arena = Arena.ofAuto();
        return map(string, arena);
    }

    public static MemorySegment map(String string, Arena arena) {
        var stringView = WGPUStringView.allocate(arena);
        var stringSegment = arena.allocateFrom(string);
        WGPUStringView.data(stringView, stringSegment);
        WGPUStringView.length(stringView, -1); // -1 indicates that the string is NULL-terminated
        return stringView;
    }
}
