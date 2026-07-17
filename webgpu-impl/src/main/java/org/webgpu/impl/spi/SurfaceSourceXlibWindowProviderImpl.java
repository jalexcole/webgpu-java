package org.webgpu.impl.spi;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;

import org.webgpu.api.spi.SurfaceSourceXlibWindowProvider;
import org.webgpu.panama.WGPUSurfaceSourceXlibWindow;

/**
 * SurfaceSourceXlibWindowProviderImpl
 */
public class SurfaceSourceXlibWindowProviderImpl implements SurfaceSourceXlibWindowProvider {
    private Arena arena = Arena.ofAuto();

    @Override
    public MemorySegment initializer() {
        return WGPUSurfaceSourceXlibWindow.allocate(arena);
    }

    @Override
    public MemorySegment display(MemorySegment structPtr) {
        return WGPUSurfaceSourceXlibWindow.display(structPtr);
    }

    @Override
    public long window(MemorySegment structPtr) {
        return WGPUSurfaceSourceXlibWindow.window(structPtr);
    }

    @Override
    public void display(MemorySegment structPtr, MemorySegment display) {
        WGPUSurfaceSourceXlibWindow.display(structPtr, display);
    }

    @Override
    public void window(MemorySegment structPtr, long window) {
        WGPUSurfaceSourceXlibWindow.window(structPtr, window);
    }

}
