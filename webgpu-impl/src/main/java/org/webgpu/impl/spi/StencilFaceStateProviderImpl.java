package org.webgpu.impl.spi;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;

import org.jspecify.annotations.NonNull;
import org.webgpu.api.CompareFunction;
import org.webgpu.api.StencilOperation;
import org.webgpu.api.spi.StencilFaceStateProvider;
import org.webgpu.panama.WGPUStencilFaceState;

/**
 * StencilFaceStateProviderImpl
 */
public class StencilFaceStateProviderImpl implements StencilFaceStateProvider {
    private final Arena arena = Arena.ofAuto();

    @Override
    public MemorySegment initializer() {
        return WGPUStencilFaceState.allocate(arena);
    }

    @Override
    public CompareFunction compare(MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'compare'");
    }

    @Override
    public StencilOperation failOp(MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'failOp'");
    }

    @Override
    public StencilOperation depthFailOp(MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'depthFailOp'");
    }

    @Override
    public StencilOperation passOp(MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'passOp'");
    }

    @Override
    public void compare(MemorySegment structPtr, CompareFunction compare) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'compare'");
    }

    @Override
    public void failOp(MemorySegment structPtr, StencilOperation failOp) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'failOp'");
    }

    @Override
    public void depthFailOp(MemorySegment structPtr, StencilOperation depthFailOp) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'depthFailOp'");
    }

    @Override
    public void passOp(MemorySegment structPtr, StencilOperation passOp) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'passOp'");
    }

}
