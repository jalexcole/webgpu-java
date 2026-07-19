package org.webgpu.impl.spi;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.ValueLayout;
import java.util.Set;

import org.webgpu.api.Extent3D;
import org.webgpu.api.TextureDimension;
import org.webgpu.api.TextureFormat;
import org.webgpu.api.TextureUsage;
import org.webgpu.api.spi.TextureDescriptorProvider;
import org.webgpu.impl.util.BitPacker;
import org.webgpu.impl.util.StringViewMapper;
import org.webgpu.impl.util.StructTools;
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
        return StringViewMapper.map(WGPUTextureDescriptor.label(structPtr));
    }

    @Override
    public Set<TextureUsage> usage(MemorySegment structPtr) {
        final long usageValue = WGPUTextureDescriptor.usage(structPtr);
        return BitPacker.unpack(usageValue, TextureUsage.class);
    }

    @Override
    public TextureDimension dimension(MemorySegment structPtr) {
        final int dimensionValue = WGPUTextureDescriptor.dimension(structPtr);
        return TextureDimension.values()[dimensionValue];
    }

    @Override
    public Extent3D size(MemorySegment structPtr) {
        final var size = WGPUTextureDescriptor.size(structPtr);
        return StructTools.placeSegment(size, Extent3D.class);
    }

    @Override
    public TextureFormat format(MemorySegment structPtr) {
        final int formatValue = WGPUTextureDescriptor.format(structPtr);
        return TextureFormat.values()[formatValue];
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
        final MemorySegment labelSegment = StringViewMapper.map(label, arena);
        WGPUTextureDescriptor.label(structPtr, labelSegment);
    }

    @Override
    public void usage(MemorySegment structPtr, Set<TextureUsage> usage) {
        final long usageValue = BitPacker.pack(usage);
        WGPUTextureDescriptor.usage(structPtr, usageValue);
    }

    @Override
    public void dimension(MemorySegment structPtr, TextureDimension dimension) {
        int dimensionValue = dimension.value();
        WGPUTextureDescriptor.dimension(structPtr, dimensionValue);
    }

    @Override
    public void size(MemorySegment structPtr, Extent3D size) {
        final var sizeSegment = StructTools.fetchSegment(size);
        WGPUTextureDescriptor.size(structPtr, sizeSegment);
    }

    @Override
    public void format(MemorySegment structPtr, TextureFormat format) {
        final int formatValue = format.value();
        WGPUTextureDescriptor.format(structPtr, formatValue);
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
        if (viewFormats == null || viewFormats.length == 0) {
            WGPUTextureDescriptor.viewFormats(structPtr, MemorySegment.NULL);
            WGPUTextureDescriptor.viewFormatCount(structPtr, 0);
            return;
        }
        final MemorySegment viewFormatsPtr = arena.allocate(ValueLayout.JAVA_INT, viewFormats.length);
        for (int i = 0; i < viewFormats.length; i++) {
            viewFormatsPtr.setAtIndex(ValueLayout.JAVA_INT, i, viewFormats[i].value());
        }
        WGPUTextureDescriptor.viewFormats(structPtr, viewFormatsPtr);
        WGPUTextureDescriptor.viewFormatCount(structPtr, viewFormats.length);
    }

}
