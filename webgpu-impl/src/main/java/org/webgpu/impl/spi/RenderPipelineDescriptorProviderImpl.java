package org.webgpu.impl.spi;

import java.lang.foreign.MemorySegment;

import org.jspecify.annotations.NonNull;
import org.webgpu.api.DepthStencilState;
import org.webgpu.api.FragmentState;
import org.webgpu.api.MultisampleState;
import org.webgpu.api.PipelineLayout;
import org.webgpu.api.PrimitiveState;
import org.webgpu.api.VertexState;
import org.webgpu.api.spi.RenderPipelineDescriptorProvider;

/**
 * RenderPipelineDescriptorProviderImpl
 */
public class RenderPipelineDescriptorProviderImpl implements RenderPipelineDescriptorProvider {

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
    public @NonNull PipelineLayout layout(@NonNull MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'layout'");
    }

    @Override
    public @NonNull VertexState vertex(@NonNull MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'vertex'");
    }

    @Override
    public @NonNull PrimitiveState primitive(@NonNull MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'primitive'");
    }

    @Override
    public @NonNull DepthStencilState depthStencil(@NonNull MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'depthStencil'");
    }

    @Override
    public @NonNull MultisampleState multisample(@NonNull MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'multisample'");
    }

    @Override
    public @NonNull FragmentState fragment(@NonNull MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'fragment'");
    }

    @Override
    public void label(@NonNull MemorySegment structPtr, @NonNull String label) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'label'");
    }

    @Override
    public void layout(@NonNull MemorySegment structPtr, @NonNull PipelineLayout layout) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'layout'");
    }

    @Override
    public void vertex(@NonNull MemorySegment structPtr, @NonNull VertexState vertex) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'vertex'");
    }

    @Override
    public void primitive(@NonNull MemorySegment structPtr, @NonNull PrimitiveState primitive) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'primitive'");
    }

    @Override
    public void depthStencil(@NonNull MemorySegment structPtr, @NonNull DepthStencilState depthStencil) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'depthStencil'");
    }

    @Override
    public void multisample(@NonNull MemorySegment structPtr, @NonNull MultisampleState multisample) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'multisample'");
    }

    @Override
    public void fragment(@NonNull MemorySegment structPtr, @NonNull FragmentState fragment) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'fragment'");
    }

}
