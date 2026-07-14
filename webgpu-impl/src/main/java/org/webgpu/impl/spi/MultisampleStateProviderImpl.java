package org.webgpu.impl.spi;

import java.lang.foreign.MemorySegment;

import org.jspecify.annotations.NonNull;
import org.webgpu.api.spi.MultisampleStateProvider;

/**
 * MultisampleStateProviderImpl
 */
public class MultisampleStateProviderImpl implements MultisampleStateProvider {

    @Override
    public @NonNull MemorySegment initializer() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'initializer'");
    }

    @Override
    public int count(@NonNull MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'count'");
    }

    @Override
    public int mask(@NonNull MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mask'");
    }

    @Override
    public boolean alphaToCoverageEnabled(@NonNull MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'alphaToCoverageEnabled'");
    }

    @Override
    public void count(@NonNull MemorySegment structPtr, int count) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'count'");
    }

    @Override
    public void mask(@NonNull MemorySegment structPtr, int mask) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mask'");
    }

    @Override
    public void alphaToCoverageEnabled(@NonNull MemorySegment structPtr, boolean alphaToCoverageEnabled) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'alphaToCoverageEnabled'");
    }

}
