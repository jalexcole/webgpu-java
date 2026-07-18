package org.webgpu.impl.spi;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;

import org.webgpu.api.PredefinedColorSpace;
import org.webgpu.api.ToneMappingMode;
import org.webgpu.api.spi.SurfaceColorManagementProvider;
import org.webgpu.panama.WGPUSurfaceColorManagement;

/**
 * SurfaceColorManagementProviderImpl
 */
public class SurfaceColorManagementProviderImpl implements SurfaceColorManagementProvider {
    private final Arena arena = Arena.ofAuto();

    @Override
    public MemorySegment initializer() {
        return WGPUSurfaceColorManagement.allocate(arena);
    }

    @Override
    public PredefinedColorSpace colorSpace(MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'colorSpace'");
    }

    @Override
    public ToneMappingMode toneMappingMode(MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'toneMappingMode'");
    }

    @Override
    public void colorSpace(MemorySegment structPtr, PredefinedColorSpace colorSpace) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'colorSpace'");
    }

    @Override
    public void toneMappingMode(MemorySegment structPtr, ToneMappingMode toneMappingMode) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'toneMappingMode'");
    }

}
