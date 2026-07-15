package org.webgpu.impl;

import java.lang.foreign.MemorySegment;

import org.jspecify.annotations.NullMarked;
import org.webgpu.api.ComputePipeline;
import org.webgpu.api.exceptions.WGPUException;
import org.webgpu.panama.webgpu_h;

@NullMarked
public final class ComputePipelineImpl implements ComputePipeline, WebGPUObjectImpl {

    private final MemorySegment memorySegment;

    public ComputePipelineImpl(MemorySegment memorySegment) {
        this.memorySegment = memorySegment;
    }

	@Override
	public BindGroupLayoutImpl getBindGroupLayout(int groupIndex) {
		final var bindGroupLayoutPtr = webgpu_h.wgpuComputePipelineGetBindGroupLayout(this.memorySegment, groupIndex);
		
		return new BindGroupLayoutImpl(bindGroupLayoutPtr);
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
