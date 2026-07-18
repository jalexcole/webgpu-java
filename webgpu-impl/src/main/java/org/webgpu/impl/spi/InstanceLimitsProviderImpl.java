package org.webgpu.impl.spi;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;

import org.webgpu.api.spi.InstanceLimitsProvider;
import org.webgpu.panama.WGPUInstanceLimits;

/**
 * InstanceLimitsProviderImpl
 */
public class InstanceLimitsProviderImpl implements InstanceLimitsProvider {
    private final Arena arena = Arena.ofAuto();

    @Override
    public MemorySegment initializer() {
        return WGPUInstanceLimits.allocate(arena);
    }

    @Override
    public long timedWaitAnyMaxCount(MemorySegment structPtr) {
        return WGPUInstanceLimits.timedWaitAnyMaxCount(structPtr);
    }

    @Override
    public void timedWaitAnyMaxCount(MemorySegment structPtr, long timedWaitAnyMaxCount) {
        WGPUInstanceLimits.timedWaitAnyMaxCount(structPtr, timedWaitAnyMaxCount);
    }

}
