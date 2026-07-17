package org.webgpu.impl.spi;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;

import org.jspecify.annotations.NonNull;
import org.webgpu.api.ExternalTexture;
import org.webgpu.api.spi.ExternalTextureBindingEntryProvider;
import org.webgpu.panama.WGPUExternalTextureBindingEntry;

/**
 * ExternalTextureBindingEntryProviderImpl
 */
public class ExternalTextureBindingEntryProviderImpl implements ExternalTextureBindingEntryProvider {
    private final Arena arena = Arena.ofAuto();

    @Override
    public MemorySegment initializer() {
        return WGPUExternalTextureBindingEntry.allocate(arena);
    }

    @Override
    public ExternalTexture externalTexture(MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'externalTexture'");
    }

    @Override
    public void externalTexture(MemorySegment structPtr, ExternalTexture externalTexture) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'externalTexture'");
    }

}
