package org.webgpu.impl;

import java.lang.foreign.MemorySegment;

import org.jspecify.annotations.NullMarked;
import org.webgpu.api.QuerySet;
import org.webgpu.api.QueryType;
import org.webgpu.api.exceptions.WGPUException;
import org.webgpu.panama.webgpu_h;

@NullMarked
public final class QuerySetImpl implements QuerySet, WebGPUObjectImpl {

    private final MemorySegment memorySegment;

    public QuerySetImpl(MemorySegment memorySegment) {
        this.memorySegment = memorySegment;
    }

    @Override
    public void setLabel(String label) {
        throw new WGPUException(new UnsupportedOperationException());
    }

    @Override
    public QueryType getType() {
        final int queryType = webgpu_h.wgpuQuerySetGetType(memorySegment);
        return QueryType.values()[queryType];
    }

    @Override
    public int getCount() {
        return webgpu_h.wgpuQuerySetGetCount(memorySegment);
    }

    @Override
    public void destroy() {
        webgpu_h.wgpuQuerySetDestroy(memorySegment);
    }

    @Override
    public MemorySegment ptr() {
        return this.memorySegment;
    }
}
