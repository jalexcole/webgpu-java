package org.webgpu.util;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.ValueLayout;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.logging.Logger;

import org.jspecify.annotations.NonNull;
import org.webgpu.extract.WGPUStringView;

public record StringView(MemorySegment stringViewPtr) {

    private static final Logger logger = Logger.getLogger(StringView.class.getName());

    public static MemorySegment of(@NonNull @SuppressWarnings("preview") Arena arena, @NonNull String string) {
        // Step 1: Convert the Java String to UTF-8 bytes
        byte[] utf8Bytes = string.getBytes(StandardCharsets.UTF_8);
        logger.info("String '" + string + "' converts to " + utf8Bytes.length + " UTF-8 bytes.");

        // Step 2: Allocate the native memory for the string data (UTF-8 bytes)
        // This is off-heap memory, and its lifecycle is tied to the 'arena'.
        @SuppressWarnings("preview")
        MemorySegment nativeStringData = arena.allocate(utf8Bytes.length);
        logger.info("Allocated nativeStringData (off-heap) of size: " + nativeStringData.byteSize()
                + " bytes at: " + nativeStringData);

        // Step 3: Copy the content from the on-heap utf8Bytes array into the off-heap
        // nativeStringData segment.
        nativeStringData.copyFrom(MemorySegment.ofArray(utf8Bytes)); // <-- CORRECTED LINE HERE
        logger.info("Copied UTF-8 bytes from on-heap array to off-heap nativeStringData. NativeStringData: " + nativeStringData.toString());

        // Step 4: Allocate the WGPUStringView struct itself using the provided Arena
        @SuppressWarnings("preview")
        MemorySegment stringViewPtr = WGPUStringView.allocate(arena);
        logger.info("Allocated WGPUStringView struct (off-heap) at: " + stringViewPtr);

        // Step 5: Set the data pointer and length in the native WGPUStringView struct
        WGPUStringView.data(stringViewPtr, nativeStringData);
        WGPUStringView.length(stringViewPtr, utf8Bytes.length);
       logger.info("Set data pointer and length in WGPUStringView struct. Length: " + utf8Bytes.length);

        return stringViewPtr;
    }

    public String string() {
        if (stringViewPtr == null || stringViewPtr.equals(MemorySegment.NULL)) {
            throw new IllegalStateException("StringView is null");
        }

        MemorySegment stringData = WGPUStringView.data(stringViewPtr);
        logger.info("String Data memory segment: " + stringData.toString());
        long length = WGPUStringView.length(stringViewPtr); // Get the *actual* byte length
        logger.info("String Data length: " + length);
        // Defensive checks
        // if (!stringData.()) {
        // throw new IllegalStateException("Native string data segment is already
        // closed.");
        // }

        // Allocate an on-heap byte array to hold the string data
        // Ensure the length is not negative (though unlikely with proper FFM usage)
        if (length < 0) {
            throw new IllegalArgumentException("Invalid string length: " + length);
        }

        // Check if the length is truly too large for a Java array (which is also
        // int-limited)
        // If length > Integer.MAX_VALUE, you cannot get it into a single byte[]
        // directly.
        // For *most* practical purposes with strings, this limit is rarely hit.
        // However, if it *is* hit, you might need to process the string in chunks
        // or return a stream, which is complex for a simple 'string()' method.
        // For now, assume a string fits into a single byte array.
        if (length > Integer.MAX_VALUE) {
            // This scenario means the string itself is larger than 2GB.
            // You cannot represent this as a single java.lang.String.
            // A java.lang.String's internal char array is also limited by int length.
            throw new IllegalStateException(
                    "String content is too large to fit into a Java String object. Length: " + length + " bytes.");
        }

        byte[] charArray = new byte[(int) length]; // Create a byte array of the correct size
        logger.info("Empty Char Array: " + Arrays.toString(charArray));
        // Copy the contents from the native MemorySegment into the on-heap byte array
        // You need to explicitly specify the layout for the copy.
        // Use ValueLayout.JAVA_BYTE to copy byte by byte.
        // Access `stringData` from offset 0 for `length` bytes.
        for (int i = 0; i < length; i++) {
            charArray[i] = stringData.get(ValueLayout.JAVA_BYTE, i);
        }

        logger.info("Filled Char Array: " + Arrays.toString(charArray));

        // Or, a more efficient way to copy the entire segment (if it fits in an
        // int-sized array):
        // stringData.asSlice(0, length).copyInto(MemorySegment.ofArray(charArray));
        // Or (if your FFM version supports it, `toArray` is common):
        // byte[] charArray = stringData.asSlice(0,
        // length).toArray(ValueLayout.JAVA_BYTE);

        return new String(charArray, StandardCharsets.UTF_8);
    }

    @SuppressWarnings("preview")
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
