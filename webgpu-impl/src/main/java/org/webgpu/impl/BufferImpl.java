package org.webgpu.impl;

import org.webgpu.api.*;
import org.webgpu.panama.WGPUStringView;
import org.webgpu.panama.webgpu_h;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;
import java.util.EnumSet;

class BufferImpl implements Buffer {

    private final MemorySegment memorySegment;

    public BufferImpl(MemorySegment memorySegment) {
        this.memorySegment = memorySegment;
    }

    @Override
    public void mapAsync(EnumSet<MapMode> mode, long offset, long size) {

    }

    @Override
    public MemorySegment getMappedRange(long offset, long size) {
        return null;
    }

    @Override
    public MemorySegment getConstMappedRange(long offset, long size) {
        return null;
    }

    @Override
    public Status readMappedRange(long offset, MemorySegment data, long size) {
        return null;
    }

    @Override
    public Status writeMappedRange(long offset, MemorySegment data, long size) {
        return null;
    }

    @Override
    public void setLabel(String label) {
        final Arena arena = Arena.ofAuto();
        final var stringView = arena.allocate(WGPUStringView.layout());
        final var labelSegment = arena.allocateFrom(label);
        WGPUStringView.data(stringView, labelSegment);
        WGPUStringView.length(stringView, label.length());
        webgpu_h.wgpuBufferSetLabel(this.memorySegment, stringView);
    }

    @Override
    public EnumSet<BufferUsage> getUsage() {
        return null;
    }

    @Override
    public long getSize() {
        return 0;
    }

    @Override
    public BufferMapState getMapState() {
        return null;
    }

    @Override
    public void unmap() {
        webgpu_h.wgpuBufferUnmap(this.memorySegment);
    }

    @Override
    public void destroy() {

    }
}
