package org.webgpu.impl;

import java.lang.foreign.MemorySegment;

import org.webgpu.api.Buffer;

public record BufferImpl(MemorySegment ptr) implements Buffer {
    
}
