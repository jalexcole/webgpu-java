package org.webgpu;

import java.lang.foreign.MemorySegment;
import java.time.Instant;

import org.webgpu.extract.WGPUComputePassDescriptor;

public class ComputePassDescriptor {
    private MemorySegment ptr;

    ComputePassDescriptor(MemorySegment ptr) {
        this.ptr = ptr;
    }

    public String label() {
        return new StringView(WGPUComputePassDescriptor.label(ptr)).string();
    }

    public void setLabel(String label) {
        StringView stringView = new StringView(label);
        WGPUComputePassDescriptor.label(ptr, stringView.ptr());
    }

    public MemorySegment ptr() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'ptr'");
    }

    
}
