package org.webgpu.impl;

import java.lang.foreign.MemorySegment;
import java.nio.ByteBuffer;

import org.webgpu.api.BindGroup;
import org.webgpu.api.Buffer;
import org.webgpu.api.ComputePassEncoder;
import org.webgpu.api.ComputePipeline;

public class ComputePassEncoderImpl implements ComputePassEncoder {

    private final MemorySegment memorySegment;

    public ComputePassEncoderImpl(MemorySegment memorySegment) {
        this.memorySegment = memorySegment;
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
	public void setPipeline(ComputePipeline pipeline) {
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
	public void dispatchWorkgroups(int workgroupCountX, int workgroupCountY, int workgroupCountZ) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'dispatchWorkgroups'");
	}

	@Override
	public void dispatchWorkgroupsIndirect(Buffer indirectBuffer, long indirectOffset) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'dispatchWorkgroupsIndirect'");
	}

	@Override
	public void end() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'end'");
	}

	@Override
	public void setLabel(String label) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'setLabel'");
	}
    
}
