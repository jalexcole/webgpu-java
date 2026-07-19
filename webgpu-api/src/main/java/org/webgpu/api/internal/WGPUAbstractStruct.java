package org.webgpu.api.internal;

import java.lang.foreign.MemorySegment;

public abstract class WGPUAbstractStruct {
    

    protected final MemorySegment memorySegment;

    protected WGPUAbstractStruct(MemorySegment memorySegment) {
        this.memorySegment = memorySegment;
    }
}
