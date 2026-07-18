package org.webgpu.impl.spi;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;

import org.webgpu.api.ConstantEntry;
import org.webgpu.api.ShaderModule;
import org.webgpu.api.spi.ComputeStateProvider;
import org.webgpu.impl.ShaderModuleImpl;
import org.webgpu.impl.util.StringViewMapper;
import org.webgpu.panama.WGPUComputeState;

/**
 * ComputeStateProviderImpl
 */
public class ComputeStateProviderImpl implements ComputeStateProvider {

    @Override
    public MemorySegment initializer() {
        return WGPUComputeState.allocate(Arena.ofAuto());
    }

    @Override
    public ShaderModuleImpl module(MemorySegment structPtr) {
        final var shaderModulePtr = WGPUComputeState.module(structPtr);
        return new ShaderModuleImpl(shaderModulePtr);
    }

    @Override
    public String entryPoint(MemorySegment structPtr) {
        final var entryPointPtr = WGPUComputeState.entryPoint(structPtr);
        return StringViewMapper.map(entryPointPtr);
    }

    @Override
    public ConstantEntry[] constants(MemorySegment structPtr) {
        throw new UnsupportedOperationException("Unimplemented method 'constants'");
    }

    @Override
    public void module(MemorySegment structPtr, ShaderModule module) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'module'");
    }

    @Override
    public void entryPoint(MemorySegment structPtr, String entryPoint) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'entryPoint'");
    }

    @Override
    public void constants(MemorySegment structPtr, ConstantEntry[] constants) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'constants'");
    }

    

}
