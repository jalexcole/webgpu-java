package org.webgpu.api;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;
import java.util.Optional;

import org.webgpu.extract.WGPUBindGroupDescriptor;
import org.webgpu.util.StringView;

public class BindGroupDescriptor {

    private final MemorySegment ptr;

    public BindGroupDescriptor() {
        Arena arena = Arena.ofAuto();
        ptr = WGPUBindGroupDescriptor.allocate(arena);
    }

    public Optional<ChainedStruct> nextInChain() {
        return Optional.of(new ChainedStruct(WGPUBindGroupDescriptor.nextInChain(ptr)));
    }

    public void setNextInChain(ChainedStruct chainedStruct) {
        WGPUBindGroupDescriptor.nextInChain(ptr, chainedStruct.ptr());
    }

    public String label() {
        return new StringView(WGPUBindGroupDescriptor.label(ptr)).toString();
    }

    public void setLabel(String label) {
        Arena arena = Arena.ofAuto();
        var stringView = StringView.of(arena, label);
        WGPUBindGroupDescriptor.label(ptr, stringView);
    }

    public MemorySegment ptr() {
        return this.ptr;   
    }
    
}