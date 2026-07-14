package org.webgpu.impl;

import java.lang.foreign.MemorySegment;

import org.jspecify.annotations.NullMarked;
import org.webgpu.api.ExternalTexture;

@NullMarked
public class ExternalTextureImpl implements ExternalTexture {

    private final MemorySegment memorySegment;
    
    public ExternalTextureImpl(MemorySegment memorySegment) {
        this.memorySegment = memorySegment;
    }

	@Override
	public void setLabel(String label) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'setLabel'");
	}
    
}