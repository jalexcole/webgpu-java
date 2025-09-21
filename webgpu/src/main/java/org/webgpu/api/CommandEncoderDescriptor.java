package org.webgpu.api;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;

public class CommandEncoderDescriptor {
    private final MemorySegment ptr;

    public CommandEncoderDescriptor() {
        try {
            Arena arena = Arena.ofAuto();
            ptr = org.webgpu.panama.foreign.WGPUCommandEncoderDescriptor.allocate(arena);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public MemorySegment ptr() {
        return ptr;
    }
}
