package org.webgpu.api;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;
import java.util.Optional;

import org.webgpu.foreign.WGPUShaderModuleDescriptor;
import org.webgpu.util.StringView;

public class ShaderModuleDescriptor {
    private final MemorySegment ptr;

    public ShaderModuleDescriptor() {
        final Arena arena = Arena.ofAuto();
        this.ptr = WGPUShaderModuleDescriptor.allocate(arena);
    }

    ShaderModuleDescriptor(MemorySegment ptr) {
        this.ptr = ptr;
    }

    public Optional<ChainedStruct> nextInChain() {
        return Optional.of(new ChainedStruct(WGPUShaderModuleDescriptor.nextInChain(ptr)));
    }

    public String label() {
        return new StringView(WGPUShaderModuleDescriptor.label(ptr)).string();
    }


    public MemorySegment ptr() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'ptr'");
    }

    @Override
    public String toString() {
        return "ShaderModuleDescriptor [nextInChain()=" + nextInChain() + ", label()=" + label() + "]";
    }

    

}
