package org.webgpu;

import java.lang.foreign.MemorySegment;

public class Instance {
    private MemorySegment instancePtr;

    Instance(MemorySegment instance) {
        this.instancePtr = instance;
    }

    MemorySegment ptr() {
       return this.instancePtr;
    }
}
