package org.webgpu.impl;

import java.lang.foreign.MemorySegment;
import java.util.Optional;

import org.webgpu.api.ChainedStruct;
import org.webgpu.api.Limits;
import org.webgpu.panama.foreign.WGPULimits;

public record LimitsImpl(MemorySegment ptr) implements Limits {
    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(LimitsImpl.class);
    @Override
    public Optional<ChainedStruct> nextInChain() {
        var nextInChainPtr = WGPULimits.nextInChain(this.ptr);

        if (nextInChainPtr == MemorySegment.NULL || nextInChainPtr == null) {
            return Optional.empty();
        }
        return Optional.of(new ChainedStruct(nextInChainPtr));
    }

    @Override
    public int maxTextureDimension1D() {
        return WGPULimits.maxTextureDimension1D(this.ptr);
    }

    @Override
    public int maxTextureDimension2D() {
        return WGPULimits.maxTextureDimension2D(this.ptr);
    }

    @Override
    public int maxTextureDimension3D() {
        return WGPULimits.maxTextureDimension3D(this.ptr);
    }

    @Override
    public int maxTextureArrayLayers() {
        return WGPULimits.maxTextureArrayLayers(this.ptr);
    }

    @Override
    public int maxBindGroups() {
        return WGPULimits.maxBindGroups(this.ptr);
    }

    @Override
    public int maxBindGroupsPlusVertexBuffers() {
        return WGPULimits.maxBindGroupsPlusVertexBuffers(this.ptr);
    }

    @Override
    public int maxBindingsPerBindGroup() {
        return WGPULimits.maxBindingsPerBindGroup(this.ptr);
    }

    @Override
    public int maxDynamicUniformBuffersPerPipelineLayout() {
        return WGPULimits.maxDynamicUniformBuffersPerPipelineLayout(this.ptr);
    }

    @Override
    public int maxDynamicStorageBuffersPerPipelineLayout() {
        return WGPULimits.maxDynamicStorageBuffersPerPipelineLayout(this.ptr);
    }

    @Override
    public int maxSampledTexturesPerShaderStage() {
        return WGPULimits.maxSampledTexturesPerShaderStage(this.ptr);
    }

    @Override
    public int maxSamplersPerShaderStage() {
        return WGPULimits.maxSamplersPerShaderStage(this.ptr);
    }

    @Override
    public int maxStorageBuffersPerShaderStage() {
        return WGPULimits.maxStorageBuffersPerShaderStage(this.ptr);
    }

    @Override
    public int maxStorageTexturesPerShaderStage() {
        return WGPULimits.maxStorageTexturesPerShaderStage(this.ptr);
    }

    @Override
    public int maxUniformBuffersPerShaderStage() {
        return WGPULimits.maxUniformBuffersPerShaderStage(this.ptr);
    }

    @Override
    public long maxUniformBufferBindingSize() {
        return WGPULimits.maxUniformBufferBindingSize(this.ptr);
    }

    @Override
    public long maxStorageBufferBindingSize() {
        return WGPULimits.maxStorageBufferBindingSize(this.ptr);
    }

    @Override
    public long minUniformBufferOffsetAlignment() {
        return WGPULimits.minUniformBufferOffsetAlignment(this.ptr);
    }

    @Override
    public int minStorageBufferOffsetAlignment() {
        return WGPULimits.minStorageBufferOffsetAlignment(this.ptr);
    }

    @Override
    public int maxVertexBuffers() {
        return WGPULimits.maxVertexBuffers(this.ptr);
    }

    @Override
    public long maxBufferSize() {
        return WGPULimits.maxBufferSize(this.ptr);
    }

    @Override
    public int maxVertexAttributes() {
        return WGPULimits.maxVertexAttributes(this.ptr);
    }

    @Override
    public int maxVertexBufferArrayStride() {
        return WGPULimits.maxVertexBufferArrayStride(this.ptr);
    }

    @Override
    public int maxInterStageShaderVariables() {
        return WGPULimits.maxInterStageShaderVariables(this.ptr);
    }

    @Override
    public int maxColorAttachments() {
        return WGPULimits.maxColorAttachments(this.ptr);
    }

    @Override
    public int maxColorAttachmentBytesPerSample() {
        return WGPULimits.maxColorAttachmentBytesPerSample(this.ptr);
    }

    @Override
    public int maxComputeWorkgroupStorageSize() {
        return WGPULimits.maxComputeWorkgroupStorageSize(this.ptr);
    }

    @Override
    public int maxComputeInvocationsPerWorkgroup() {
        return WGPULimits.maxComputeInvocationsPerWorkgroup(this.ptr);
    }

    @Override
    public int maxComputeWorkgroupSizeX() {
        return WGPULimits.maxComputeWorkgroupSizeX(this.ptr);
    }

    @Override
    public int maxComputeWorkgroupSizeY() {
        return WGPULimits.maxComputeWorkgroupSizeY(this.ptr);
    }

    @Override
    public int maxComputeWorkgroupSizeZ() {
        return WGPULimits.maxComputeWorkgroupSizeZ(this.ptr);
    }

    @Override
    public int maxComputeWorkgroupsPerDimension() {
        return WGPULimits.maxComputeWorkgroupsPerDimension(this.ptr);
    }

    @Override
    public String toString() {
        return "LimitsImpl [nextInChain=" + nextInChain() +
                ", maxTextureDimension1D=" + maxTextureDimension1D() +
                ", maxTextureDimension2D=" + maxTextureDimension2D() +
                ", maxTextureDimension3D=" + maxTextureDimension3D() +
                ", maxTextureArrayLayers=" + maxTextureArrayLayers() +
                ", maxBindGroups=" + maxBindGroups() +
                ", maxBindGroupsPlusVertexBuffers=" + maxBindGroupsPlusVertexBuffers() +
                ", maxBindingsPerBindGroup=" + maxBindingsPerBindGroup() +
                ", maxDynamicUniformBuffersPerPipelineLayout=" + maxDynamicUniformBuffersPerPipelineLayout() +
                ", maxDynamicStorageBuffersPerPipelineLayout=" + maxDynamicStorageBuffersPerPipelineLayout() +
                ", maxSampledTexturesPerShaderStage=" + maxSampledTexturesPerShaderStage() +
                ", maxSamplersPerShaderStage=" + maxSamplersPerShaderStage() +
                ", maxStorageBuffersPerShaderStage=" + maxStorageBuffersPerShaderStage() +
                ", maxStorageTexturesPerShaderStage=" + maxStorageTexturesPerShaderStage() +
                ", maxUniformBuffersPerShaderStage=" + maxUniformBuffersPerShaderStage() +
                ", maxUniformBufferBindingSize=" + maxUniformBufferBindingSize() +
                ", maxStorageBufferBindingSize=" + maxStorageBufferBindingSize() +
                ", minUniformBufferOffsetAlignment=" + minUniformBufferOffsetAlignment() +
                ", minStorageBufferOffsetAlignment=" + minStorageBufferOffsetAlignment() +
                ", maxVertexBuffers=" + maxVertexBuffers() +
                ", maxBufferSize=" + maxBufferSize() +
                ", maxVertexAttributes=" + maxVertexAttributes() +
                ", maxVertexBufferArrayStride=" + maxVertexBufferArrayStride() +
                ", maxInterStageShaderVariables=" + maxInterStageShaderVariables() +
                ", maxColorAttachments=" + maxColorAttachments() +
                ", maxColorAttachmentBytesPerSample=" + maxColorAttachmentBytesPerSample() +
                ", maxComputeWorkgroupStorageSize=" + maxComputeWorkgroupStorageSize() +
                ", maxComputeInvocationsPerWorkgroup=" + maxComputeInvocationsPerWorkgroup() +
                ", maxComputeWorkgroupSizeX=" + maxComputeWorkgroupSizeX() +
                ", maxComputeWorkgroupSizeY=" + maxComputeWorkgroupSizeY() +
                ", maxComputeWorkgroupSizeZ=" + maxComputeWorkgroupSizeZ() +
                ", maxComputeWorkgroupsPerDimension=" + maxComputeWorkgroupsPerDimension() + "]";
    }

}
