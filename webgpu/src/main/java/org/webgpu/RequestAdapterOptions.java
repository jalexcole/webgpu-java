package org.webgpu;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;

import org.webgpu.extract.WGPURequestAdapterOptions;


public class RequestAdapterOptions {
    private MemorySegment ptr;

    public RequestAdapterOptions() {
        try (Arena arena = Arena.ofConfined()) {
            ptr = WGPURequestAdapterOptions.allocate(arena);
        }
    }

    public MemorySegment ptr() {
        return this.ptr;
    }
}
