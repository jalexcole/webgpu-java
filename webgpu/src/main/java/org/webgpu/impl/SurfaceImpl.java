package org.webgpu.impl;

import java.lang.foreign.MemorySegment;

import org.webgpu.api.Adapter;
import org.webgpu.api.Status;
import org.webgpu.api.Surface;
import org.webgpu.api.SurfaceCapabilities;
import org.webgpu.api.SurfaceConfiguration;
import org.webgpu.api.Texture;
import org.webgpu.exceptions.WebGPUException;

public record SurfaceImpl(@SuppressWarnings("preview") MemorySegment ptr) implements Surface {

    @Override
    public void configure(SurfaceConfiguration config) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'configure'");
    }

    @Override
    public SurfaceCapabilities getCapabilities(Adapter adapter) throws WebGPUException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getCapabilities'");
    }

    @Override
    public Texture getCurrentTexture() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getCurrentTexture'");
    }

    @Override
    public Status present() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'present'");
    }

    @Override
    public void setLabel(String label) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setLabel'");
    }

    @Override
    public void unconfigure() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'unconfigure'");
    }

    @Override
    public void addRef() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addRef'");
    }
    
}
