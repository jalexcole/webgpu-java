package org.webgpu.impl;

import org.jspecify.annotations.NullMarked;
import org.webgpu.api.*;
import org.webgpu.api.exceptions.WGPUException;
import org.webgpu.panama.webgpu_h;

import java.lang.foreign.MemorySegment;
import java.util.EnumSet;
import java.util.Set;

@NullMarked
public final class BufferImpl implements Buffer, WebGPUObjectImpl {

    private final MemorySegment memorySegment;
    private boolean destroyed = false;

    public BufferImpl(MemorySegment memorySegment) {
        this.memorySegment = memorySegment;
    }


    public void mapAsync(Set<MapMode> mode, long offset, long size) {
        final long modes = mode.stream().mapToLong(MapMode::value).sum();

        throw new WGPUException(new UnsupportedOperationException());
    }

    @Override
    public MemorySegment getMappedRange(long offset, long size) {
        return webgpu_h.wgpuBufferGetMappedRange(this.memorySegment, offset, size);
    }

    @Override
    public MemorySegment getConstMappedRange(long offset, long size) {
        return webgpu_h.wgpuBufferGetConstMappedRange(this.memorySegment, offset, size);
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
        throw new WGPUException(new UnsupportedOperationException("WGPU Does not support setting labels on buffers yet."));
    }

    @Override
    public EnumSet<BufferUsage> getUsage() {
        return null;
    }

    @Override
    public long getSize() {
        return webgpu_h.wgpuBufferGetSize(this.memorySegment);
    }

    @Override
    public BufferMapState getMapState() {
        final var mapState = webgpu_h.wgpuBufferGetMapState(this.memorySegment);
        return BufferMapState.values()[mapState];
        
    }

    @Override
    public void unmap() {
        webgpu_h.wgpuBufferUnmap(this.memorySegment);
    }

    @Override
    public synchronized void destroy() {
        if (!destroyed) {
            webgpu_h.wgpuBufferDestroy(this.memorySegment);
            destroyed = true;
        }
    }
    
    @Override
    public void mapAsync(BufferMap callback, Set<MapMode> mode, long offset, long size) {
        throw new UnsupportedOperationException("Unimplemented method 'mapAsync'");
    }


	@Override
	public MemorySegment ptr() {
		return this.memorySegment;
	}
}
