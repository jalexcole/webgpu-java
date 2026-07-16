package org.webgpu.impl.spi;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;

import org.jspecify.annotations.NonNull;
import org.webgpu.api.ComputeState;
import org.webgpu.api.PipelineLayout;
import org.webgpu.api.spi.ComputePipelineDescriptorProvider;
import org.webgpu.panama.WGPUComputePipelineDescriptor;

/**
 * ComputePipelineDescriptorProviderImpl
 */
public class ComputePipelineDescriptorProviderImpl implements ComputePipelineDescriptorProvider {

    private final Arena arena = Arena.ofAuto();

    @Override
    public @NonNull MemorySegment initializer() {
        return WGPUComputePipelineDescriptor.allocate(arena);
    }

    @Override
    public @NonNull String label(@NonNull MemorySegment structPtr) {
        WGPUComputePipelineDescriptor.label(structPtr);
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'label'");
    }

    @Override
    public @NonNull PipelineLayout layout(@NonNull MemorySegment structPtr) {
        WGPUComputePipelineDescriptor.layout(structPtr);
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'layout'");
    }

    @Override
    public @NonNull ComputeState compute(@NonNull MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'compute'");
    }

    @Override
    public void label(@NonNull MemorySegment structPtr, @NonNull String label) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'label'");
    }

    @Override
    public void layout(@NonNull MemorySegment structPtr, @NonNull PipelineLayout layout) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'layout'");
    }

    @Override
    public void compute(@NonNull MemorySegment structPtr, @NonNull ComputeState compute) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'compute'");
    }

}
