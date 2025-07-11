package org.webgpu.impl;

import java.lang.foreign.MemorySegment;

import org.webgpu.api.Texture;

public record TextureImpl(MemorySegment ptr) implements Texture {
    
}
