package org.webgpu.impl;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;

import org.webgpu.api.RenderPipeline;
import org.webgpu.extract.webgpu_h;
import org.webgpu.util.StringView;

public record RenderPipelineImpl(MemorySegment ptr) implements RenderPipeline {

    @Override
    public void setLabel(String label) {
        try (Arena arena = Arena.ofConfined()) {
            MemorySegment labelSegment = StringView.of(arena, label);
            webgpu_h.wgpuRenderPipelineSetLabel(this.ptr, labelSegment);
        }
    }

    @Override
    public void addRef() {
        webgpu_h.wgpuRenderPipelineAddRef(ptr);
    }

    @Override
    public void release() {
        webgpu_h.wgpuRenderPipelineRelease(ptr);
    }
    
}
