package org.webgpu.impl;

import java.lang.foreign.MemorySegment;

import org.webgpu.api.TextureView;
import org.webgpu.extract.webgpu_h;

public record TextureViewImpl(MemorySegment ptr) implements TextureView {

    @Override
    public void setLabel(String label) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setLabel'");
    }

    @Override
    public void addRef() {
        webgpu_h.wgpuTextureViewAddRef(ptr);
    }

    @Override
    public void release() {
        webgpu_h.wgpuTextureViewRelease(ptr);
    }
    
}
