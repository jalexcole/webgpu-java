package org.webgpu.impl;

import java.lang.foreign.MemorySegment;

import org.webgpu.api.ComputePipeline;

public record ComputePipelineImpl(MemorySegment ptr) implements ComputePipeline {
    
}
