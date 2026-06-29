package org.webgpu.api;

public interface PipelineLayout {

    public void setLabel(String label);

    public void addRef();

    public void release();

}
