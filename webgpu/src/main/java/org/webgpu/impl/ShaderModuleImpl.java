package org.webgpu.impl;

import java.lang.foreign.MemorySegment;

import org.webgpu.api.ShaderModule;

public record ShaderModuleImpl(MemorySegment ptr) implements ShaderModule {
    
}
