package org.webgpu.impl.spi;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;
import java.util.Set;

import org.jspecify.annotations.NonNull;
import org.webgpu.api.CompositeAlphaMode;
import org.webgpu.api.PresentMode;
import org.webgpu.api.TextureFormat;
import org.webgpu.api.TextureUsage;
import org.webgpu.api.spi.SurfaceCapabilitiesProvider;
import org.webgpu.panama.WGPUSurfaceCapabilities;

/**
 * SurfaceCapabilitiesProviderImpl
 */
public class SurfaceCapabilitiesProviderImpl implements SurfaceCapabilitiesProvider {
    private final Arena arena = Arena.ofAuto();

    @Override
    public MemorySegment initializer() {
        return WGPUSurfaceCapabilities.allocate(arena);
    }

    @Override
    public Set<TextureUsage> usages(MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'usages'");
    }

    @Override
    public TextureFormat[] formats(MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'formats'");
    }

    @Override
    public PresentMode[] presentModes(MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'presentModes'");
    }

    @Override
    public CompositeAlphaMode[] alphaModes(MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'alphaModes'");
    }

    @Override
    public void usages(MemorySegment structPtr, Set<TextureUsage> usages) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'usages'");
    }

    @Override
    public void formats(MemorySegment structPtr, TextureFormat[] formats) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'formats'");
    }

    @Override
    public void presentModes(MemorySegment structPtr, PresentMode[] presentModes) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'presentModes'");
    }

    @Override
    public void alphaModes(MemorySegment structPtr, CompositeAlphaMode[] alphaModes) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'alphaModes'");
    }

}
