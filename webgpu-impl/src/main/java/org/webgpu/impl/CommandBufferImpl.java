package org.webgpu.impl;

import java.lang.foreign.MemorySegment;

import org.webgpu.api.CommandBuffer;

class CommandBufferImpl implements CommandBuffer {

    private final MemorySegment memorySegment;

    public CommandBufferImpl(MemorySegment memorySegment) {
        this.memorySegment = memorySegment;
    }

    @Override
    public void setLabel(String label) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setLabel'");
    }
}
