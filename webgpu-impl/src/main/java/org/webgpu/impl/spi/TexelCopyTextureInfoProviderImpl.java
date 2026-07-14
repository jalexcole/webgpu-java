package org.webgpu.impl.spi;

import java.lang.foreign.MemorySegment;

import org.jspecify.annotations.NonNull;
import org.webgpu.api.Origin3D;
import org.webgpu.api.Texture;
import org.webgpu.api.TextureAspect;
import org.webgpu.api.spi.TexelCopyTextureInfoProvider;

/**
 * TexelCopyTextureInfoProviderImpl
 */
public class TexelCopyTextureInfoProviderImpl implements TexelCopyTextureInfoProvider {

    @Override
    public @NonNull MemorySegment initializer() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'initializer'");
    }

    @Override
    public @NonNull Texture texture(@NonNull MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'texture'");
    }

    @Override
    public int mipLevel(@NonNull MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mipLevel'");
    }

    @Override
    public @NonNull Origin3D origin(@NonNull MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'origin'");
    }

    @Override
    public @NonNull TextureAspect aspect(@NonNull MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'aspect'");
    }

    @Override
    public void texture(@NonNull MemorySegment structPtr, @NonNull Texture texture) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'texture'");
    }

    @Override
    public void mipLevel(@NonNull MemorySegment structPtr, int mipLevel) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mipLevel'");
    }

    @Override
    public void origin(@NonNull MemorySegment structPtr, @NonNull Origin3D origin) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'origin'");
    }

    @Override
    public void aspect(@NonNull MemorySegment structPtr, @NonNull TextureAspect aspect) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'aspect'");
    }

}
