package org.webgpu;

import java.lang.foreign.MemorySegment;

class Proc implements ObjectBase {
    private MemorySegment procPtr;

    Proc(MemorySegment procPtr) {
        this.procPtr = procPtr;
    }

    @Override
    public MemorySegment ptr() {
        return procPtr;
    }
}
