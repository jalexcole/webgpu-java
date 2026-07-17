package org.webgpu.impl.spi;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;

import org.jspecify.annotations.NonNull;
import org.webgpu.api.spi.ShaderSourceSPIRVProvider;
import org.webgpu.panama.WGPUShaderSourceSPIRV;

/**
 * ShaderSourceSPIRVProviderImpl
 */
public class ShaderSourceSPIRVProviderImpl implements ShaderSourceSPIRVProvider {
    private final Arena arena = Arena.ofAuto();

    @Override
    public MemorySegment initializer() {
        return WGPUShaderSourceSPIRV.allocate(arena);
    }

    @Override
    public int codeSize(MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'codeSize'");
    }

    @Override
    public int code(MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'code'");
    }

    @Override
    public void codeSize(MemorySegment structPtr, int codeSize) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'codeSize'");
    }

    @Override
    public void code(MemorySegment structPtr, int code) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'code'");
    }

}
