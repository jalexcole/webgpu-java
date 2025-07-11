package org.webgpu.impl;

import java.lang.foreign.MemorySegment;

import org.webgpu.api.BindGroupLayout;

public record BindGroupLayoutImpl(MemorySegment ptr) implements BindGroupLayout {
    
}
