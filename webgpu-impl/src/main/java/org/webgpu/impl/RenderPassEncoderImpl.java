package org.webgpu.impl;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.ValueLayout;


import org.webgpu.api.BindGroup;
import org.webgpu.api.Buffer;
import org.webgpu.api.Color;
import org.webgpu.api.IndexFormat;
import org.webgpu.api.RenderBundle;
import org.webgpu.api.RenderPassEncoder;
import org.webgpu.api.RenderPipeline;
import org.webgpu.impl.util.StringViewMapper;
import org.webgpu.impl.util.StructTools;
import org.webgpu.panama.webgpu_h;

public class RenderPassEncoderImpl implements RenderPassEncoder {

	private final MemorySegment memorySegment;
	private final Arena arena = Arena.ofAuto();
	
	public RenderPassEncoderImpl(MemorySegment memorySegment) {
		this.memorySegment = memorySegment;
	}

	@Override
	public void setPipeline(RenderPipeline pipeline) {
		webgpu_h.wgpuRenderPassEncoderSetPipeline(memorySegment, ((RenderPipelineImpl) pipeline).ptr());
	}

	@Override
	public void setBindGroup(int groupIndex, BindGroup group, int[] dynamicOffsets) {
		
		final MemorySegment dynamicOffsetsSegment = arena.allocateFrom(ValueLayout.JAVA_INT, dynamicOffsets);
		final MemorySegment groupPointer = ((BindGroupImpl) group).ptr();

		webgpu_h.wgpuRenderPassEncoderSetBindGroup(this.memorySegment, groupIndex, groupPointer, dynamicOffsets.length, dynamicOffsetsSegment);
		
	}

	@Override
	public void setImmediates(int offset, MemorySegment data, long size) {
		webgpu_h.wgpuRenderPassEncoderSetImmediates(memorySegment, offset, data, size);
	}

	@Override
	public void draw(int vertexCount, int instanceCount, int firstVertex, int firstInstance) {
		webgpu_h.wgpuRenderPassEncoderDraw(memorySegment, vertexCount, instanceCount, firstVertex, firstInstance);
	}

	@Override
	public void drawIndexed(int indexCount, int instanceCount, int firstIndex, int baseVertex, int firstInstance) {
		webgpu_h.wgpuRenderPassEncoderDrawIndexed(memorySegment, indexCount, instanceCount, firstIndex, baseVertex, firstInstance);
	}

	@Override
	public void drawIndirect(Buffer indirectBuffer, long indirectOffset) {
		final BufferImpl bufferImpl = (BufferImpl) indirectBuffer;
		webgpu_h.wgpuRenderPassEncoderDrawIndirect(memorySegment, bufferImpl.ptr(), indirectOffset);
	}

	@Override
	public void drawIndexedIndirect(Buffer indirectBuffer, long indirectOffset) {
		final BufferImpl bufferImpl = (BufferImpl) indirectBuffer;
		webgpu_h.wgpuRenderPassEncoderDrawIndexedIndirect(memorySegment, bufferImpl.ptr(), indirectOffset);
	}

	@Override
	public void executeBundles(RenderBundle[] bundles) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'executeBundles'");
	}

	@Override
	public void insertDebugMarker(String markerLabel) {
		webgpu_h.wgpuRenderPassEncoderInsertDebugMarker(this.memorySegment, StringViewMapper.map(markerLabel));
	}

	@Override
	public void popDebugGroup() {
		webgpu_h.wgpuRenderPassEncoderPopDebugGroup(this.memorySegment);
	}

	@Override
	public void pushDebugGroup(String groupLabel) {
		webgpu_h.wgpuRenderPassEncoderPushDebugGroup(this.memorySegment, StringViewMapper.map(groupLabel));
	}

	@Override
	public void setStencilReference(int reference) {
		webgpu_h.wgpuRenderPassEncoderSetStencilReference(this.memorySegment, reference);
	}

	@Override
	public void setBlendConstant(Color color) {
		final MemorySegment colorPointer = StructTools.fetchSegment(color);
		webgpu_h.wgpuRenderPassEncoderSetBlendConstant(this.memorySegment, colorPointer);
	}

	@Override
	public void setViewport(float x, float y, float width, float height, float minDepth, float maxDepth) {
		webgpu_h.wgpuRenderPassEncoderSetViewport(this.memorySegment, x, y, width, height, minDepth, maxDepth);
	}

	@Override
	public void setScissorRect(int x, int y, int width, int height) {
		webgpu_h.wgpuRenderPassEncoderSetScissorRect(this.memorySegment, x, y, width, height);
	}

	@Override
	public void setVertexBuffer(int slot, Buffer buffer, long offset, long size) {
		webgpu_h.wgpuRenderPassEncoderSetVertexBuffer(this.memorySegment, slot, ((BufferImpl) buffer).ptr(), offset, size);
	}

	@Override
	public void setIndexBuffer(Buffer buffer, IndexFormat format, long offset, long size) {
		final BufferImpl bufferImpl = (BufferImpl) buffer;
		final int indexFormat = format.value();

		webgpu_h.wgpuRenderPassEncoderSetIndexBuffer(memorySegment, bufferImpl.ptr(), indexFormat, offset, size);
	}

	@Override
	public void beginOcclusionQuery(int queryIndex) {
		webgpu_h.wgpuRenderPassEncoderBeginOcclusionQuery(memorySegment, queryIndex);
	}

	@Override
	public void endOcclusionQuery() {
		webgpu_h.wgpuRenderPassEncoderEndOcclusionQuery(memorySegment);
	}

	@Override
	public void end() {
		webgpu_h.wgpuRenderPassEncoderEnd(memorySegment);
	}

	@Override
	public void setLabel(String label) {
		throw new UnsupportedOperationException("Unimplemented method 'setLabel'");
	}
    
}
