package org.webgpu.impl.spi;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;

import org.webgpu.api.spi.ShaderSourceWGSLProvider;
import org.webgpu.impl.util.StringViewMapper;
import org.webgpu.panama.WGPUShaderSourceWGSL;

public class ShaderSourceWGSLProviderImpl implements ShaderSourceWGSLProvider {
    private final Arena arena = Arena.ofAuto();

    @Override
    public MemorySegment initializer() {
        return WGPUShaderSourceWGSL.allocate(arena);
    }

    @Override
    public String code(MemorySegment structPtr) {
        return StringViewMapper.map(WGPUShaderSourceWGSL.code(structPtr));
    }

    @Override
    public void code(MemorySegment structPtr, String code) {
        try (Arena arena = Arena.ofConfined()) {
            WGPUShaderSourceWGSL.code(structPtr, StringViewMapper.map(code, arena));
        }
    }

}
