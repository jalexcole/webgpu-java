package org.webgpu.impl;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;
import java.util.concurrent.Future;

import org.jspecify.annotations.Nullable;
import org.webgpu.api.AdapterInfo;
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
import org.webgpu.extract.WGPUAdapterInfo;
import org.webgpu.extract.webgpu_h;

public record DeviceImpl(MemorySegment ptr) implements Device {

    @Override
    public void attribute() {

        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'attribute'");
    }

    @Override
    public SupportedFeatures features() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'features'");
    }

    @Override
    public SupportedLimits limits() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'limits'");
    }

    @Override
    public AdapterInfo adapterInfo() {
        try  {
            Arena arena = Arena.ofAuto();
            var adapterInfo = WGPUAdapterInfo.allocate(arena);
            webgpu_h.wgpuAdapterGetInfo(this.ptr, adapterInfo);

            Arena autoArena = Arena.ofAuto();
            var output = WGPUAdapterInfo.allocate(autoArena);
            
            // return new AdapterInfo()
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'adapterInfo'");
    }

    @Override
    public Queue queue() {
        return new QueueImpl(webgpu_h.wgpuDeviceGetQueue(this.ptr));
    }

    @Override
    public void destroy() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'destroy'");
    }

    @Override
    public Buffer createBuffer(BufferDescriptor descriptor) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createBuffer'");
    }

    @Override
    public Texture createTexture(TextureDescriptor descriptor) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createTexture'");
    }

    @Override
    public Sampler createSampler(@Nullable SamplerDescriptor descriptor) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createSampler'");
    }

    @Override
    public ExternalTexture importExternalTexture(ExternalTextureDescriptor descriptor) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'importExternalTexture'");
    }

    @Override
    public BindGroupLayout createBindGroupLayout(BindGroupLayoutDescriptor descriptor) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createBindGroupLayout'");
    }

    @Override
    public PipelineLayout createPipelineLayout(PipelineLayoutDescriptor descriptor) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createPipelineLayout'");
    }

    @Override
    public BindGroup createBindGroup(BindGroupDescriptor descriptor) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createBindGroup'");
    }

    @Override
    public ShaderModule createShaderModule(ShaderModuleDescriptor descriptor) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createShaderModule'");
    }

    @Override
    public ComputePipeline createComputePipeline(ComputePipelineDescriptor descriptor) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createComputePipeline'");
    }

    @Override
    public RenderPipeline createRenderPipeline(RenderPipelineDescriptor descriptor) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createRenderPipeline'");
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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createCommandEncoder'");
    }

    @Override
    public RenderBundleEncoder createRenderBundleEncoder(RenderBundleEncoderDescriptor descriptor) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createRenderBundleEncoder'");
    }

    @Override
    public QuerySet createQuerySet(QuerySetDescriptor descriptor) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createQuerySet'");
    }

}
