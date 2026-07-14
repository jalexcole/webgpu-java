package org.webgpu.impl.spi;

import java.lang.foreign.MemorySegment;
import java.util.Set;

import org.jspecify.annotations.NonNull;
import org.webgpu.api.Extent3D;
import org.webgpu.api.TextureDimension;
import org.webgpu.api.TextureFormat;
import org.webgpu.api.TextureUsage;
import org.webgpu.api.spi.TextureDescriptorProvider;

/**
 * TextureDescriptorProviderImpl
 */
public class TextureDescriptorProviderImpl implements TextureDescriptorProvider {

    @Override
    public @NonNull MemorySegment initializer() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'initializer'");
    }

    @Override
    public @NonNull String label(@NonNull MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'label'");
    }

    @Override
    public @NonNull Set<TextureUsage> usage(@NonNull MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'usage'");
    }

    @Override
    public @NonNull TextureDimension dimension(@NonNull MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'dimension'");
    }

    @Override
    public @NonNull Extent3D size(@NonNull MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'size'");
    }

    @Override
    public @NonNull TextureFormat format(@NonNull MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'format'");
    }

    @Override
    public int mipLevelCount(@NonNull MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mipLevelCount'");
    }

    @Override
    public int sampleCount(@NonNull MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'sampleCount'");
    }

    @Override
    public TextureFormat @NonNull [] viewFormats(@NonNull MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'viewFormats'");
    }

    @Override
    public void label(@NonNull MemorySegment structPtr, @NonNull String label) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'label'");
    }

    @Override
    public void usage(@NonNull MemorySegment structPtr, @NonNull Set<TextureUsage> usage) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'usage'");
    }

    @Override
    public void dimension(@NonNull MemorySegment structPtr, @NonNull TextureDimension dimension) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'dimension'");
    }

    @Override
    public void size(@NonNull MemorySegment structPtr, @NonNull Extent3D size) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'size'");
    }

    @Override
    public void format(@NonNull MemorySegment structPtr, @NonNull TextureFormat format) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'format'");
    }

    @Override
    public void mipLevelCount(@NonNull MemorySegment structPtr, int mipLevelCount) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mipLevelCount'");
    }

    @Override
    public void sampleCount(@NonNull MemorySegment structPtr, int sampleCount) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'sampleCount'");
    }

    @Override
    public void viewFormats(@NonNull MemorySegment structPtr, TextureFormat @NonNull [] viewFormats) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'viewFormats'");
    }

}
