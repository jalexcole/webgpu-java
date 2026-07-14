package org.webgpu.impl.spi;

import java.lang.foreign.MemorySegment;
import java.util.Set;

import org.jspecify.annotations.NonNull;
import org.webgpu.api.CompositeAlphaMode;
import org.webgpu.api.PresentMode;
import org.webgpu.api.TextureFormat;
import org.webgpu.api.TextureUsage;
import org.webgpu.api.spi.SurfaceCapabilitiesProvider;

/**
 * SurfaceCapabilitiesProviderImpl
 */
public class SurfaceCapabilitiesProviderImpl implements SurfaceCapabilitiesProvider {

    @Override
    public @NonNull MemorySegment initializer() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'initializer'");
    }

    @Override
    public @NonNull Set<TextureUsage> usages(@NonNull MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'usages'");
    }

    @Override
    public TextureFormat @NonNull [] formats(@NonNull MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'formats'");
    }

    @Override
    public PresentMode @NonNull [] presentModes(@NonNull MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'presentModes'");
    }

    @Override
    public CompositeAlphaMode @NonNull [] alphaModes(@NonNull MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'alphaModes'");
    }

    @Override
    public void usages(@NonNull MemorySegment structPtr, @NonNull Set<TextureUsage> usages) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'usages'");
    }

    @Override
    public void formats(@NonNull MemorySegment structPtr, TextureFormat @NonNull [] formats) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'formats'");
    }

    @Override
    public void presentModes(@NonNull MemorySegment structPtr, PresentMode @NonNull [] presentModes) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'presentModes'");
    }

    @Override
    public void alphaModes(@NonNull MemorySegment structPtr, CompositeAlphaMode @NonNull [] alphaModes) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'alphaModes'");
    }

}
