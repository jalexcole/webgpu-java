package org.webgpu.impl;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.ValueLayout;
import java.lang.foreign.ValueLayout.OfInt;

import org.jspecify.annotations.NullMarked;
import org.webgpu.api.BindGroup;
import org.webgpu.api.Buffer;
import org.webgpu.api.ComputePassEncoder;
import org.webgpu.api.ComputePipeline;
import org.webgpu.api.exceptions.WGPUException;
import org.webgpu.impl.util.StringViewMapper;
import org.webgpu.panama.webgpu_h;

@NullMarked
public class ComputePassEncoderImpl implements ComputePassEncoder {

    private final MemorySegment memorySegment;

    public ComputePassEncoderImpl(MemorySegment memorySegment) {
        this.memorySegment = memorySegment;
    }

	@Override
	public void insertDebugMarker(String markerLabel) {
		webgpu_h.wgpuComputePassEncoderInsertDebugMarker(this.memorySegment, StringViewMapper.map(markerLabel));
	}

	@Override
	public void popDebugGroup() {
		webgpu_h.wgpuComputePassEncoderPopDebugGroup(this.memorySegment);
	}

	@Override
	public void pushDebugGroup(String groupLabel) {
		webgpu_h.wgpuComputePassEncoderPushDebugGroup(this.memorySegment, StringViewMapper.map(groupLabel));
	}

	@Override
	public void setPipeline(ComputePipeline pipeline) {
		final ComputePipelineImpl computePipelinImpl = (ComputePipelineImpl) pipeline;
		webgpu_h.wgpuComputePassEncoderSetPipeline(this.memorySegment, computePipelinImpl.ptr());
	}

	@Override
	public void setBindGroup(int groupIndex, BindGroup group, int[] dynamicOffsets) {
		final var groupPtr = ((BindGroupImpl) group).ptr();
		final var dynamicOffsetsPtr = Arena.ofAuto().allocateFrom(ValueLayout.JAVA_INT, dynamicOffsets);

		webgpu_h.wgpuComputePassEncoderSetBindGroup(this.memorySegment, groupIndex, groupPtr, groupIndex, dynamicOffsetsPtr);
	}

	@Override
	public void setImmediates(int offset, MemorySegment data, long size) {
		webgpu_h.wgpuComputePassEncoderSetImmediates(this.memorySegment, offset, data, size);
	}

	@Override
	public void dispatchWorkgroups(int workgroupCountX, int workgroupCountY, int workgroupCountZ) {
		webgpu_h.wgpuComputePassEncoderDispatchWorkgroups(this.memorySegment, workgroupCountX, workgroupCountY, workgroupCountZ);
	}

	@Override
	public void dispatchWorkgroupsIndirect(Buffer indirectBuffer, long indirectOffset) {
		webgpu_h.wgpuComputePassEncoderDispatchWorkgroupsIndirect(this.memorySegment, ((BufferImpl) indirectBuffer).ptr(), indirectOffset);
	}

	@Override
	public void end() {
		webgpu_h.wgpuComputePassEncoderEnd(this.memorySegment);
	}

	@Override
	public void setLabel(String label) {
		throw new WGPUException(new UnsupportedOperationException("Unimplemented method 'setLabel'"));
	}
    
}
