package org.webgpu.impl.spi;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;

import org.webgpu.api.TextureSampleType;
import org.webgpu.api.TextureViewDimension;
import org.webgpu.api.spi.TextureBindingLayoutProvider;
import org.webgpu.panama.WGPUTextureBindingLayout;

/**
 * TextureBindingLayoutProviderImpl
 */
public class TextureBindingLayoutProviderImpl implements TextureBindingLayoutProvider {

    private final Arena arena = Arena.ofAuto();

    @Override
    public MemorySegment initializer() {
        return WGPUTextureBindingLayout.allocate(arena);
    }

    @Override
    public TextureSampleType sampleType(MemorySegment structPtr) {
        return TextureSampleType.values()[WGPUTextureBindingLayout.sampleType(structPtr)];
    }

    @Override
    public TextureViewDimension viewDimension(MemorySegment structPtr) {
        return TextureViewDimension.values()[WGPUTextureBindingLayout.viewDimension(structPtr)];
    }

    @Override
    public boolean multisampled(MemorySegment structPtr) {
        return WGPUTextureBindingLayout.multisampled(structPtr) != 0;
    }

    @Override
    public void sampleType(MemorySegment structPtr, TextureSampleType sampleType) {
        WGPUTextureBindingLayout.sampleType(structPtr, sampleType.value());
    }

    @Override
    public void viewDimension(MemorySegment structPtr, TextureViewDimension viewDimension) {
        WGPUTextureBindingLayout.viewDimension(structPtr, viewDimension.value());
    }

    @Override
    public void multisampled(MemorySegment structPtr, boolean multisampled) {
        WGPUTextureBindingLayout.multisampled(structPtr, multisampled ? 1 : 0);
    }

}
