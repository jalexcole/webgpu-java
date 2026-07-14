package org.webgpu.impl.spi;

import java.lang.foreign.MemorySegment;

import org.jspecify.annotations.NonNull;
import org.webgpu.api.spi.SurfaceSourceXlibWindowProvider;

/**
 * SurfaceSourceXlibWindowProviderImpl
 */
public class SurfaceSourceXlibWindowProviderImpl implements SurfaceSourceXlibWindowProvider {

    @Override
    public @NonNull MemorySegment initializer() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'initializer'");
    }

    @Override
    public @NonNull MemorySegment display(@NonNull MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'display'");
    }

    @Override
    public long window(@NonNull MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'window'");
    }

    @Override
    public void display(@NonNull MemorySegment structPtr, @NonNull MemorySegment display) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'display'");
    }

    @Override
    public void window(@NonNull MemorySegment structPtr, long window) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'window'");
    }

}
