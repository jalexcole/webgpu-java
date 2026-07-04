package org.webgpu.impl;

import java.lang.foreign.MemorySegment;

public sealed interface WebGPUObjectImpl permits AdapterImpl {
    

    public MemorySegment ptr();
}
