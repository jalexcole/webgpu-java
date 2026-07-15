package org.webgpu.impl;

import org.jspecify.annotations.NullMarked;
import org.webgpu.api.*;
import org.webgpu.api.exceptions.WGPUException;
import org.webgpu.impl.util.BitPacker;
import org.webgpu.impl.util.StringViewMapper;
import org.webgpu.panama.WGPUBufferMapCallback;
import org.webgpu.panama.WGPUBufferMapCallbackInfo;
import org.webgpu.panama.webgpu_h;

import java.lang.foreign.Arena;
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
        var statusCode = webgpu_h.wgpuBufferReadMappedRange(this.memorySegment, offset, data, size);
        return Status.values()[statusCode];
    }

    @Override
    public Status writeMappedRange(long offset, MemorySegment data, long size) {
        var statusCode = webgpu_h.wgpuBufferWriteMappedRange(this.memorySegment, offset, data, size);
        return Status.values()[statusCode];
    }

    @Override
    public void setLabel(String label) {
        throw new WGPUException(new UnsupportedOperationException("WGPU Does not support setting labels on buffers yet."));
    }

    @Override
    public Set<BufferUsage> getUsage() {
        return BitPacker.unpack(webgpu_h.wgpuBufferGetUsage(this.memorySegment), BufferUsage.class);
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
        final long modes = BitPacker.pack(mode);
        final var callbackPtr = WGPUBufferMapCallback
                .allocate((int status, MemorySegment message, MemorySegment userdata1, MemorySegment userdata2) -> {
            callback.apply(MapAsyncStatus.values()[status], StringViewMapper.map(message));
                }, Arena.ofAuto());
        
        final var callbackInfoPtr = WGPUBufferMapCallbackInfo.allocate(Arena.ofAuto());
        WGPUBufferMapCallbackInfo.callback(callbackInfoPtr, callbackPtr);

        webgpu_h.wgpuBufferMapAsync(Arena.ofAuto(), this.memorySegment, modes, offset, size, callbackInfoPtr);
    }


	@Override
	public MemorySegment ptr() {
		return this.memorySegment;
	}
}
