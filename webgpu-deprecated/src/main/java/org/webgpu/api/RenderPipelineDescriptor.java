package org.webgpu.api;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;
import java.util.Optional;

import org.webgpu.panama.foreign.WGPURenderPipelineDescriptor;
import org.webgpu.impl.PipelineLayoutImpl;
import org.webgpu.util.StringView;

public non-sealed class RenderPipelineDescriptor implements DescriptorBase {
    private final MemorySegment ptr;

    public RenderPipelineDescriptor() {
        final Arena arena = Arena.ofAuto();
        this.ptr = WGPURenderPipelineDescriptor.allocate(arena);
    }

    public RenderPipelineDescriptor(MemorySegment ptr) {
        this.ptr = ptr;
    }

    public Optional<ChainedStruct> nextInChain() {
        return Optional.of(new ChainedStruct(WGPURenderPipelineDescriptor.nextInChain(ptr)));
    }

    public String label() {
        return StringView.map(WGPURenderPipelineDescriptor.label(ptr));
    }

    public PipelineLayout layout() {
        return new PipelineLayoutImpl(WGPURenderPipelineDescriptor.layout(ptr));
    }

    public VertexState vertex() {
        throw new UnsupportedOperationException("Unimplemented method 'vertex'");
    }

    public PrimitiveState primitive() {
        throw new UnsupportedOperationException("Unimplemented method 'primitive'");
    }

    public DepthStencilState depthStencil() {
        throw new UnsupportedOperationException("Unimplemented method 'depthStencil'");
    }

    public MultisampleState multisample() {
        throw new UnsupportedOperationException("Unimplemented method 'multisample'");
    }

    public FragmentState fragment() {
        throw new UnsupportedOperationException("Unimplemented method 'fragment'");
    }

    public MemorySegment ptr() {
        return ptr;
    }

    @Override
    public String toString() {
        return "RenderPipelineDescriptor [nextInChain()=" + nextInChain() + ", label()=" + label() + ", layout()="
                + layout() + ", vertex()=" + vertex() + ", primitive()=" + primitive() + ", depthStencil()="
                + depthStencil() + ", multisample()=" + multisample() + ", fragment()=" + fragment() + "]";
    }

}
