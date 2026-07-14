package org.webgpu.impl;

import java.lang.foreign.MemorySegment;

import org.jspecify.annotations.NullMarked;
import org.webgpu.api.CommandBuffer;
import org.webgpu.api.exceptions.WGPUException;

@NullMarked
public final class CommandBufferImpl implements CommandBuffer, WebGPUObjectImpl {

    private final MemorySegment memorySegment;

    public CommandBufferImpl(MemorySegment memorySegment) {
        this.memorySegment = memorySegment;
    }

    @Override
    public void setLabel(String label) {
        throw new WGPUException(new UnsupportedOperationException("Unimplemented method 'setLabel'"));
    }

    @Override
    public MemorySegment ptr() {
        return this.memorySegment;
    }
}
