package org.webgpu.impl.spi;

import java.lang.foreign.MemorySegment;

import org.jspecify.annotations.NonNull;
import org.webgpu.api.spi.InstanceLimitsProvider;

/**
 * InstanceLimitsProviderImpl
 */
public class InstanceLimitsProviderImpl implements InstanceLimitsProvider {

    @Override
    public @NonNull MemorySegment initializer() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'initializer'");
    }

    @Override
    public long timedWaitAnyMaxCount(@NonNull MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'timedWaitAnyMaxCount'");
    }

    @Override
    public void timedWaitAnyMaxCount(@NonNull MemorySegment structPtr, long timedWaitAnyMaxCount) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'timedWaitAnyMaxCount'");
    }

}
