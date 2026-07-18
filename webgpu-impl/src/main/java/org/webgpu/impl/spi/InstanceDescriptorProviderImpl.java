package org.webgpu.impl.spi;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.ValueLayout;
import java.util.Arrays;

import org.webgpu.api.InstanceFeatureName;
import org.webgpu.api.InstanceLimits;
import org.webgpu.api.spi.InstanceDescriptorProvider;
import org.webgpu.impl.util.EnumUtil;
import org.webgpu.impl.util.StructTools;
import org.webgpu.panama.WGPUInstanceDescriptor;

/**
 * InstanceDescriptorProviderImpl
 */
public class InstanceDescriptorProviderImpl implements InstanceDescriptorProvider {
    final Arena arena = Arena.ofAuto();

    @Override
    public MemorySegment initializer() {
        return WGPUInstanceDescriptor.allocate(arena);
    }

    @Override
    public InstanceFeatureName[] requiredFeatures(MemorySegment structPtr) {
        final var requiredFeaturesPtr = WGPUInstanceDescriptor.requiredFeatures(structPtr);
        final long count = WGPUInstanceDescriptor.requiredFeatureCount(structPtr);

       return EnumUtil.unpackEnum(requiredFeaturesPtr, count, InstanceFeatureName.class);
    }

    @Override
    public InstanceLimits requiredLimits(MemorySegment structPtr) {
        final var limitsPtr = WGPUInstanceDescriptor.requiredLimits(structPtr);
        return StructTools.placeSegment(limitsPtr, InstanceLimits.class);
    }

    @Override
    public void requiredFeatures(MemorySegment structPtr, InstanceFeatureName[] requiredFeatures) {
        final int[] features = Arrays.stream(requiredFeatures).mapToInt(InstanceFeatureName::value).toArray();
        final var requiredFeaturesPtr = arena.allocateFrom(ValueLayout.JAVA_INT, features);
        WGPUInstanceDescriptor.requiredFeatures(structPtr, requiredFeaturesPtr);
    }

    @Override
    public void requiredLimits(MemorySegment structPtr, InstanceLimits requiredLimits) {
        final var requiredLimitsPtr = StructTools.fetchSegment(requiredLimits);
        WGPUInstanceDescriptor.requiredLimits(structPtr, requiredLimitsPtr);
    }

}
