package org.webgpu.impl.spi;

import java.lang.foreign.MemorySegment;

import org.jspecify.annotations.NonNull;
import org.webgpu.api.spi.Extent3DProvider;

/**
 * Extent3DProviderImpl
 */
public class Extent3DProviderImpl implements Extent3DProvider {

    @Override
    public @NonNull MemorySegment initializer() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'initializer'");
    }

    @Override
    public int width(@NonNull MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'width'");
    }

    @Override
    public int height(@NonNull MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'height'");
    }

    @Override
    public int depthOrArrayLayers(@NonNull MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'depthOrArrayLayers'");
    }

    @Override
    public void width(@NonNull MemorySegment structPtr, int width) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'width'");
    }

    @Override
    public void height(@NonNull MemorySegment structPtr, int height) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'height'");
    }

    @Override
    public void depthOrArrayLayers(@NonNull MemorySegment structPtr, int depthOrArrayLayers) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'depthOrArrayLayers'");
    }

}
