package org.webgpu.impl.spi;

import java.lang.foreign.MemorySegment;

import org.jspecify.annotations.NonNull;
import org.webgpu.api.spi.SurfaceSourceWindowsHWNDProvider;

/**
 * SurfaceSourceWindowsHWNDProviderImpl
 */
public class SurfaceSourceWindowsHWNDProviderImpl implements SurfaceSourceWindowsHWNDProvider {

    @Override
    public @NonNull MemorySegment initializer() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'initializer'");
    }

    @Override
    public @NonNull MemorySegment hinstance(@NonNull MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'hinstance'");
    }

    @Override
    public @NonNull MemorySegment hwnd(@NonNull MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'hwnd'");
    }

    @Override
    public void hinstance(@NonNull MemorySegment structPtr, @NonNull MemorySegment hinstance) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'hinstance'");
    }

    @Override
    public void hwnd(@NonNull MemorySegment structPtr, @NonNull MemorySegment hwnd) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'hwnd'");
    }

}
