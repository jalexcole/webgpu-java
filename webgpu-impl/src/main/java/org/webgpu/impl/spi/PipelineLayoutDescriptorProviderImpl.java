package org.webgpu.impl.spi;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;

import org.jspecify.annotations.NonNull;
import org.webgpu.api.BindGroupLayout;
import org.webgpu.api.spi.PipelineLayoutDescriptorProvider;
import org.webgpu.panama.WGPUPipelineLayoutDescriptor;

/**
 * PipelineLayoutDescriptorProviderImpl
 */
public class PipelineLayoutDescriptorProviderImpl implements PipelineLayoutDescriptorProvider {
    private final Arena arena = Arena.ofAuto();

    @Override
    public MemorySegment initializer() {
        return WGPUPipelineLayoutDescriptor.allocate(arena);
    }

    @Override
    public String label(MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'label'");
    }

    @Override
    public BindGroupLayout[] bindGroupLayouts(MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'bindGroupLayouts'");
    }

    @Override
    public int immediateSize(MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'immediateSize'");
    }

    @Override
    public void label(MemorySegment structPtr, String label) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'label'");
    }

    @Override
    public void bindGroupLayouts(MemorySegment structPtr, BindGroupLayout[] bindGroupLayouts) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'bindGroupLayouts'");
    }

    @Override
    public void immediateSize(MemorySegment structPtr, int immediateSize) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'immediateSize'");
    }

}
