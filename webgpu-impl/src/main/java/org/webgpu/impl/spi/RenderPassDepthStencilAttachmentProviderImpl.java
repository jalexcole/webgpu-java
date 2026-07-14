package org.webgpu.impl.spi;

import java.lang.foreign.MemorySegment;

import org.jspecify.annotations.NonNull;
import org.webgpu.api.LoadOp;
import org.webgpu.api.StoreOp;
import org.webgpu.api.TextureView;
import org.webgpu.api.spi.RenderPassDepthStencilAttachmentProvider;

/**
 * RenderPassDepthStencilAttachmentProviderImpl
 */
public class RenderPassDepthStencilAttachmentProviderImpl implements RenderPassDepthStencilAttachmentProvider {

    @Override
    public @NonNull MemorySegment initializer() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'initializer'");
    }

    @Override
    public @NonNull TextureView view(@NonNull MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'view'");
    }

    @Override
    public @NonNull LoadOp depthLoadOp(@NonNull MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'depthLoadOp'");
    }

    @Override
    public @NonNull StoreOp depthStoreOp(@NonNull MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'depthStoreOp'");
    }

    @Override
    public float depthClearValue(@NonNull MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'depthClearValue'");
    }

    @Override
    public boolean depthReadOnly(@NonNull MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'depthReadOnly'");
    }

    @Override
    public @NonNull LoadOp stencilLoadOp(@NonNull MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'stencilLoadOp'");
    }

    @Override
    public @NonNull StoreOp stencilStoreOp(@NonNull MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'stencilStoreOp'");
    }

    @Override
    public int stencilClearValue(@NonNull MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'stencilClearValue'");
    }

    @Override
    public boolean stencilReadOnly(@NonNull MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'stencilReadOnly'");
    }

    @Override
    public void view(@NonNull MemorySegment structPtr, @NonNull TextureView view) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'view'");
    }

    @Override
    public void depthLoadOp(@NonNull MemorySegment structPtr, @NonNull LoadOp depthLoadOp) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'depthLoadOp'");
    }

    @Override
    public void depthStoreOp(@NonNull MemorySegment structPtr, @NonNull StoreOp depthStoreOp) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'depthStoreOp'");
    }

    @Override
    public void depthClearValue(@NonNull MemorySegment structPtr, float depthClearValue) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'depthClearValue'");
    }

    @Override
    public void depthReadOnly(@NonNull MemorySegment structPtr, boolean depthReadOnly) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'depthReadOnly'");
    }

    @Override
    public void stencilLoadOp(@NonNull MemorySegment structPtr, @NonNull LoadOp stencilLoadOp) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'stencilLoadOp'");
    }

    @Override
    public void stencilStoreOp(@NonNull MemorySegment structPtr, @NonNull StoreOp stencilStoreOp) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'stencilStoreOp'");
    }

    @Override
    public void stencilClearValue(@NonNull MemorySegment structPtr, int stencilClearValue) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'stencilClearValue'");
    }

    @Override
    public void stencilReadOnly(@NonNull MemorySegment structPtr, boolean stencilReadOnly) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'stencilReadOnly'");
    }

}
