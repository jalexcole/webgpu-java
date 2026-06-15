package org.webgpu.hand.spi;

import org.webgpu.api.Instance;
import org.webgpu.api.InstanceDescriptor;
import org.webgpu.api.InstanceBuilder;
import org.webgpu.hand.HandInstance;

public final class DefaultInstanceBuilder extends NativeEntrant implements InstanceBuilder {

    private InstanceDescriptor descriptor = null;

    public DefaultInstanceBuilder() {
    }

     @Override
     public InstanceBuilder descriptor(InstanceDescriptor descriptor) {
          this.descriptor = descriptor;
          return this;
     }

     @Override
     public Instance build() {
          return new HandInstance(descriptor);
     }
}
