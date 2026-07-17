package org.webgpu.impl;

import java.lang.foreign.MemorySegment;

import org.jspecify.annotations.NonNull;

public sealed interface WebGPUObjectImpl permits AdapterImpl, BindGroupImpl, BufferImpl, RenderPipelineImpl, CommandBufferImpl, BindGroupLayoutImpl, ComputePipelineImpl, QuerySetImpl, SamplerImpl, TextureViewImpl, PipelineLayoutImpl, DeviceImpl, TextureImpl {
    
    @NonNull
    public MemorySegment ptr();
}
