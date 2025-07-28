package org.webgpu.api;

import java.util.Optional;

public interface Limits {
    
    public Optional<ChainedStruct> nextInChain();

    public int maxTextureDimension1D();
    
    public int maxTextureDimension2D();
    
    public int maxTextureDimension3D();
    
    public int maxTextureArrayLayers();
    
    public int maxBindGroups();
    
    public int maxBindGroupsPlusVertexBuffers();
    
    public int maxBindingsPerBindGroup();
    
    public int maxDynamicUniformBuffersPerPipelineLayout();
    
    public int maxDynamicStorageBuffersPerPipelineLayout();
    
    public int maxSampledTexturesPerShaderStage();
    
    public int maxSamplersPerShaderStage();
    
    public int maxStorageBuffersPerShaderStage();
    
    public int maxStorageTexturesPerShaderStage();
    
    public int maxUniformBuffersPerShaderStage();
    
    public long maxUniformBufferBindingSize();
    
    public long maxStorageBufferBindingSize();
    
    public long minUniformBufferOffsetAlignment();
    
    public int minStorageBufferOffsetAlignment();
    
    public int maxVertexBuffers();
    
    public long maxBufferSize();
    
    public int maxVertexAttributes();
    
    public int maxVertexBufferArrayStride();
    
    public int maxInterStageShaderVariables();
    
    public int maxColorAttachments();
    
    public int maxColorAttachmentBytesPerSample();
    
    public int maxComputeWorkgroupStorageSize();
    
    public int maxComputeInvocationsPerWorkgroup();
    
    public int maxComputeWorkgroupSizeX();
    
    public int maxComputeWorkgroupSizeY();
    
    public int maxComputeWorkgroupSizeZ();
    
    public int maxComputeWorkgroupsPerDimension();
    

}
