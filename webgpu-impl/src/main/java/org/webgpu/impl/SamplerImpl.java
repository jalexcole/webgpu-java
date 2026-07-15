package org.webgpu.impl;

import java.lang.foreign.MemorySegment;

import org.webgpu.api.Sampler;
import org.webgpu.api.exceptions.WGPUException;

public class SamplerImpl implements Sampler {

    private final MemorySegment memorySegment;

    public SamplerImpl(MemorySegment memorySegment) {
        this.memorySegment = memorySegment;
    }

    
    @Override
    public void setLabel(String label) {
        throw new WGPUException(new UnsupportedOperationException("Unimplemented method 'setLabel'"));
    }
}
