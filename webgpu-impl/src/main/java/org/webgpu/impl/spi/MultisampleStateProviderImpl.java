package org.webgpu.impl.spi;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;

import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.NullMarked;
import org.webgpu.api.spi.MultisampleStateProvider;
import org.webgpu.panama.WGPUMultisampleState;

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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'count'");
    }

    @Override
    public int mask(MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mask'");
    }

    @Override
    public boolean alphaToCoverageEnabled(MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'alphaToCoverageEnabled'");
    }

    @Override
    public void count(MemorySegment structPtr, int count) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'count'");
    }

    @Override
    public void mask(MemorySegment structPtr, int mask) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mask'");
    }

    @Override
    public void alphaToCoverageEnabled(MemorySegment structPtr, boolean alphaToCoverageEnabled) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'alphaToCoverageEnabled'");
    }

}
