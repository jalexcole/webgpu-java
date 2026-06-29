package org.webgpu.impl;

import java.lang.foreign.MemorySegment;

import org.webgpu.api.RenderBundle;

public class RenderBundleImpl implements RenderBundle {

	private final MemorySegment memorySegment;
	
	public RenderBundleImpl(MemorySegment memorySegment) {
	    this.memorySegment = memorySegment;
	}

	@Override
	public void setLabel(String label) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'setLabel'");
	}
    
}
