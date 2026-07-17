package org.webgpu.impl.spi;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;

import org.webgpu.api.BufferBindingType;
import org.webgpu.api.spi.BufferBindingLayoutProvider;
import org.webgpu.panama.WGPUBufferBindingLayout;

public class BufferBindingLayoutProviderImpl implements BufferBindingLayoutProvider {

    private final Arena arena = Arena.ofAuto();

    @Override
    public MemorySegment initializer() {
        return WGPUBufferBindingLayout.allocate(arena);
    }

    @Override
    public BufferBindingType type(MemorySegment structPtr) {
        return BufferBindingType.values()[WGPUBufferBindingLayout.type(structPtr)];
    }

    @Override
    public boolean hasDynamicOffset(MemorySegment structPtr) {
        return WGPUBufferBindingLayout.hasDynamicOffset(structPtr) != 0;
    }

    @Override
    public long minBindingSize(MemorySegment structPtr) {
        return WGPUBufferBindingLayout.minBindingSize(structPtr);
    }

    @Override
    public void type(MemorySegment structPtr, BufferBindingType type) {
        WGPUBufferBindingLayout.type(structPtr, type.value());
    }

    @Override
    public void hasDynamicOffset(MemorySegment structPtr, boolean hasDynamicOffset) {
        WGPUBufferBindingLayout.hasDynamicOffset(structPtr, hasDynamicOffset ? 1 : 0);
    }

    @Override
    public void minBindingSize(MemorySegment structPtr, long minBindingSize) {
        WGPUBufferBindingLayout.minBindingSize(structPtr, minBindingSize);
    }
}
