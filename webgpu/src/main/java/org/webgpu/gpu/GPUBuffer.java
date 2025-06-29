package org.webgpu.gpu;

import java.util.concurrent.CompletableFuture;

/**
 * A GPUBuffer represents a block of memory that can be used in GPU operations. 
 * Data is stored in linear layout, meaning that each byte of the allocation 
 * can be addressed by its offset from the start of the GPUBuffer, subject to 
 * alignment restrictions depending on the operation. Some GPUBuffers can be 
 * mapped which makes the block of memory accessible via an ArrayBuffer called 
 * its mapping.
 * 
 * GPUBuffers are created via createBuffer(). Buffers may be mappedAtCreation.
 */
public interface GPUBuffer {
    public void size();

    public void usage();
    public void mapState();

    public CompletableFuture<Void> mapAsync();

    public byte[] getMappedRange(long offset, long size);
    /**
     * Unmaps the mapped range of the GPUBuffer and makes its contents available for use by the GPU again.
     */
    public void unmap();
    public void destroy();
}
