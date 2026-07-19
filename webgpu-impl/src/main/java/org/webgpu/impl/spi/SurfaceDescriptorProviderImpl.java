package org.webgpu.impl.spi;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;

import org.webgpu.api.spi.SurfaceDescriptorProvider;
import org.webgpu.impl.util.StringViewMapper;
import org.webgpu.panama.WGPUSurfaceDescriptor;

/**
 * SurfaceDescriptorProviderImpl
 */
public class SurfaceDescriptorProviderImpl implements SurfaceDescriptorProvider {
    private final Arena arena = Arena.ofAuto();

    @Override
    public MemorySegment initializer() {
        return WGPUSurfaceDescriptor.allocate(arena);
    }

    @Override
    public String label(MemorySegment structPtr) {
        return StringViewMapper.map(WGPUSurfaceDescriptor.label(structPtr));
    }

    @Override
    public void label(MemorySegment structPtr, String label) {
        final MemorySegment labelSegment = StringViewMapper.map(label, arena);
        WGPUSurfaceDescriptor.label(structPtr, labelSegment);
    }

}
