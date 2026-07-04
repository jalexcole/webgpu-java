package org.webgpu.impl;

import org.webgpu.api.BindGroupLayout;
import org.webgpu.api.RenderPipeline;
import org.webgpu.panama.WGPUStringView;
import org.webgpu.panama.webgpu_h;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;

public class RenderPipelineImpl implements RenderPipeline {

    private final MemorySegment memorySegment;

    public RenderPipelineImpl(MemorySegment memorySegment) {
        this.memorySegment = memorySegment;
    }

    @Override
    public BindGroupLayout getBindGroupLayout(int groupIndex) {
        return null;
    }

    @Override
    public void setLabel(final String label) {
        throw new UnsupportedOperationException("WGPU Does not support setting labels on render pipelines yet.");
    }
}
