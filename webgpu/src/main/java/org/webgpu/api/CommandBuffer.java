package org.webgpu.api;



public interface CommandBuffer {

    public void setLabel(String label);

    public void addRef();

    public void release();

}
