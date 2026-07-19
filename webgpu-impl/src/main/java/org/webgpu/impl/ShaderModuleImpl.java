package org.webgpu.impl;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;

import org.webgpu.api.CompilationInfo;
import org.webgpu.api.Future;
import org.webgpu.api.ShaderModule;
import org.webgpu.api.exceptions.WGPUException;
import org.webgpu.impl.util.StructTools;
import org.webgpu.panama.webgpu_h;

public class ShaderModuleImpl implements ShaderModule {

	private final MemorySegment memorySegment;
	
	public ShaderModuleImpl(MemorySegment memorySegment) {
	    this.memorySegment = memorySegment;
	}

	@Override
	public void setLabel(String label) {
		throw new WGPUException(new UnsupportedOperationException("Unimplemented method 'setLabel'"));
	}


	@Override
	public void getCompilationInfo(CompilationInfo callback) {
		final var callbackPtr = StructTools.fetchSegment(callback);
		final var futurePtr = webgpu_h.wgpuShaderModuleGetCompilationInfo(Arena.ofAuto(), this.memorySegment,
				callbackPtr);
		final Future future = StructTools.placeSegment(futurePtr, Future.class);

		future.id();
	}

	public MemorySegment ptr() {
		return this.memorySegment;
	}
    
}
