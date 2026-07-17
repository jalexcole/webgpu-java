package org.webgpu.impl.spi;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;

import org.jspecify.annotations.NonNull;
import org.webgpu.api.spi.RequestAdapterWebXROptionsProvider;
import org.webgpu.panama.WGPURequestAdapterWebXROptions;
import org.webgpu.panama.webgpu_h;

/**
 * RequestAdapterWebXROptionsProviderImpl
 */
public class RequestAdapterWebXROptionsProviderImpl implements RequestAdapterWebXROptionsProvider {
    private final Arena arena = Arena.ofAuto();

    @Override
    public MemorySegment initializer() {
        return WGPURequestAdapterWebXROptions.allocate(arena);
    }

    @Override
    public boolean xrCompatible(MemorySegment structPtr) {
        return WGPURequestAdapterWebXROptions.xrCompatible(structPtr) != 0;
    }

    @Override
    public void xrCompatible(MemorySegment structPtr, boolean xrCompatible) {
        WGPURequestAdapterWebXROptions.xrCompatible(structPtr, xrCompatible ? webgpu_h.WGPU_TRUE() : 0);
    }

}
