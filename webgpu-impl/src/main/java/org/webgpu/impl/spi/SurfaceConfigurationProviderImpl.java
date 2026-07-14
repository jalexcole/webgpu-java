package org.webgpu.impl.spi;

import java.lang.foreign.MemorySegment;
import java.util.Set;

import org.jspecify.annotations.NonNull;
import org.webgpu.api.CompositeAlphaMode;
import org.webgpu.api.Device;
import org.webgpu.api.PresentMode;
import org.webgpu.api.TextureFormat;
import org.webgpu.api.TextureUsage;
import org.webgpu.api.spi.SurfaceConfigurationProvider;

/**
 * SurfaceConfigurationProviderImpl
 */
public class SurfaceConfigurationProviderImpl implements SurfaceConfigurationProvider {

    @Override
    public @NonNull MemorySegment initializer() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'initializer'");
    }

    @Override
    public @NonNull Device device(@NonNull MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'device'");
    }

    @Override
    public @NonNull TextureFormat format(@NonNull MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'format'");
    }

    @Override
    public @NonNull Set<TextureUsage> usage(@NonNull MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'usage'");
    }

    @Override
    public int width(@NonNull MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'width'");
    }

    @Override
    public int height(@NonNull MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'height'");
    }

    @Override
    public TextureFormat @NonNull [] viewFormats(@NonNull MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'viewFormats'");
    }

    @Override
    public @NonNull CompositeAlphaMode alphaMode(@NonNull MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'alphaMode'");
    }

    @Override
    public @NonNull PresentMode presentMode(@NonNull MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'presentMode'");
    }

    @Override
    public void device(@NonNull MemorySegment structPtr, @NonNull Device device) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'device'");
    }

    @Override
    public void format(@NonNull MemorySegment structPtr, @NonNull TextureFormat format) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'format'");
    }

    @Override
    public void usage(@NonNull MemorySegment structPtr, @NonNull Set<TextureUsage> usage) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'usage'");
    }

    @Override
    public void width(@NonNull MemorySegment structPtr, int width) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'width'");
    }

    @Override
    public void height(@NonNull MemorySegment structPtr, int height) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'height'");
    }

    @Override
    public void viewFormats(@NonNull MemorySegment structPtr, TextureFormat @NonNull [] viewFormats) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'viewFormats'");
    }

    @Override
    public void alphaMode(@NonNull MemorySegment structPtr, @NonNull CompositeAlphaMode alphaMode) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'alphaMode'");
    }

    @Override
    public void presentMode(@NonNull MemorySegment structPtr, @NonNull PresentMode presentMode) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'presentMode'");
    }

}
