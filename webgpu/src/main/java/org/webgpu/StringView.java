package org.webgpu;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;

import org.jspecify.annotations.NonNull;
import org.webgpu.extract.WGPUStringView;

class StringView {
    @SuppressWarnings("preview")
    private MemorySegment StringViewPtr;

    StringView(@NonNull @SuppressWarnings("preview") MemorySegment ptr) {
        this.StringViewPtr = ptr;
    }

    StringView(@NonNull String string) {
        try (@SuppressWarnings("preview")
        Arena arena = Arena.ofConfined()) {
            @SuppressWarnings("preview")
            var stringMemorySegment = MemorySegment.ofArray(string.toCharArray());
            
            StringViewPtr = WGPUStringView.allocate(arena);
            WGPUStringView.data(StringViewPtr, stringMemorySegment);
            WGPUStringView.length(StringViewPtr, string.length());
        }
    }

    public String string() {
        var stringData = WGPUStringView.data(StringViewPtr);
        return stringData.getUtf8String(WGPUStringView.length(StringViewPtr));
    }

    @SuppressWarnings("preview")
    MemorySegment ptr() {
        return StringViewPtr;
    }

    public long length() {
        return WGPUStringView.length(StringViewPtr);
    }

    @Override
    public String toString() {
        return "StringView [" + string() + "]";
    }

}
