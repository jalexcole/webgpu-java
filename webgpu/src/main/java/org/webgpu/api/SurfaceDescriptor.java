package org.webgpu.api;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;
import java.util.Optional;

import org.webgpu.foreign.WGPUSurfaceDescriptor;
import org.webgpu.util.StringView;

public class SurfaceDescriptor {

    @SuppressWarnings("preview")
    private final MemorySegment ptr;

    public SurfaceDescriptor(@SuppressWarnings("preview") MemorySegment ptr) {
        this.ptr = ptr;
    }

    public SurfaceDescriptor() {
        @SuppressWarnings("preview")
        final Arena arena = Arena.ofAuto();
        this.ptr = WGPUSurfaceDescriptor.allocate(arena);
    }

    public Optional<ChainedStruct> nextInChain() {
        return Optional.of(new ChainedStruct(WGPUSurfaceDescriptor.nextInChain(ptr)));
    }

    public String label() {
        return new StringView(WGPUSurfaceDescriptor.label(ptr)).string();
    }

    @SuppressWarnings("preview")
    public MemorySegment ptr() {
        return this.ptr;
    }

    @Override
    public String toString() {
        return "SurfaceDescriptor [nextInChain()=" + nextInChain() + ", label()=" + label() + "]";
    }

}
