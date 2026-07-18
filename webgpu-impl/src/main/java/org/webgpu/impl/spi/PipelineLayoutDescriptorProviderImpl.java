package org.webgpu.impl.spi;

import java.lang.foreign.AddressLayout;
import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;

import org.webgpu.api.BindGroupLayout;
import org.webgpu.api.spi.PipelineLayoutDescriptorProvider;
import org.webgpu.impl.BindGroupLayoutImpl;
import org.webgpu.impl.util.StringViewMapper;
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
        final var labelPtr = WGPUPipelineLayoutDescriptor.label(structPtr);
        return StringViewMapper.map(labelPtr);
    }

    @Override
    public BindGroupLayout[] bindGroupLayouts(MemorySegment structPtr) {
        final var bindGroupLayoutsPtr = WGPUPipelineLayoutDescriptor.bindGroupLayouts(structPtr);
        final long count = WGPUPipelineLayoutDescriptor.bindGroupLayoutCount(structPtr);

        final var bindGroupLayouts = new BindGroupLayout[(int) count];
        for (int i = 0; i < count; i++) {
            final var bindGroupLayoutPtr = bindGroupLayoutsPtr.getAtIndex(AddressLayout.ADDRESS, i);
            bindGroupLayouts[i] = new BindGroupLayoutImpl(bindGroupLayoutPtr);
        }
        return bindGroupLayouts;
    }

    @Override
    public int immediateSize(MemorySegment structPtr) {
        return WGPUPipelineLayoutDescriptor.immediateSize(structPtr);
    }

    @Override
    public void label(MemorySegment structPtr, String label) {
        try (Arena confinedArena = Arena.ofConfined()) {
            WGPUPipelineLayoutDescriptor.label(structPtr, StringViewMapper.map(label, confinedArena));
        }
    }

    @Override
    public void bindGroupLayouts(MemorySegment structPtr, BindGroupLayout[] bindGroupLayouts) {
        final var bindGroupLayoutsPtr = arena.allocate(AddressLayout.ADDRESS, bindGroupLayouts.length);
        for (int i = 0; i < bindGroupLayouts.length; i++) {
            bindGroupLayoutsPtr.setAtIndex(AddressLayout.ADDRESS, i, ((BindGroupLayoutImpl) bindGroupLayouts[i]).ptr());
        }
        WGPUPipelineLayoutDescriptor.bindGroupLayouts(structPtr, bindGroupLayoutsPtr);
        WGPUPipelineLayoutDescriptor.bindGroupLayoutCount(structPtr, bindGroupLayouts.length);
    }

    @Override
    public void immediateSize(MemorySegment structPtr, int immediateSize) {
        WGPUPipelineLayoutDescriptor.immediateSize(structPtr, immediateSize);
    }

}
