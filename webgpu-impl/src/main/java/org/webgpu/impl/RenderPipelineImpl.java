package org.webgpu.impl;

import org.webgpu.api.BindGroupLayout;
import org.webgpu.api.RenderPipeline;
import org.webgpu.api.exceptions.WGPUException;
import org.webgpu.panama.webgpu_h;

import java.lang.foreign.MemorySegment;

public final class RenderPipelineImpl implements RenderPipeline, WebGPUObjectImpl {

    private final MemorySegment memorySegment;

    public RenderPipelineImpl(MemorySegment memorySegment) {
        this.memorySegment = memorySegment;
    }

    @Override
    public BindGroupLayout getBindGroupLayout(int groupIndex) {
        final var bindGroupLayoutSegment = webgpu_h.wgpuRenderPipelineGetBindGroupLayout(memorySegment, groupIndex);

        return new BindGroupLayoutImpl(bindGroupLayoutSegment);
    }

    @Override
    public void setLabel(final String label) {
        throw new WGPUException(new UnsupportedOperationException("WGPU Does not support setting labels on render pipelines yet."));
    }

	@Override
	public MemorySegment ptr() {
        return this.memorySegment;
	}
}
