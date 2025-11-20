package org.webgpu.util;

import java.io.ByteArrayOutputStream;
import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.ValueLayout;
import java.lang.foreign.ValueLayout.OfByte;
import java.lang.foreign.ValueLayout.OfChar;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

import org.jspecify.annotations.NonNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.webgpu.api.WGPU;
import org.webgpu.panama.foreign.WGPUStringView;
import org.webgpu.panama.foreign.webgpu_h;

public record StringView(MemorySegment stringViewPtr) {

    private static final Logger logger = LoggerFactory.getLogger(StringView.class);

    public static MemorySegment of(@NonNull Arena arena, @NonNull String string) {
        byte[] utf8Bytes = string.getBytes(StandardCharsets.UTF_8);
        logger.info("String '{}' converts to {} UTF-8 bytes.", string, Arrays.toString(utf8Bytes));
        
        MemorySegment nativeStringData = arena.allocate(utf8Bytes.length);
        logger.info("Allocated nativeStringData (off-heap) of size: {} bytes at: {}", nativeStringData.byteSize(),
                nativeStringData);

        nativeStringData.copyFrom(MemorySegment.ofArray(utf8Bytes)); // <-- CORRECTED LINE HERE
        logger.info("Copied UTF-8 bytes from on-heap array to off-heap nativeStringData. NativeStringData: {}",
                nativeStringData.toString());

        MemorySegment stringViewPtr = WGPUStringView.allocate(arena);
        logger.info("Allocated WGPUStringView struct (off-heap) at: {}", stringViewPtr);

        WGPUStringView.data(stringViewPtr, nativeStringData);
        WGPUStringView.length(stringViewPtr, utf8Bytes.length);
        logger.info("Set data pointer and length in WGPUStringView struct. Length: {}", utf8Bytes.length);

        return stringViewPtr;
    }
    
    /**
     * Creates a Java String from a WGPUStringView MemorySegment.
     * 
     * @param stringViewPtr MemorySegment pointing to a WGPUStringView struct.
     * 
     * @note This method assumes the string is encoded in UTF-8.
     *       
     * Everything must be initialized properly before calling this method.
     */
    public static String map(@NonNull final MemorySegment stringViewPtr) {
        final long length = WGPUStringView.length(stringViewPtr);

        // If `length` is WGPU_STRLEN, the string is NULL-terminated.
        if (length == webgpu_h.WGPU_STRLEN()) {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            int offset = 0;
            byte b;

            while ((b = WGPUStringView.data(stringViewPtr).get(ValueLayout.JAVA_BYTE, offset)) != 0) {
                bos.write(b);
                offset++;
            }

            return new String(bos.toByteArray(), StandardCharsets.UTF_8);
        } else {
            byte[] dataArray = new byte[(int) length];
            for (int i = 0; i < length; i++) {
                byte b = WGPUStringView.data(stringViewPtr).get(ValueLayout.JAVA_BYTE, i);
                dataArray[i] = b;
            }

            return new String(dataArray, StandardCharsets.UTF_8);
        }
    }

    String string() {
        if (stringViewPtr == null || stringViewPtr.equals(MemorySegment.NULL)) {
            throw new IllegalStateException("StringView is null");
        }

        MemorySegment stringData = WGPUStringView.data(stringViewPtr);
        logger.info("String Data memory segment: {}",  stringData);
        long length = WGPUStringView.length(stringViewPtr); // Get the *actual* byte length
        logger.info("String Data length: {}", length);
        
        if (length < 0) {
            throw new IllegalArgumentException("Invalid string length: {}" + length);
        }

        
        if (length > Integer.MAX_VALUE) {
            
            throw new IllegalStateException(
                    "String content is too large to fit into a Java String object. Length: " + length + " bytes.");
        }

        byte[] charArray = new byte[(int) length]; // Create a byte array of the correct size
        logger.info("Empty Char Array: {}", Arrays.toString(charArray));
        
        for (int i = 0; i < length; i++) {
            charArray[i] = stringData.get(ValueLayout.JAVA_BYTE, i);
        }

        logger.info("Filled Char Array: {}", Arrays.toString(charArray));

        return new String(charArray, StandardCharsets.UTF_8);
    }

    public MemorySegment ptr() {
        return stringViewPtr;
    }

    public long length() {
        if (stringViewPtr == null || stringViewPtr.equals(MemorySegment.NULL)) {
            throw new IllegalStateException("StringView is null");
        }
        return WGPUStringView.length(stringViewPtr);
    }

    @Override
    public String toString() {
        return "StringView [" + string() + "]";
    }

}
