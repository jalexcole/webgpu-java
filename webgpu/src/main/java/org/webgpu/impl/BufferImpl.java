package org.webgpu.impl;

import java.lang.foreign.MemorySegment;

import org.webgpu.api.Buffer;
import org.webgpu.api.BufferMapState;
import org.webgpu.api.BufferUsage;
import org.webgpu.extract.webgpu_h;

public record BufferImpl(MemorySegment ptr) implements Buffer {

    @Override
    public void destroy() {
        webgpu_h.wgpuBufferDestroy(ptr);
    }

    @Override
    public BufferMapState getMapState() {
        return BufferMapState.fromValue(webgpu_h.wgpuBufferGetMapState(ptr));
    }

    @Override
    public long getSize() {
        return webgpu_h.wgpuBufferGetSize(ptr);
    }

    @Override
    public BufferUsage getUsage() {
        return BufferUsage.fromValue(webgpu_h.wgpuBufferGetUsage(ptr));
    }

    @Override
    public void unmap() {
        webgpu_h.wgpuBufferUnmap(ptr);
    }

    public void addRef() {
        webgpu_h.wgpuBufferAddRef(ptr);
    }

    public void release() {
        webgpu_h.wgpuBufferRelease(ptr);
    }

    @Override
    public String toString() {
        return "BufferImpl[" + getMapState() + ", size=" + getSize() + ", usage=" + getUsage() + "]";
    }
}
