package org.webgpu.impl.spi;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;

import org.jspecify.annotations.NonNull;
import org.webgpu.api.VertexAttribute;
import org.webgpu.api.VertexStepMode;
import org.webgpu.api.spi.VertexBufferLayoutProvider;
import org.webgpu.panama.WGPUVertexBufferLayout;

/**
 * VertexBufferLayoutProviderImpl
 */
public class VertexBufferLayoutProviderImpl implements VertexBufferLayoutProvider {
    private final Arena arena = Arena.ofAuto();

    @Override
    public MemorySegment initializer() {
        return WGPUVertexBufferLayout.allocate(arena);
    }

    @Override
    public VertexStepMode stepMode(MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'stepMode'");
    }

    @Override
    public long arrayStride(MemorySegment structPtr) {
        return WGPUVertexBufferLayout.arrayStride(structPtr);
    }

    @Override
    public VertexAttribute[] attributes(MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'attributes'");
    }

    @Override
    public void stepMode(MemorySegment structPtr, VertexStepMode stepMode) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'stepMode'");
    }

    @Override
    public void arrayStride(MemorySegment structPtr, long arrayStride) {
        WGPUVertexBufferLayout.arrayStride(structPtr, arrayStride);
    }

    @Override
    public void attributes(MemorySegment structPtr, VertexAttribute[] attributes) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'attributes'");
    }

}
