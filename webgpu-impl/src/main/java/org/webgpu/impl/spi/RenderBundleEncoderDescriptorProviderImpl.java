package org.webgpu.impl.spi;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;

import org.jspecify.annotations.NonNull;
import org.webgpu.api.TextureFormat;
import org.webgpu.api.spi.RenderBundleEncoderDescriptorProvider;
import org.webgpu.panama.WGPURenderBundleEncoderDescriptor;

/**
 * RenderBundleEncoderDescriptorProviderImpl
 */
public class RenderBundleEncoderDescriptorProviderImpl implements RenderBundleEncoderDescriptorProvider {
    private final Arena arena = Arena.ofAuto();

    @Override
    public MemorySegment initializer() {
        return WGPURenderBundleEncoderDescriptor.allocate(arena);
    }

    @Override
    public String label(MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'label'");
    }

    @Override
    public TextureFormat[] colorFormats(MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'colorFormats'");
    }

    @Override
    public TextureFormat depthStencilFormat(MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'depthStencilFormat'");
    }

    @Override
    public int sampleCount(MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'sampleCount'");
    }

    @Override
    public boolean depthReadOnly(MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'depthReadOnly'");
    }

    @Override
    public boolean stencilReadOnly(MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'stencilReadOnly'");
    }

    @Override
    public void label(MemorySegment structPtr, String label) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'label'");
    }

    @Override
    public void colorFormats(MemorySegment structPtr, TextureFormat[] colorFormats) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'colorFormats'");
    }

    @Override
    public void depthStencilFormat(MemorySegment structPtr, TextureFormat depthStencilFormat) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'depthStencilFormat'");
    }

    @Override
    public void sampleCount(MemorySegment structPtr, int sampleCount) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'sampleCount'");
    }

    @Override
    public void depthReadOnly(MemorySegment structPtr, boolean depthReadOnly) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'depthReadOnly'");
    }

    @Override
    public void stencilReadOnly(MemorySegment structPtr, boolean stencilReadOnly) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'stencilReadOnly'");
    }

}
