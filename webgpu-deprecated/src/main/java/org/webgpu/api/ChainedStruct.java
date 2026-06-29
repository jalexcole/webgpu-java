package org.webgpu.api;

import java.lang.foreign.MemorySegment;

import org.webgpu.panama.foreign.WGPUChainedStruct;

public class ChainedStruct {
    @SuppressWarnings("preview")
    private MemorySegment chainedStructPtr;

    public ChainedStruct(MemorySegment chainedStructPtr) {
        this.chainedStructPtr = chainedStructPtr;
    }

    public ChainedStruct nextInChain() {
        return new ChainedStruct(WGPUChainedStruct.next(chainedStructPtr));
    }

    public SType sType() {
        return SType.values()[WGPUChainedStruct.sType(this.chainedStructPtr)];
    }

    public MemorySegment ptr() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'ptr'");
    }
}
