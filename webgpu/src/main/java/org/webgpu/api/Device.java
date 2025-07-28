package org.webgpu.api;

import java.util.concurrent.Future;

import org.jspecify.annotations.Nullable;
import org.webgpu.impl.AdapterInfoImpl;

/**
 * A GPUDevice encapsulates a device and exposes the functionality of that
 * device.
 * 
 * GPUDevice is the top-level interface through which WebGPU interfaces are
 * created.
 * 
 * To get a GPUDevice, use requestDevice().
 * 
 */
public interface Device extends ObjectBase {

    // [SameObject]
    void attribute();

    SupportedFeatures features();// [SameObject]

    // readonly attribute

    SupportedLimits limits();// [SameObject]

   // readonly attribute

    AdapterInfoImpl adapterInfo();

    // [SameObject]

    // readonly attribute
    Queue queue();

    void destroy();

    Buffer createBuffer(BufferDescriptor descriptor);

    Texture createTexture(TextureDescriptor descriptor);

    Sampler createSampler(@Nullable SamplerDescriptor descriptor);
    
    /**
     * Creates a GPUExternalTexture wrapping the provided image source.
     * 
     * @param descriptor
     * @return
     */
    ExternalTexture importExternalTexture(ExternalTextureDescriptor descriptor);

    BindGroupLayout createBindGroupLayout(BindGroupLayoutDescriptor descriptor);

    PipelineLayout createPipelineLayout(PipelineLayoutDescriptor descriptor);

    BindGroup createBindGroup(BindGroupDescriptor descriptor);

    ShaderModule createShaderModule(ShaderModuleDescriptor descriptor);

    ComputePipeline createComputePipeline(ComputePipelineDescriptor descriptor);

    RenderPipeline createRenderPipeline(RenderPipelineDescriptor descriptor);

    Future<ComputePipeline> createComputePipelineAsync(ComputePipelineDescriptor descriptor);

    Future<RenderPipeline> createRenderPipelineAsync(RenderPipelineDescriptor descriptor);

    CommandEncoder createCommandEncoder(@Nullable CommandEncoderDescriptor descriptor);

    RenderBundleEncoder createRenderBundleEncoder(RenderBundleEncoderDescriptor descriptor);

    QuerySet createQuerySet(QuerySetDescriptor descriptor);

}
