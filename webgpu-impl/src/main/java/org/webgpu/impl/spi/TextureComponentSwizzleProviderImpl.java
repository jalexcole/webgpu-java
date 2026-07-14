package org.webgpu.impl.spi;

import java.lang.foreign.MemorySegment;

import org.jspecify.annotations.NonNull;
import org.webgpu.api.TextureComponentSwizzle;
import org.webgpu.api.spi.TextureComponentSwizzleDescriptorProvider;

/**
 * TextureComponentSwizzleProviderImpl
 */
public class TextureComponentSwizzleProviderImpl implements TextureComponentSwizzleDescriptorProvider {

    @Override
    public @NonNull MemorySegment initializer() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'initializer'");
    }

    @Override
    public @NonNull TextureComponentSwizzle swizzle(@NonNull MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'swizzle'");
    }

    @Override
    public void swizzle(@NonNull MemorySegment structPtr, @NonNull TextureComponentSwizzle swizzle) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'swizzle'");
    }

}
