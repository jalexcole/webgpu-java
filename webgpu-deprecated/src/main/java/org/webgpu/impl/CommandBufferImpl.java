package org.webgpu.impl;

import java.lang.foreign.MemorySegment;

import org.webgpu.api.CommandBuffer;

public record CommandBufferImpl(MemorySegment ptr) implements CommandBuffer{
    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(CommandBufferImpl.class);
    @Override
    public void setLabel(String label) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setLabel'");
    }

    @Override
    public void addRef() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addRef'");
    }

    @Override
    public void release() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'release'");
    }

    
}
