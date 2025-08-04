package org.webgpu.api;
import java.lang.foreign.MemorySegment;



public class QuerySetDescriptor {

    private MemorySegment ptr;

    /**
     * This can only be created from a {@link Device}.
     * 
     * @param ptr
     */
    public QuerySetDescriptor(MemorySegment ptr) {
        this.ptr = ptr;
    }

    public MemorySegment ptr() {
        return ptr;
    }

}
