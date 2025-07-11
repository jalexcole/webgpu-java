package org.webgpu.impl;

import java.lang.foreign.MemorySegment;

import org.webgpu.api.Sampler;

public record SamplerImpl(MemorySegment ptr) implements Sampler{
    
}
