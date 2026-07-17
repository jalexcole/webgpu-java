package org.webgpu.impl.spi;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;

import org.jspecify.annotations.NonNull;
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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'x'");
    }

    @Override
    public int y(MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'y'");
    }

    @Override
    public int z(MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'z'");
    }

    @Override
    public void x(MemorySegment structPtr, int x) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'x'");
    }

    @Override
    public void y(MemorySegment structPtr, int y) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'y'");
    }

    @Override
    public void z(MemorySegment structPtr, int z) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'z'");
    }

}
