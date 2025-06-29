package org.webgpu.gpu;

import java.util.Optional;

public interface GPURenderBundleEncoder {
    public GPURenderBundle finish(Optional<GPURenderBundleDescriptor> descriptor);
}
