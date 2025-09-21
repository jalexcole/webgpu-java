package org.webgpu.api;

import org.webgpu.foreign.WGPURequestAdapterCallback;

@FunctionalInterface
public interface RequestAdapterCallback  {
    void apply(Status status, Adapter adapter, String message, Object userdata1, Object userdata2);
}
