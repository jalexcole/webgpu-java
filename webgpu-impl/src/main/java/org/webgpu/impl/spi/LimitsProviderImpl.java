package org.webgpu.impl.spi;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;

import org.webgpu.api.spi.LimitsProvider;
import org.webgpu.panama.WGPULimits;

/**
 * LimitsProviderImpl
 */
public class LimitsProviderImpl implements LimitsProvider {
    private final Arena arena = Arena.ofAuto();

    @Override
    public MemorySegment initializer() {
        return WGPULimits.allocate(arena);
    }

    @Override
    public int maxTextureDimension1D(MemorySegment structPtr) {
        return WGPULimits.maxTextureDimension1D(structPtr);
    }

    @Override
    public int maxTextureDimension2D(MemorySegment structPtr) {
        return WGPULimits.maxTextureDimension2D(structPtr);
    }

    @Override
    public int maxTextureDimension3D(MemorySegment structPtr) {
        return WGPULimits.maxTextureDimension3D(structPtr);
    }

    @Override
    public int maxTextureArrayLayers(MemorySegment structPtr) {
        return WGPULimits.maxTextureArrayLayers(structPtr);
    }

    @Override
    public int maxBindGroups(MemorySegment structPtr) {
        return WGPULimits.maxBindGroups(structPtr);
    }

    @Override
    public int maxBindGroupsPlusVertexBuffers(MemorySegment structPtr) {
        return WGPULimits.maxBindGroupsPlusVertexBuffers(structPtr);
    }

    @Override
    public int maxBindingsPerBindGroup(MemorySegment structPtr) {
        return WGPULimits.maxBindingsPerBindGroup(structPtr);
    }

    @Override
    public int maxDynamicUniformBuffersPerPipelineLayout(MemorySegment structPtr) {
        return WGPULimits.maxDynamicUniformBuffersPerPipelineLayout(structPtr);
    }

    @Override
    public int maxDynamicStorageBuffersPerPipelineLayout(MemorySegment structPtr) {
        return WGPULimits.maxDynamicStorageBuffersPerPipelineLayout(structPtr);
    }

    @Override
    public int maxSampledTexturesPerShaderStage(MemorySegment structPtr) {
        return WGPULimits.maxSampledTexturesPerShaderStage(structPtr);
    }

    @Override
    public int maxSamplersPerShaderStage(MemorySegment structPtr) {
        return WGPULimits.maxSamplersPerShaderStage(structPtr);
    }

    @Override
    public int maxStorageBuffersPerShaderStage(MemorySegment structPtr) {
        return WGPULimits.maxStorageBuffersPerShaderStage(structPtr);
    }

    @Override
    public int maxStorageTexturesPerShaderStage(MemorySegment structPtr) {
        return WGPULimits.maxStorageTexturesPerShaderStage(structPtr);
    }

    @Override
    public int maxUniformBuffersPerShaderStage(MemorySegment structPtr) {
        return WGPULimits.maxUniformBuffersPerShaderStage(structPtr);
    }

    @Override
    public long maxUniformBufferBindingSize(MemorySegment structPtr) {
        return WGPULimits.maxUniformBufferBindingSize(structPtr);
    }

    @Override
    public long maxStorageBufferBindingSize(MemorySegment structPtr) {
        return WGPULimits.maxStorageBufferBindingSize(structPtr);
    }

    @Override
    public int minUniformBufferOffsetAlignment(MemorySegment structPtr) {
        return WGPULimits.minUniformBufferOffsetAlignment(structPtr);
    }

    @Override
    public int minStorageBufferOffsetAlignment(MemorySegment structPtr) {
        return WGPULimits.minStorageBufferOffsetAlignment(structPtr);
    }

    @Override
    public int maxVertexBuffers(MemorySegment structPtr) {
        return WGPULimits.maxVertexBuffers(structPtr);
    }

    @Override
    public long maxBufferSize(MemorySegment structPtr) {
        return WGPULimits.maxBufferSize(structPtr);
    }

    @Override
    public int maxVertexAttributes(MemorySegment structPtr) {
        return WGPULimits.maxVertexAttributes(structPtr);
    }

    @Override
    public int maxVertexBufferArrayStride(MemorySegment structPtr) {
        return WGPULimits.maxVertexBufferArrayStride(structPtr);
    }

    @Override
    public int maxInterStageShaderVariables(MemorySegment structPtr) {
        return WGPULimits.maxInterStageShaderVariables(structPtr);
    }

    @Override
    public int maxColorAttachments(MemorySegment structPtr) {
        return WGPULimits.maxColorAttachments(structPtr);
    }

    @Override
    public int maxColorAttachmentBytesPerSample(MemorySegment structPtr) {
        return WGPULimits.maxColorAttachmentBytesPerSample(structPtr);
    }

    @Override
    public int maxComputeWorkgroupStorageSize(MemorySegment structPtr) {
        return WGPULimits.maxComputeWorkgroupStorageSize(structPtr);
    }

    @Override
    public int maxComputeInvocationsPerWorkgroup(MemorySegment structPtr) {
        return WGPULimits.maxComputeInvocationsPerWorkgroup(structPtr);
    }

    @Override
    public int maxComputeWorkgroupSizeX(MemorySegment structPtr) {
        return WGPULimits.maxComputeWorkgroupSizeX(structPtr);
    }

    @Override
    public int maxComputeWorkgroupSizeY(MemorySegment structPtr) {
        return WGPULimits.maxComputeWorkgroupSizeY(structPtr);
    }

    @Override
    public int maxComputeWorkgroupSizeZ(MemorySegment structPtr) {
        return WGPULimits.maxComputeWorkgroupSizeZ(structPtr);
    }

    @Override
    public int maxComputeWorkgroupsPerDimension(MemorySegment structPtr) {
        return WGPULimits.maxComputeWorkgroupsPerDimension(structPtr);
    }

    @Override
    public int maxImmediateSize(MemorySegment structPtr) {
        return WGPULimits.maxImmediateSize(structPtr);
    }

    @Override
    public void maxTextureDimension1D(MemorySegment structPtr, int maxTextureDimension1D) {
        WGPULimits.maxTextureDimension1D(structPtr, maxTextureDimension1D);
    }

    @Override
    public void maxTextureDimension2D(MemorySegment structPtr, int maxTextureDimension2D) {
        WGPULimits.maxTextureDimension2D(structPtr, maxTextureDimension2D);
    }

    @Override
    public void maxTextureDimension3D(MemorySegment structPtr, int maxTextureDimension3D) {
        WGPULimits.maxTextureDimension3D(structPtr, maxTextureDimension3D);
    }

    @Override
    public void maxTextureArrayLayers(MemorySegment structPtr, int maxTextureArrayLayers) {
        WGPULimits.maxTextureArrayLayers(structPtr, maxTextureArrayLayers);
    }

    @Override
    public void maxBindGroups(MemorySegment structPtr, int maxBindGroups) {
        WGPULimits.maxBindGroups(structPtr, maxBindGroups);
    }

    @Override
    public void maxBindGroupsPlusVertexBuffers(MemorySegment structPtr, int maxBindGroupsPlusVertexBuffers) {
        WGPULimits.maxBindGroupsPlusVertexBuffers(structPtr, maxBindGroupsPlusVertexBuffers);
    }

    @Override
    public void maxBindingsPerBindGroup(MemorySegment structPtr, int maxBindingsPerBindGroup) {
        WGPULimits.maxBindingsPerBindGroup(structPtr, maxBindingsPerBindGroup);
    }

    @Override
    public void maxDynamicUniformBuffersPerPipelineLayout(MemorySegment structPtr,
            int maxDynamicUniformBuffersPerPipelineLayout) {
        WGPULimits.maxDynamicUniformBuffersPerPipelineLayout(structPtr, maxDynamicUniformBuffersPerPipelineLayout);
    }

    @Override
    public void maxDynamicStorageBuffersPerPipelineLayout(MemorySegment structPtr,
            int maxDynamicStorageBuffersPerPipelineLayout) {
        WGPULimits.maxDynamicStorageBuffersPerPipelineLayout(structPtr, maxDynamicStorageBuffersPerPipelineLayout);
    }

    @Override
    public void maxSampledTexturesPerShaderStage(MemorySegment structPtr,
            int maxSampledTexturesPerShaderStage) {
        WGPULimits.maxSampledTexturesPerShaderStage(structPtr, maxSampledTexturesPerShaderStage);
    }

    @Override
    public void maxSamplersPerShaderStage(MemorySegment structPtr, int maxSamplersPerShaderStage) {
        WGPULimits.maxSamplersPerShaderStage(structPtr, maxSamplersPerShaderStage);
    }

    @Override
    public void maxStorageBuffersPerShaderStage(MemorySegment structPtr, int maxStorageBuffersPerShaderStage) {
        WGPULimits.maxStorageBuffersPerShaderStage(structPtr, maxStorageBuffersPerShaderStage);
    }

    @Override
    public void maxStorageTexturesPerShaderStage(MemorySegment structPtr,
            int maxStorageTexturesPerShaderStage) {
        WGPULimits.maxStorageTexturesPerShaderStage(structPtr, maxStorageTexturesPerShaderStage);
    }

    @Override
    public void maxUniformBuffersPerShaderStage(MemorySegment structPtr, int maxUniformBuffersPerShaderStage) {
        WGPULimits.maxUniformBuffersPerShaderStage(structPtr, maxUniformBuffersPerShaderStage);
    }

    @Override
    public void maxUniformBufferBindingSize(MemorySegment structPtr, long maxUniformBufferBindingSize) {
        WGPULimits.maxUniformBufferBindingSize(structPtr, maxUniformBufferBindingSize);
    }

    @Override
    public void maxStorageBufferBindingSize(MemorySegment structPtr, long maxStorageBufferBindingSize) {
        WGPULimits.maxStorageBufferBindingSize(structPtr, maxStorageBufferBindingSize);
    }

    @Override
    public void minUniformBufferOffsetAlignment(MemorySegment structPtr, int minUniformBufferOffsetAlignment) {
        WGPULimits.minUniformBufferOffsetAlignment(structPtr, minUniformBufferOffsetAlignment);
    }

    @Override
    public void minStorageBufferOffsetAlignment(MemorySegment structPtr, int minStorageBufferOffsetAlignment) {
        WGPULimits.minStorageBufferOffsetAlignment(structPtr, minStorageBufferOffsetAlignment);
    }

    @Override
    public void maxVertexBuffers(MemorySegment structPtr, int maxVertexBuffers) {
        WGPULimits.maxVertexBuffers(structPtr, maxVertexBuffers);
    }

    @Override
    public void maxBufferSize(MemorySegment structPtr, long maxBufferSize) {
        WGPULimits.maxBufferSize(structPtr, maxBufferSize);
    }

    @Override
    public void maxVertexAttributes(MemorySegment structPtr, int maxVertexAttributes) {
        WGPULimits.maxVertexAttributes(structPtr, maxVertexAttributes);
    }

    @Override
    public void maxVertexBufferArrayStride(MemorySegment structPtr, int maxVertexBufferArrayStride) {
        WGPULimits.maxVertexBufferArrayStride(structPtr, maxVertexBufferArrayStride);
    }

    @Override
    public void maxInterStageShaderVariables(MemorySegment structPtr, int maxInterStageShaderVariables) {
        WGPULimits.maxInterStageShaderVariables(structPtr, maxInterStageShaderVariables);
    }

    @Override
    public void maxColorAttachments(MemorySegment structPtr, int maxColorAttachments) {
        WGPULimits.maxColorAttachments(structPtr, maxColorAttachments);
    }

    @Override
    public void maxColorAttachmentBytesPerSample(MemorySegment structPtr,
            int maxColorAttachmentBytesPerSample) {
        WGPULimits.maxColorAttachmentBytesPerSample(structPtr, maxColorAttachmentBytesPerSample);
    }

    @Override
    public void maxComputeWorkgroupStorageSize(MemorySegment structPtr, int maxComputeWorkgroupStorageSize) {
        WGPULimits.maxComputeWorkgroupStorageSize(structPtr, maxComputeWorkgroupStorageSize);
    }

    @Override
    public void maxComputeInvocationsPerWorkgroup(MemorySegment structPtr,
            int maxComputeInvocationsPerWorkgroup) {
        WGPULimits.maxComputeInvocationsPerWorkgroup(structPtr, maxComputeInvocationsPerWorkgroup);
    }

    @Override
    public void maxComputeWorkgroupSizeX(MemorySegment structPtr, int maxComputeWorkgroupSizeX) {
        WGPULimits.maxComputeWorkgroupSizeX(structPtr, maxComputeWorkgroupSizeX);
    }

    @Override
    public void maxComputeWorkgroupSizeY(MemorySegment structPtr, int maxComputeWorkgroupSizeY) {
        WGPULimits.maxComputeWorkgroupSizeY(structPtr, maxComputeWorkgroupSizeY);
    }

    @Override
    public void maxComputeWorkgroupSizeZ(MemorySegment structPtr, int maxComputeWorkgroupSizeZ) {
        WGPULimits.maxComputeWorkgroupSizeZ(structPtr, maxComputeWorkgroupSizeZ);
    }

    @Override
    public void maxComputeWorkgroupsPerDimension(MemorySegment structPtr,
            int maxComputeWorkgroupsPerDimension) {
        WGPULimits.maxComputeWorkgroupsPerDimension(structPtr, maxComputeWorkgroupsPerDimension);
    }

    @Override
    public void maxImmediateSize(MemorySegment structPtr, int maxImmediateSize) {
        WGPULimits.maxImmediateSize(structPtr, maxImmediateSize);
    }

}
