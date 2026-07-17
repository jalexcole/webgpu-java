package org.webgpu.impl.spi;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;
import java.util.Set;

import org.jspecify.annotations.NonNull;
import org.webgpu.api.TextureAspect;
import org.webgpu.api.TextureFormat;
import org.webgpu.api.TextureUsage;
import org.webgpu.api.TextureViewDimension;
import org.webgpu.api.spi.TextureViewDescriptorProvider;
import org.webgpu.panama.WGPUTextureViewDescriptor;

/**
 * TextureViewDescriptorProviderImpl
 */
public class TextureViewDescriptorProviderImpl implements TextureViewDescriptorProvider {
    private final Arena arena = Arena.ofAuto();

    @Override
    public MemorySegment initializer() {
        return WGPUTextureViewDescriptor.allocate(arena);
    }

    @Override
    public String label(MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'label'");
    }

    @Override
    public TextureFormat format(MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'format'");
    }

    @Override
    public TextureViewDimension dimension(MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'dimension'");
    }

    @Override
    public int baseMipLevel(MemorySegment structPtr) {
        return WGPUTextureViewDescriptor.baseMipLevel(structPtr);
    }

    @Override
    public int mipLevelCount(MemorySegment structPtr) {
        return WGPUTextureViewDescriptor.mipLevelCount(structPtr);
    }

    @Override
    public int baseArrayLayer(MemorySegment structPtr) {
        return WGPUTextureViewDescriptor.baseArrayLayer(structPtr);
    }

    @Override
    public int arrayLayerCount(MemorySegment structPtr) {
        return WGPUTextureViewDescriptor.arrayLayerCount(structPtr);
    }

    @Override
    public TextureAspect aspect(MemorySegment structPtr) {
        final int aspectValue = WGPUTextureViewDescriptor.aspect(structPtr);
        return TextureAspect.values()[aspectValue];
    }

    @Override
    public Set<TextureUsage> usage(MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'usage'");
    }

    @Override
    public void label(MemorySegment structPtr, String label) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'label'");
    }

    @Override
    public void format(MemorySegment structPtr, TextureFormat format) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'format'");
    }

    @Override
    public void dimension(MemorySegment structPtr, TextureViewDimension dimension) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'dimension'");
    }

    @Override
    public void baseMipLevel(MemorySegment structPtr, int baseMipLevel) {
        WGPUTextureViewDescriptor.baseMipLevel(structPtr, baseMipLevel);
    }

    @Override
    public void mipLevelCount(MemorySegment structPtr, int mipLevelCount) {
        WGPUTextureViewDescriptor.mipLevelCount(structPtr, mipLevelCount);
    }

    @Override
    public void baseArrayLayer(MemorySegment structPtr, int baseArrayLayer) {
        WGPUTextureViewDescriptor.baseArrayLayer(structPtr, baseArrayLayer);
    }

    @Override
    public void arrayLayerCount(MemorySegment structPtr, int arrayLayerCount) {
        WGPUTextureViewDescriptor.arrayLayerCount(structPtr, arrayLayerCount);
    }

    @Override
    public void aspect(MemorySegment structPtr, TextureAspect aspect) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'aspect'");
    }

    @Override
    public void usage(MemorySegment structPtr, Set<TextureUsage> usage) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'usage'");
    }

}
