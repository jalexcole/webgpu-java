package org.webgpu.impl.spi;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;

import org.jspecify.annotations.NullMarked;
import org.webgpu.api.spi.MultisampleStateProvider;
import org.webgpu.panama.WGPUMultisampleState;
import org.webgpu.panama.webgpu_h;

/**
 * MultisampleStateProviderImpl
 */
@NullMarked
public class MultisampleStateProviderImpl implements MultisampleStateProvider {
    private final Arena arena = Arena.ofAuto();

    @Override
    public MemorySegment initializer() {
        return WGPUMultisampleState.allocate(arena);
    }

    @Override
    public int count(MemorySegment structPtr) {
        return WGPUMultisampleState.count(structPtr);
    }

    @Override
    public int mask(MemorySegment structPtr) {
        return WGPUMultisampleState.mask(structPtr);
    }

    @Override
    public boolean alphaToCoverageEnabled(MemorySegment structPtr) {
        return WGPUMultisampleState.alphaToCoverageEnabled(structPtr) == webgpu_h.WGPU_TRUE();
    }

    @Override
    public void count(MemorySegment structPtr, int count) {
        WGPUMultisampleState.count(structPtr, count);
    }

    @Override
    public void mask(MemorySegment structPtr, int mask) {
        WGPUMultisampleState.mask(structPtr, mask);
    }

    @Override
    public void alphaToCoverageEnabled(MemorySegment structPtr, boolean alphaToCoverageEnabled) {
        WGPUMultisampleState.alphaToCoverageEnabled(structPtr, alphaToCoverageEnabled ? webgpu_h.WGPU_TRUE() : webgpu_h.WGPU_FALSE());
    }

}
