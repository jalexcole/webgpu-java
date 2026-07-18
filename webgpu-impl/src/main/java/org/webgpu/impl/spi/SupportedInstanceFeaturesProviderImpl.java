package org.webgpu.impl.spi;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;

import org.jspecify.annotations.NullMarked;
import org.webgpu.api.InstanceFeatureName;
import org.webgpu.api.spi.SupportedInstanceFeaturesProvider;
import org.webgpu.panama.WGPUSupportedInstanceFeatures;

/**
 * SupportedInstanceFeaturesProviderImpl
 */
@NullMarked
public class SupportedInstanceFeaturesProviderImpl implements SupportedInstanceFeaturesProvider {
    private final Arena arena = Arena.ofAuto();

    @Override
    public MemorySegment initializer() {
        return WGPUSupportedInstanceFeatures.allocate(arena);
    }

    @Override
    public InstanceFeatureName[] features(MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'features'");
    }

    @Override
    public void features(MemorySegment structPtr, InstanceFeatureName[] features) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'features'");
    }

}
