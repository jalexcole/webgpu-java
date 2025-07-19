package org.webgpu.api;

public interface Texture extends ObjectBase {

    public TextureView createView(TextureViewDescriptor descriptor);

    public void destroy();

    public int getDepthOrArrayLayers();

    public int getDimension();

    public TextureFormat getFormat();

    public int getHeight();

    public int getMipLevelCount();

    public int getSampleCount();

    public TextureUsage getUsage();

    public int getWidth();

    public void setLabel(String label);

    public void addRef();

    public void release();
}
