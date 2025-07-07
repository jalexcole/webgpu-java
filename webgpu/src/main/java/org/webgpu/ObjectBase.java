package org.webgpu;

import java.lang.foreign.MemorySegment;

interface ObjectBase {
    /**
     * Retrieves the ptr for the object;
     * @return
     */
    MemorySegment ptr();
}
