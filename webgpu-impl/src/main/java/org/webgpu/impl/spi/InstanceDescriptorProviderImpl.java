package org.webgpu.impl.spi;

import java.lang.foreign.MemorySegment;

import org.jspecify.annotations.NonNull;
import org.webgpu.api.InstanceFeatureName;
import org.webgpu.api.InstanceLimits;
import org.webgpu.api.spi.InstanceDescriptorProvider;

/**
 * InstanceDescriptorProviderImpl
 */
public class InstanceDescriptorProviderImpl implements InstanceDescriptorProvider {

    @Override
    public @NonNull MemorySegment initializer() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'initializer'");
    }

    @Override
    public InstanceFeatureName @NonNull [] requiredFeatures(@NonNull MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'requiredFeatures'");
    }

    @Override
    public @NonNull InstanceLimits requiredLimits(@NonNull MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'requiredLimits'");
    }

    @Override
    public void requiredFeatures(@NonNull MemorySegment structPtr, InstanceFeatureName @NonNull [] requiredFeatures) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'requiredFeatures'");
    }

    @Override
    public void requiredLimits(@NonNull MemorySegment structPtr, @NonNull InstanceLimits requiredLimits) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'requiredLimits'");
    }

}
