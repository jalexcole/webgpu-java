package org.webgpu.impl.spi;

import java.lang.foreign.MemorySegment;

import org.jspecify.annotations.NonNull;
import org.webgpu.api.spi.SurfaceSourceXCBWindowProvider;

/**
 * SurfaceSourceXCBWindowProviderImpl
 */
public class SurfaceSourceXCBWindowProviderImpl implements SurfaceSourceXCBWindowProvider {

    @Override
    public @NonNull MemorySegment initializer() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'initializer'");
    }

    @Override
    public @NonNull MemorySegment connection(@NonNull MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'connection'");
    }

    @Override
    public int window(@NonNull MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'window'");
    }

    @Override
    public void connection(@NonNull MemorySegment structPtr, @NonNull MemorySegment connection) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'connection'");
    }

    @Override
    public void window(@NonNull MemorySegment structPtr, int window) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'window'");
    }

}
