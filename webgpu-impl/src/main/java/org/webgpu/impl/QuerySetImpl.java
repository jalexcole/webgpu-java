package org.webgpu.impl;

import java.lang.foreign.MemorySegment;

import org.webgpu.api.QuerySet;
import org.webgpu.api.QueryType;

public class QuerySetImpl implements QuerySet {

    private final MemorySegment memorySegment;

    public QuerySetImpl(MemorySegment memorySegment) {
        this.memorySegment = memorySegment;
    }

    @Override
    public void setLabel(String label) {

    }

    @Override
    public QueryType getType() {
        return null;
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public void destroy() {

    }
}
