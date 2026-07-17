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
import org.webgpu.impl.TextureViewImpl;

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
        return WGPUBindGroupEntry.offset(structPtr);
    }

    @Override
    public long size(MemorySegment structPtr) {
        return WGPUBindGroupEntry.size(structPtr);
    }

    @Override
    public Sampler sampler(MemorySegment structPtr) {
        return new org.webgpu.impl.SamplerImpl(WGPUBindGroupEntry.sampler(structPtr));
    }

    @Override
    public TextureView textureView(MemorySegment structPtr) {
        return new org.webgpu.impl.TextureViewImpl(WGPUBindGroupEntry.textureView(structPtr));
    }
    // This class is intentionally left empty as a placeholder for future
    // implementation.

    @Override
    public void binding(MemorySegment structPtr, int binding) {
        WGPUBindGroupEntry.binding(structPtr, binding);
    }

    @Override
    public void buffer(MemorySegment structPtr, Buffer buffer) {
        WGPUBindGroupEntry.buffer(structPtr, ((BufferImpl) buffer).ptr());
    }

    @Override
    public void offset(MemorySegment structPtr, long offset) {
        WGPUBindGroupEntry.offset(structPtr, offset);
    }

    @Override
    public void size(MemorySegment structPtr, long size) {
        WGPUBindGroupEntry.size(structPtr, size);
    }

    @Override
    public void sampler(MemorySegment structPtr, Sampler sampler) {
        WGPUBindGroupEntry.sampler(structPtr, ((org.webgpu.impl.SamplerImpl) sampler).ptr());
    }

    @Override
    public void textureView(MemorySegment structPtr, TextureView textureView) {
        WGPUBindGroupEntry.textureView(structPtr, ((TextureViewImpl) textureView).ptr());
    }

}