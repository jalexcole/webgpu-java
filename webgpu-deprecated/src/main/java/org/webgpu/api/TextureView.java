package org.webgpu.api;

public interface TextureView extends ObjectBase {

    public void setLabel(String label);


    public void addRef();
    
    public void release();
}
