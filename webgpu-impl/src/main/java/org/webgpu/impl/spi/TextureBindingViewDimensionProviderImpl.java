package org.webgpu.impl.spi;

import java.lang.foreign.MemorySegment;

import org.jspecify.annotations.NonNull;
import org.webgpu.api.TextureViewDimension;
import org.webgpu.api.spi.TextureBindingViewDimensionProvider;

/**
 * TextureBindingViewDimensionProviderImpl
 */
public class TextureBindingViewDimensionProviderImpl implements TextureBindingViewDimensionProvider{

    @Override
    public @NonNull MemorySegment initializer() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'initializer'");
    }

    @Override
    public @NonNull TextureViewDimension textureBindingViewDimension(@NonNull MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'textureBindingViewDimension'");
    }

    @Override
    public void textureBindingViewDimension(@NonNull MemorySegment structPtr,
            @NonNull TextureViewDimension textureBindingViewDimension) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'textureBindingViewDimension'");
    }

}
