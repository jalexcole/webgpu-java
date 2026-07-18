package org.webgpu.impl.spi;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;

import org.webgpu.api.LoadOp;
import org.webgpu.api.StoreOp;
import org.webgpu.api.TextureView;
import org.webgpu.api.spi.RenderPassDepthStencilAttachmentProvider;
import org.webgpu.panama.WGPURenderPassDepthStencilAttachment;

/**
 * RenderPassDepthStencilAttachmentProviderImpl
 */
public class RenderPassDepthStencilAttachmentProviderImpl implements RenderPassDepthStencilAttachmentProvider {
    private final Arena arena = Arena.ofAuto();

    @Override
    public MemorySegment initializer() {
        return WGPURenderPassDepthStencilAttachment.allocate(arena);
    }

    @Override
    public TextureView view(MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'view'");
    }

    @Override
    public LoadOp depthLoadOp(MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'depthLoadOp'");
    }

    @Override
    public StoreOp depthStoreOp(MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'depthStoreOp'");
    }

    @Override
    public float depthClearValue(MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'depthClearValue'");
    }

    @Override
    public boolean depthReadOnly(MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'depthReadOnly'");
    }

    @Override
    public LoadOp stencilLoadOp(MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'stencilLoadOp'");
    }

    @Override
    public StoreOp stencilStoreOp(MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'stencilStoreOp'");
    }

    @Override
    public int stencilClearValue(MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'stencilClearValue'");
    }

    @Override
    public boolean stencilReadOnly(MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'stencilReadOnly'");
    }

    @Override
    public void view(MemorySegment structPtr, TextureView view) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'view'");
    }

    @Override
    public void depthLoadOp(MemorySegment structPtr, LoadOp depthLoadOp) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'depthLoadOp'");
    }

    @Override
    public void depthStoreOp(MemorySegment structPtr, StoreOp depthStoreOp) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'depthStoreOp'");
    }

    @Override
    public void depthClearValue(MemorySegment structPtr, float depthClearValue) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'depthClearValue'");
    }

    @Override
    public void depthReadOnly(MemorySegment structPtr, boolean depthReadOnly) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'depthReadOnly'");
    }

    @Override
    public void stencilLoadOp(MemorySegment structPtr, LoadOp stencilLoadOp) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'stencilLoadOp'");
    }

    @Override
    public void stencilStoreOp(MemorySegment structPtr, StoreOp stencilStoreOp) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'stencilStoreOp'");
    }

    @Override
    public void stencilClearValue(MemorySegment structPtr, int stencilClearValue) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'stencilClearValue'");
    }

    @Override
    public void stencilReadOnly(MemorySegment structPtr, boolean stencilReadOnly) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'stencilReadOnly'");
    }

}
