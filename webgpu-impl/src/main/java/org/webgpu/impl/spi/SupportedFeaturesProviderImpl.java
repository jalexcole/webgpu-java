package org.webgpu.impl.spi;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.ValueLayout;
import java.util.Arrays;

import org.webgpu.api.FeatureName;
import org.webgpu.api.spi.SupportedFeaturesProvider;
import org.webgpu.impl.util.EnumUtil;
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
        final MemorySegment featuresArray = WGPUSupportedFeatures.features(structPtr);
        final long count = WGPUSupportedFeatures.featureCount(structPtr);
        System.out.println("featuresArray: " + featuresArray);
        // TODO EnumUtil.unpackEnum(featuresArray, count, FeatureName.class);

        return new FeatureName[0]; // Placeholder return value
    }

    @Override
    public void features(MemorySegment structPtr, FeatureName[] features) {
        final MemorySegment featuresPtr = EnumUtil.packEnum(features, arena);
        WGPUSupportedFeatures.features(structPtr, featuresPtr);
    }

}
