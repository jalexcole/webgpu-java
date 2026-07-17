package org.webgpu.impl.spi;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;

import org.jspecify.annotations.NonNull;
import org.webgpu.api.CullMode;
import org.webgpu.api.FrontFace;
import org.webgpu.api.IndexFormat;
import org.webgpu.api.PrimitiveTopology;
import org.webgpu.api.spi.PrimitiveStateProvider;
import org.webgpu.panama.WGPUPrimitiveState;

/**
 * PrimitiveStateProviderImpl
 */
public class PrimitiveStateProviderImpl implements PrimitiveStateProvider {
    private final Arena arena = Arena.ofAuto();

    @Override
    public MemorySegment initializer() {
        return WGPUPrimitiveState.allocate(arena);
    }

    @Override
    public PrimitiveTopology topology(MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'topology'");
    }

    @Override
    public IndexFormat stripIndexFormat(MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'stripIndexFormat'");
    }

    @Override
    public FrontFace frontFace(MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'frontFace'");
    }

    @Override
    public CullMode cullMode(MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'cullMode'");
    }

    @Override
    public boolean unclippedDepth(MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'unclippedDepth'");
    }

    @Override
    public void topology(MemorySegment structPtr, PrimitiveTopology topology) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'topology'");
    }

    @Override
    public void stripIndexFormat(MemorySegment structPtr, IndexFormat stripIndexFormat) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'stripIndexFormat'");
    }

    @Override
    public void frontFace(MemorySegment structPtr, FrontFace frontFace) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'frontFace'");
    }

    @Override
    public void cullMode(MemorySegment structPtr, CullMode cullMode) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'cullMode'");
    }

    @Override
    public void unclippedDepth(MemorySegment structPtr, boolean unclippedDepth) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'unclippedDepth'");
    }

}
