package org.webgpu.impl;

import java.lang.foreign.MemorySegment;

import org.webgpu.api.BindGroup;

public record BindGroupImpl(MemorySegment ptr) implements BindGroup {

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
