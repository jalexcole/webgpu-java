package org.webgpu.api;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;
import java.time.Instant;

import org.webgpu.extract.WGPUComputePassDescriptor;
import org.webgpu.util.StringView;

public class ComputePassDescriptor {
    private MemorySegment ptr;

    ComputePassDescriptor(MemorySegment ptr) {
        this.ptr = ptr;
    }

    public String label() {
        return new StringView(WGPUComputePassDescriptor.label(ptr)).string();
    }

    public void setLabel(String label) {
        try (Arena arena = Arena.ofConfined()) {
            var stringView = StringView.of(arena, label);
            WGPUComputePassDescriptor.label(ptr, stringView);
        }
    }

    public MemorySegment ptr() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'ptr'");
    }

}
