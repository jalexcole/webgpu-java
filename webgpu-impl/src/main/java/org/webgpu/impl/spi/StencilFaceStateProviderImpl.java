package org.webgpu.impl.spi;

import java.lang.foreign.MemorySegment;

import org.jspecify.annotations.NonNull;
import org.webgpu.api.CompareFunction;
import org.webgpu.api.StencilOperation;
import org.webgpu.api.spi.StencilFaceStateProvider;

/**
 * StencilFaceStateProviderImpl
 */
public class StencilFaceStateProviderImpl implements StencilFaceStateProvider {

    @Override
    public @NonNull MemorySegment initializer() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'initializer'");
    }

    @Override
    public @NonNull CompareFunction compare(@NonNull MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'compare'");
    }

    @Override
    public @NonNull StencilOperation failOp(@NonNull MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'failOp'");
    }

    @Override
    public @NonNull StencilOperation depthFailOp(@NonNull MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'depthFailOp'");
    }

    @Override
    public @NonNull StencilOperation passOp(@NonNull MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'passOp'");
    }

    @Override
    public void compare(@NonNull MemorySegment structPtr, @NonNull CompareFunction compare) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'compare'");
    }

    @Override
    public void failOp(@NonNull MemorySegment structPtr, @NonNull StencilOperation failOp) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'failOp'");
    }

    @Override
    public void depthFailOp(@NonNull MemorySegment structPtr, @NonNull StencilOperation depthFailOp) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'depthFailOp'");
    }

    @Override
    public void passOp(@NonNull MemorySegment structPtr, @NonNull StencilOperation passOp) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'passOp'");
    }

}
