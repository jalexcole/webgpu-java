package org.webgpu.api;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;

import org.webgpu.extract.WGPURequestAdapterOptions;


public class RequestAdapterOptions {
    private MemorySegment ptr;

    public RequestAdapterOptions() {
        try {
            Arena arena = Arena.ofAuto();
            ptr = WGPURequestAdapterOptions.allocate(arena);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public MemorySegment ptr() {
        return this.ptr;
    }
}
