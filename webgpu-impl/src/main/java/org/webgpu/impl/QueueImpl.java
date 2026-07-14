package org.webgpu.impl;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.ValueLayout;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.List;

import org.jspecify.annotations.NullMarked;
import org.webgpu.api.Buffer;
import org.webgpu.api.CommandBuffer;
import org.webgpu.api.Extent3D;
import org.webgpu.api.Queue;
import org.webgpu.api.QueueWorkDone;
import org.webgpu.api.TexelCopyBufferLayout;
import org.webgpu.api.TexelCopyTextureInfo;
import org.webgpu.panama.webgpu_h;

@NullMarked
public class QueueImpl implements Queue {
    
	private final MemorySegment memorySegment;
	
	private final Arena arena = Arena.ofAuto();
    public QueueImpl(MemorySegment memorySegment) {
        this.memorySegment = memorySegment;
    }

	@Override
	public void submit(CommandBuffer[] commands) {
		
		final List<MemorySegment> pointers = Arrays.stream((CommandBufferImpl[]) commands).map(CommandBufferImpl::ptr).toList();
		
		try (Arena arena = Arena.ofConfined()) {
    		final MemorySegment commandArray = arena.allocate(
				ValueLayout.ADDRESS, pointers.size());

    		for (int i = 0; i < pointers.size(); i++) {
        			commandArray.setAtIndex(ValueLayout.ADDRESS, i, pointers.get(i));
					webgpu_h.wgpuQueueSubmit(memorySegment, commands.length, commandArray);
    		}
		}
	}

	@Override
	public void writeBuffer(Buffer buffer, long bufferOffset, MemorySegment data, long size) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'writeBuffer'");
	}

	@Override
	public void writeTexture(TexelCopyTextureInfo destination, 
			MemorySegment data, long dataSize,
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
