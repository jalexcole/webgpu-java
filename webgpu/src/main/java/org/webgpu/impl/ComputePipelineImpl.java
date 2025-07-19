package org.webgpu.impl;

import java.lang.foreign.MemorySegment;

import org.webgpu.api.BindGroupLayout;
import org.webgpu.api.ComputePipeline;

public record ComputePipelineImpl(MemorySegment ptr) implements ComputePipeline {

    @Override
    public BindGroupLayout getBindGroupLayout(int groupIndex) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getBindGroupLayout'");
    }

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
