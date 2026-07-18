package org.webgpu.impl.spi;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;

import org.webgpu.api.Origin3D;
import org.webgpu.api.Texture;
import org.webgpu.api.TextureAspect;
import org.webgpu.api.spi.TexelCopyTextureInfoProvider;
import org.webgpu.panama.WGPUTexelCopyTextureInfo;

/**
 * TexelCopyTextureInfoProviderImpl
 */
public class TexelCopyTextureInfoProviderImpl implements TexelCopyTextureInfoProvider {
    private final Arena arena = Arena.ofAuto();

    @Override
    public MemorySegment initializer() {
        return WGPUTexelCopyTextureInfo.allocate(arena);
    }

    @Override
    public Texture texture(MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'texture'");
    }

    @Override
    public int mipLevel(MemorySegment structPtr) {
        return WGPUTexelCopyTextureInfo.mipLevel(structPtr);
    }

    @Override
    public Origin3D origin(MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'origin'");
    }

    @Override
    public TextureAspect aspect(MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'aspect'");
    }

    @Override
    public void texture(MemorySegment structPtr, Texture texture) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'texture'");
    }

    @Override
    public void mipLevel(MemorySegment structPtr, int mipLevel) {
        WGPUTexelCopyTextureInfo.mipLevel(structPtr, mipLevel);
    }

    @Override
    public void origin(MemorySegment structPtr, Origin3D origin) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'origin'");
    }

    @Override
    public void aspect(MemorySegment structPtr, TextureAspect aspect) {
        WGPUTexelCopyTextureInfo.aspect(structPtr, aspect.value());
    }

}
