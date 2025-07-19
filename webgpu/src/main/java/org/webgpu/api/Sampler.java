package org.webgpu.api;

public interface Sampler extends ObjectBase {
    
    public void setLabel(String label);
    
    public void addRef();
    
    public void release();
    
}
