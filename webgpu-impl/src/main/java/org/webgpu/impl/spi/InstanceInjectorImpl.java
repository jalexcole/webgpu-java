package org.webgpu.impl.spi;

import java.lang.foreign.Arena;

import org.webgpu.api.Instance;
import org.webgpu.api.InstanceDescriptor;
import org.webgpu.api.InstanceFeatureName;
import org.webgpu.api.InstanceLimits;
import org.webgpu.api.Status;
import org.webgpu.api.SupportedInstanceFeatures;
import org.webgpu.api.spi.InstanceInjector;
import org.webgpu.impl.InstanceImpl;
import org.webgpu.panama.NativeLibraryLoader;
import org.webgpu.panama.WGPUSupportedInstanceFeatures;
import org.webgpu.panama.webgpu_h;

public class InstanceInjectorImpl implements InstanceInjector {

    static {
        NativeLibraryLoader.loadLibrary();
    }

    @Override
    public Instance createInstance(InstanceDescriptor descriptor) {
        descriptor = descriptor == null ? new InstanceDescriptor(new InstanceFeatureName[0], new InstanceLimits(0))
                : descriptor;
        return new InstanceImpl(descriptor);
    }

    @Override
    public void getInstanceFeatures(SupportedInstanceFeatures features) {
        var featuresSegment = Arena.ofAuto().allocate(WGPUSupportedInstanceFeatures.layout());
        webgpu_h.wgpuGetInstanceFeatures(featuresSegment);
        long size = WGPUSupportedInstanceFeatures.featureCount(featuresSegment);

        for (int i = 0; i < size; i++) {
            
        }
       
        
    }

    @Override
    public Status getInstanceLimits(InstanceLimits limits) {

        return Status.SUCCESS;
    }

    @Override
    public boolean hasInstanceFeature(InstanceFeatureName feature) {
        var result =  webgpu_h.wgpuHasInstanceFeature(feature.value());

        return result == webgpu_h.WGPUOptionalBool_True();
    }
}
