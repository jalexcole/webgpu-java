package org.webgpu.impl;

import java.lang.foreign.MemorySegment;

import org.webgpu.api.RenderBundle;

public record RenderBundleImpl(MemorySegment ptr) implements RenderBundle {
    
}
