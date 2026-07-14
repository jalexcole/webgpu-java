package org.webgpu.impl.spi;

import java.lang.foreign.MemorySegment;
import java.util.Set;

import org.jspecify.annotations.NonNull;
import org.webgpu.api.TextureAspect;
import org.webgpu.api.TextureFormat;
import org.webgpu.api.TextureUsage;
import org.webgpu.api.TextureViewDimension;
import org.webgpu.api.spi.TextureViewDescriptorProvider;

/**
 * TextureViewDescriptorProviderImpl
 */
public class TextureViewDescriptorProviderImpl implements TextureViewDescriptorProvider {

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
    public @NonNull TextureFormat format(@NonNull MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'format'");
    }

    @Override
    public @NonNull TextureViewDimension dimension(@NonNull MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'dimension'");
    }

    @Override
    public int baseMipLevel(@NonNull MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'baseMipLevel'");
    }

    @Override
    public int mipLevelCount(@NonNull MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mipLevelCount'");
    }

    @Override
    public int baseArrayLayer(@NonNull MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'baseArrayLayer'");
    }

    @Override
    public int arrayLayerCount(@NonNull MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'arrayLayerCount'");
    }

    @Override
    public @NonNull TextureAspect aspect(@NonNull MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'aspect'");
    }

    @Override
    public @NonNull Set<TextureUsage> usage(@NonNull MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'usage'");
    }

    @Override
    public void label(@NonNull MemorySegment structPtr, @NonNull String label) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'label'");
    }

    @Override
    public void format(@NonNull MemorySegment structPtr, @NonNull TextureFormat format) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'format'");
    }

    @Override
    public void dimension(@NonNull MemorySegment structPtr, @NonNull TextureViewDimension dimension) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'dimension'");
    }

    @Override
    public void baseMipLevel(@NonNull MemorySegment structPtr, int baseMipLevel) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'baseMipLevel'");
    }

    @Override
    public void mipLevelCount(@NonNull MemorySegment structPtr, int mipLevelCount) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mipLevelCount'");
    }

    @Override
    public void baseArrayLayer(@NonNull MemorySegment structPtr, int baseArrayLayer) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'baseArrayLayer'");
    }

    @Override
    public void arrayLayerCount(@NonNull MemorySegment structPtr, int arrayLayerCount) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'arrayLayerCount'");
    }

    @Override
    public void aspect(@NonNull MemorySegment structPtr, @NonNull TextureAspect aspect) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'aspect'");
    }

    @Override
    public void usage(@NonNull MemorySegment structPtr, @NonNull Set<TextureUsage> usage) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'usage'");
    }

}
