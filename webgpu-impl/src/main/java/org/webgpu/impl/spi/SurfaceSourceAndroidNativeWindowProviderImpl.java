package org.webgpu.impl.spi;

import java.lang.foreign.MemorySegment;

import org.jspecify.annotations.NonNull;
import org.webgpu.api.spi.SurfaceSourceAndroidNativeWindowProvider;

/**
 * SurfaceSourceAndroidNativeWindowProviderImpl
 */
public class SurfaceSourceAndroidNativeWindowProviderImpl implements SurfaceSourceAndroidNativeWindowProvider {

    @Override
    public @NonNull MemorySegment initializer() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'initializer'");
    }

    @Override
    public @NonNull MemorySegment window(@NonNull MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'window'");
    }

    @Override
    public void window(@NonNull MemorySegment structPtr, @NonNull MemorySegment window) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'window'");
    }

}
