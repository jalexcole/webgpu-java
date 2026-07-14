package org.webgpu.impl.spi;

import java.lang.foreign.MemorySegment;

import org.webgpu.api.CompilationMessage;
import org.webgpu.api.spi.CompilationInfoProvider;

/**
 * CompilationInfoProviderImpl
 */
public class CompilationInfoProviderImpl implements CompilationInfoProvider {

    @Override
    public MemorySegment initializer() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'initializer'");
    }

    @Override
    public CompilationMessage[] messages(MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'messages'");
    }

    @Override
    public void messages(MemorySegment structPtr, CompilationMessage[] messages) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'messages'");
    }

}
