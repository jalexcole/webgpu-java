package org.webgpu.impl.util;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;

public abstract class AbstractMapper<T> {

    public MemorySegment map(T object) {
        Arena arena = Arena.ofAuto();
        return map(object, arena);
    }

    public abstract MemorySegment map(T object, Arena arena);

    public abstract T unmap(MemorySegment segment);
    
}
