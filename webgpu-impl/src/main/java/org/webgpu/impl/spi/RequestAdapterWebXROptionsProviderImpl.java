package org.webgpu.impl.spi;

import java.lang.foreign.MemorySegment;

import org.jspecify.annotations.NonNull;
import org.webgpu.api.spi.RequestAdapterWebXROptionsProvider;

/**
 * RequestAdapterWebXROptionsProviderImpl
 */
public class RequestAdapterWebXROptionsProviderImpl implements RequestAdapterWebXROptionsProvider {

    @Override
    public @NonNull MemorySegment initializer() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'initializer'");
    }

    @Override
    public boolean xrCompatible(@NonNull MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'xrCompatible'");
    }

    @Override
    public void xrCompatible(@NonNull MemorySegment structPtr, boolean xrCompatible) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'xrCompatible'");
    }

}
