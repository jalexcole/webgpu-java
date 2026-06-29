package org.webgpu.impl;

import java.lang.foreign.MemorySegment;

import org.webgpu.api.FutureWaitInfo;
import org.webgpu.api.Instance;
import org.webgpu.api.InstanceDescriptor;
import org.webgpu.api.RequestAdapterOptions;
import org.webgpu.api.SupportedWGSLLanguageFeatures;
import org.webgpu.api.Surface;
import org.webgpu.api.SurfaceDescriptor;
import org.webgpu.api.WGSLLanguageFeatureName;
import org.webgpu.api.WaitStatus;
import org.webgpu.impl.util.InstanceDescriptorMapper;
import org.webgpu.panama.webgpu_h;

public class InstanceImpl implements Instance {

    private final MemorySegment memorySegment;

    public InstanceImpl(InstanceDescriptor descriptor) {
        this.memorySegment = webgpu_h.wgpuCreateInstance(InstanceDescriptorMapper.map(descriptor));
    }

    @Override
    public Surface createSurface(SurfaceDescriptor descriptor) {
        throw new UnsupportedOperationException("Unimplemented method 'createSurface'");
    }

    @Override
    public void getWGSLLanguageFeatures(SupportedWGSLLanguageFeatures features) {
        throw new UnsupportedOperationException("Unimplemented method 'getWGSLLanguageFeatures'");
    }

    @Override
    public boolean hasWGSLLanguageFeature(WGSLLanguageFeatureName feature) {
        throw new UnsupportedOperationException("Unimplemented method 'hasWGSLLanguageFeature'");
    }

    @Override
    public void processEvents() {
        throw new UnsupportedOperationException("Unimplemented method 'processEvents'");
    }

    @Override
    public void requestAdapter(RequestAdapterOptions options) {
        throw new UnsupportedOperationException("Unimplemented method 'requestAdapter'");
    }

    @Override
    public WaitStatus waitAny(long futureCount, FutureWaitInfo futures, long timeoutNS) {
        throw new UnsupportedOperationException("Unimplemented method 'waitAny'");
    }
    
}
