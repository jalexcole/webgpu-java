package org.webgpu.impl;

import static org.webgpu.panama.foreign.webgpu_h.wgpuComputePassEncoderDispatchWorkgroups;
import static org.webgpu.panama.foreign.webgpu_h.wgpuComputePassEncoderDispatchWorkgroupsIndirect;
import static org.webgpu.panama.foreign.webgpu_h.wgpuComputePassEncoderEnd;
import static org.webgpu.panama.foreign.webgpu_h.wgpuComputePassEncoderSetPipeline;

import java.lang.foreign.MemorySegment;

import org.webgpu.api.Buffer;
import org.webgpu.api.ComputePassEncoder;
import org.webgpu.api.ComputePipeline;

public record ComputePassEncoderImpl(MemorySegment ptr) implements ComputePassEncoder {
    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(ComputePassEncoderImpl.class);
    @Override
    public void setPipeline(ComputePipeline pipeline) {
        wgpuComputePassEncoderSetPipeline(this.ptr, pipeline.ptr());
    }

    @Override
    public void dispatchWorkgroups(int workgroupCountX, int workgroupCountY, int workgroupCountZ) {
        wgpuComputePassEncoderDispatchWorkgroups(this.ptr, workgroupCountX, workgroupCountY, workgroupCountZ);
    }

    @Override
    public void dispatchWorkgroupsIndirect(Buffer indirectBuffer, long indirectOffset) {
        wgpuComputePassEncoderDispatchWorkgroupsIndirect(this.ptr, ((BufferImpl) indirectBuffer).ptr(), indirectOffset);
    }

    @Override
    public void end() {
        wgpuComputePassEncoderEnd(this.ptr);
    }

}
