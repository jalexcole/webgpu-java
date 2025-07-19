package org.webgpu.api;



public interface Buffer {
    
    public void destroy();

    public BufferMapState getMapState();
    public int getSize();

    public BufferUsage getUsage();
}
