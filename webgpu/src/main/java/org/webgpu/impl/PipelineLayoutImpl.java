package org.webgpu.impl;

import java.lang.foreign.MemorySegment;

import org.webgpu.api.PipelineLayout;

public record PipelineLayoutImpl(MemorySegment ptr) implements PipelineLayout {
    
}
