package org.webgpu.impl.spi;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;

import org.jspecify.annotations.NonNull;
import org.webgpu.api.spi.RenderBundleDescriptorProvider;
import org.webgpu.impl.util.StringViewMapper;
import org.webgpu.panama.WGPURenderBundleDescriptor;

/**
 * RenderBundleDescriptorProviderImpl
 */
public class RenderBundleDescriptorProviderImpl implements RenderBundleDescriptorProvider {
    private final Arena arena = Arena.ofAuto();

    @Override
    public MemorySegment initializer() {
        return WGPURenderBundleDescriptor.allocate(arena);
    }

    @Override
    public String label(MemorySegment structPtr) {
        return StringViewMapper.map(WGPURenderBundleDescriptor.label(structPtr));
    }

    @Override
    public void label(MemorySegment structPtr, String label) {
        WGPURenderBundleDescriptor.label(structPtr, StringViewMapper.map(label, arena));
    }

}
