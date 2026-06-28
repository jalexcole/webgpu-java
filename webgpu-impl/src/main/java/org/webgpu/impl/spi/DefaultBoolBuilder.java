package org.webgpu.impl.spi;

import org.webgpu.api.BoolBuilder;
import org.webgpu.api.InstanceFeatureName;

public final class DefaultBoolBuilder extends NativeEntrant implements BoolBuilder {

    private InstanceFeatureName feature;

    public DefaultBoolBuilder() {
    }

    @Override
    public BoolBuilder feature(InstanceFeatureName feature) {
        this.feature = feature;
        return this;
    }

    @Override
    public boolean build() {
        // Default implementation - always return false for now
        return false;
    }
}
