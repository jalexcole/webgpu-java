package org.webgpu.impl;

import java.lang.foreign.MemorySegment;

import org.webgpu.api.CompilationInfo;
import org.webgpu.api.ShaderModule;

public class ShaderModuleImpl implements ShaderModule {

	private final MemorySegment memorySegment;
	
	public ShaderModuleImpl(MemorySegment memorySegment) {
	    this.memorySegment = memorySegment;
	}

	
	public void getCompilationInfo() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'getCompilationInfo'");
	}

	@Override
	public void setLabel(String label) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'setLabel'");
	}


	@Override
	public void getCompilationInfo(CompilationInfo callback) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'getCompilationInfo'");
	}
    
}
