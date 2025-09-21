package org.webgpu.impl;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;
import java.util.concurrent.Future;

import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;
import org.webgpu.api.BindGroup;
import org.webgpu.api.BindGroupDescriptor;
import org.webgpu.api.BindGroupLayout;
import org.webgpu.api.BindGroupLayoutDescriptor;
import org.webgpu.api.Buffer;
import org.webgpu.api.BufferDescriptor;
import org.webgpu.api.CommandEncoder;
import org.webgpu.api.CommandEncoderDescriptor;
import org.webgpu.api.ComputePipeline;
import org.webgpu.api.ComputePipelineDescriptor;
import org.webgpu.api.Device;
import org.webgpu.api.ExternalTexture;
import org.webgpu.api.ExternalTextureDescriptor;
import org.webgpu.api.PipelineLayout;
import org.webgpu.api.PipelineLayoutDescriptor;
import org.webgpu.api.QuerySet;
import org.webgpu.api.QuerySetDescriptor;
import org.webgpu.api.Queue;
import org.webgpu.api.RenderBundleEncoder;
import org.webgpu.api.RenderBundleEncoderDescriptor;
import org.webgpu.api.RenderPipeline;
import org.webgpu.api.RenderPipelineDescriptor;
import org.webgpu.api.Sampler;
import org.webgpu.api.SamplerDescriptor;
import org.webgpu.api.ShaderModule;
import org.webgpu.api.ShaderModuleDescriptor;
import org.webgpu.api.SupportedFeatures;
import org.webgpu.api.SupportedLimits;
import org.webgpu.api.Texture;
import org.webgpu.api.TextureDescriptor;
import org.webgpu.panama.foreign.WGPUAdapterInfo;
import org.webgpu.panama.foreign.WGPUSupportedFeatures;
import org.webgpu.panama.foreign.webgpu_h;

public record DeviceImpl(MemorySegment ptr, Arena arena) implements Device {

    @Override
    public SupportedFeatures features() {
        Arena arena = Arena.ofAuto();
        MemorySegment featuresSegment = WGPUSupportedFeatures.allocate(arena);

        webgpu_h.wgpuAdapterGetFeatures(ptr, featuresSegment);

        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'features'");
    }

    @Override
    public SupportedLimits limits() {
        Arena arena = Arena.ofAuto();

        webgpu_h.wgpuDeviceGetLimits(ptr, null);
        throw new UnsupportedOperationException("Unimplemented method 'limits'");
    }

    @Override
    public AdapterInfoImpl adapterInfo() {
        try {
            Arena arena = Arena.ofAuto();
            var adapterInfo = WGPUAdapterInfo.allocate(arena);
            webgpu_h.wgpuAdapterGetInfo(this.ptr, adapterInfo);

            Arena autoArena = Arena.ofAuto();
            var output = WGPUAdapterInfo.allocate(autoArena);

            return new AdapterInfoImpl(adapterInfo);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public Queue queue() {
        return new QueueImpl(webgpu_h.wgpuDeviceGetQueue(this.ptr));
    }

    @Override
    public void destroy() {
        webgpu_h.wgpuDeviceRelease(this.ptr);
    }

    @Override
    public Buffer createBuffer(@NonNull BufferDescriptor descriptor) {
        var bufferPtr = webgpu_h.wgpuDeviceCreateBuffer(this.ptr,
                descriptor != null ? descriptor.ptr() : MemorySegment.NULL);

        return new BufferImpl(bufferPtr);

    }

    @Override
    public Texture createTexture(TextureDescriptor descriptor) {
        final var texturePtr = webgpu_h.wgpuDeviceCreateTexture(this.ptr,
                descriptor != null ? descriptor.ptr() : MemorySegment.NULL);

        return new TextureImpl(texturePtr);
    }

    @Override
    public Sampler createSampler(@Nullable SamplerDescriptor descriptor) {
        final var samplerPtr = webgpu_h.wgpuDeviceCreateSampler(this.ptr,
                descriptor != null ? descriptor.ptr() : MemorySegment.NULL);

        return new SamplerImpl(samplerPtr);
    }

    @Override
    public ExternalTexture importExternalTexture(ExternalTextureDescriptor descriptor) {

        throw new UnsupportedOperationException("Unimplemented method 'importExternalTexture'");
    }

    @Override
    public BindGroupLayout createBindGroupLayout(BindGroupLayoutDescriptor descriptor) {
        final var bindGroupLayoutPtr = webgpu_h.wgpuDeviceCreateBindGroupLayout(this.ptr,
                descriptor != null ? descriptor.ptr() : MemorySegment.NULL);

        return new BindGroupLayoutImpl(bindGroupLayoutPtr);
    }

    @Override
    public PipelineLayout createPipelineLayout(PipelineLayoutDescriptor descriptor) {
        final var pipelineLayoutPtr = webgpu_h.wgpuDeviceCreatePipelineLayout(this.ptr,
                descriptor != null ? descriptor.ptr() : MemorySegment.NULL);

        return new PipelineLayoutImpl(pipelineLayoutPtr);
    }

    @Override
    public BindGroup createBindGroup(BindGroupDescriptor descriptor) {
        final var bindGroupPtr = webgpu_h.wgpuDeviceCreateBindGroup(this.ptr,
                descriptor != null ? descriptor.ptr() : MemorySegment.NULL);
        return new BindGroupImpl(bindGroupPtr);
    }

    @Override
    public ShaderModule createShaderModule(ShaderModuleDescriptor descriptor) {
        final var shaderModulePtr = webgpu_h.wgpuDeviceCreateShaderModule(this.ptr,
                descriptor != null ? descriptor.ptr() : MemorySegment.NULL);

        return new ShaderModuleImpl(shaderModulePtr);
    }

    @Override
    public ComputePipeline createComputePipeline(ComputePipelineDescriptor descriptor) {
        final var computePipelinePtr = webgpu_h.wgpuDeviceCreateComputePipeline(this.ptr,
                descriptor != null ? descriptor.ptr() : MemorySegment.NULL);

        return new ComputePipelineImpl(computePipelinePtr);
    }

    @Override
    public RenderPipeline createRenderPipeline(RenderPipelineDescriptor descriptor) {
        final var renderPipelinePtr = webgpu_h.wgpuDeviceCreateRenderPipeline(this.ptr,
                descriptor != null ? descriptor.ptr() : MemorySegment.NULL);

        return new RenderPipelineImpl(renderPipelinePtr);
    }

    @Override
    public Future<ComputePipeline> createComputePipelineAsync(ComputePipelineDescriptor descriptor) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createComputePipelineAsync'");
    }

    @Override
    public Future<RenderPipeline> createRenderPipelineAsync(RenderPipelineDescriptor descriptor) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createRenderPipelineAsync'");
    }

    @Override
    public CommandEncoder createCommandEncoder(@Nullable CommandEncoderDescriptor descriptor) {
        final var commandEncoderPtr = webgpu_h.wgpuDeviceCreateCommandEncoder(this.ptr,
                descriptor != null ? descriptor.ptr() : MemorySegment.NULL);

        return new CommandEncoder(commandEncoderPtr);
    }

    @Override
    public RenderBundleEncoder createRenderBundleEncoder(RenderBundleEncoderDescriptor descriptor) {
        final var renderBundleEncoderPtr = webgpu_h.wgpuDeviceCreateRenderBundleEncoder(this.ptr,
                descriptor != null ? descriptor.ptr() : MemorySegment.NULL);

        return new RenderBundleEncoderImpl(renderBundleEncoderPtr);
    }

    @Override
    public QuerySet createQuerySet(QuerySetDescriptor descriptor) {
        final MemorySegment querySetPtr = webgpu_h.wgpuDeviceCreateQuerySet(this.ptr,
                descriptor != null ? descriptor.ptr() : MemorySegment.NULL);

        return new QuerySetImpl(querySetPtr);
    }

}
