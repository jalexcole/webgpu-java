package org.webgpu.api;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;

import org.webgpu.foreign.WGPUConstantEntry;
import org.webgpu.util.StringView;

public class ConstantEntry {
    private final MemorySegment ptr;

    public ConstantEntry() {
        final Arena arena = Arena.ofAuto();
        this.ptr = WGPUConstantEntry.allocate(arena);
    }

    ConstantEntry(MemorySegment ptr) {
        this.ptr = ptr;
    }

    public final String key() {
        return new StringView(WGPUConstantEntry.key(ptr)).string();
    }

    public final void setKey(String key) {
        try (Arena arena = Arena.ofConfined()) {
            var stringView = StringView.of(arena, key);
            WGPUConstantEntry.key(ptr, stringView);
        }
    }

    public final double value() {
        return WGPUConstantEntry.value(ptr);
    }

    public final void setValue(double value) {
        WGPUConstantEntry.value(ptr, value);
    }
}
