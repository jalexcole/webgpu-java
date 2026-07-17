package org.webgpu.impl.spi;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;

import org.jspecify.annotations.NonNull;
import org.webgpu.api.spi.Extent3DProvider;
import org.webgpu.panama.WGPUExtent3D;

/**
 * Extent3DProviderImpl
 */
public class Extent3DProviderImpl implements Extent3DProvider {
    private final Arena arena = Arena.ofAuto();

    @Override
    public MemorySegment initializer() {
        return WGPUExtent3D.allocate(arena);
    }

    @Override
    public int width(MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'width'");
    }

    @Override
    public int height(MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'height'");
    }

    @Override
    public int depthOrArrayLayers(MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'depthOrArrayLayers'");
    }

    @Override
    public void width(MemorySegment structPtr, int width) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'width'");
    }

    @Override
    public void height(MemorySegment structPtr, int height) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'height'");
    }

    @Override
    public void depthOrArrayLayers(MemorySegment structPtr, int depthOrArrayLayers) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'depthOrArrayLayers'");
    }

}
