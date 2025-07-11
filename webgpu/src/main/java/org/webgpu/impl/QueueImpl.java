package org.webgpu.impl;

import java.lang.foreign.MemorySegment;

import org.webgpu.api.Queue;

public record QueueImpl(MemorySegment ptr) implements Queue {
    
}
