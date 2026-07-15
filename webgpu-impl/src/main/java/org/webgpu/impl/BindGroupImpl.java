package org.webgpu.impl;

import java.lang.foreign.MemorySegment;

import org.jspecify.annotations.NullMarked;
import org.webgpu.api.BindGroup;
import org.webgpu.api.exceptions.WGPUException;

@NullMarked
final class BindGroupImpl implements BindGroup, WebGPUObjectImpl {

    private final MemorySegment memorySegment;

    public BindGroupImpl(MemorySegment memorySegment) {
        this.memorySegment = memorySegment;
    }
    @Override
    public MemorySegment ptr() {
        return memorySegment;
    }

    @Override
    public void setLabel(String label) {
        throw new WGPUException(new UnsupportedOperationException("Unimplemented method 'setLabel'"));
    }
}
