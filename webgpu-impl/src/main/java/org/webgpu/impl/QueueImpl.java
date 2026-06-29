package org.webgpu.impl;

import java.lang.foreign.MemorySegment;

import org.webgpu.api.Buffer;
import org.webgpu.api.CommandBuffer;
import org.webgpu.api.Extent3D;
import org.webgpu.api.Queue;
import org.webgpu.api.TexelCopyBufferLayout;
import org.webgpu.api.TexelCopyTextureInfo;

public class QueueImpl implements Queue {
    
    private final MemorySegment memorySegment;

    public QueueImpl(MemorySegment memorySegment) {
        this.memorySegment = memorySegment;
    }

	@Override
	public void submit(CommandBuffer[] commands) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'submit'");
	}

	@Override
	public void onSubmittedWorkDone() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'onSubmittedWorkDone'");
	}

	@Override
	public void writeBuffer(Buffer buffer, long bufferOffset, MemorySegment data, long size) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'writeBuffer'");
	}

	@Override
	public void writeTexture(TexelCopyTextureInfo destination, MemorySegment data, long dataSize,
			TexelCopyBufferLayout dataLayout, Extent3D writeSize) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'writeTexture'");
	}

	@Override
	public void setLabel(String label) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'setLabel'");
	}
    
}
