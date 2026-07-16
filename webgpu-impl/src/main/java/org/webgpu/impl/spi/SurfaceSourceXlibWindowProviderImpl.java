package org.webgpu.impl.spi;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;

import org.jspecify.annotations.NonNull;
import org.webgpu.api.spi.SurfaceSourceXlibWindowProvider;
import org.webgpu.panama.WGPUSurfaceSourceXlibWindow;

/**
 * SurfaceSourceXlibWindowProviderImpl
 */
public class SurfaceSourceXlibWindowProviderImpl implements SurfaceSourceXlibWindowProvider {
    private Arena arena = Arena.ofAuto();
    @Override
    public @NonNull MemorySegment initializer() {
        return WGPUSurfaceSourceXlibWindow.allocate(arena);
    }

    @Override
    public @NonNull MemorySegment display(@NonNull MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'display'");
    }

    @Override
    public long window(@NonNull MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'window'");
    }

    @Override
    public void display(@NonNull MemorySegment structPtr, @NonNull MemorySegment display) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'display'");
    }

    @Override
    public void window(@NonNull MemorySegment structPtr, long window) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'window'");
    }

}
