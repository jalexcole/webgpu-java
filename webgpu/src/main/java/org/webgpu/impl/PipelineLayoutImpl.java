package org.webgpu.impl;

import java.lang.foreign.MemorySegment;

import org.webgpu.api.PipelineLayout;

public record PipelineLayoutImpl(MemorySegment ptr) implements PipelineLayout {

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
