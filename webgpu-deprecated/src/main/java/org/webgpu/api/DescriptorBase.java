package org.webgpu.api;

public sealed interface DescriptorBase permits BufferDescriptor, BindGroupDescriptor, ComputePassDescriptor,
        CommandBufferDescriptor, RenderPassDescriptor, InstanceDescriptor, PipelineLayoutDescriptor, QuerySetDescriptor,
        RenderBundleDescriptor, RenderBundleEncoderDescriptor, RenderPipelineDescriptor, ShaderModuleDescriptor,
        SurfaceDescriptor, TextureDescriptor, TextureViewDescriptor {

}
