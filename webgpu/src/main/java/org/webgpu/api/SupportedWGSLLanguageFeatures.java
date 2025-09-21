package org.webgpu.api;

import java.lang.foreign.MemorySegment;

import org.webgpu.foreign.WGPUSupportedWGSLLanguageFeatures;

public class SupportedWGSLLanguageFeatures {
    private MemorySegment ptr;

    SupportedWGSLLanguageFeatures(MemorySegment ptr) {
        this.ptr = ptr;
    }
    
    MemorySegment ptr() {
        return ptr;
    }

    public long featureCount() {
        return WGPUSupportedWGSLLanguageFeatures.featureCount(ptr);
    }

    public WGSLLanguageFeatureName[] features() {
        // return WGPUSupportedWGSLLanguageFeatures.features(ptr);
        throw new UnsupportedOperationException("Unimplemented method 'features'");
    }
}
