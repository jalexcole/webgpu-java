package org.webgpu.impl.spi;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;

import org.webgpu.api.CompareFunction;
import org.webgpu.api.OptionalBool;
import org.webgpu.api.StencilFaceState;
import org.webgpu.api.TextureFormat;
import org.webgpu.api.spi.DepthStencilStateProvider;
import org.webgpu.panama.WGPUDepthStencilState;

/**
 * DepthStencilStateProviderImpl
 */
public class DepthStencilStateProviderImpl implements DepthStencilStateProvider {
    private final Arena arena = Arena.ofAuto();

    @Override
    public MemorySegment initializer() {
        return WGPUDepthStencilState.allocate(arena);
    }

    @Override
    public TextureFormat format(MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'format'");
    }

    @Override
    public OptionalBool depthWriteEnabled(MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'depthWriteEnabled'");
    }

    @Override
    public CompareFunction depthCompare(MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'depthCompare'");
    }

    @Override
    public StencilFaceState stencilFront(MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'stencilFront'");
    }

    @Override
    public StencilFaceState stencilBack(MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'stencilBack'");
    }

    @Override
    public int stencilReadMask(MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'stencilReadMask'");
    }

    @Override
    public int stencilWriteMask(MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'stencilWriteMask'");
    }

    @Override
    public int depthBias(MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'depthBias'");
    }

    @Override
    public float depthBiasSlopeScale(MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'depthBiasSlopeScale'");
    }

    @Override
    public float depthBiasClamp(MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'depthBiasClamp'");
    }

    @Override
    public void format(MemorySegment structPtr, TextureFormat format) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'format'");
    }

    @Override
    public void depthWriteEnabled(MemorySegment structPtr, OptionalBool depthWriteEnabled) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'depthWriteEnabled'");
    }

    @Override
    public void depthCompare(MemorySegment structPtr, CompareFunction depthCompare) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'depthCompare'");
    }

    @Override
    public void stencilFront(MemorySegment structPtr, StencilFaceState stencilFront) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'stencilFront'");
    }

    @Override
    public void stencilBack(MemorySegment structPtr, StencilFaceState stencilBack) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'stencilBack'");
    }

    @Override
    public void stencilReadMask(MemorySegment structPtr, int stencilReadMask) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'stencilReadMask'");
    }

    @Override
    public void stencilWriteMask(MemorySegment structPtr, int stencilWriteMask) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'stencilWriteMask'");
    }

    @Override
    public void depthBias(MemorySegment structPtr, int depthBias) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'depthBias'");
    }

    @Override
    public void depthBiasSlopeScale(MemorySegment structPtr, float depthBiasSlopeScale) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'depthBiasSlopeScale'");
    }

    @Override
    public void depthBiasClamp(MemorySegment structPtr, float depthBiasClamp) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'depthBiasClamp'");
    }

}
