package org.webgpu.impl.spi;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;

import org.jspecify.annotations.NonNull;
import org.webgpu.api.spi.SurfaceDescriptorProvider;
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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'label'");
    }

    @Override
    public void label(MemorySegment structPtr, String label) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'label'");
    }

}
