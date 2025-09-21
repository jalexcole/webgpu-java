package org.webgpu.api;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;
import java.util.Optional;

import org.webgpu.foreign.WGPURequestAdapterOptions;
import org.webgpu.impl.SurfaceImpl;


public class RequestAdapterOptions {
    private MemorySegment ptr;

    public RequestAdapterOptions() {
        try {
            Arena arena = Arena.ofShared();
            ptr = WGPURequestAdapterOptions.allocate(arena);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public MemorySegment ptr() {
        return this.ptr;
    }

    public Optional<ChainedStruct> nextInChain() {
        var chainedStructPtr = WGPURequestAdapterOptions.nextInChain(ptr);

        if (chainedStructPtr.equals(MemorySegment.NULL)) {
            return Optional.empty();
        }
        
        return Optional.of(new ChainedStruct(WGPURequestAdapterOptions.nextInChain(ptr)));
    }

    public FeatureLevel featureLevel() {
        return FeatureLevel.values()[WGPURequestAdapterOptions.featureLevel(ptr)];
    }

    public void featureLevel(FeatureLevel featureLevel) {
        WGPURequestAdapterOptions.featureLevel(ptr, featureLevel.value());
    }

    public PowerPreference powerPreference() {
        return PowerPreference.values()[WGPURequestAdapterOptions.powerPreference(ptr)];
    }

    public void powerPreference(PowerPreference powerPreference) {
        WGPURequestAdapterOptions.powerPreference(ptr, powerPreference.value());
    }

    public boolean forceFallbackAdapter() {
        return WGPURequestAdapterOptions.forceFallbackAdapter(ptr) != 0;
    }

    public void forceFallbackAdapter(boolean forceFallbackAdapter) {
        WGPURequestAdapterOptions.forceFallbackAdapter(ptr, forceFallbackAdapter ? 1 : 0);
    }

    public BackendType backendType() {
        return BackendType.values()[WGPURequestAdapterOptions.backendType(ptr)];
    }

    public void backendType(BackendType backendType) {
        WGPURequestAdapterOptions.backendType(ptr, backendType.value());
    }

    public Surface compatibleSurface() {
        return new SurfaceImpl(WGPURequestAdapterOptions.compatibleSurface(ptr));
    }

    public void compatibleSurface(Surface compatibleSurface) {
        WGPURequestAdapterOptions.compatibleSurface(ptr, ((SurfaceImpl) compatibleSurface).ptr());
    }



    @Override
    public String toString() {
        return "RequestAdapterOptions [nextInChain()=" + nextInChain() + ", featureLevel()=" + featureLevel()
                + ", powerPreference()=" + powerPreference() + ", forceFallbackAdapter()=" + forceFallbackAdapter()
                + ", backendType()=" + backendType() + ", compatibleSurface()=" + compatibleSurface() + "]";
    }

    
}
