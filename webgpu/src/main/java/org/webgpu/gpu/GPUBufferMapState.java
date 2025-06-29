package org.webgpu.gpu;

public enum GPUBufferMapState {
    /** The buffer is not mapped for use by this.getMappedRange(). */
    UNMAPPED,
    /**
     * A mapping of the buffer has been requested, but is pending. It may succeed,
     * or fail validation in mapAsync().
     */
    PENDING,
    /** The buffer is mapped and this.getMappedRange() may be used. */
    MAPPED
}
