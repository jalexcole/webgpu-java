package org.webgpu.api;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;

import org.webgpu.foreign.WGPUComputePassDescriptor;
import org.webgpu.util.StringView;

public final class ComputePassDescriptor implements DescriptorBase {
    @SuppressWarnings("preview")
    private MemorySegment ptr;

    ComputePassDescriptor(@SuppressWarnings("preview") MemorySegment ptr) {
        this.ptr = ptr;
    }

    public ComputePassDescriptor() {
        @SuppressWarnings("preview")
        final Arena arena = Arena.ofAuto();
        this.ptr = WGPUComputePassDescriptor.allocate(arena);
    }

    public String label() {
        return new StringView(WGPUComputePassDescriptor.label(ptr)).string();
    }

    public void setLabel(String label) {
        try (@SuppressWarnings("preview")
        Arena arena = Arena.ofConfined()) {
            var stringView = StringView.of(arena, label);
            WGPUComputePassDescriptor.label(ptr, stringView);
        }
    }

    @SuppressWarnings("preview")
    public MemorySegment ptr() {
        return this.ptr;
    }

}
