package org.webgpu.impl.spi;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.ValueLayout;
import java.util.Arrays;

import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.NullMarked;
import org.webgpu.api.WGSLLanguageFeatureName;
import org.webgpu.api.spi.SupportedWGSLLanguageFeaturesProvider;
import org.webgpu.panama.WGPUSupportedWGSLLanguageFeatures;

/**
 * SupportedWGSLLanguageFeaturesProviderImpl
 */
@NullMarked
public class SupportedWGSLLanguageFeaturesProviderImpl implements SupportedWGSLLanguageFeaturesProvider {
    private final Arena arena = Arena.ofAuto();

    @Override
    public MemorySegment initializer() {
        return WGPUSupportedWGSLLanguageFeatures.allocate(arena);
    }

    @Override
    public WGSLLanguageFeatureName[] features(MemorySegment structPtr) {
        final var featuresPtr = WGPUSupportedWGSLLanguageFeatures.features(structPtr);
        final int featureCount = (int) WGPUSupportedWGSLLanguageFeatures.featureCount(structPtr);

        WGSLLanguageFeatureName[] features = new WGSLLanguageFeatureName[featureCount];
        for (int i = 0; i < featureCount; i++) {
            int featureValue = featuresPtr.get(ValueLayout.JAVA_INT, i);
            features[i] = WGSLLanguageFeatureName.values()[featureValue];
        }

        return features;
    }

    @Override
    public void features(MemorySegment structPtr, WGSLLanguageFeatureName[] features) {
        final var featuresPtr = arena.allocateFrom(ValueLayout.JAVA_INT,
                Arrays.stream(features).mapToInt(WGSLLanguageFeatureName::value).toArray());
        WGPUSupportedWGSLLanguageFeatures.features(structPtr, featuresPtr);
        WGPUSupportedWGSLLanguageFeatures.featureCount(structPtr, features.length);
    }

}
