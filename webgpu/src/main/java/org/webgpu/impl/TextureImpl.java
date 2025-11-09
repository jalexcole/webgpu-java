package org.webgpu.impl;

import java.lang.foreign.MemorySegment;

import org.webgpu.api.Texture;
import org.webgpu.api.TextureFormat;
import org.webgpu.api.TextureUsage;
import org.webgpu.api.TextureView;
import org.webgpu.api.TextureViewDescriptor;
import org.webgpu.panama.foreign.webgpu_h;

public record TextureImpl(MemorySegment ptr) implements Texture {
    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(TextureImpl.class);
    @Override
    public TextureView createView(TextureViewDescriptor descriptor) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createView'");
    }

    @Override
    public void destroy() {
        webgpu_h.wgpuTextureRelease(this.ptr);
    }

    @Override
    public int getDepthOrArrayLayers() {
        return webgpu_h.wgpuTextureGetDepthOrArrayLayers(ptr);
    }

    @Override
    public int getDimension() {
        return webgpu_h.wgpuTextureGetDimension(ptr);
    }

    @Override
    public TextureFormat getFormat() {
        int formatValue = webgpu_h.wgpuTextureGetFormat(ptr);
        return TextureFormat.fromValue(formatValue);
    }

    @Override
    public int getHeight() {
        return webgpu_h.wgpuTextureGetHeight(ptr);
    }

    @Override
    public int getMipLevelCount() {
        return webgpu_h.wgpuTextureGetMipLevelCount(ptr);
    }

    @Override
    public int getSampleCount() {
        return webgpu_h.wgpuTextureGetSampleCount(ptr);
    }

    @Override
    public TextureUsage getUsage() {
        final long usageValue = webgpu_h.wgpuTextureGetUsage(ptr);
        return TextureUsage.fromValue(usageValue);
    }

    @Override
    public int getWidth() {
        return webgpu_h.wgpuTextureGetWidth(ptr);
    }

    @Override
    public void setLabel(String label) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setLabel'");
    }

    @Override
    public void addRef() {
        webgpu_h.wgpuTextureAddRef(ptr);
    }

    @Override
    public void release() {
        webgpu_h.wgpuTextureRelease(ptr);
    }

}
