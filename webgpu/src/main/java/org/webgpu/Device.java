package org.webgpu;

import java.lang.foreign.MemorySegment;

public class Device implements ObjectBase {
    private MemorySegment ptr;

    Device(MemorySegment ptr) {
        this.ptr = ptr;
    }

    public MemorySegment ptr() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'ptr'");
    }
}
