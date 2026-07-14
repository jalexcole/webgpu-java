package org.webgpu.impl.spi;

import java.lang.foreign.MemorySegment;

import org.jspecify.annotations.NonNull;
import org.webgpu.api.BindGroupLayout;
import org.webgpu.api.spi.PipelineLayoutDescriptorProvider;

/**
 * PipelineLayoutDescriptorProviderImpl
 */
public class PipelineLayoutDescriptorProviderImpl implements PipelineLayoutDescriptorProvider {

    @Override
    public @NonNull MemorySegment initializer() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'initializer'");
    }

    @Override
    public @NonNull String label(@NonNull MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'label'");
    }

    @Override
    public BindGroupLayout @NonNull [] bindGroupLayouts(@NonNull MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'bindGroupLayouts'");
    }

    @Override
    public int immediateSize(@NonNull MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'immediateSize'");
    }

    @Override
    public void label(@NonNull MemorySegment structPtr, @NonNull String label) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'label'");
    }

    @Override
    public void bindGroupLayouts(@NonNull MemorySegment structPtr, BindGroupLayout @NonNull [] bindGroupLayouts) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'bindGroupLayouts'");
    }

    @Override
    public void immediateSize(@NonNull MemorySegment structPtr, int immediateSize) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'immediateSize'");
    }

}
