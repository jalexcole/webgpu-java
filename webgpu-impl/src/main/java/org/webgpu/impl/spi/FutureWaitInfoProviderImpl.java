package org.webgpu.impl.spi;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;

import org.jspecify.annotations.NonNull;
import org.webgpu.api.Future;
import org.webgpu.api.spi.FutureWaitInfoProvider;
import org.webgpu.panama.WGPUFutureWaitInfo;

/**
 * FutureWaitInfoProviderImpl
 */
public class FutureWaitInfoProviderImpl implements FutureWaitInfoProvider {
    private final Arena arena = Arena.ofAuto();

    @Override
    public MemorySegment initializer() {
        return WGPUFutureWaitInfo.allocate(arena);
    }

    @Override
    public Future future(MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'future'");
    }

    @Override
    public boolean completed(MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'completed'");
    }

    @Override
    public void future(MemorySegment structPtr, Future future) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'future'");
    }

    @Override
    public void completed(MemorySegment structPtr, boolean completed) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'completed'");
    }

}
