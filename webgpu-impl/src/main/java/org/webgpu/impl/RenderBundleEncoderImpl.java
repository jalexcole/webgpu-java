package org.webgpu.impl;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.ValueLayout;

import org.jspecify.annotations.NullMarked;
import org.webgpu.api.BindGroup;
import org.webgpu.api.Buffer;
import org.webgpu.api.IndexFormat;
import org.webgpu.api.RenderBundle;
import org.webgpu.api.RenderBundleDescriptor;
import org.webgpu.api.RenderBundleEncoder;
import org.webgpu.api.RenderPipeline;
import org.webgpu.api.exceptions.WGPUException;
import org.webgpu.impl.util.StringViewMapper;
import org.webgpu.impl.util.StructTools;
import org.webgpu.panama.webgpu_h;

@NullMarked
public class RenderBundleEncoderImpl implements RenderBundleEncoder {

	private final MemorySegment memorySegment;
	private final Arena arena = Arena.ofAuto();
	
	public RenderBundleEncoderImpl(MemorySegment memorySegment) {
		this.memorySegment = memorySegment;
	}

	@Override
	public void setPipeline(RenderPipeline pipeline) {
		final var pipelinePtr = ((RenderPipelineImpl) pipeline).ptr();
		webgpu_h.wgpuRenderBundleEncoderSetPipeline(this.memorySegment, pipelinePtr);
	}

	@Override
	public void setBindGroup(int groupIndex, BindGroup group, int[] dynamicOffsets) {
		final var groupPtr = ((BindGroupImpl) group).ptr();
		final var dynamicOffsetsPtr = arena.allocateFrom(ValueLayout.JAVA_INT, dynamicOffsets);
		webgpu_h.wgpuRenderBundleEncoderSetBindGroup(this.memorySegment, groupIndex, groupPtr, dynamicOffsets.length, dynamicOffsetsPtr);
	}

	@Override
	public void setImmediates(int offset, MemorySegment data, long size) {
		webgpu_h.wgpuRenderBundleEncoderSetImmediates(this.memorySegment, offset, data, size);
	}

	@Override
	public void draw(int vertexCount, int instanceCount, int firstVertex, int firstInstance) {
		webgpu_h.wgpuRenderBundleEncoderDraw(memorySegment, vertexCount, instanceCount, firstVertex, firstInstance);
	}

	@Override
	public void drawIndexed(int indexCount, int instanceCount, int firstIndex, int baseVertex, int firstInstance) {
		webgpu_h.wgpuRenderBundleEncoderDrawIndexed(memorySegment, indexCount, instanceCount, firstIndex, baseVertex, firstInstance);
	}

	@Override
	public void drawIndirect(Buffer indirectBuffer, long indirectOffset) {
		webgpu_h.wgpuRenderBundleEncoderDrawIndirect(memorySegment, ((BufferImpl) indirectBuffer).ptr(), indirectOffset);
	}

	@Override
	public void drawIndexedIndirect(Buffer indirectBuffer, long indirectOffset) {
		webgpu_h.wgpuRenderBundleEncoderDrawIndexedIndirect(memorySegment, ((BufferImpl) indirectBuffer).ptr(), indirectOffset);
	}

	@Override
	public void insertDebugMarker(String markerLabel) {
		webgpu_h.wgpuRenderBundleEncoderInsertDebugMarker(memorySegment, StringViewMapper.map(markerLabel));
	}

	@Override
	public void popDebugGroup() {
		webgpu_h.wgpuRenderBundleEncoderPopDebugGroup(memorySegment);
	}

	@Override
	public void pushDebugGroup(String groupLabel) {
		webgpu_h.wgpuRenderBundleEncoderPushDebugGroup(memorySegment, StringViewMapper.map(groupLabel));
	}

	@Override
	public void setVertexBuffer(int slot, Buffer buffer, long offset, long size) {
		webgpu_h.wgpuRenderBundleEncoderSetVertexBuffer(memorySegment, slot, ((BufferImpl) buffer).ptr(), offset, size);
	}

	@Override
	public void setIndexBuffer(Buffer buffer, IndexFormat format, long offset, long size) {
		webgpu_h.wgpuRenderBundleEncoderSetIndexBuffer(memorySegment, ((BufferImpl) buffer).ptr(), format.value(), offset, size);
	}

	@Override
	public RenderBundleImpl finish(RenderBundleDescriptor descriptor) {
		final var descriptorPtr = StructTools.fetchSegment(descriptor);
		final var renderBundlePtr = webgpu_h.wgpuRenderBundleEncoderFinish(this.memorySegment, descriptorPtr);
		return new RenderBundleImpl(renderBundlePtr);
	}

	@Override
	public void setLabel(String label) {
		throw new WGPUException(new UnsupportedOperationException("Unimplemented method 'setLabel'"));
	}
    
}
