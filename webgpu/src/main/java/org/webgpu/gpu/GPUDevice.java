package org.webgpu.gpu;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;

/**
 * A GPUDevice encapsulates a device and exposes the functionality of that
 * device.
 * 
 * GPUDevice is the top-level interface through which WebGPU interfaces are
 * created.
 * 
 * To get a GPUDevice, use requestDevice().
 */
public interface GPUDevice extends GPUObjectBase{
    public GPUBuffer createBuffer(GPUBufferDescriptor descriptor);

    public GPUTexture createTexture(GPUTextureDescriptor descriptor);

    public GPUSampler createSampler(Optional<GPUSamplerDescriptor> descriptor);

    public GPUExternalTexture importExternalTexture(GPUExternalTextureDescriptor descriptor);

    public GPUBindGroupLayout createBindGroupLayout(GPUBindGroupLayoutDescriptor descriptor);

    public GPUPipelineLayout createPipelineLayout(GPUPipelineLayoutDescriptor descriptor);

    public GPUBindGroup createBindGroup(GPUBindGroupDescriptor descriptor);

    public GPUShaderModule createShaderModule(GPUShaderModuleDescriptor descriptor);

    public GPUComputePipeline createComputePipeline(GPUComputePipelineDescriptor descriptor);

    public GPURenderPipeline createRenderPipeline(GPURenderPipelineDescriptor descriptor);

    public CompletableFuture<GPUComputePipeline> createComputePipelineAsync(GPUComputePipelineDescriptor descriptor);

    public CompletableFuture<GPURenderPipeline> createRenderPipelineAsync(GPURenderPipelineDescriptor descriptor);

    public GPUCommandEncoder createCommandEncoder(Optional<GPUCommandEncoderDescriptor> descriptor);

    public GPURenderBundleEncoder createRenderBundleEncoder(GPURenderBundleEncoderDescriptor descriptor);

    public GPUQuerySet createQuerySet(GPUQuerySetDescriptor descriptor);
}
