package org.webgpu.api;

import java.lang.foreign.MemorySegment;

public interface RenderBundle {
    public void setLabel(String label);

    public void addRef();

    public void release();
}
