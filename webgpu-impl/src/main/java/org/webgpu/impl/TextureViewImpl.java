package org.webgpu.impl;

import java.lang.foreign.MemorySegment;

import org.webgpu.api.*;

public class TextureViewImpl implements TextureView {

    private final MemorySegment memorySegment;

    public TextureViewImpl(MemorySegment memorySegment) {
        this.memorySegment = memorySegment;
    }

    @Override
    public void setLabel(String label) {

    }
}


