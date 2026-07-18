package org.webgpu.impl.spi;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;

import org.webgpu.api.BackendType;
import org.webgpu.api.FeatureLevel;
import org.webgpu.api.PowerPreference;
import org.webgpu.api.Surface;
import org.webgpu.api.spi.RequestAdapterOptionsProvider;
import org.webgpu.panama.WGPURequestAdapterOptions;

/**
 * RequestAdapterOptionsProviderImpl
 */
public class RequestAdapterOptionsProviderImpl implements RequestAdapterOptionsProvider {
    private final Arena arena = Arena.ofAuto();

    @Override
    public MemorySegment initializer() {
        return WGPURequestAdapterOptions.allocate(arena);
    }

    @Override
    public FeatureLevel featureLevel(MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'featureLevel'");
    }

    @Override
    public PowerPreference powerPreference(MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'powerPreference'");
    }

    @Override
    public boolean forceFallbackAdapter(MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'forceFallbackAdapter'");
    }

    @Override
    public BackendType backendType(MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'backendType'");
    }

    @Override
    public Surface compatibleSurface(MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'compatibleSurface'");
    }

    @Override
    public void featureLevel(MemorySegment structPtr, FeatureLevel featureLevel) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'featureLevel'");
    }

    @Override
    public void powerPreference(MemorySegment structPtr, PowerPreference powerPreference) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'powerPreference'");
    }

    @Override
    public void forceFallbackAdapter(MemorySegment structPtr, boolean forceFallbackAdapter) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'forceFallbackAdapter'");
    }

    @Override
    public void backendType(MemorySegment structPtr, BackendType backendType) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'backendType'");
    }

    @Override
    public void compatibleSurface(MemorySegment structPtr, Surface compatibleSurface) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'compatibleSurface'");
    }

}
