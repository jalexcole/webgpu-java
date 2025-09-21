package org.webgpu.api;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;
import java.util.Optional;

import org.webgpu.foreign.WGPUTextureDescriptor;
import org.webgpu.util.StringView;

public class TextureDescriptor {

    @SuppressWarnings("preview")
    private final MemorySegment ptr;

    public TextureDescriptor() {
        @SuppressWarnings("preview")
        Arena arena = Arena.ofAuto();

        ptr = WGPUTextureDescriptor.allocate(arena);
    }

    public Optional<ChainedStruct> nextInChain() {
        return Optional.of(new ChainedStruct(WGPUTextureDescriptor.nextInChain(ptr)));
    }

    public String label() {
        return new StringView(WGPUTextureDescriptor.label(ptr)).string();
    }

    public void setLabel(String label) {
        try (@SuppressWarnings("preview")
        Arena arena = Arena.ofConfined()) {
            var stringView = StringView.of(arena, label);
            WGPUTextureDescriptor.label(ptr, stringView);
        }
    }

    public TextureUsage usage() {
        return TextureUsage.fromValue(WGPUTextureDescriptor.usage(ptr));
    }

    public void setUsage(TextureUsage usage) {
        WGPUTextureDescriptor.usage(ptr, usage.value());
    }

    public TextureDimension dimension() {
        return TextureDimension.fromValue(WGPUTextureDescriptor.dimension(ptr));
    }

    public void setDimension(TextureDimension dimension) {
        WGPUTextureDescriptor.dimension(ptr, dimension.value());
    }

    public Extent3D size() {
        
        throw new UnsupportedOperationException("Unimplemented method 'size'");
    }

    public TextureFormat format() {
        throw new UnsupportedOperationException("Unimplemented method 'format'");
    }

    public int mipLevelCount() {
        return WGPUTextureDescriptor.mipLevelCount(ptr);
    }

    public int sampleCount() {
        return WGPUTextureDescriptor.sampleCount(ptr);
    }

    public long viewFormatCount() {
        return WGPUTextureDescriptor.viewFormatCount(ptr);
    }

    @SuppressWarnings("preview")
    public MemorySegment ptr() {
        return ptr;
    }

    @Override
    public String toString() {
        return "TextureDescriptor [nextInChain()=" + nextInChain() + ", label()=" + label() + ", usage()=" + usage()
                + ", dimension()=" + dimension() + ", size()=" + size() + ", format()=" + format()
                + ", mipLevelCount()=" + mipLevelCount() + ", sampleCount()=" + sampleCount() + ", viewFormatCount()="
                + viewFormatCount() + "]";
    }

    

}
