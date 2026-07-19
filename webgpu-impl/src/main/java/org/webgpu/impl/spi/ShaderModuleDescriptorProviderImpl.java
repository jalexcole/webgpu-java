package org.webgpu.impl.spi;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;

import org.webgpu.api.spi.ShaderModuleDescriptorProvider;
import org.webgpu.impl.util.StringViewMapper;
import org.webgpu.panama.WGPUShaderModuleDescriptor;

/**
 * ShaderModuleDescriptorProviderImpl
 */
public class ShaderModuleDescriptorProviderImpl implements ShaderModuleDescriptorProvider {
    private final Arena arena = Arena.ofAuto();

    @Override
    public MemorySegment initializer() {
        return WGPUShaderModuleDescriptor.allocate(arena);
    }

    @Override
    public String label(MemorySegment structPtr) {
        final MemorySegment labelSegment = WGPUShaderModuleDescriptor.label(structPtr);
        return StringViewMapper.map(labelSegment);

    }

    @Override
    public void label(MemorySegment structPtr, String label) {
        final MemorySegment labelSegment = StringViewMapper.map(label, arena);
        WGPUShaderModuleDescriptor.label(structPtr, labelSegment);
    }

}
