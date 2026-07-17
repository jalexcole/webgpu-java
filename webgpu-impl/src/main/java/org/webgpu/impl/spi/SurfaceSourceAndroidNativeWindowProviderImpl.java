package org.webgpu.impl.spi;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;

import org.jspecify.annotations.NonNull;
import org.webgpu.api.spi.SurfaceSourceAndroidNativeWindowProvider;
import org.webgpu.panama.WGPUSurfaceSourceAndroidNativeWindow;

/**
 * SurfaceSourceAndroidNativeWindowProviderImpl
 */
public class SurfaceSourceAndroidNativeWindowProviderImpl implements SurfaceSourceAndroidNativeWindowProvider {
    private final Arena arena = Arena.ofAuto();

    @Override
    public MemorySegment initializer() {
        return WGPUSurfaceSourceAndroidNativeWindow.allocate(arena);
    }

    @Override
    public MemorySegment window(MemorySegment structPtr) {
        return WGPUSurfaceSourceAndroidNativeWindow.window(structPtr);
    }

    @Override
    public void window(MemorySegment structPtr, MemorySegment window) {
        WGPUSurfaceSourceAndroidNativeWindow.window(structPtr, window);
    }

}
