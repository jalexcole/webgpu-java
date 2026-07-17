package org.webgpu.impl.spi;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;
import java.util.Set;

import org.jspecify.annotations.NonNull;
import org.webgpu.api.Extent3D;
import org.webgpu.api.TextureDimension;
import org.webgpu.api.TextureFormat;
import org.webgpu.api.TextureUsage;
import org.webgpu.api.spi.TextureDescriptorProvider;
import org.webgpu.panama.WGPUTextureDescriptor;

/**
 * TextureDescriptorProviderImpl
 */
public class TextureDescriptorProviderImpl implements TextureDescriptorProvider {
    private final Arena arena = Arena.ofAuto();

    @Override
    public MemorySegment initializer() {
        return WGPUTextureDescriptor.allocate(arena);
    }

    @Override
    public String label(MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'label'");
    }

    @Override
    public Set<TextureUsage> usage(MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'usage'");
    }

    @Override
    public TextureDimension dimension(MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'dimension'");
    }

    @Override
    public Extent3D size(MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'size'");
    }

    @Override
    public TextureFormat format(MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'format'");
    }

    @Override
    public int mipLevelCount(MemorySegment structPtr) {
        return WGPUTextureDescriptor.mipLevelCount(structPtr);
    }

    @Override
    public int sampleCount(MemorySegment structPtr) {
        return WGPUTextureDescriptor.sampleCount(structPtr);
    }

    @Override
    public TextureFormat[] viewFormats(MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'viewFormats'");
    }

    @Override
    public void label(MemorySegment structPtr, String label) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'label'");
    }

    @Override
    public void usage(MemorySegment structPtr, Set<TextureUsage> usage) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'usage'");
    }

    @Override
    public void dimension(MemorySegment structPtr, TextureDimension dimension) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'dimension'");
    }

    @Override
    public void size(MemorySegment structPtr, Extent3D size) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'size'");
    }

    @Override
    public void format(MemorySegment structPtr, TextureFormat format) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'format'");
    }

    @Override
    public void mipLevelCount(MemorySegment structPtr, int mipLevelCount) {
        WGPUTextureDescriptor.mipLevelCount(structPtr, mipLevelCount);
    }

    @Override
    public void sampleCount(MemorySegment structPtr, int sampleCount) {
        WGPUTextureDescriptor.sampleCount(structPtr, sampleCount);
    }

    @Override
    public void viewFormats(MemorySegment structPtr, TextureFormat[] viewFormats) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'viewFormats'");
    }

}
