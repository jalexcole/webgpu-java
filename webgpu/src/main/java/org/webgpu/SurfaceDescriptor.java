package org.webgpu;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;

import org.webgpu.extract.WGPUSurfaceDescriptor;

public class SurfaceDescriptor {

    private MemorySegment ptr;

    public SurfaceDescriptor(MemorySegment ptr) {
        this.ptr = ptr;
    }

    public SurfaceDescriptor() {
        try(Arena arena = Arena.ofConfined()) {
            this.ptr = WGPUSurfaceDescriptor.allocate(arena);
        }
    }

    public MemorySegment ptr() {
        return this.ptr;
    }

}
