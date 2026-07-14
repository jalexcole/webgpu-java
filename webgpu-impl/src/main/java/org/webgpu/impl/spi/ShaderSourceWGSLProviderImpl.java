package org.webgpu.impl.spi;

import java.lang.foreign.MemorySegment;

import org.jspecify.annotations.NonNull;
import org.webgpu.api.spi.ShaderSourceWGSLProvider;

/**
 * ShaderSourceWGSLProviderImpl
 */
public class ShaderSourceWGSLProviderImpl implements ShaderSourceWGSLProvider {

    @Override
    public @NonNull MemorySegment initializer() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'initializer'");
    }

    @Override
    public @NonNull String code(@NonNull MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'code'");
    }

    @Override
    public void code(@NonNull MemorySegment structPtr, @NonNull String code) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'code'");
    }

}
