package org.webgpu.impl;

import java.lang.foreign.MemorySegment;

import org.webgpu.api.CommandBufferEncoder;

public record CommandBufferEncoderImpl(MemorySegment ptr) implements CommandBufferEncoder {
    
}
