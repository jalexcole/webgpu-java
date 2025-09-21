package org.webgpu.impl;

import java.lang.foreign.MemorySegment;

import org.webgpu.api.RenderBundle;
import org.webgpu.foreign.webgpu_h;

public record RenderBundleImpl(MemorySegment ptr) implements RenderBundle {

    @Override
    public void setLabel(String label) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setLabel'");
    }

    @Override
    public void addRef() {
        webgpu_h.wgpuRenderBundleAddRef(ptr);
    }

    @Override
    public void release() {
        webgpu_h.wgpuRenderBundleRelease(ptr);
    }
    
}
