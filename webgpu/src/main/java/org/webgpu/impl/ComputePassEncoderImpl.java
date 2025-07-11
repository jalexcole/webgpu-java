package org.webgpu.impl;

import java.lang.foreign.MemorySegment;

import org.webgpu.api.ComputePassEncoder;

public record ComputePassEncoderImpl(MemorySegment ptr) implements ComputePassEncoder {
    
}
