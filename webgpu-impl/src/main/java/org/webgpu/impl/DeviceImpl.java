package org.webgpu.impl;

import org.jspecify.annotations.NullMarked;
import org.webgpu.api.*;
import org.webgpu.api.exceptions.WGPUException;
import org.webgpu.impl.util.StructTools;
import org.webgpu.panama.webgpu_h;

import java.lang.foreign.MemorySegment;
import java.util.concurrent.atomic.AtomicBoolean;

@NullMarked
public class DeviceImpl implements Device {

    private final MemorySegment memorySegment;
    private final AtomicBoolean destroyed = new AtomicBoolean(false);

    public DeviceImpl(MemorySegment memorySegment) {
        this.memorySegment = memorySegment;
    }
    
    @Override
    public BindGroup createBindGroup(BindGroupDescriptor descriptor) {
        final MemorySegment descriptorPtr = StructTools.fetchSegment(descriptor);
        final var bindgroupPtr = webgpu_h.wgpuDeviceCreateBindGroup(this.memorySegment, descriptorPtr)
        return new BindGroupImpl(bindgroupPtr);
    }

    @Override
    public BindGroupLayoutImpl createBindGroupLayout(BindGroupLayoutDescriptor descriptor) {
        return null;
    }

    @Override
    public Buffer createBuffer(BufferDescriptor descriptor) {
        return null;
    }

    @Override
    public CommandEncoderImpl createCommandEncoder(CommandEncoderDescriptor descriptor) {
        return null;
    }

    @Override
    public ComputePipelineImpl createComputePipeline(ComputePipelineDescriptor descriptor) {
        return null;
    }

    
    public void createComputePipelineAsync(ComputePipelineDescriptor descriptor) {

    }

    @Override
    public PipelineLayoutImpl createPipelineLayout(PipelineLayoutDescriptor descriptor) {
        return null;
    }

    @Override
    public QuerySetImpl createQuerySet(QuerySetDescriptor descriptor) {
        return new QuerySetImpl(webgpu_h.wgpuDeviceCreateQuerySet(memorySegment, StructTools.fetchSegment(descriptor)));
    }

    
    public void createRenderPipelineAsync(RenderPipelineDescriptor descriptor) {
        throw new UnsupportedOperationException();
    }

    @Override
    public RenderBundleEncoderImpl createRenderBundleEncoder(RenderBundleEncoderDescriptor descriptor) {
        return null;
    }

    @Override
    public RenderPipelineImpl createRenderPipeline(RenderPipelineDescriptor descriptor) {
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
        if (!destroyed.compareAndExchange(false, true)) {
            webgpu_h.wgpuDeviceDestroy(this.memorySegment);
        }
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
        return new QueueImpl(webgpu_h.wgpuDeviceGetQueue(memorySegment));
    }

    @Override
    public void pushErrorScope(ErrorFilter filter) {
        webgpu_h.wgpuDevicePushErrorScope(this.memorySegment, filter.value());
    }

    @Override
    public void setLabel(String label) {
        throw new WGPUException(new UnsupportedOperationException());
    }

    

    @Override
    public void popErrorScope(PopErrorScope callback) {
        throw new UnsupportedOperationException("Unimplemented method 'popErrorScope'");
    }

    @Override
    public void createComputePipelineAsync(CreateComputePipelineAsync callback, ComputePipelineDescriptor descriptor) {
        throw new UnsupportedOperationException("Unimplemented method 'createComputePipelineAsync'");
    }

    @Override
    public void createRenderPipelineAsync(CreateRenderPipelineAsync callback, RenderPipelineDescriptor descriptor) {
        throw new UnsupportedOperationException("Unimplemented method 'createRenderPipelineAsync'");
    }
}
