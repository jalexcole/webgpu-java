package org.webgpu.impl.spi;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;

import org.jspecify.annotations.NullMarked;
import org.webgpu.api.Buffer;
import org.webgpu.api.Sampler;
import org.webgpu.api.TextureView;
import org.webgpu.api.spi.BindGroupEntryProvider;
import org.webgpu.panama.WGPUBindGroupEntry;

import org.webgpu.impl.BufferImpl;

@NullMarked
public class BindGroupEntryProviderImpl implements BindGroupEntryProvider {

    private final Arena arena = Arena.ofAuto();

    @Override
    public MemorySegment initializer() {
        return WGPUBindGroupEntry.allocate(arena);
    }

    @Override
    public int binding(MemorySegment structPtr) {
        return WGPUBindGroupEntry.binding(structPtr);
    }

    @Override
    public Buffer buffer(MemorySegment structPtr) {
        var bufferPtr = WGPUBindGroupEntry.buffer(structPtr);
        return new BufferImpl(bufferPtr);
    }

    @Override
    public long offset(MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'offset'");
    }

    @Override
    public long size(MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'size'");
    }

    @Override
    public Sampler sampler(MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'sampler'");
    }

    @Override
    public TextureView textureView(MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'textureView'");
    }
    // This class is intentionally left empty as a placeholder for future
    // implementation.

    @Override
    public void binding(MemorySegment structPtr, int binding) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'binding'");
    }

    @Override
    public void buffer(MemorySegment structPtr, Buffer buffer) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buffer'");
    }

    @Override
    public void offset(MemorySegment structPtr, long offset) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'offset'");
    }

    @Override
    public void size(MemorySegment structPtr, long size) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'size'");
    }

    @Override
    public void sampler(MemorySegment structPtr, Sampler sampler) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'sampler'");
    }

    @Override
    public void textureView(MemorySegment structPtr, TextureView textureView) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'textureView'");
    }

}