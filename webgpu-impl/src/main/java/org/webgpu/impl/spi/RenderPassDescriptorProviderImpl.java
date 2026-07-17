package org.webgpu.impl.spi;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;

import org.jspecify.annotations.NonNull;
import org.webgpu.api.PassTimestampWrites;
import org.webgpu.api.QuerySet;
import org.webgpu.api.RenderPassColorAttachment;
import org.webgpu.api.RenderPassDepthStencilAttachment;
import org.webgpu.api.spi.RenderPassDescriptorProvider;
import org.webgpu.panama.WGPURenderPassDescriptor;

/**
 * RenderPassDescriptorProviderImpl
 */
public class RenderPassDescriptorProviderImpl implements RenderPassDescriptorProvider {
    private final Arena arena = Arena.ofAuto();

    @Override
    public MemorySegment initializer() {
        return WGPURenderPassDescriptor.allocate(arena);
    }

    @Override
    public String label(MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'label'");
    }

    @Override
    public RenderPassColorAttachment[] colorAttachments(MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'colorAttachments'");
    }

    @Override
    public RenderPassDepthStencilAttachment depthStencilAttachment(MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'depthStencilAttachment'");
    }

    @Override
    public QuerySet occlusionQuerySet(MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'occlusionQuerySet'");
    }

    @Override
    public PassTimestampWrites timestampWrites(MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'timestampWrites'");
    }

    @Override
    public void label(MemorySegment structPtr, String label) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'label'");
    }

    @Override
    public void colorAttachments(MemorySegment structPtr,
            RenderPassColorAttachment[] colorAttachments) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'colorAttachments'");
    }

    @Override
    public void depthStencilAttachment(MemorySegment structPtr,
            RenderPassDepthStencilAttachment depthStencilAttachment) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'depthStencilAttachment'");
    }

    @Override
    public void occlusionQuerySet(MemorySegment structPtr, QuerySet occlusionQuerySet) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'occlusionQuerySet'");
    }

    @Override
    public void timestampWrites(MemorySegment structPtr, PassTimestampWrites timestampWrites) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'timestampWrites'");
    }

}
