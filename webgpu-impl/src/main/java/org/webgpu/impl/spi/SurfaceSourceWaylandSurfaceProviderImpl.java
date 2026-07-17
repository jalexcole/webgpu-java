package org.webgpu.impl.spi;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;

import org.jspecify.annotations.NonNull;
import org.webgpu.api.spi.SurfaceSourceWaylandSurfaceProvider;
import org.webgpu.panama.WGPUSurfaceSourceWaylandSurface;

/**
 * SurfaceSourceWaylandSurfaceProviderImpl
 */
public class SurfaceSourceWaylandSurfaceProviderImpl implements SurfaceSourceWaylandSurfaceProvider {
    private final Arena arena = Arena.ofAuto();

    @Override
    public MemorySegment initializer() {
        return WGPUSurfaceSourceWaylandSurface.allocate(arena);
    }

    @Override
    public MemorySegment display(MemorySegment structPtr) {
        return WGPUSurfaceSourceWaylandSurface.display(structPtr);
    }

    @Override
    public MemorySegment surface(MemorySegment structPtr) {
        return WGPUSurfaceSourceWaylandSurface.surface(structPtr);
    }

    @Override
    public void display(MemorySegment structPtr, MemorySegment display) {
        WGPUSurfaceSourceWaylandSurface.display(structPtr, display);
    }

    @Override
    public void surface(MemorySegment structPtr, MemorySegment surface) {
        WGPUSurfaceSourceWaylandSurface.surface(structPtr, surface);
    }

}
