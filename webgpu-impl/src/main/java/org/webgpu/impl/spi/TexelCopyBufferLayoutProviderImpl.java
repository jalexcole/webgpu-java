package org.webgpu.impl.spi;

import java.lang.foreign.MemorySegment;

import org.jspecify.annotations.NonNull;
import org.webgpu.api.spi.TexelCopyBufferLayoutProvider;

/**
 * TexelCopyBufferLayoutProviderImpl
 */
public class TexelCopyBufferLayoutProviderImpl implements TexelCopyBufferLayoutProvider {

    @Override
    public @NonNull MemorySegment initializer() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'initializer'");
    }

    @Override
    public long offset(@NonNull MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'offset'");
    }

    @Override
    public int bytesPerRow(@NonNull MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'bytesPerRow'");
    }

    @Override
    public int rowsPerImage(@NonNull MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'rowsPerImage'");
    }

    @Override
    public void offset(@NonNull MemorySegment structPtr, long offset) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'offset'");
    }

    @Override
    public void bytesPerRow(@NonNull MemorySegment structPtr, int bytesPerRow) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'bytesPerRow'");
    }

    @Override
    public void rowsPerImage(@NonNull MemorySegment structPtr, int rowsPerImage) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'rowsPerImage'");
    }

}
