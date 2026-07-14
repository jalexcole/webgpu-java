package org.webgpu.impl.spi;

import java.lang.foreign.MemorySegment;

import org.jspecify.annotations.NonNull;
import org.webgpu.api.ColorTargetState;
import org.webgpu.api.ConstantEntry;
import org.webgpu.api.ShaderModule;
import org.webgpu.api.spi.FragmentStateProvider;

/**
 * FragmentStateProviderImpl
 */
public class FragmentStateProviderImpl implements FragmentStateProvider {

    @Override
    public @NonNull MemorySegment initializer() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'initializer'");
    }

    @Override
    public @NonNull ShaderModule module(@NonNull MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'module'");
    }

    @Override
    public @NonNull String entryPoint(@NonNull MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'entryPoint'");
    }

    @Override
    public ConstantEntry @NonNull [] constants(@NonNull MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'constants'");
    }

    @Override
    public ColorTargetState @NonNull [] targets(@NonNull MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'targets'");
    }

    @Override
    public void module(@NonNull MemorySegment structPtr, @NonNull ShaderModule module) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'module'");
    }

    @Override
    public void entryPoint(@NonNull MemorySegment structPtr, @NonNull String entryPoint) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'entryPoint'");
    }

    @Override
    public void constants(@NonNull MemorySegment structPtr, ConstantEntry @NonNull [] constants) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'constants'");
    }

    @Override
    public void targets(@NonNull MemorySegment structPtr, ColorTargetState @NonNull [] targets) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'targets'");
    }

}
