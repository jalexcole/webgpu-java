package org.webgpu.impl.spi;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;

import org.jspecify.annotations.NonNull;
import org.webgpu.api.spi.ShaderSourceWGSLProvider;
import org.webgpu.panama.WGPUShaderSourceWGSL;

/**
 * ShaderSourceWGSLProviderImpl
 */
public class ShaderSourceWGSLProviderImpl implements ShaderSourceWGSLProvider {
    private final Arena arena = Arena.ofAuto();

    @Override
    public MemorySegment initializer() {
        return WGPUShaderSourceWGSL.allocate(arena);
    }

    @Override
    public String code(MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'code'");
    }

    @Override
    public void code(MemorySegment structPtr, String code) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'code'");
    }

}
