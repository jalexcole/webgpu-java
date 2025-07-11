package org.webgpu.impl;

import java.lang.foreign.MemorySegment;

import org.webgpu.api.RenderPassEncoder;

public record RenderPassEncoderImpl(MemorySegment ptr) implements RenderPassEncoder {
    
}
