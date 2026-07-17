package org.webgpu.impl.spi;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;

import org.webgpu.api.spi.CompatibilityModeLimitsProvider;
import org.webgpu.panama.WGPUCompatibilityModeLimits;

public class CompatibilityModeLimitsProviderImpl implements CompatibilityModeLimitsProvider{

    private final Arena arena = Arena.ofAuto();

    @Override
    public MemorySegment initializer() {
        return WGPUCompatibilityModeLimits.allocate(arena);
    }

    @Override
    public int maxStorageBuffersInVertexStage(MemorySegment structPtr) {
        return (int) WGPUCompatibilityModeLimits.maxStorageBuffersInVertexStage(structPtr);
    }

    @Override
    public int maxStorageTexturesInVertexStage(MemorySegment structPtr) {
        return (int) WGPUCompatibilityModeLimits.maxStorageTexturesInVertexStage(structPtr);
    }

    @Override
    public int maxStorageBuffersInFragmentStage(MemorySegment structPtr) {
        return (int) WGPUCompatibilityModeLimits.maxStorageBuffersInFragmentStage(structPtr);
    }

    @Override
    public int maxStorageTexturesInFragmentStage(MemorySegment structPtr) {
        return (int) WGPUCompatibilityModeLimits.maxStorageTexturesInFragmentStage(structPtr);
    }

    @Override
    public void maxStorageBuffersInVertexStage(MemorySegment structPtr, int maxStorageBuffersInVertexStage) {
        WGPUCompatibilityModeLimits.maxStorageBuffersInVertexStage(structPtr, maxStorageBuffersInVertexStage);
    }

    @Override
    public void maxStorageTexturesInVertexStage(MemorySegment structPtr, int maxStorageTexturesInVertexStage) {
        WGPUCompatibilityModeLimits.maxStorageTexturesInVertexStage(structPtr, maxStorageTexturesInVertexStage);
    }

    @Override
    public void maxStorageBuffersInFragmentStage(MemorySegment structPtr, int maxStorageBuffersInFragmentStage) {
        WGPUCompatibilityModeLimits.maxStorageBuffersInFragmentStage(structPtr, maxStorageBuffersInFragmentStage);
    }

    @Override
    public void maxStorageTexturesInFragmentStage(MemorySegment structPtr, int maxStorageTexturesInFragmentStage) {
        WGPUCompatibilityModeLimits.maxStorageTexturesInFragmentStage(structPtr, maxStorageTexturesInFragmentStage);
    }

}
