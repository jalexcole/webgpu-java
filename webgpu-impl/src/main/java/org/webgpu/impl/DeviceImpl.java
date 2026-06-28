package org.webgpu.impl;

import org.webgpu.api.*;
import org.webgpu.panama.webgpu_h;

import java.lang.foreign.MemorySegment;

public class DeviceImpl implements Device {

    private final MemorySegment memorySegment;

    public DeviceImpl(MemorySegment memorySegment) {
        this.memorySegment = memorySegment;
    }
    
    @Override
    public BindGroup createBindGroup(BindGroupDescriptor descriptor) {
        return null;
    }

    @Override
    public BindGroupLayout createBindGroupLayout(BindGroupLayoutDescriptor descriptor) {
        return null;
    }

    @Override
    public Buffer createBuffer(BufferDescriptor descriptor) {
        return null;
    }

    @Override
    public CommandEncoder createCommandEncoder(CommandEncoderDescriptor descriptor) {
        return null;
    }

    @Override
    public ComputePipeline createComputePipeline(ComputePipelineDescriptor descriptor) {
        return null;
    }

    @Override
    public void createComputePipelineAsync(ComputePipelineDescriptor descriptor) {

    }

    @Override
    public PipelineLayout createPipelineLayout(PipelineLayoutDescriptor descriptor) {
        return null;
    }

    @Override
    public QuerySet createQuerySet(QuerySetDescriptor descriptor) {
        return null;
    }

    @Override
    public void createRenderPipelineAsync(RenderPipelineDescriptor descriptor) {

    }

    @Override
    public RenderBundleEncoder createRenderBundleEncoder(RenderBundleEncoderDescriptor descriptor) {
        return null;
    }

    @Override
    public RenderPipeline createRenderPipeline(RenderPipelineDescriptor descriptor) {
        return null;
    }

    @Override
    public Sampler createSampler(SamplerDescriptor descriptor) {
        return null;
    }

    @Override
    public ShaderModule createShaderModule(ShaderModuleDescriptor descriptor) {
        return null;
    }

    @Override
    public Texture createTexture(TextureDescriptor descriptor) {
        return null;
    }

    @Override
    public void destroy() {

    }

    @Override
    public Future getLostFuture() {
        return null;
    }

    @Override
    public Status getLimits(Limits limits) {
        // webgpu_h.wgpuDeviceGetLimits(this.memorySegment, )
        return null;
    }

    @Override
    public boolean hasFeature(FeatureName feature) {
        return false;
    }

    @Override
    public void getFeatures(SupportedFeatures features) {

    }

    @Override
    public Status getAdapterInfo(AdapterInfo adapterInfo) {
        return null;
    }

    @Override
    public Queue getQueue() {
        return null;
    }

    @Override
    public void pushErrorScope(ErrorFilter filter) {

    }

    @Override
    public void popErrorScope() {

    }

    @Override
    public void setLabel(String label) {

    }
}
