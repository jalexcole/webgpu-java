package org.webgpu.impl;

import java.lang.foreign.MemorySegment;

import org.webgpu.api.Surface;

public record SurfaceImpl(MemorySegment ptr) implements Surface {
    
}
