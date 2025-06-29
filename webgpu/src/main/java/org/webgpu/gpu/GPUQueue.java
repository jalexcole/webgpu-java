package org.webgpu.gpu;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

public interface GPUQueue extends GPUObjectBase {
    public Object submit(List<GPUCommandBuffer> commandBuffers);

    public CompletableFuture<Object> onSubmittedWorkDone();

    public Object writeBuffer(
            GPUBuffer buffer,
            long bufferOffset,
            AllowSharedBufferSource data,
            Optional<Long> dataOffset,
            Optional<Long> size);

    Object writeTexture(
            GPUTexelCopyTextureInfo destination,
            AllowSharedBufferSource data,
            GPUTexelCopyBufferLayout dataLayout,
            GPUExtent3D size);

    Object copyExternalImageToTexture(
            GPUCopyExternalImageSourceInfo source,
            GPUCopyExternalImageDestInfo destination,
            GPUExtent3D copySize);
}
