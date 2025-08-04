package org.webgpu.api;

import java.lang.foreign.MemorySegment;

public class ExternalTextureDescriptor {
    private final MemorySegment ptr;

    public ExternalTextureDescriptor(MemorySegment ptr) {
        this.ptr = ptr;
    }

    public MemorySegment ptr() {
        return ptr;
    }

    // Additional methods for managing the descriptor can be added here
}
