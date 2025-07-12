package org.webgpu.api;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;

import org.webgpu.extract.webgpu_h;

public class QuerySetDescriptor {

    private MemorySegment ptr;
    /**
     * This can only be created from a {@link Device}.
     * @param ptr
     */
    public QuerySetDescriptor(MemorySegment ptr) {
        this.ptr = ptr;
    }


    


}
