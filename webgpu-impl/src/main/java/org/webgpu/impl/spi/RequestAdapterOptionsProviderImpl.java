package org.webgpu.impl.spi;

import java.lang.foreign.MemorySegment;

import org.jspecify.annotations.NonNull;
import org.webgpu.api.BackendType;
import org.webgpu.api.FeatureLevel;
import org.webgpu.api.PowerPreference;
import org.webgpu.api.Surface;
import org.webgpu.api.spi.RequestAdapterOptionsProvider;

/**
 * RequestAdapterOptionsProviderImpl
 */
public class RequestAdapterOptionsProviderImpl implements RequestAdapterOptionsProvider {

    @Override
    public @NonNull MemorySegment initializer() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'initializer'");
    }

    @Override
    public @NonNull FeatureLevel featureLevel(@NonNull MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'featureLevel'");
    }

    @Override
    public @NonNull PowerPreference powerPreference(@NonNull MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'powerPreference'");
    }

    @Override
    public boolean forceFallbackAdapter(@NonNull MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'forceFallbackAdapter'");
    }

    @Override
    public @NonNull BackendType backendType(@NonNull MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'backendType'");
    }

    @Override
    public @NonNull Surface compatibleSurface(@NonNull MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'compatibleSurface'");
    }

    @Override
    public void featureLevel(@NonNull MemorySegment structPtr, @NonNull FeatureLevel featureLevel) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'featureLevel'");
    }

    @Override
    public void powerPreference(@NonNull MemorySegment structPtr, @NonNull PowerPreference powerPreference) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'powerPreference'");
    }

    @Override
    public void forceFallbackAdapter(@NonNull MemorySegment structPtr, boolean forceFallbackAdapter) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'forceFallbackAdapter'");
    }

    @Override
    public void backendType(@NonNull MemorySegment structPtr, @NonNull BackendType backendType) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'backendType'");
    }

    @Override
    public void compatibleSurface(@NonNull MemorySegment structPtr, @NonNull Surface compatibleSurface) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'compatibleSurface'");
    }

}
