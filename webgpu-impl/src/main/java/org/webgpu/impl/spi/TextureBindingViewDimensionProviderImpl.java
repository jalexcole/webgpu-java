package org.webgpu.impl.spi;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;

import org.jspecify.annotations.NonNull;
import org.webgpu.api.TextureViewDimension;
import org.webgpu.api.spi.TextureBindingViewDimensionProvider;
import org.webgpu.panama.WGPUTextureBindingViewDimension;

/**
 * TextureBindingViewDimensionProviderImpl
 */
public class TextureBindingViewDimensionProviderImpl implements TextureBindingViewDimensionProvider {
    private final Arena arena = Arena.ofAuto();

    @Override
    public MemorySegment initializer() {
        return WGPUTextureBindingViewDimension.allocate(arena);
    }

    @Override
    public TextureViewDimension textureBindingViewDimension(MemorySegment structPtr) {
        final int value = WGPUTextureBindingViewDimension.textureBindingViewDimension(structPtr);
        return TextureViewDimension.values()[value];
        
    }

    @Override
    public void textureBindingViewDimension(MemorySegment structPtr,
            TextureViewDimension textureBindingViewDimension) {
        WGPUTextureBindingViewDimension.textureBindingViewDimension(structPtr, textureBindingViewDimension.value());
    }

}
