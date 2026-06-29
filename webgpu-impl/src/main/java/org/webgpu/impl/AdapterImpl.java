package org.webgpu.impl;

import java.lang.foreign.MemorySegment;

import org.webgpu.api.Adapter;
import org.webgpu.api.AdapterInfo;
import org.webgpu.api.DeviceDescriptor;
import org.webgpu.api.FeatureName;
import org.webgpu.api.Limits;
import org.webgpu.api.Status;
import org.webgpu.api.SupportedFeatures;
import org.webgpu.panama.webgpu_h;

public class AdapterImpl implements Adapter {
    
    private final MemorySegment memorySegment;

    public AdapterImpl(MemorySegment memorySegment) {
        this.memorySegment = memorySegment;
    }

    @Override
    public Status getLimits(Limits limits) {


        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getLimits'");
    }

    @Override
    public boolean hasFeature(FeatureName feature) {
        return webgpu_h.wgpuAdapterHasFeature(this.memorySegment, feature.value()) == webgpu_h.WGPUOptionalBool_True();
    }

    @Override
    public void getFeatures(SupportedFeatures features) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getFeatures'");
    }

    @Override
    public Status getInfo(AdapterInfo info) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getInfo'");
    }

    @Override
    public void requestDevice(DeviceDescriptor descriptor) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'requestDevice'");
    }
    
}
