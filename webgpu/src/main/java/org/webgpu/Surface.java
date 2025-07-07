package org.webgpu;

import java.lang.foreign.MemorySegment;

public class Surface {

    private MemorySegment surfacePtr;

    public Surface(MemorySegment surfacePtr) {
        this.surfacePtr = surfacePtr;
    }

    public MemorySegment ptr() {
        return this.surfacePtr;
    }

}
