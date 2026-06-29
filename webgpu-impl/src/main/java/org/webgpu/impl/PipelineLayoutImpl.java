package org.webgpu.impl;

import java.lang.foreign.MemorySegment;

import org.webgpu.api.PipelineLayout;

public class PipelineLayoutImpl implements PipelineLayout {

    private final MemorySegment ptr;
    public PipelineLayoutImpl(MemorySegment ptr) {
        this.ptr = ptr;
    }


	@Override
	public void setLabel(String label) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'setLabel'");
	}
    
}
