package org.webgpu.impl.spi;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;

import org.jspecify.annotations.NonNull;
import org.webgpu.api.SurfaceGetCurrentTextureStatus;
import org.webgpu.api.Texture;
import org.webgpu.api.spi.SurfaceTextureProvider;
import org.webgpu.impl.TextureImpl;
import org.webgpu.panama.WGPUSurfaceTexture;

/**
 * SurfaceTextureProviderImpl
 */
public class SurfaceTextureProviderImpl implements SurfaceTextureProvider {
    private final Arena arena = Arena.ofAuto();

    @Override
    public MemorySegment initializer() {
        return WGPUSurfaceTexture.allocate(arena);
    }

    @Override
    public Texture texture(MemorySegment structPtr) {
        final var texturePtr = WGPUSurfaceTexture.texture(structPtr);
        return new TextureImpl(texturePtr);
    }

    @Override
    public SurfaceGetCurrentTextureStatus status(MemorySegment structPtr) {
        return SurfaceGetCurrentTextureStatus.values()[WGPUSurfaceTexture.status(structPtr)];
    }

    @Override
    public void texture(MemorySegment structPtr, Texture texture) {
        WGPUSurfaceTexture.texture(structPtr, ((TextureImpl) texture).ptr());
    }

    @Override
    public void status(MemorySegment structPtr, SurfaceGetCurrentTextureStatus status) {
        WGPUSurfaceTexture.status(structPtr, status.value());
    }

}
