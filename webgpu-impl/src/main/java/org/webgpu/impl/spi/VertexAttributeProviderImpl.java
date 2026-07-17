package org.webgpu.impl.spi;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;

import org.jspecify.annotations.NonNull;
import org.webgpu.api.VertexFormat;
import org.webgpu.api.spi.VertexAttributeProvider;
import org.webgpu.panama.WGPUVertexAttribute;

/**
 * VertexAttributeProviderImpl
 */
public class VertexAttributeProviderImpl implements VertexAttributeProvider {
    private final Arena arena = Arena.ofAuto();

    @Override
    public MemorySegment initializer() {
        return WGPUVertexAttribute.allocate(arena);
    }

    @Override
    public VertexFormat format(MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'format'");
    }

    @Override
    public long offset(MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'offset'");
    }

    @Override
    public int shaderLocation(MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'shaderLocation'");
    }

    @Override
    public void format(MemorySegment structPtr, VertexFormat format) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'format'");
    }

    @Override
    public void offset(MemorySegment structPtr, long offset) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'offset'");
    }

    @Override
    public void shaderLocation(MemorySegment structPtr, int shaderLocation) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'shaderLocation'");
    }

}
