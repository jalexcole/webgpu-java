package org.webgpu.impl.spi;

import java.lang.foreign.MemorySegment;

import org.jspecify.annotations.NonNull;
import org.webgpu.api.SamplerBindingType;
import org.webgpu.api.spi.SamplerBindingLayoutProvider;

/**
 * SamplerBindingLayoutProviderImpl
 */
public class SamplerBindingLayoutProviderImpl implements SamplerBindingLayoutProvider {

    @Override
    public @NonNull MemorySegment initializer() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'initializer'");
    }

    @Override
    public @NonNull SamplerBindingType type(@NonNull MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'type'");
    }

    @Override
    public void type(@NonNull MemorySegment structPtr, @NonNull SamplerBindingType type) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'type'");
    }

}
