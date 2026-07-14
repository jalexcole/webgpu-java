package org.webgpu.impl.spi;

import java.lang.foreign.MemorySegment;

import org.jspecify.annotations.NonNull;
import org.webgpu.api.StorageTextureAccess;
import org.webgpu.api.TextureFormat;
import org.webgpu.api.TextureViewDimension;
import org.webgpu.api.spi.StorageTextureBindingLayoutProvider;

/**
 * StorageTextureBindingLayoutProviderImpl
 */
public class StorageTextureBindingLayoutProviderImpl implements StorageTextureBindingLayoutProvider {

    @Override
    public @NonNull MemorySegment initializer() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'initializer'");
    }

    @Override
    public @NonNull StorageTextureAccess access(@NonNull MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'access'");
    }

    @Override
    public @NonNull TextureFormat format(@NonNull MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'format'");
    }

    @Override
    public @NonNull TextureViewDimension viewDimension(@NonNull MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'viewDimension'");
    }

    @Override
    public void access(@NonNull MemorySegment structPtr, @NonNull StorageTextureAccess access) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'access'");
    }

    @Override
    public void format(@NonNull MemorySegment structPtr, @NonNull TextureFormat format) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'format'");
    }

    @Override
    public void viewDimension(@NonNull MemorySegment structPtr, @NonNull TextureViewDimension viewDimension) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'viewDimension'");
    }

}
