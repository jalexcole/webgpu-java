package org.webgpu.impl.spi;

import java.lang.foreign.MemorySegment;

import org.jspecify.annotations.NonNull;
import org.webgpu.api.WGSLLanguageFeatureName;
import org.webgpu.api.spi.SupportedWGSLLanguageFeaturesProvider;

/**
 * SupportedWGSLLanguageFeaturesProviderImpl
 */
public class SupportedWGSLLanguageFeaturesProviderImpl implements SupportedWGSLLanguageFeaturesProvider {

    @Override
    public @NonNull MemorySegment initializer() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'initializer'");
    }

    @Override
    public WGSLLanguageFeatureName @NonNull [] features(@NonNull MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'features'");
    }

    @Override
    public void features(@NonNull MemorySegment structPtr, WGSLLanguageFeatureName @NonNull [] features) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'features'");
    }

}
