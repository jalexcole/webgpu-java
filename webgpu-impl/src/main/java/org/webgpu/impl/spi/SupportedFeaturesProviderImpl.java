package org.webgpu.impl.spi;

import java.lang.foreign.MemorySegment;

import org.jspecify.annotations.NonNull;
import org.webgpu.api.FeatureName;
import org.webgpu.api.spi.SupportedFeaturesProvider;

/**
 * SupportedFeaturesProviderImpl
 */
public class SupportedFeaturesProviderImpl implements SupportedFeaturesProvider {

    @Override
    public @NonNull MemorySegment initializer() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'initializer'");
    }

    @Override
    public FeatureName @NonNull [] features(@NonNull MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'features'");
    }

    @Override
    public void features(@NonNull MemorySegment structPtr, FeatureName @NonNull [] features) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'features'");
    }

}
