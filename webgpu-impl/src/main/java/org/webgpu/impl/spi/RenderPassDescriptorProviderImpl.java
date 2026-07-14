package org.webgpu.impl.spi;

import java.lang.foreign.MemorySegment;

import org.jspecify.annotations.NonNull;
import org.webgpu.api.PassTimestampWrites;
import org.webgpu.api.QuerySet;
import org.webgpu.api.RenderPassColorAttachment;
import org.webgpu.api.RenderPassDepthStencilAttachment;
import org.webgpu.api.spi.RenderPassDescriptorProvider;

/**
 * RenderPassDescriptorProviderImpl
 */
public class RenderPassDescriptorProviderImpl implements RenderPassDescriptorProvider {

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
    public RenderPassColorAttachment @NonNull [] colorAttachments(@NonNull MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'colorAttachments'");
    }

    @Override
    public @NonNull RenderPassDepthStencilAttachment depthStencilAttachment(@NonNull MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'depthStencilAttachment'");
    }

    @Override
    public @NonNull QuerySet occlusionQuerySet(@NonNull MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'occlusionQuerySet'");
    }

    @Override
    public @NonNull PassTimestampWrites timestampWrites(@NonNull MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'timestampWrites'");
    }

    @Override
    public void label(@NonNull MemorySegment structPtr, @NonNull String label) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'label'");
    }

    @Override
    public void colorAttachments(@NonNull MemorySegment structPtr,
            RenderPassColorAttachment @NonNull [] colorAttachments) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'colorAttachments'");
    }

    @Override
    public void depthStencilAttachment(@NonNull MemorySegment structPtr,
            @NonNull RenderPassDepthStencilAttachment depthStencilAttachment) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'depthStencilAttachment'");
    }

    @Override
    public void occlusionQuerySet(@NonNull MemorySegment structPtr, @NonNull QuerySet occlusionQuerySet) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'occlusionQuerySet'");
    }

    @Override
    public void timestampWrites(@NonNull MemorySegment structPtr, @NonNull PassTimestampWrites timestampWrites) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'timestampWrites'");
    }

}
