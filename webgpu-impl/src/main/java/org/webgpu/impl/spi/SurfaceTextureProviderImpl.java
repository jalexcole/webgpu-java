package org.webgpu.impl.spi;

import java.lang.foreign.MemorySegment;

import org.jspecify.annotations.NonNull;
import org.webgpu.api.SurfaceGetCurrentTextureStatus;
import org.webgpu.api.Texture;
import org.webgpu.api.spi.SurfaceTextureProvider;

/**
 * SurfaceTextureProviderImpl
 */
public class SurfaceTextureProviderImpl implements SurfaceTextureProvider {

    @Override
    public @NonNull MemorySegment initializer() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'initializer'");
    }

    @Override
    public @NonNull Texture texture(@NonNull MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'texture'");
    }

    @Override
    public @NonNull SurfaceGetCurrentTextureStatus status(@NonNull MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'status'");
    }

    @Override
    public void texture(@NonNull MemorySegment structPtr, @NonNull Texture texture) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'texture'");
    }

    @Override
    public void status(@NonNull MemorySegment structPtr, @NonNull SurfaceGetCurrentTextureStatus status) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'status'");
    }

}
