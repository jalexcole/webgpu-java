package org.webgpu.impl.spi;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;

import org.webgpu.api.spi.Origin3DProvider;
import org.webgpu.panama.WGPUOrigin3D;

/**
 * Origin3DProviderImpl
 */
public class Origin3DProviderImpl implements Origin3DProvider {
    private final Arena arena = Arena.ofAuto();

    @Override
    public MemorySegment initializer() {
        return WGPUOrigin3D.allocate(arena);
    }

    @Override
    public int x(MemorySegment structPtr) {
        return WGPUOrigin3D.x(structPtr);
    }

    @Override
    public int y(MemorySegment structPtr) {
        return WGPUOrigin3D.y(structPtr);
    }

    @Override
    public int z(MemorySegment structPtr) {
        return WGPUOrigin3D.z(structPtr);
    }

    @Override
    public void x(MemorySegment structPtr, int x) {
        WGPUOrigin3D.x(structPtr, x);
    }

    @Override
    public void y(MemorySegment structPtr, int y) {
        WGPUOrigin3D.y(structPtr, y);
    }

    @Override
    public void z(MemorySegment structPtr, int z) {
        WGPUOrigin3D.z(structPtr, z);
    }

}
