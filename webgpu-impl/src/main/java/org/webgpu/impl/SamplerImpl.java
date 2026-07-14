package org.webgpu.impl;

import java.lang.foreign.MemorySegment;

import org.webgpu.api.Sampler;

public class SamplerImpl implements Sampler {

    private final MemorySegment memorySegment;

    public SamplerImpl(MemorySegment memorySegment) {
        this.memorySegment = memorySegment;
    }

    
    @Override
    public void setLabel(String label) {
        throw new UnsupportedOperationException("Unimplemented method 'setLabel'");
    }
}
