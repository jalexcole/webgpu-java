package org.webgpu.impl.spi;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;

import org.jspecify.annotations.NonNull;
import org.webgpu.api.Buffer;
import org.webgpu.api.TexelCopyBufferLayout;
import org.webgpu.api.spi.TexelCopyBufferInfoProvider;
import org.webgpu.impl.BufferImpl;
import org.webgpu.impl.util.StructTools;
import org.webgpu.panama.WGPUTexelCopyBufferInfo;

/**
 * TexelCopyBufferInfoProviderImpl
 */
public class TexelCopyBufferInfoProviderImpl implements TexelCopyBufferInfoProvider {
    private final Arena arena = Arena.ofAuto();

    @Override
    public MemorySegment initializer() {
        return WGPUTexelCopyBufferInfo.allocate(arena);
    }

    @Override
    public TexelCopyBufferLayout layout(MemorySegment structPtr) {
        final var layoutPtr = WGPUTexelCopyBufferInfo.layout(structPtr);
        return StructTools.placeSegment(layoutPtr, TexelCopyBufferLayout.class);
    }

    @Override
    public Buffer buffer(MemorySegment structPtr) {
        final var bufferPtr = WGPUTexelCopyBufferInfo.buffer(structPtr);
        return new BufferImpl(bufferPtr);
    }

    @Override
    public void layout(MemorySegment structPtr, TexelCopyBufferLayout layout) {
        final var layoutPtr = StructTools.fetchSegment(layout);
        WGPUTexelCopyBufferInfo.layout(structPtr, layoutPtr);
    }

    @Override
    public void buffer(MemorySegment structPtr, Buffer buffer) {
        final var bufferPtr = ((BufferImpl) buffer).ptr();
        WGPUTexelCopyBufferInfo.buffer(structPtr, bufferPtr);
    }

}
