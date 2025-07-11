package org.webgpu.impl;

import java.lang.foreign.MemorySegment;

import org.webgpu.api.TextureView;

public record TextureViewImpl(MemorySegment ptr) implements TextureView {
    
}
