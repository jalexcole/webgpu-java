package org.webgpu.impl;

import java.lang.foreign.MemorySegment;

import org.webgpu.api.RenderBundleEncoder;

public record RenderBundleEncoderImpl(MemorySegment ptr) implements RenderBundleEncoder {
    
}
