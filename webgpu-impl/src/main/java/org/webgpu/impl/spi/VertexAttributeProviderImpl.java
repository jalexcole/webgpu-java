package org.webgpu.impl.spi;

import java.lang.foreign.MemorySegment;

import org.jspecify.annotations.NonNull;
import org.webgpu.api.VertexFormat;
import org.webgpu.api.spi.VertexAttributeProvider;

/**
 * VertexAttributeProviderImpl
 */
public class VertexAttributeProviderImpl implements VertexAttributeProvider {

    @Override
    public @NonNull MemorySegment initializer() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'initializer'");
    }

    @Override
    public @NonNull VertexFormat format(@NonNull MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'format'");
    }

    @Override
    public long offset(@NonNull MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'offset'");
    }

    @Override
    public int shaderLocation(@NonNull MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'shaderLocation'");
    }

    @Override
    public void format(@NonNull MemorySegment structPtr, @NonNull VertexFormat format) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'format'");
    }

    @Override
    public void offset(@NonNull MemorySegment structPtr, long offset) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'offset'");
    }

    @Override
    public void shaderLocation(@NonNull MemorySegment structPtr, int shaderLocation) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'shaderLocation'");
    }

}
