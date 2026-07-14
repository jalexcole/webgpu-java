package org.webgpu.impl.spi;

import java.lang.foreign.MemorySegment;

import org.jspecify.annotations.NonNull;
import org.webgpu.api.CompareFunction;
import org.webgpu.api.OptionalBool;
import org.webgpu.api.StencilFaceState;
import org.webgpu.api.TextureFormat;
import org.webgpu.api.spi.DepthStencilStateProvider;

/**
 * DepthStencilStateProviderImpl
 */
public class DepthStencilStateProviderImpl implements DepthStencilStateProvider{

    @Override
    public @NonNull MemorySegment initializer() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'initializer'");
    }

    @Override
    public @NonNull TextureFormat format(@NonNull MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'format'");
    }

    @Override
    public @NonNull OptionalBool depthWriteEnabled(@NonNull MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'depthWriteEnabled'");
    }

    @Override
    public @NonNull CompareFunction depthCompare(@NonNull MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'depthCompare'");
    }

    @Override
    public @NonNull StencilFaceState stencilFront(@NonNull MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'stencilFront'");
    }

    @Override
    public @NonNull StencilFaceState stencilBack(@NonNull MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'stencilBack'");
    }

    @Override
    public int stencilReadMask(@NonNull MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'stencilReadMask'");
    }

    @Override
    public int stencilWriteMask(@NonNull MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'stencilWriteMask'");
    }

    @Override
    public int depthBias(@NonNull MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'depthBias'");
    }

    @Override
    public float depthBiasSlopeScale(@NonNull MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'depthBiasSlopeScale'");
    }

    @Override
    public float depthBiasClamp(@NonNull MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'depthBiasClamp'");
    }

    @Override
    public void format(@NonNull MemorySegment structPtr, @NonNull TextureFormat format) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'format'");
    }

    @Override
    public void depthWriteEnabled(@NonNull MemorySegment structPtr, @NonNull OptionalBool depthWriteEnabled) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'depthWriteEnabled'");
    }

    @Override
    public void depthCompare(@NonNull MemorySegment structPtr, @NonNull CompareFunction depthCompare) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'depthCompare'");
    }

    @Override
    public void stencilFront(@NonNull MemorySegment structPtr, @NonNull StencilFaceState stencilFront) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'stencilFront'");
    }

    @Override
    public void stencilBack(@NonNull MemorySegment structPtr, @NonNull StencilFaceState stencilBack) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'stencilBack'");
    }

    @Override
    public void stencilReadMask(@NonNull MemorySegment structPtr, int stencilReadMask) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'stencilReadMask'");
    }

    @Override
    public void stencilWriteMask(@NonNull MemorySegment structPtr, int stencilWriteMask) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'stencilWriteMask'");
    }

    @Override
    public void depthBias(@NonNull MemorySegment structPtr, int depthBias) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'depthBias'");
    }

    @Override
    public void depthBiasSlopeScale(@NonNull MemorySegment structPtr, float depthBiasSlopeScale) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'depthBiasSlopeScale'");
    }

    @Override
    public void depthBiasClamp(@NonNull MemorySegment structPtr, float depthBiasClamp) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'depthBiasClamp'");
    }

}
