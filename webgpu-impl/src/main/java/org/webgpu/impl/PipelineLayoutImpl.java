package org.webgpu.impl;

import java.lang.foreign.MemorySegment;

import org.jspecify.annotations.NullMarked;
import org.webgpu.api.PipelineLayout;
import org.webgpu.api.exceptions.WGPUException;

@NullMarked
public class PipelineLayoutImpl implements PipelineLayout {

	private final MemorySegment ptr;
	
    public PipelineLayoutImpl(MemorySegment ptr) {
        this.ptr = ptr;
    }


	@Override
	public void setLabel(String label) {
		// TODO Auto-generated method stub
		throw new WGPUException(new UnsupportedOperationException("Unimplemented method 'setLabel'"));
	}
    
}
