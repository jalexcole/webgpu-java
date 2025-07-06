package org.webgpu;

import java.lang.foreign.MemorySegment;

public class Instance {
    private MemorySegment instance;

    Instance(MemorySegment instance) {
        this.instance = instance;
    }
}
