package org.webgpu.impl;

import java.lang.foreign.MemorySegment;
import java.nio.ByteBuffer;

import org.webgpu.api.BindGroup;
import org.webgpu.api.Buffer;
import org.webgpu.api.IndexFormat;
import org.webgpu.api.RenderBundle;
import org.webgpu.api.RenderBundleDescriptor;
import org.webgpu.api.RenderBundleEncoder;
import org.webgpu.api.RenderPipeline;

public class RenderBundleEncoderImpl implements RenderBundleEncoder {

	private final MemorySegment memorySegment;
	
	public RenderBundleEncoderImpl(MemorySegment memorySegment) {
		this.memorySegment = memorySegment;
	}

	@Override
	public void setPipeline(RenderPipeline pipeline) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'setPipeline'");
	}

	@Override
	public void setBindGroup(int groupIndex, BindGroup group, int[] dynamicOffsets) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'setBindGroup'");
	}

	@Override
	public void setImmediates(int offset, ByteBuffer data, long size) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'setImmediates'");
	}

	@Override
	public void draw(int vertexCount, int instanceCount, int firstVertex, int firstInstance) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'draw'");
	}

	@Override
	public void drawIndexed(int indexCount, int instanceCount, int firstIndex, int baseVertex, int firstInstance) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'drawIndexed'");
	}

	@Override
	public void drawIndirect(Buffer indirectBuffer, long indirectOffset) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'drawIndirect'");
	}

	@Override
	public void drawIndexedIndirect(Buffer indirectBuffer, long indirectOffset) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'drawIndexedIndirect'");
	}

	@Override
	public void insertDebugMarker(String markerLabel) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'insertDebugMarker'");
	}

	@Override
	public void popDebugGroup() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'popDebugGroup'");
	}

	@Override
	public void pushDebugGroup(String groupLabel) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'pushDebugGroup'");
	}

	@Override
	public void setVertexBuffer(int slot, Buffer buffer, long offset, long size) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'setVertexBuffer'");
	}

	@Override
	public void setIndexBuffer(Buffer buffer, IndexFormat format, long offset, long size) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'setIndexBuffer'");
	}

	@Override
	public RenderBundle finish(RenderBundleDescriptor descriptor) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'finish'");
	}

	@Override
	public void setLabel(String label) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'setLabel'");
	}
    
}
