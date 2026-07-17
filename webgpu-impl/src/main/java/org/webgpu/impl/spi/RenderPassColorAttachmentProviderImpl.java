package org.webgpu.impl.spi;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;

import org.jspecify.annotations.NonNull;
import org.webgpu.api.Color;
import org.webgpu.api.LoadOp;
import org.webgpu.api.StoreOp;
import org.webgpu.api.TextureView;
import org.webgpu.api.spi.RenderPassColorAttachmentProvider;
import org.webgpu.panama.WGPURenderPassColorAttachment;

/**
 * RenderPassColorAttachmentProviderImpl
 */
public class RenderPassColorAttachmentProviderImpl implements RenderPassColorAttachmentProvider {
    private final Arena arena = Arena.ofAuto();

    @Override
    public MemorySegment initializer() {
        return WGPURenderPassColorAttachment.allocate(arena);
    }

    @Override
    public TextureView view(MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'view'");
    }

    @Override
    public int depthSlice(MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'depthSlice'");
    }

    @Override
    public TextureView resolveTarget(MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'resolveTarget'");
    }

    @Override
    public LoadOp loadOp(MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'loadOp'");
    }

    @Override
    public StoreOp storeOp(MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'storeOp'");
    }

    @Override
    public Color clearValue(MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'clearValue'");
    }

    @Override
    public void view(MemorySegment structPtr, TextureView view) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'view'");
    }

    @Override
    public void depthSlice(MemorySegment structPtr, int depthSlice) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'depthSlice'");
    }

    @Override
    public void resolveTarget(MemorySegment structPtr, TextureView resolveTarget) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'resolveTarget'");
    }

    @Override
    public void loadOp(MemorySegment structPtr, LoadOp loadOp) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'loadOp'");
    }

    @Override
    public void storeOp(MemorySegment structPtr, StoreOp storeOp) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'storeOp'");
    }

    @Override
    public void clearValue(MemorySegment structPtr, Color clearValue) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'clearValue'");
    }

}
