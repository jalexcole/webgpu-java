package org.webgpu.impl;

import java.lang.foreign.MemorySegment;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.webgpu.api.BindGroup;

public record BindGroupImpl(MemorySegment ptr) implements BindGroup {
	private static final Logger logger = LoggerFactory.getLogger(BindGroupImpl.class);
	@Override
	public String label() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'label'");
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
