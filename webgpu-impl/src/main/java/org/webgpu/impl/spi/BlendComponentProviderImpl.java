package org.webgpu.impl.spi;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;

import org.webgpu.api.BlendFactor;
import org.webgpu.api.BlendOperation;
import org.webgpu.api.spi.BlendComponentProvider;
import org.webgpu.panama.WGPUBlendComponent;

public class BlendComponentProviderImpl implements BlendComponentProvider {

    private final Arena arena = Arena.ofAuto();

    @Override
    public MemorySegment initializer() {
        return WGPUBlendComponent.allocate(arena);
    }

    @Override
    public BlendOperation operation(MemorySegment structPtr) {
        return BlendOperation.values()[WGPUBlendComponent.operation(structPtr)];
    }

    @Override
    public BlendFactor srcFactor(MemorySegment structPtr) {
        return BlendFactor.values()[WGPUBlendComponent.srcFactor(structPtr)];
    }

    @Override
    public BlendFactor dstFactor(MemorySegment structPtr) {
        return BlendFactor.values()[WGPUBlendComponent.dstFactor(structPtr)];
    }

    @Override
    public void operation(MemorySegment structPtr, BlendOperation operation) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'operation'");
    }

    @Override
    public void srcFactor(MemorySegment structPtr, BlendFactor srcFactor) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'srcFactor'");
    }

    @Override
    public void dstFactor(MemorySegment structPtr, BlendFactor dstFactor) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'dstFactor'");
    }
}