package org.webgpu.impl.spi;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;


import org.webgpu.api.spi.TexelCopyBufferLayoutProvider;
import org.webgpu.panama.WGPUTexelCopyBufferLayout;

/**
 * TexelCopyBufferLayoutProviderImpl
 */
public class TexelCopyBufferLayoutProviderImpl implements TexelCopyBufferLayoutProvider {
    private final Arena arena = Arena.ofAuto();

    @Override
    public MemorySegment initializer() {
        return WGPUTexelCopyBufferLayout.allocate(arena);
    }

    @Override
    public long offset(MemorySegment structPtr) {
        return WGPUTexelCopyBufferLayout.offset(structPtr);
    }

    @Override
    public int bytesPerRow(MemorySegment structPtr) {
        return WGPUTexelCopyBufferLayout.bytesPerRow(structPtr);
    }

    @Override
    public int rowsPerImage(MemorySegment structPtr) {
        return WGPUTexelCopyBufferLayout.rowsPerImage(structPtr);
    }

    @Override
    public void offset(MemorySegment structPtr, long offset) {
        WGPUTexelCopyBufferLayout.offset(structPtr, offset);
    }

    @Override
    public void bytesPerRow(MemorySegment structPtr, int bytesPerRow) {
        WGPUTexelCopyBufferLayout.bytesPerRow(structPtr, bytesPerRow);
    }

    @Override
    public void rowsPerImage(MemorySegment structPtr, int rowsPerImage) {
        WGPUTexelCopyBufferLayout.rowsPerImage(structPtr, rowsPerImage);
    }

}
