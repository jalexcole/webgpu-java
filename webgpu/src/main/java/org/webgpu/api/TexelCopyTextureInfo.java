package org.webgpu.api;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;

import org.webgpu.foreign.WGPUTexelCopyTextureInfo;
import org.webgpu.impl.TextureImpl;

public class TexelCopyTextureInfo {
    private final MemorySegment ptr;

    public TexelCopyTextureInfo(MemorySegment ptr) {
        this.ptr = ptr;
    }

    public TexelCopyTextureInfo() {
        try {
            final Arena arena = Arena.ofAuto();
            ptr = WGPUTexelCopyTextureInfo.allocate(arena);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public MemorySegment ptr() {
        return this.ptr;
    }
    
    public Texture texture() {
        return new TextureImpl(WGPUTexelCopyTextureInfo.texture(ptr));
    }

    public void setTexture(Texture texture) {
        if (texture == null) {
            WGPUTexelCopyTextureInfo.texture(ptr, MemorySegment.NULL);
        } else {
            WGPUTexelCopyTextureInfo.texture(ptr, texture.ptr());
        }
    }

    public int mipLevel() {
        return WGPUTexelCopyTextureInfo.mipLevel(ptr);
    }

    public Origin3D origin() {
        return new Origin3D(WGPUTexelCopyTextureInfo.origin(ptr));
    }

    public void setOrigin(Origin3D origin) {
        if (origin == null) {
            WGPUTexelCopyTextureInfo.origin(ptr, MemorySegment.NULL);
        } else {
            WGPUTexelCopyTextureInfo.origin(ptr, origin.ptr());
        }
    }

    public TextureAspect aspect() {
        return TextureAspect.fromValue(WGPUTexelCopyTextureInfo.aspect(ptr));
    }

    public void setAspect(TextureAspect aspect) {
        WGPUTexelCopyTextureInfo.aspect(ptr, aspect.value());
    }

}
