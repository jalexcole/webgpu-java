package org.webgpu.gpu;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;

/**
 * A GPUAdapter encapsulates an adapter, and describes its capabilities
 * (features and limits).
 * 
 * To get a GPUAdapter, use requestAdapter().
 */
public interface GPUAdapter {
    /**
     * Requests a device from the adapter.
     * 
     * This is a one-time action: if a device is returned successfully, the adapter
     * becomes "consumed".
     * 
     * @param descriptor Description of the GPUDevice to request.
     * @return
     * 
     * Content timeline steps:
     * 
     * 1. Let contentTimeline be the current Content timeline.
     * 2. Let promise be a new promise.
     * 3. Let adapter be this.[[adapter]].
     * 4. Issue the initialization steps to the Device timeline of this.
     * 5. Return promise.
     */
    public CompletableFuture<GPUDevice> requestDevice(Optional<GPUDeviceDescriptor> descriptor);
}
