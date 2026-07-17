package org.webgpu.impl.spi;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;

import org.jspecify.annotations.NonNull;
import org.webgpu.api.spi.RenderPassMaxDrawCountProvider;
import org.webgpu.panama.WGPURenderPassMaxDrawCount;

/**
 * RenderPassMaxDrawCountProviderImpl
 */
public class RenderPassMaxDrawCountProviderImpl implements RenderPassMaxDrawCountProvider {
    private final Arena arena = Arena.ofAuto();

    @Override
    public MemorySegment initializer() {
        return WGPURenderPassMaxDrawCount.allocate(arena);
    }

    @Override
    public long maxDrawCount(MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'maxDrawCount'");
    }

    @Override
    public void maxDrawCount(MemorySegment structPtr, long maxDrawCount) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'maxDrawCount'");
    }

}
