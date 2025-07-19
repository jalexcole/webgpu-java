package org.webgpu.api;

public interface RenderPipeline {
    public void setLabel(String label);
    public void addRef();
    public void release();
}
