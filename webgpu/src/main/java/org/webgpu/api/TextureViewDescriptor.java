package org.webgpu.api;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;
import java.util.Optional;

import org.webgpu.panama.foreign.WGPUTextureViewDescriptor;
import org.webgpu.util.StringView;

public non-sealed class TextureViewDescriptor implements DescriptorBase {
    private final MemorySegment ptr;

    public TextureViewDescriptor() {
        final Arena arena = Arena.ofAuto();
        this.ptr = WGPUTextureViewDescriptor.allocate(arena);
    }

    public TextureViewDescriptor(MemorySegment ptr) {
        this.ptr = ptr;
    }

    public Optional<ChainedStruct> nextInChain() {
        return Optional.of(new ChainedStruct(WGPUTextureViewDescriptor.nextInChain(ptr)));
    }

    public String label() {
        return new StringView(WGPUTextureViewDescriptor.label(ptr)).string();
    }

    public TextureFormat format() {
        return TextureFormat.fromValue(WGPUTextureViewDescriptor.format(ptr));
    }

    public TextureViewDimension dimension() {
        return TextureViewDimension.fromValue(WGPUTextureViewDescriptor.dimension(ptr));
    }

    public int mipLevelCount() {
        return WGPUTextureViewDescriptor.mipLevelCount(ptr);
    }

    public int baseArrayLayer() {
        return WGPUTextureViewDescriptor.baseArrayLayer(ptr);
    }

    public int arrayLayerCount() {
        return WGPUTextureViewDescriptor.arrayLayerCount(ptr);
    }

    public TextureAspect aspect() {
        return TextureAspect.fromValue(WGPUTextureViewDescriptor.aspect(ptr));
    }

    public TextureUsage usage() {
        throw new UnsupportedOperationException("Unimplemented method 'usage'");
    }

    public MemorySegment ptr() {
        return ptr;
    }

    @Override
    public String toString() {
        return "TextureViewDescriptor [nextInChain()=" + nextInChain() + ", label()=" + label() + ", format()="
                + format() + ", dimension()=" + dimension() + ", mipLevelCount()=" + mipLevelCount()
                + ", baseArrayLayer()=" + baseArrayLayer() + ", arrayLayerCount()=" + arrayLayerCount() + ", aspect()="
                + aspect() + ", usage()=" + usage() + "]";
    }

}
