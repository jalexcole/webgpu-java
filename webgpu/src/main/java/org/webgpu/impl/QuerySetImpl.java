package org.webgpu.impl;

import java.lang.foreign.MemorySegment;

import org.webgpu.api.QuerySet;
import org.webgpu.api.QueryType;
import org.webgpu.panama.foreign.webgpu_h;

public record QuerySetImpl(MemorySegment ptr) implements QuerySet {

    @Override
    public void destroy() {
        webgpu_h.wgpuQuerySetRelease(ptr);
    }

    @Override
    public int getCount() {
        return webgpu_h.wgpuQuerySetGetCount(ptr);
    }

    @Override
    public QueryType getType() {
        int queryTypeValue = webgpu_h.wgpuQuerySetGetType(ptr);
        return QueryType.fromValue(queryTypeValue);
    }

    @Override
    public void setLabel(String label) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setLabel'");
    }

    @Override
    public void addRef() {
        webgpu_h.wgpuQuerySetAddRef(ptr);
    }

    @Override
    public void release() {
        webgpu_h.wgpuQuerySetRelease(ptr);
    }

}
