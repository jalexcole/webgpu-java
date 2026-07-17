package org.webgpu.impl.spi;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;

import org.jspecify.annotations.NonNull;
import org.webgpu.api.ComponentSwizzle;
import org.webgpu.api.TextureComponentSwizzle;
import org.webgpu.api.spi.TextureComponentSwizzleDescriptorProvider;
import org.webgpu.api.spi.TextureComponentSwizzleProvider;
import org.webgpu.panama.WGPUTextureComponentSwizzleDescriptor;

/**
 * TextureComponentSwizzleProviderImpl
 */
public class TextureComponentSwizzleProviderImpl implements TextureComponentSwizzleProvider {
    private final Arena arena = Arena.ofAuto();

    @Override
    public MemorySegment initializer() {
        return WGPUTextureComponentSwizzleDescriptor.allocate(arena);
    }

    @Override
    public ComponentSwizzle r(MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'r'");
    }

    @Override
    public ComponentSwizzle g(MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'g'");
    }

    @Override
    public ComponentSwizzle b(MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'b'");
    }

    @Override
    public ComponentSwizzle a(MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'a'");
    }

    @Override
    public void r(MemorySegment structPtr, ComponentSwizzle r) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'r'");
    }

    @Override
    public void g(MemorySegment structPtr, ComponentSwizzle g) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'g'");
    }

    @Override
    public void b(MemorySegment structPtr, ComponentSwizzle b) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'b'");
    }

    @Override
    public void a(MemorySegment structPtr, ComponentSwizzle a) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'a'");
    }

    

}
