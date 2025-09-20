package org.webgpu.api;



public interface Buffer {
    
    public void destroy();

    public BufferMapState getMapState();
    
    public long getSize();

    public BufferUsage getUsage();

    public void unmap();
    
}
