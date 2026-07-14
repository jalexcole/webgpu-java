package org.webgpu.impl.spi;

import java.lang.foreign.MemorySegment;

import org.jspecify.annotations.NonNull;
import org.webgpu.api.TextureFormat;
import org.webgpu.api.spi.RenderBundleEncoderDescriptorProvider;

/**
 * RenderBundleEncoderDescriptorProviderImpl
 */
public class RenderBundleEncoderDescriptorProviderImpl implements RenderBundleEncoderDescriptorProvider {

    @Override
    public @NonNull MemorySegment initializer() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'initializer'");
    }

    @Override
    public @NonNull String label(@NonNull MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'label'");
    }

    @Override
    public TextureFormat @NonNull [] colorFormats(@NonNull MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'colorFormats'");
    }

    @Override
    public @NonNull TextureFormat depthStencilFormat(@NonNull MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'depthStencilFormat'");
    }

    @Override
    public int sampleCount(@NonNull MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'sampleCount'");
    }

    @Override
    public boolean depthReadOnly(@NonNull MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'depthReadOnly'");
    }

    @Override
    public boolean stencilReadOnly(@NonNull MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'stencilReadOnly'");
    }

    @Override
    public void label(@NonNull MemorySegment structPtr, @NonNull String label) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'label'");
    }

    @Override
    public void colorFormats(@NonNull MemorySegment structPtr, TextureFormat @NonNull [] colorFormats) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'colorFormats'");
    }

    @Override
    public void depthStencilFormat(@NonNull MemorySegment structPtr, @NonNull TextureFormat depthStencilFormat) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'depthStencilFormat'");
    }

    @Override
    public void sampleCount(@NonNull MemorySegment structPtr, int sampleCount) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'sampleCount'");
    }

    @Override
    public void depthReadOnly(@NonNull MemorySegment structPtr, boolean depthReadOnly) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'depthReadOnly'");
    }

    @Override
    public void stencilReadOnly(@NonNull MemorySegment structPtr, boolean stencilReadOnly) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'stencilReadOnly'");
    }

}
