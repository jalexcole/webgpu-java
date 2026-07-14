package org.webgpu.impl.spi;

import java.lang.foreign.MemorySegment;

import org.jspecify.annotations.NonNull;
import org.webgpu.api.PredefinedColorSpace;
import org.webgpu.api.ToneMappingMode;
import org.webgpu.api.spi.SurfaceColorManagementProvider;

/**
 * SurfaceColorManagementProviderImpl
 */
public class SurfaceColorManagementProviderImpl implements SurfaceColorManagementProvider {

    @Override
    public @NonNull MemorySegment initializer() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'initializer'");
    }

    @Override
    public @NonNull PredefinedColorSpace colorSpace(@NonNull MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'colorSpace'");
    }

    @Override
    public @NonNull ToneMappingMode toneMappingMode(@NonNull MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'toneMappingMode'");
    }

    @Override
    public void colorSpace(@NonNull MemorySegment structPtr, @NonNull PredefinedColorSpace colorSpace) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'colorSpace'");
    }

    @Override
    public void toneMappingMode(@NonNull MemorySegment structPtr, @NonNull ToneMappingMode toneMappingMode) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'toneMappingMode'");
    }

}
