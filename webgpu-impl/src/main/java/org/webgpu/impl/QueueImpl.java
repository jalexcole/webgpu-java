package org.webgpu.impl;

import java.lang.foreign.MemorySegment;
import java.nio.ByteBuffer;

import org.webgpu.api.Buffer;
import org.webgpu.api.CommandBuffer;
import org.webgpu.api.Extent3D;
import org.webgpu.api.Queue;
import org.webgpu.api.QueueWorkDone;
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

	
	public void onSubmittedWorkDone() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'onSubmittedWorkDone'");
	}

	@Override
	public void writeBuffer(Buffer buffer, long bufferOffset, ByteBuffer data, long size) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'writeBuffer'");
	}

	@Override
	public void writeTexture(TexelCopyTextureInfo destination, ByteBuffer data, long dataSize,
			TexelCopyBufferLayout dataLayout, Extent3D writeSize) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'writeTexture'");
	}

	@Override
	public void setLabel(String label) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'setLabel'");
	}

	@Override
	public void onSubmittedWorkDone(QueueWorkDone callback) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'onSubmittedWorkDone'");
	}
    
}
