package org.webgpu.impl;

import java.lang.foreign.MemorySegment;

import org.jspecify.annotations.NullMarked;
import org.webgpu.api.BindGroupLayout;

@NullMarked
public final class BindGroupLayoutImpl implements BindGroupLayout, WebGPUObjectImpl {

    private final MemorySegment memorySegment;

    public BindGroupLayoutImpl(MemorySegment memorySegment) {
        this.memorySegment = memorySegment;
    }

    @Override
    public void setLabel(String label) {
        throw new UnsupportedOperationException();
    }

    @Override
    public MemorySegment ptr() {
        return this.memorySegment;
    }
}
