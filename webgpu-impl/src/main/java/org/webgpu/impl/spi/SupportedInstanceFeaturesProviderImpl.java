package org.webgpu.impl.spi;

import java.lang.foreign.MemorySegment;

import org.jspecify.annotations.NonNull;
import org.webgpu.api.InstanceFeatureName;
import org.webgpu.api.spi.SupportedInstanceFeaturesProvider;

/**
 * SupportedInstanceFeaturesProviderImpl
 */
public class SupportedInstanceFeaturesProviderImpl implements SupportedInstanceFeaturesProvider {

    @Override
    public @NonNull MemorySegment initializer() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'initializer'");
    }

    @Override
    public InstanceFeatureName @NonNull [] features(@NonNull MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'features'");
    }

    @Override
    public void features(@NonNull MemorySegment structPtr, InstanceFeatureName @NonNull [] features) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'features'");
    }

}
