package org.webgpu.impl.spi;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;

import org.webgpu.api.spi.SurfaceSourceXCBWindowProvider;
import org.webgpu.panama.WGPUSurfaceSourceXCBWindow;

/**
 * SurfaceSourceXCBWindowProviderImpl
 */
public class SurfaceSourceXCBWindowProviderImpl implements SurfaceSourceXCBWindowProvider {
    private final Arena arena = Arena.ofAuto();

    @Override
    public MemorySegment initializer() {
        return WGPUSurfaceSourceXCBWindow.allocate(arena);
    }

    @Override
    public MemorySegment connection(MemorySegment structPtr) {
        return WGPUSurfaceSourceXCBWindow.connection(structPtr);
    }

    @Override
    public int window(MemorySegment structPtr) {
        return WGPUSurfaceSourceXCBWindow.window(structPtr);
    }

    @Override
    public void connection(MemorySegment structPtr, MemorySegment connection) {
        WGPUSurfaceSourceXCBWindow.connection(structPtr, connection);
    }

    @Override
    public void window(MemorySegment structPtr, int window) {
        WGPUSurfaceSourceXCBWindow.window(structPtr, window);
    }

}
