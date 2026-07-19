package org.webgpu.impl.spi;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;

import org.webgpu.api.spi.ShaderSourceWGSLProvider;
import org.webgpu.impl.util.StringViewMapper;
import org.webgpu.panama.WGPUChainedStruct;
import org.webgpu.panama.WGPUShaderSourceWGSL;
import org.webgpu.panama.webgpu_h;

public class ShaderSourceWGSLProviderImpl implements ShaderSourceWGSLProvider {
    private final Arena arena = Arena.ofAuto();

    @Override
    public MemorySegment initializer() {
        final MemorySegment structPtr = WGPUShaderSourceWGSL.allocate(arena);
        WGPUChainedStruct.sType(WGPUShaderSourceWGSL.chain(structPtr), webgpu_h.WGPUSType_ShaderSourceWGSL());
        WGPUShaderSourceWGSL.code(structPtr, StringViewMapper.map("", arena));
        return structPtr;
    }

    @Override
    public String code(MemorySegment structPtr) {
        return StringViewMapper.map(WGPUShaderSourceWGSL.code(structPtr));
    }

    @Override
    public void code(MemorySegment structPtr, String code) {
        final MemorySegment codeSegment = StringViewMapper.map(code, arena);
        WGPUShaderSourceWGSL.code(structPtr, codeSegment);
    }

}
