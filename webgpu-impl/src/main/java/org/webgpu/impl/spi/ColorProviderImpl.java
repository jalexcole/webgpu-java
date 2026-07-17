package org.webgpu.impl.spi;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;

import org.webgpu.api.spi.ColorProvider;
import org.webgpu.panama.WGPUColor;

public class ColorProviderImpl implements ColorProvider {

    private final Arena arena = Arena.ofAuto();

    @Override
    public MemorySegment initializer() {
        return WGPUColor.allocate(arena);
    }

    @Override
    public double r(MemorySegment structPtr) {
        return WGPUColor.r(structPtr);
    }

    @Override
    public double g(MemorySegment structPtr) {
        return WGPUColor.g(structPtr);
    }

    @Override
    public double b(MemorySegment structPtr) {
        return WGPUColor.b(structPtr);
    }

    @Override
    public double a(MemorySegment structPtr) {
        return WGPUColor.a(structPtr);
    }

    @Override
    public void r(MemorySegment structPtr, double r) {
        WGPUColor.r(structPtr, r);
    }

    @Override
    public void g(MemorySegment structPtr, double g) {
        WGPUColor.g(structPtr, g);
    }

    @Override
    public void b(MemorySegment structPtr, double b) {
        WGPUColor.b(structPtr, b);
    }

    @Override
    public void a(MemorySegment structPtr, double a) {
        WGPUColor.a(structPtr, a);
    }
}