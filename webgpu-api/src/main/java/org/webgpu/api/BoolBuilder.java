package org.webgpu.api;

import org.webgpu.api.InstanceFeatureName;

public interface BoolBuilder {
    public BoolBuilder feature(InstanceFeatureName instanceFeatureName);
    public boolean build();
}
