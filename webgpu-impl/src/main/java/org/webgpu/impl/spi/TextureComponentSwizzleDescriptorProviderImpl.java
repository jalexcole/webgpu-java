package org.webgpu.impl.spi;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;

import org.jspecify.annotations.NonNull;
import org.webgpu.api.TextureComponentSwizzle;
import org.webgpu.api.spi.TextureComponentSwizzleDescriptorProvider;
import org.webgpu.impl.util.StructTools;
import org.webgpu.panama.WGPUTextureComponentSwizzleDescriptor;

/**
 * TextureComponentSwizzleDescriptorProviderImpl
 */
public class TextureComponentSwizzleDescriptorProviderImpl implements TextureComponentSwizzleDescriptorProvider {
    private final Arena arena = Arena.ofAuto();

    @Override
    public MemorySegment initializer() {
        return WGPUTextureComponentSwizzleDescriptor.allocate(arena);
    }

    @Override
    public TextureComponentSwizzle swizzle(MemorySegment structPtr) {
        final MemorySegment swizzlePtr = WGPUTextureComponentSwizzleDescriptor.swizzle(structPtr);
        return StructTools.placeSegment(swizzlePtr, TextureComponentSwizzle.class);
    }

    @Override
    public void swizzle(MemorySegment structPtr, TextureComponentSwizzle swizzle) {
        final MemorySegment swizzlePtr = StructTools.fetchSegment(swizzle);
        WGPUTextureComponentSwizzleDescriptor.swizzle(structPtr, swizzlePtr);
    }

}
