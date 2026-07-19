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
import java.util.Set;

@NullMarked
public final class BufferImpl implements Buffer, WebGPUObjectImpl {

    private final MemorySegment memorySegment;
    private final Arena callbackArena = Arena.ofShared();
    private boolean destroyed = false;

    public BufferImpl(MemorySegment memorySegment) {
        this.memorySegment = memorySegment;
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
        throw new WGPUException(
                new UnsupportedOperationException("WGPU Does not support setting labels on buffers yet."));
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
        final var callbackPtr = WGPUBufferMapCallback.allocate(
                (int status, MemorySegment message, MemorySegment userdata1, MemorySegment userdata2) -> callback
                        .apply(MapAsyncStatus.values()[status],
                                message == MemorySegment.NULL ? "" : StringViewMapper.map(message)),
                callbackArena);

        final var callbackInfoPtr = WGPUBufferMapCallbackInfo.allocate(callbackArena);
        WGPUBufferMapCallbackInfo.callback(callbackInfoPtr, callbackPtr);
        WGPUBufferMapCallbackInfo.nextInChain(callbackInfoPtr, MemorySegment.NULL);
        WGPUBufferMapCallbackInfo.mode(callbackInfoPtr, CallbackMode.ALLOW_SPONTANEOUS.value());
        WGPUBufferMapCallbackInfo.userdata1(callbackInfoPtr, MemorySegment.NULL);
        WGPUBufferMapCallbackInfo.userdata2(callbackInfoPtr, MemorySegment.NULL);

        webgpu_h.wgpuBufferMapAsync(callbackArena, this.memorySegment, modes, offset, size, callbackInfoPtr);
    }

    @Override
    public MemorySegment ptr() {
        return this.memorySegment;
    }
}
