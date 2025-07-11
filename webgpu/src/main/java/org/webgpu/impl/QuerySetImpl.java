package org.webgpu.impl;

import java.lang.foreign.MemorySegment;

import org.webgpu.api.QuerySet;

public record QuerySetImpl(MemorySegment ptr) implements QuerySet {
    
}
