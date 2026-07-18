package org.webgpu.impl;

import java.lang.foreign.MemorySegment;

import org.jspecify.annotations.NullMarked;
import org.webgpu.api.ExternalTexture;
import org.webgpu.api.exceptions.WGPUException;
@NullMarked
public final class ExternalTextureImpl implements ExternalTexture, WebGPUObjectImpl {

    private final MemorySegment memorySegment;
    
    public ExternalTextureImpl(MemorySegment memorySegment) {
        this.memorySegment = memorySegment;
    }

	@Override
	public void setLabel(String label) {
		throw new WGPUException(new UnsupportedOperationException("Unimplemented method 'setLabel'"));
	}

	@Override
	public MemorySegment ptr() {
		return this.memorySegment;
	}
    
}