package org.webgpu.impl.spi;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;

import org.jspecify.annotations.NonNull;
import org.webgpu.api.ComputeState;
import org.webgpu.api.PipelineLayout;
import org.webgpu.api.spi.ComputePipelineDescriptorProvider;
import org.webgpu.panama.WGPUComputePipelineDescriptor;
import org.webgpu.panama.WGPUComputeState;

import org.webgpu.impl.util.StructTools;
import org.webgpu.impl.PipelineLayoutImpl;
import org.webgpu.impl.util.StringViewMapper;

/**
 * ComputePipelineDescriptorProviderImpl
 */
public class ComputePipelineDescriptorProviderImpl implements ComputePipelineDescriptorProvider {

    private final Arena arena = Arena.ofAuto();

    @Override
    public MemorySegment initializer() {
        return WGPUComputePipelineDescriptor.allocate(arena);
    }

    @Override
    public String label(MemorySegment structPtr) {
        return StringViewMapper.map(WGPUComputePipelineDescriptor.label(structPtr));
    }

    @Override
    public PipelineLayoutImpl layout(MemorySegment structPtr) {
        var ptr = WGPUComputePipelineDescriptor.layout(structPtr);
        if (ptr == null || ptr.equals(MemorySegment.NULL)) {
            return null;
        }
        return new PipelineLayoutImpl(ptr);
    }

    @Override
    public ComputeState compute(MemorySegment structPtr) {
        var seg = WGPUComputePipelineDescriptor.compute(structPtr);
        return StructTools.placeSegment(seg, ComputeState.class);
    }

    @Override
    public void label(MemorySegment structPtr, String label) {
        WGPUComputePipelineDescriptor.label(structPtr, StringViewMapper.map(label, arena));
    }

    @Override
    public void layout(MemorySegment structPtr, PipelineLayout layout) {
        WGPUComputePipelineDescriptor.layout(structPtr, ((PipelineLayoutImpl) layout).ptr());
    }

    @Override
    public void compute(MemorySegment structPtr, ComputeState compute) {
        if (compute == null) {
            return;
        }
        var seg = StructTools.fetchSegment(compute);
        MemorySegment.copy(seg, 0, WGPUComputePipelineDescriptor.compute(structPtr), 0,
                WGPUComputeState.layout().byteSize());
    }

}
