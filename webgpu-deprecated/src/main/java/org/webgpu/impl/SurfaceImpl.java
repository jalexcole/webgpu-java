package org.webgpu.impl;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;

import org.webgpu.api.Adapter;
import org.webgpu.api.Status;
import org.webgpu.api.Surface;
import org.webgpu.api.SurfaceCapabilities;
import org.webgpu.api.SurfaceConfiguration;
import org.webgpu.api.SurfaceTexture;
import org.webgpu.api.Texture;
import org.webgpu.api.WGPU;
import org.webgpu.exceptions.WebGPUException;
import org.webgpu.panama.foreign.WGPUSurfaceCapabilities;
import org.webgpu.panama.foreign.webgpu_h;

public record SurfaceImpl(@SuppressWarnings("preview") MemorySegment ptr) implements Surface {
    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(SurfaceImpl.class);
    @Override
    public void configure(SurfaceConfiguration config) {
        webgpu_h.wgpuSurfaceConfigure(ptr, config.ptr());
    }

    @Override
    public SurfaceCapabilities getCapabilities(Adapter adapter) throws WebGPUException {
        Arena arena = Arena.ofAuto();

        var surfaceCapabilitiesPtr = arena.allocate(WGPUSurfaceCapabilities.layout());
        var returnStatus = webgpu_h.wgpuSurfaceGetCapabilities(ptr, ((AdapterImpl) adapter).ptr(),
                surfaceCapabilitiesPtr);

        if (returnStatus != Status.SUCCESS.value()) {
            throw new WebGPUException("Failed to get surface capabilities: " + Status.fromValue(returnStatus));
        }

        throw new UnsupportedOperationException("Unimplemented method 'getCapabilities'");
    }

    @Override
    public SurfaceTexture getCurrentTexture() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getCurrentTexture'");
    }

    @Override
    public Status present() {
        int statusValue = webgpu_h.wgpuSurfacePresent(ptr);
        return Status.fromValue(statusValue);
    }

    @Override
    public void setLabel(String label) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setLabel'");
    }

    @Override
    public void unconfigure() {
        webgpu_h.wgpuSurfaceUnconfigure(ptr);
    }

    @Override
    public void addRef() {
        webgpu_h.wgpuSurfaceAddRef(ptr);
    }

}
