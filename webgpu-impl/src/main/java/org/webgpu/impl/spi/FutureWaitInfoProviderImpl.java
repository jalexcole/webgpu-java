package org.webgpu.impl.spi;

import java.lang.foreign.MemorySegment;

import org.jspecify.annotations.NonNull;
import org.webgpu.api.Future;
import org.webgpu.api.spi.FutureWaitInfoProvider;

/**
 * FutureWaitInfoProviderImpl
 */
public class FutureWaitInfoProviderImpl implements FutureWaitInfoProvider {

    @Override
    public @NonNull MemorySegment initializer() {
        
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'initializer'");
    }

    @Override
    public @NonNull Future future(@NonNull MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'future'");
    }

    @Override
    public boolean completed(@NonNull MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'completed'");
    }

    @Override
    public void future(@NonNull MemorySegment structPtr, @NonNull Future future) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'future'");
    }

    @Override
    public void completed(@NonNull MemorySegment structPtr, boolean completed) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'completed'");
    }

}
