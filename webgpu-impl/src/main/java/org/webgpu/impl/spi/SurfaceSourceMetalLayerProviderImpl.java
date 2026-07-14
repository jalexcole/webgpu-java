package org.webgpu.impl.spi;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;

import org.jspecify.annotations.NullMarked;
import org.webgpu.api.spi.SurfaceSourceMetalLayerProvider;

/**
 * SurfaceSourceMetalLayerProviderImpl
 */
@NullMarked
public class SurfaceSourceMetalLayerProviderImpl implements SurfaceSourceMetalLayerProvider {

    private final Arena arena = Arena.ofAuto();

    @Override
    public MemorySegment initializer() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'initializer'");
    }

    @Override
    public MemorySegment layer(MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'layer'");
    }

    @Override
    public void layer(MemorySegment structPtr, MemorySegment layer) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'layer'");
    }

}
