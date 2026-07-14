package org.webgpu.impl.spi;

import java.lang.foreign.MemorySegment;

import org.webgpu.api.BlendComponent;
import org.webgpu.api.spi.BlendStateProvider;

/**
 * BlendStateProviderImpl
 */
public class BlendStateProviderImpl implements BlendStateProvider {

    @Override
    public MemorySegment initializer() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'initializer'");
    }

    @Override
    public BlendComponent color(MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'color'");
    }

    @Override
    public BlendComponent alpha(MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'alpha'");
    }

    @Override
    public void color(MemorySegment structPtr, BlendComponent color) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'color'");
    }

    @Override
    public void alpha(MemorySegment structPtr, BlendComponent alpha) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'alpha'");
    }

}
