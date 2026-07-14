package org.webgpu.impl.spi;

import java.lang.foreign.MemorySegment;

import org.jspecify.annotations.NonNull;
import org.webgpu.api.spi.SurfaceSourceWaylandSurfaceProvider;

/**
 * SurfaceSourceWaylandSurfaceProviderImpl
 */
public class SurfaceSourceWaylandSurfaceProviderImpl implements SurfaceSourceWaylandSurfaceProvider {

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
    public @NonNull MemorySegment surface(@NonNull MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'surface'");
    }

    @Override
    public void display(@NonNull MemorySegment structPtr, @NonNull MemorySegment display) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'display'");
    }

    @Override
    public void surface(@NonNull MemorySegment structPtr, @NonNull MemorySegment surface) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'surface'");
    }

}
