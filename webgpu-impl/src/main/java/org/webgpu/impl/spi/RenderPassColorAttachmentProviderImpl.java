package org.webgpu.impl.spi;

import java.lang.foreign.MemorySegment;

import org.jspecify.annotations.NonNull;
import org.webgpu.api.Color;
import org.webgpu.api.LoadOp;
import org.webgpu.api.StoreOp;
import org.webgpu.api.TextureView;
import org.webgpu.api.spi.RenderPassColorAttachmentProvider;

/**
 * RenderPassColorAttachmentProviderImpl
 */
public class RenderPassColorAttachmentProviderImpl implements RenderPassColorAttachmentProvider {

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
    public int depthSlice(@NonNull MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'depthSlice'");
    }

    @Override
    public @NonNull TextureView resolveTarget(@NonNull MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'resolveTarget'");
    }

    @Override
    public @NonNull LoadOp loadOp(@NonNull MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'loadOp'");
    }

    @Override
    public @NonNull StoreOp storeOp(@NonNull MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'storeOp'");
    }

    @Override
    public @NonNull Color clearValue(@NonNull MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'clearValue'");
    }

    @Override
    public void view(@NonNull MemorySegment structPtr, @NonNull TextureView view) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'view'");
    }

    @Override
    public void depthSlice(@NonNull MemorySegment structPtr, int depthSlice) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'depthSlice'");
    }

    @Override
    public void resolveTarget(@NonNull MemorySegment structPtr, @NonNull TextureView resolveTarget) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'resolveTarget'");
    }

    @Override
    public void loadOp(@NonNull MemorySegment structPtr, @NonNull LoadOp loadOp) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'loadOp'");
    }

    @Override
    public void storeOp(@NonNull MemorySegment structPtr, @NonNull StoreOp storeOp) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'storeOp'");
    }

    @Override
    public void clearValue(@NonNull MemorySegment structPtr, @NonNull Color clearValue) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'clearValue'");
    }

}
