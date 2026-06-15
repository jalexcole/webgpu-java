package org.webgpu.api;

import org.webgpu.api.Instance;
import org.webgpu.api.InstanceDescriptor;

public interface InstanceBuilder {
    InstanceBuilder descriptor(InstanceDescriptor descriptor);
    Instance build();
}
