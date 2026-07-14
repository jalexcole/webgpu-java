package org.webgpu.impl.spi;

import java.lang.foreign.MemorySegment;

import org.jspecify.annotations.NonNull;
import org.webgpu.api.ExternalTexture;
import org.webgpu.api.spi.ExternalTextureBindingEntryProvider;

/**
 * ExternalTextureBindingEntryProviderImpl
 */
public class ExternalTextureBindingEntryProviderImpl implements ExternalTextureBindingEntryProvider{

    @Override
    public @NonNull MemorySegment initializer() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'initializer'");
    }

    @Override
    public @NonNull ExternalTexture externalTexture(@NonNull MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'externalTexture'");
    }

    @Override
    public void externalTexture(@NonNull MemorySegment structPtr, @NonNull ExternalTexture externalTexture) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'externalTexture'");
    }

}
