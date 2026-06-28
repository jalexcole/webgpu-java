package org.webgpu.impl;

import org.webgpu.api.BindGroupLayout;
import org.webgpu.api.RenderPipeline;
import org.webgpu.panama.WGPUStringView;
import org.webgpu.panama.webgpu_h;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;

public class RenderPipelineImpl implements RenderPipeline {

    private MemorySegment memorySegment;

    @Override
    public BindGroupLayout getBindGroupLayout(int groupIndex) {
        return null;
    }

    @Override
    public void setLabel(final String label) {
        final Arena arena = Arena.ofAuto();
        final var stringView = arena.allocate(WGPUStringView.layout());
        final var labelSegment = arena.allocateFrom(label);
        WGPUStringView.data(stringView, labelSegment);
        WGPUStringView.length(stringView, label.length());
        webgpu_h.wgpuRenderPipelineSetLabel(this.memorySegment, stringView);
    }
}
