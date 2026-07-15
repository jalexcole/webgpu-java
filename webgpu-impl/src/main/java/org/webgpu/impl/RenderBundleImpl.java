package org.webgpu.impl;

import java.lang.foreign.MemorySegment;

import org.webgpu.api.RenderBundle;
import org.webgpu.api.exceptions.WGPUException;

public class RenderBundleImpl implements RenderBundle {

	private final MemorySegment memorySegment;
	
	public RenderBundleImpl(MemorySegment memorySegment) {
	    this.memorySegment = memorySegment;
	}

	@Override
	public void setLabel(String label) {
		throw new WGPUException(new UnsupportedOperationException("Unimplemented method 'setLabel'"));
	}
    
}
