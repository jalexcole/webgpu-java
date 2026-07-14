package org.webgpu.impl.spi;

import java.lang.foreign.MemorySegment;

import org.jspecify.annotations.NonNull;
import org.webgpu.api.Buffer;
import org.webgpu.api.TexelCopyBufferLayout;
import org.webgpu.api.spi.TexelCopyBufferInfoProvider;

/**
 * TexelCopyBufferInfoProviderImpl
 */
public class TexelCopyBufferInfoProviderImpl implements TexelCopyBufferInfoProvider {

    @Override
    public @NonNull MemorySegment initializer() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'initializer'");
    }

    @Override
    public @NonNull TexelCopyBufferLayout layout(@NonNull MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'layout'");
    }

    @Override
    public @NonNull Buffer buffer(@NonNull MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buffer'");
    }

    @Override
    public void layout(@NonNull MemorySegment structPtr, @NonNull TexelCopyBufferLayout layout) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'layout'");
    }

    @Override
    public void buffer(@NonNull MemorySegment structPtr, @NonNull Buffer buffer) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buffer'");
    }

}
