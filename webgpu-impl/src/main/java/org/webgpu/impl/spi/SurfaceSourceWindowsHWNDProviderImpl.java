package org.webgpu.impl.spi;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;

import org.jspecify.annotations.NonNull;
import org.webgpu.api.spi.SurfaceSourceWindowsHWNDProvider;
import org.webgpu.panama.WGPUSurfaceSourceWindowsHWND;

/**
 * SurfaceSourceWindowsHWNDProviderImpl
 */
public class SurfaceSourceWindowsHWNDProviderImpl implements SurfaceSourceWindowsHWNDProvider {
    private final Arena arena = Arena.ofAuto();

    @Override
    public MemorySegment initializer() {
        return WGPUSurfaceSourceWindowsHWND.allocate(arena);
    }

    @Override
    public MemorySegment hinstance(MemorySegment structPtr) {
        return WGPUSurfaceSourceWindowsHWND.hinstance(structPtr);
    }

    @Override
    public MemorySegment hwnd(MemorySegment structPtr) {
        return WGPUSurfaceSourceWindowsHWND.hwnd(structPtr);
    }

    @Override
    public void hinstance(MemorySegment structPtr, MemorySegment hinstance) {
        WGPUSurfaceSourceWindowsHWND.hinstance(structPtr, hinstance);
    }

    @Override
    public void hwnd(MemorySegment structPtr, MemorySegment hwnd) {
        WGPUSurfaceSourceWindowsHWND.hwnd(structPtr, hwnd);
    }

}
