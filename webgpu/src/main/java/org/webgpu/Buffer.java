package org.webgpu;

import java.lang.foreign.MemorySegment;

public class Buffer {
    private MemorySegment ptr;

    Buffer(MemorySegment ptr) {
        this.ptr = ptr;
    }


    MemorySegment memorySegment() {
        return ptr;
    }


    public MemorySegment ptr() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'ptr'");
    }
}
