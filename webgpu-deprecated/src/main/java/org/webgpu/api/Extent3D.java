package org.webgpu.api;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;

import org.webgpu.panama.foreign.WGPUExtent3D;

public class Extent3D {
    private MemorySegment ptr;

    public MemorySegment ptr() {
        return ptr;
    }

    public Extent3D() {
        Arena arena = Arena.ofAuto();
        ptr = WGPUExtent3D.allocate(arena);

    }

    public int width() {
        return WGPUExtent3D.width(ptr());
    }

    public int height() {
        return WGPUExtent3D.height(ptr());
    }

    public int depthOrArrayLayers() {
        return WGPUExtent3D.depthOrArrayLayers(ptr());
    }
}
