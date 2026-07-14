package org.webgpu.impl.spi;

import java.lang.foreign.MemorySegment;

import org.jspecify.annotations.NonNull;
import org.webgpu.api.TextureSampleType;
import org.webgpu.api.TextureViewDimension;
import org.webgpu.api.spi.TextureBindingLayoutProvider;

/**
 * TextureBindingLayoutProviderImpl
 */
public class TextureBindingLayoutProviderImpl implements TextureBindingLayoutProvider {

    @Override
    public @NonNull MemorySegment initializer() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'initializer'");
    }

    @Override
    public @NonNull TextureSampleType sampleType(@NonNull MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'sampleType'");
    }

    @Override
    public @NonNull TextureViewDimension viewDimension(@NonNull MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'viewDimension'");
    }

    @Override
    public boolean multisampled(@NonNull MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'multisampled'");
    }

    @Override
    public void sampleType(@NonNull MemorySegment structPtr, @NonNull TextureSampleType sampleType) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'sampleType'");
    }

    @Override
    public void viewDimension(@NonNull MemorySegment structPtr, @NonNull TextureViewDimension viewDimension) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'viewDimension'");
    }

    @Override
    public void multisampled(@NonNull MemorySegment structPtr, boolean multisampled) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'multisampled'");
    }

}
