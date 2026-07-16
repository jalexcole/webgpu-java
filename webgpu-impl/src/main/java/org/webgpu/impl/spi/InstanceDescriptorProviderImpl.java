package org.webgpu.impl.spi;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.ValueLayout;
import java.util.Arrays;

import org.jspecify.annotations.NonNull;
import org.webgpu.api.InstanceFeatureName;
import org.webgpu.api.InstanceLimits;
import org.webgpu.api.spi.InstanceDescriptorProvider;
import org.webgpu.impl.util.StructTools;
import org.webgpu.panama.WGPUInstanceDescriptor;

/**
 * InstanceDescriptorProviderImpl
 */
public class InstanceDescriptorProviderImpl implements InstanceDescriptorProvider {
    final Arena arena = Arena.ofAuto();
    @Override
    public @NonNull MemorySegment initializer() {
        System.out.println("Creating Instance Descriptor");
        return WGPUInstanceDescriptor.allocate(arena);
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
        final int[] features = Arrays.stream(requiredFeatures).mapToInt(InstanceFeatureName::value).toArray();
        final var requiredFeaturesPtr = arena.allocateFrom(ValueLayout.JAVA_INT, features);
        WGPUInstanceDescriptor.requiredFeatures(structPtr, requiredFeaturesPtr);
    }

    @Override
    public void requiredLimits(@NonNull MemorySegment structPtr, @NonNull InstanceLimits requiredLimits) {
        final var requiredLimitsPtr = StructTools.fetchSegment(requiredLimits);
        WGPUInstanceDescriptor.requiredLimits(structPtr, requiredLimitsPtr);
    }

}
