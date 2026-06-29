package org.webgpu.impl;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;

import org.webgpu.api.BindGroupLayout;
import org.webgpu.api.ComputePipeline;
import org.webgpu.panama.foreign.webgpu_h;
import org.webgpu.util.StringView;

public record ComputePipelineImpl(MemorySegment ptr) implements ComputePipeline {
    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(ComputePipelineImpl.class);
    @Override
    public BindGroupLayout getBindGroupLayout(int groupIndex) {
        final var bindGroupLayoutPtr = webgpu_h.wgpuComputePipelineGetBindGroupLayout(ptr, groupIndex);

        return new BindGroupLayoutImpl(bindGroupLayoutPtr);
    }

    @Override
    public void setLabel(String label) {
        try {
            Arena arena = Arena.ofAuto();
            var stringView = StringView.of(arena, label);
            webgpu_h.wgpuComputePipelineSetLabel(ptr, stringView);
        } catch (Exception e) {
            throw new RuntimeException("Failed to set label for ComputePipeline", e);
        }
    }

    @Override
    public void addRef() {
        webgpu_h.wgpuComputePipelineAddRef(ptr);
    }

    @Override
    public void release() {
        webgpu_h.wgpuComputePipelineRelease(ptr);
    }

}
