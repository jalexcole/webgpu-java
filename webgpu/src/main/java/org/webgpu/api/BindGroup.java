package org.webgpu.api;



public interface BindGroup {
    public String label();

    public void setLabel(String label);
    
    public void addRef();

    public void release();

    

}
