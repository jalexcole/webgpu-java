package org.webgpu.impl;

import java.lang.foreign.MemorySegment;

import org.webgpu.api.BindGroupLayout;
import org.webgpu.api.ComputePipeline;

public class ComputePipelineImpl implements ComputePipeline {

    private final MemorySegment memorySegment;

    public ComputePipelineImpl(MemorySegment memorySegment) {
        this.memorySegment = memorySegment;
    }

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
    
}
