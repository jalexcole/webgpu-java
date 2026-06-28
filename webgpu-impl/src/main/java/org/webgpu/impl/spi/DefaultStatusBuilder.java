package org.webgpu.impl.spi;

import org.webgpu.api.InstanceLimits;
import org.webgpu.api.Status;
import org.webgpu.api.StatusBuilder;

public final class DefaultStatusBuilder extends NativeEntrant implements StatusBuilder {

    private InstanceLimits limits;

    public DefaultStatusBuilder() {
    }

    @Override
    public StatusBuilder limits(InstanceLimits limits) {
        this.limits = limits;
        return this;
    }

    @Override
    public Status build() {
        // Default implementation - return a success status
        return Status.SUCCESS;
    }
}
