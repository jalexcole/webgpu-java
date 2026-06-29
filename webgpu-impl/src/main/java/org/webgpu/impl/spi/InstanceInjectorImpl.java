package org.webgpu.impl.spi;

import org.webgpu.api.Instance;
import org.webgpu.api.InstanceDescriptor;
import org.webgpu.api.InstanceFeatureName;
import org.webgpu.api.InstanceLimits;
import org.webgpu.api.Status;
import org.webgpu.api.SupportedInstanceFeatures;
import org.webgpu.api.spi.InstanceInjector;
import org.webgpu.impl.InstanceImpl;

public class InstanceInjectorImpl extends NativeEntrant implements InstanceInjector {
    @Override
    public Instance createInstance(InstanceDescriptor descriptor) {
        descriptor = descriptor == null ? new InstanceDescriptor(new InstanceFeatureName[0], new InstanceLimits(0))
                : descriptor;
        return new InstanceImpl(descriptor);
    }

    @Override
    public void getInstanceFeatures(SupportedInstanceFeatures features) {
        
    }

    @Override
    public Status getInstanceLimits(InstanceLimits limits) {
        return Status.SUCCESS;
    }

    @Override
    public boolean hasInstanceFeature(InstanceFeatureName feature) {
        return false;
    }
}
