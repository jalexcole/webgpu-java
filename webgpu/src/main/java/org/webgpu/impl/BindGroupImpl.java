package org.webgpu.impl;

import java.lang.foreign.MemorySegment;

import org.webgpu.api.BindGroup;

public record BindGroupImpl(MemorySegment ptr) implements BindGroup {
    
}
