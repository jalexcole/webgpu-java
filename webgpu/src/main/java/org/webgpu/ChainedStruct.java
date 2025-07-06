package org.webgpu;

import java.lang.foreign.MemorySegment;

import org.webgpu.extract.WGPUChainedStruct;

public class ChainedStruct {
    @SuppressWarnings("preview")
    private MemorySegment chainedStructPtr;

    ChainedStruct(MemorySegment chainedStructPtr) {
        this.chainedStructPtr = chainedStructPtr;
    }

    
    public ChainedStruct nextInChain() {
        return new ChainedStruct(WGPUChainedStruct.next(chainedStructPtr));
    }

    public SType sType() {
        return SType.values()[WGPUChainedStruct.sType(this.chainedStructPtr)];
    }
}
