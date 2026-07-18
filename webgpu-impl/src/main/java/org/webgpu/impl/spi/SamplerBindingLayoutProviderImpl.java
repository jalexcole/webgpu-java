package org.webgpu.impl.spi;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;

import org.webgpu.api.SamplerBindingType;
import org.webgpu.api.spi.SamplerBindingLayoutProvider;
import org.webgpu.panama.WGPUSamplerBindingLayout;

/**
 * SamplerBindingLayoutProviderImpl
 */
public class SamplerBindingLayoutProviderImpl implements SamplerBindingLayoutProvider {

    private final Arena arena = Arena.ofAuto();

    @Override
    public MemorySegment initializer() {
        return WGPUSamplerBindingLayout.allocate(arena);
    }

    @Override
    public SamplerBindingType type(MemorySegment structPtr) {
        return SamplerBindingType.values()[WGPUSamplerBindingLayout.type(structPtr)];
    }

    @Override
    public void type(MemorySegment structPtr, SamplerBindingType type) {
        WGPUSamplerBindingLayout.type(structPtr, type.value());
    }

}
