package org.webgpu.impl.spi;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;

import org.jspecify.annotations.NonNull;
import org.webgpu.api.DepthStencilState;
import org.webgpu.api.FragmentState;
import org.webgpu.api.MultisampleState;
import org.webgpu.api.PipelineLayout;
import org.webgpu.api.PrimitiveState;
import org.webgpu.api.VertexState;
import org.webgpu.api.spi.RenderPipelineDescriptorProvider;
import org.webgpu.panama.WGPURenderPipelineDescriptor;

/**
 * RenderPipelineDescriptorProviderImpl
 */
public class RenderPipelineDescriptorProviderImpl implements RenderPipelineDescriptorProvider {
    private final Arena arena = Arena.ofAuto();

    @Override
    public MemorySegment initializer() {
        return WGPURenderPipelineDescriptor.allocate(arena);
    }

    @Override
    public String label(MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'label'");
    }

    @Override
    public PipelineLayout layout(MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'layout'");
    }

    @Override
    public VertexState vertex(MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'vertex'");
    }

    @Override
    public PrimitiveState primitive(MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'primitive'");
    }

    @Override
    public DepthStencilState depthStencil(MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'depthStencil'");
    }

    @Override
    public MultisampleState multisample(MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'multisample'");
    }

    @Override
    public FragmentState fragment(MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'fragment'");
    }

    @Override
    public void label(MemorySegment structPtr, String label) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'label'");
    }

    @Override
    public void layout(MemorySegment structPtr, PipelineLayout layout) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'layout'");
    }

    @Override
    public void vertex(MemorySegment structPtr, VertexState vertex) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'vertex'");
    }

    @Override
    public void primitive(MemorySegment structPtr, PrimitiveState primitive) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'primitive'");
    }

    @Override
    public void depthStencil(MemorySegment structPtr, DepthStencilState depthStencil) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'depthStencil'");
    }

    @Override
    public void multisample(MemorySegment structPtr, MultisampleState multisample) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'multisample'");
    }

    @Override
    public void fragment(MemorySegment structPtr, FragmentState fragment) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'fragment'");
    }

}
