package org.webgpu.impl;

import org.jspecify.annotations.NullMarked;
import org.webgpu.api.*;
import org.webgpu.api.exceptions.WGPUException;
import org.webgpu.impl.util.StructTools;
import org.webgpu.panama.WGPUFuture;
import org.webgpu.panama.webgpu_h;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

@NullMarked
public final class DeviceImpl implements Device, WebGPUObjectImpl {

    private final MemorySegment memorySegment;
    private final AtomicBoolean destroyed = new AtomicBoolean(false);
    private final Arena arena = Arena.ofAuto();

    public DeviceImpl(MemorySegment memorySegment) {
        this.memorySegment = memorySegment;
    }
    
    @Override
    public BindGroup createBindGroup(BindGroupDescriptor descriptor) {
        final MemorySegment descriptorPtr = StructTools.fetchSegment(descriptor);
        final var bindgroupPtr = webgpu_h.wgpuDeviceCreateBindGroup(this.memorySegment, descriptorPtr);
        return new BindGroupImpl(bindgroupPtr);
    }

    @Override
    public BindGroupLayoutImpl createBindGroupLayout(BindGroupLayoutDescriptor descriptor) {
        final var descriptorPtr = StructTools.fetchSegment(descriptor);
        final var BindGroupLayoutPtr = webgpu_h.wgpuDeviceCreateBindGroupLayout(this.memorySegment, descriptorPtr);
        return new BindGroupLayoutImpl(BindGroupLayoutPtr);
    }

    @Override
    public BufferImpl createBuffer(BufferDescriptor descriptor) {
        final var descriptorPtr = StructTools.fetchSegment(descriptor);
        final var bufferPtr = webgpu_h.wgpuDeviceCreateBuffer(this.memorySegment, descriptorPtr);
        return new BufferImpl(bufferPtr);
    }

    @Override
    public CommandEncoderImpl createCommandEncoder(CommandEncoderDescriptor descriptor) {
        final var descriptorPtr = StructTools.fetchSegment(descriptor);
        final var commandEncoderPtr = webgpu_h.wgpuDeviceCreateCommandEncoder(this.memorySegment, descriptorPtr);
        return new CommandEncoderImpl(commandEncoderPtr);
    }

    @Override
    public ComputePipelineImpl createComputePipeline(ComputePipelineDescriptor descriptor) {
        final var descriptorPtr = StructTools.fetchSegment(descriptor);
        final var computePipelinePtr = webgpu_h.wgpuDeviceCreateComputePipeline(this.memorySegment, descriptorPtr);
        return new ComputePipelineImpl(computePipelinePtr);
    }

    
    public void createComputePipelineAsync(ComputePipelineDescriptor descriptor) {
        final var descriptorPtr = StructTools.fetchSegment(descriptor);
        
        // TODO: Investigate why callback function is missing.
    }

    @Override
    public PipelineLayoutImpl createPipelineLayout(PipelineLayoutDescriptor descriptor) {
        final var descriptorPtr = StructTools.fetchSegment(descriptor);
        final var pipelineLayoutPtr = webgpu_h.wgpuDeviceCreatePipelineLayout(this.memorySegment, descriptorPtr);
        return new PipelineLayoutImpl(pipelineLayoutPtr);
    }

    @Override
    public QuerySetImpl createQuerySet(QuerySetDescriptor descriptor) {
        final var descriptorPtr = StructTools.fetchSegment(descriptor);
        return new QuerySetImpl(webgpu_h.wgpuDeviceCreateQuerySet(memorySegment, descriptorPtr));
    }

    
    public void createRenderPipelineAsync(RenderPipelineDescriptor descriptor) {
        final var descriptorPtr = StructTools.fetchSegment(descriptor);
        throw new UnsupportedOperationException();
    }

    @Override
    public RenderBundleEncoderImpl createRenderBundleEncoder(RenderBundleEncoderDescriptor descriptor) {
        final var descriptorPtr = StructTools.fetchSegment(descriptor);
        return null;
    }

    @Override
    public RenderPipelineImpl createRenderPipeline(RenderPipelineDescriptor descriptor) {
        final var descriptorPtr = StructTools.fetchSegment(descriptor);
        final var renderPipelinePtr = webgpu_h.wgpuDeviceCreateRenderPipeline(this.memorySegment, descriptorPtr);
        return new RenderPipelineImpl(renderPipelinePtr);
    }

    @Override
    public SamplerImpl createSampler(SamplerDescriptor descriptor) {
        final var descriptorPtr = StructTools.fetchSegment(descriptor);
        final var samplerPtr = webgpu_h.wgpuDeviceCreateSampler(this.memorySegment, descriptorPtr);
        return new SamplerImpl(samplerPtr);
    }

    @Override
    public ShaderModule createShaderModule(ShaderModuleDescriptor descriptor) {
        final var descriptorPtr = StructTools.fetchSegment(descriptor);
        final var shaderModulePtr = webgpu_h.wgpuDeviceCreateShaderModule(this.memorySegment, descriptorPtr);
        return new ShaderModuleImpl(shaderModulePtr);
    }

    @Override
    public Texture createTexture(TextureDescriptor descriptor) {
        final var descriptorPtr = StructTools.fetchSegment(descriptor);
        final var texturePtr = webgpu_h.wgpuDeviceCreateTexture(this.memorySegment, descriptorPtr);
        return new TextureImpl(texturePtr);
    }

    @Override
    public void destroy() {
        if (!destroyed.compareAndExchange(false, true)) {
            webgpu_h.wgpuDeviceDestroy(this.memorySegment);
        }
    }

    @Override
    public Future getLostFuture() {
        final var futurePtr = webgpu_h.wgpuDeviceGetLostFuture(arena, this.memorySegment);
        return StructTools.placeSegment(futurePtr, Future.class);
    }

    @Override
    public Status getLimits(Limits limits) {
        final MemorySegment limitsPtr = StructTools.fetchSegment(limits);
        final int statusCode = webgpu_h.wgpuDeviceGetLimits(this.memorySegment, limitsPtr);
        return Status.values()[statusCode];
    }

    @Override
    public boolean hasFeature(FeatureName feature) {
        final int result = webgpu_h.wgpuDeviceHasFeature(memorySegment, feature.value());
        return result == webgpu_h.WGPU_TRUE();
    }

    @Override
    public void getFeatures(SupportedFeatures features) {
        final MemorySegment featuresPtr = StructTools.fetchSegment(features);
        Objects.requireNonNull(featuresPtr);
        webgpu_h.wgpuDeviceGetFeatures(this.memorySegment, featuresPtr);
    }

    @Override
    public Status getAdapterInfo(AdapterInfo adapterInfo) {
        final var adapterInfoPtr = StructTools.fetchSegment(adapterInfo);
        Objects.requireNonNull(adapterInfoPtr);
        final int statusCode = webgpu_h.wgpuDeviceGetAdapterInfo(this.memorySegment, adapterInfoPtr);
        return Status.values()[statusCode];
    }

    @Override
    public Queue getQueue() {
        final var queuePtr = webgpu_h.wgpuDeviceGetQueue(memorySegment);
        return new QueueImpl(queuePtr);
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

    @Override
    public MemorySegment ptr() {
        return this.memorySegment;
    }
}
