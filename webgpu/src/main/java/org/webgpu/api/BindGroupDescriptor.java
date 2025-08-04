package org.webgpu.api;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;
import java.util.Optional;

import org.webgpu.extract.WGPUBindGroupDescriptor;
import org.webgpu.impl.BindGroupLayoutImpl;
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

    public BindGroupLayout layout() {
        return new BindGroupLayoutImpl(WGPUBindGroupDescriptor.layout(ptr));
    }

    public void setLayout(BindGroupLayout layout) {
        WGPUBindGroupDescriptor.layout(ptr, ((BindGroupLayoutImpl) layout).ptr());
    }

    public long entryCount() {
        return WGPUBindGroupDescriptor.entryCount(ptr);
    }

    public void setEntryCount(long count) {
        WGPUBindGroupDescriptor.entryCount(ptr, count);
    }

    public BindGroupEntry[] entries() {
        throw new UnsupportedOperationException("Unimplemented method 'entries'");
    }

    public void setEntries(BindGroupEntry... entries) {
        throw new UnsupportedOperationException("Unimplemented method 'setEntries'");
    }

    public MemorySegment ptr() {
        return this.ptr;
    }

}