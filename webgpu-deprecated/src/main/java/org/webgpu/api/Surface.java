package org.webgpu.api;

import org.webgpu.exceptions.WebGPUException;

public interface Surface {

    public void configure(SurfaceConfiguration config);

    public SurfaceCapabilities getCapabilities(Adapter adapter) throws WebGPUException;

    public SurfaceTexture getCurrentTexture();

    public Status present();

    public void setLabel(String label);

    public void unconfigure();

    public void addRef();

}
