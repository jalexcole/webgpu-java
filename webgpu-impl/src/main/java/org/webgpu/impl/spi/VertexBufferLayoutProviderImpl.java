package org.webgpu.impl.spi;

import java.lang.foreign.MemorySegment;

import org.jspecify.annotations.NonNull;
import org.webgpu.api.VertexAttribute;
import org.webgpu.api.VertexStepMode;
import org.webgpu.api.spi.VertexBufferLayoutProvider;

/**
 * VertexBufferLayoutProviderImpl
 */
public class VertexBufferLayoutProviderImpl implements VertexBufferLayoutProvider {

    @Override
    public @NonNull MemorySegment initializer() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'initializer'");
    }

    @Override
    public @NonNull VertexStepMode stepMode(@NonNull MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'stepMode'");
    }

    @Override
    public long arrayStride(@NonNull MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'arrayStride'");
    }

    @Override
    public VertexAttribute @NonNull [] attributes(@NonNull MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'attributes'");
    }

    @Override
    public void stepMode(@NonNull MemorySegment structPtr, @NonNull VertexStepMode stepMode) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'stepMode'");
    }

    @Override
    public void arrayStride(@NonNull MemorySegment structPtr, long arrayStride) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'arrayStride'");
    }

    @Override
    public void attributes(@NonNull MemorySegment structPtr, VertexAttribute @NonNull [] attributes) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'attributes'");
    }

}
