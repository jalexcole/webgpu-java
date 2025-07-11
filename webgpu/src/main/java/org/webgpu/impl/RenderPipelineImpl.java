package org.webgpu.impl;

import java.lang.foreign.MemorySegment;

import org.webgpu.api.RenderPipeline;

public record RenderPipelineImpl(MemorySegment ptr) implements RenderPipeline {
    
}
