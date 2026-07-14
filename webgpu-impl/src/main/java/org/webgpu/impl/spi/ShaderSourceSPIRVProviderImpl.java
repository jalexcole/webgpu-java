package org.webgpu.impl.spi;

import java.lang.foreign.MemorySegment;

import org.jspecify.annotations.NonNull;
import org.webgpu.api.spi.ShaderSourceSPIRVProvider;

/**
 * ShaderSourceSPIRVProviderImpl
 */
public class ShaderSourceSPIRVProviderImpl implements ShaderSourceSPIRVProvider {

    @Override
    public @NonNull MemorySegment initializer() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'initializer'");
    }

    @Override
    public int codeSize(@NonNull MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'codeSize'");
    }

    @Override
    public int code(@NonNull MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'code'");
    }

    @Override
    public void codeSize(@NonNull MemorySegment structPtr, int codeSize) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'codeSize'");
    }

    @Override
    public void code(@NonNull MemorySegment structPtr, int code) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'code'");
    }
    
}
