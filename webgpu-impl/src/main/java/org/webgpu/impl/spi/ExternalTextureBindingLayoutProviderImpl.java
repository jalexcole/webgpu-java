package org.webgpu.impl.spi;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;

import org.webgpu.api.spi.ExternalTextureBindingLayoutProvider;
import org.webgpu.panama.WGPUExternalTextureBindingLayout;

/**
 * ExternalTextureBindingLayoutProviderImpl
 */
public class ExternalTextureBindingLayoutProviderImpl implements ExternalTextureBindingLayoutProvider {
    private final Arena arena = Arena.ofAuto();

    @Override
    public MemorySegment initializer() {
        return WGPUExternalTextureBindingLayout.allocate(arena);
    }

}
