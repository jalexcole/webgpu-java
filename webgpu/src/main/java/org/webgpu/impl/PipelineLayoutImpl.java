package org.webgpu.impl;

import java.lang.foreign.MemorySegment;

import org.webgpu.api.PipelineLayout;
import org.webgpu.panama.foreign.webgpu_h;

public record PipelineLayoutImpl(MemorySegment ptr) implements PipelineLayout {

    @Override
    public void setLabel(String label) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setLabel'");
    }

    @Override
    public void addRef() {
        webgpu_h.wgpuPipelineLayoutAddRef(ptr);
    }

    @Override
    public void release() {
        webgpu_h.wgpuPipelineLayoutRelease(ptr);
    }

}
