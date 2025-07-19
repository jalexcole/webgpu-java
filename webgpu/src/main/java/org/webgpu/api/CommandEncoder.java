package org.webgpu.api;

import static org.webgpu.extract.webgpu_h.wgpuCommandEncoderBeginComputePass;

import java.lang.foreign.MemorySegment;

import org.webgpu.impl.ComputePassEncoderImpl;

public class CommandEncoder {
    private final MemorySegment ptr;

    CommandEncoder(MemorySegment ptr) {
        this.ptr = ptr;
    }

    MemorySegment ptr() {
        return ptr;
    }

    public ComputePassEncoder beginComputePass(ComputePassDescriptor descriptor) {
        return new ComputePassEncoderImpl(wgpuCommandEncoderBeginComputePass(this.ptr, descriptor.ptr()));
    }

}
