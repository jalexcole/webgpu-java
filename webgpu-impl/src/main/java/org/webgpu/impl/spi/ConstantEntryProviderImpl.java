package org.webgpu.impl.spi;

import java.lang.foreign.MemorySegment;

import org.jspecify.annotations.NonNull;
import org.webgpu.api.spi.ConstantEntryProvider;

/**
 * ConstantEntryProviderImpl
 */
public class ConstantEntryProviderImpl implements ConstantEntryProvider {

    @Override
    public @NonNull MemorySegment initializer() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'initializer'");
    }

    @Override
    public @NonNull String key(@NonNull MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'key'");
    }

    @Override
    public double value(@NonNull MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'value'");
    }

    @Override
    public void key(@NonNull MemorySegment structPtr, @NonNull String key) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'key'");
    }

    @Override
    public void value(@NonNull MemorySegment structPtr, double value) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'value'");
    }

}
