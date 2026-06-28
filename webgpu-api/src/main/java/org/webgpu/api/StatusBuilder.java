package org.webgpu.api;

import org.webgpu.api.InstanceLimits;
import org.webgpu.api.Status;

public interface StatusBuilder {

    StatusBuilder limits(InstanceLimits limits);

    Status build();
    
}
