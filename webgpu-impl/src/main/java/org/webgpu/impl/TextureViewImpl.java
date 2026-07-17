package org.webgpu.impl;

import java.lang.foreign.MemorySegment;

import org.webgpu.api.*;
import org.webgpu.api.exceptions.WGPUException;

public final class TextureViewImpl implements TextureView, WebGPUObjectImpl {

    private final MemorySegment memorySegment;

    public TextureViewImpl(MemorySegment memorySegment) {
        this.memorySegment = memorySegment;
    }

    @Override
    public void setLabel(String label) {
        throw new WGPUException(new UnsupportedOperationException("Unimplemented method 'setLabel'"));
    }

    @Override
    public MemorySegment ptr() {
        return memorySegment;
    }
}


