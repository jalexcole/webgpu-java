package org.webgpu.impl.spi;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;

import org.jspecify.annotations.NonNull;
import org.webgpu.api.ColorTargetState;
import org.webgpu.api.ConstantEntry;
import org.webgpu.api.ShaderModule;
import org.webgpu.api.spi.FragmentStateProvider;
import org.webgpu.panama.WGPUFragmentState;

/**
 * FragmentStateProviderImpl
 */
public class FragmentStateProviderImpl implements FragmentStateProvider {
    private final Arena arena = Arena.ofAuto();

    @Override
    public MemorySegment initializer() {
        return WGPUFragmentState.allocate(arena);
    }

    @Override
    public ShaderModule module(MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'module'");
    }

    @Override
    public String entryPoint(MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'entryPoint'");
    }

    @Override
    public ConstantEntry[] constants(MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'constants'");
    }

    @Override
    public ColorTargetState[] targets(MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'targets'");
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

    @Override
    public void targets(MemorySegment structPtr, ColorTargetState[] targets) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'targets'");
    }

}
