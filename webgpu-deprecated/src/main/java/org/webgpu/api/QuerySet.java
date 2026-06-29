package org.webgpu.api;

import java.lang.foreign.MemorySegment;

public interface QuerySet {

    public void destroy();

    public int getCount();

    public QueryType getType();

    public void setLabel(String label);

    public void addRef();

    public void release();

}
