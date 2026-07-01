package org.webgpu.impl.util;

import java.io.ByteArrayOutputStream;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.ValueLayout;
import java.nio.charset.StandardCharsets;

import org.webgpu.panama.WGPUStringView;
import org.webgpu.panama.webgpu_h;

public class StringViewMapper {

    public static String map(MemorySegment stringViewPtr) {
        final long length = WGPUStringView.length(stringViewPtr);
        final String string;
        // If `length` is WGPU_STRLEN, the string is NULL-terminated.
        if (length == webgpu_h.WGPU_STRLEN()) {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            int offset = 0;
            byte b;

            while ((b = WGPUStringView.data(stringViewPtr).get(ValueLayout.JAVA_BYTE, offset)) != 0) {
                bos.write(b);
                offset++;
            }

            string = new String(bos.toByteArray(), StandardCharsets.UTF_8);
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
}
