package org.webgpu.impl;

import org.webgpu.api.Adapter;
import org.webgpu.api.AdapterInfo;
import org.webgpu.api.DeviceDescriptor;
import org.webgpu.api.FeatureName;
import org.webgpu.api.Limits;
import org.webgpu.api.Status;
import org.webgpu.api.SupportedFeatures;

public class AdapterImpl implements Adapter{

    @Override
    public Status getLimits(Limits limits) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getLimits'");
    }

    @Override
    public boolean hasFeature(FeatureName feature) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'hasFeature'");
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
