package org.webgpu.api.spi;

import org.webgpu.api.Instance;
import org.webgpu.api.InstanceDescriptor;
import org.webgpu.api.InstanceFeatureName;
import org.webgpu.api.InstanceLimits;
import org.webgpu.api.Status;
import org.webgpu.api.SupportedInstanceFeatures;

public interface InstanceInjector {
    
    public Instance createInstance(InstanceDescriptor descriptor);

    public void getInstanceFeatures(SupportedInstanceFeatures features);
    
    public Status getInstanceLimits(InstanceLimits limits);

    public boolean hasInstanceFeature(InstanceFeatureName feature);
}
