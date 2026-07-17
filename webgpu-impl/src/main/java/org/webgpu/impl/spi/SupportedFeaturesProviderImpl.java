package org.webgpu.impl.spi;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;

import org.jspecify.annotations.NonNull;
import org.webgpu.api.FeatureName;
import org.webgpu.api.spi.SupportedFeaturesProvider;
import org.webgpu.panama.WGPUSupportedFeatures;

/**
 * SupportedFeaturesProviderImpl
 */
public class SupportedFeaturesProviderImpl implements SupportedFeaturesProvider {
    private final Arena arena = Arena.ofAuto();

    @Override
    public MemorySegment initializer() {
        return WGPUSupportedFeatures.allocate(arena);
    }

    @Override
    public FeatureName[] features(MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'features'");
    }

    @Override
    public void features(MemorySegment structPtr, FeatureName[] features) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'features'");
    }

}
