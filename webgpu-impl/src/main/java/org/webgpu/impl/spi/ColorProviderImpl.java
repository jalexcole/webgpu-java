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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'r'");
    }

    @Override
    public void g(MemorySegment structPtr, double g) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'g'");
    }

    @Override
    public void b(MemorySegment structPtr, double b) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'b'");
    }

    @Override
    public void a(MemorySegment structPtr, double a) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'a'");
    }
}