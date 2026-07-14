package org.webgpu.impl.spi;

import java.lang.foreign.MemorySegment;

import org.jspecify.annotations.NonNull;
import org.webgpu.api.CullMode;
import org.webgpu.api.FrontFace;
import org.webgpu.api.IndexFormat;
import org.webgpu.api.PrimitiveTopology;
import org.webgpu.api.spi.PrimitiveStateProvider;

/**
 * PrimitiveStateProviderImpl
 */
public class PrimitiveStateProviderImpl implements PrimitiveStateProvider {

    @Override
    public @NonNull MemorySegment initializer() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'initializer'");
    }

    @Override
    public @NonNull PrimitiveTopology topology(@NonNull MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'topology'");
    }

    @Override
    public @NonNull IndexFormat stripIndexFormat(@NonNull MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'stripIndexFormat'");
    }

    @Override
    public @NonNull FrontFace frontFace(@NonNull MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'frontFace'");
    }

    @Override
    public @NonNull CullMode cullMode(@NonNull MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'cullMode'");
    }

    @Override
    public boolean unclippedDepth(@NonNull MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'unclippedDepth'");
    }

    @Override
    public void topology(@NonNull MemorySegment structPtr, @NonNull PrimitiveTopology topology) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'topology'");
    }

    @Override
    public void stripIndexFormat(@NonNull MemorySegment structPtr, @NonNull IndexFormat stripIndexFormat) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'stripIndexFormat'");
    }

    @Override
    public void frontFace(@NonNull MemorySegment structPtr, @NonNull FrontFace frontFace) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'frontFace'");
    }

    @Override
    public void cullMode(@NonNull MemorySegment structPtr, @NonNull CullMode cullMode) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'cullMode'");
    }

    @Override
    public void unclippedDepth(@NonNull MemorySegment structPtr, boolean unclippedDepth) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'unclippedDepth'");
    }

}
