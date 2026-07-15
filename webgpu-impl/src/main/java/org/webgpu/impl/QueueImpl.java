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
import org.webgpu.api.QueueWorkDoneStatus;
import org.webgpu.api.TexelCopyBufferLayout;
import org.webgpu.api.TexelCopyTextureInfo;
import org.webgpu.api.exceptions.WGPUException;
import org.webgpu.impl.util.ObjectUtils;
import org.webgpu.impl.util.StringViewMapper;
import org.webgpu.impl.util.StructTools;
import org.webgpu.panama.WGPUQueueWorkDoneCallback;
import org.webgpu.panama.WGPUQueueWorkDoneCallbackInfo;
import org.webgpu.panama.webgpu_h;

@NullMarked
public class QueueImpl implements Queue {
    
	private final MemorySegment memorySegment;
	
    public QueueImpl(MemorySegment memorySegment) {
        this.memorySegment = memorySegment;
    }

	@Override
	public void submit(CommandBuffer[] commands) {
		try (Arena arena = Arena.ofConfined()) {
			final var commandArray = ObjectUtils.mapArray(commands, arena);
			webgpu_h.wgpuQueueSubmit(memorySegment, commands.length, commandArray);
		}
	}

	@Override
	public void writeBuffer(Buffer buffer, long bufferOffset, MemorySegment data, long size) {
		final MemorySegment bufferPtr = ((BufferImpl) buffer).ptr();

		webgpu_h.wgpuQueueWriteBuffer(this.memorySegment, bufferPtr, bufferOffset, data, size);
	}

	@Override
	public void writeTexture(TexelCopyTextureInfo destination, 
			MemorySegment data, long dataSize,
			TexelCopyBufferLayout dataLayout, Extent3D writeSize) {
		final MemorySegment destinationPtr = StructTools.fetchSegment(destination);
		final MemorySegment dataLayoutPtr = StructTools.fetchSegment(dataLayout);
		final MemorySegment writeSizePtr = StructTools.fetchSegment(writeSize);

		webgpu_h.wgpuQueueWriteTexture(this.memorySegment, destinationPtr, data, dataSize, dataLayoutPtr, writeSizePtr);
	}

	@Override
	public void setLabel(String label) {
		throw new WGPUException(new UnsupportedOperationException("Unimplemented method 'setLabel'"));
	}

	@Override
	public void onSubmittedWorkDone(QueueWorkDone callback) {

		final MemorySegment info = WGPUQueueWorkDoneCallbackInfo.allocate(Arena.ofAuto());

		final var qwdc = WGPUQueueWorkDoneCallback
				.allocate((int status, MemorySegment message, MemorySegment userdata1, MemorySegment userdata2) -> {
					callback.apply(QueueWorkDoneStatus.values()[status], StringViewMapper.map(message));
		}, Arena.ofAuto());
		WGPUQueueWorkDoneCallbackInfo.callback(info, qwdc);
		
		webgpu_h.wgpuQueueOnSubmittedWorkDone(Arena.ofAuto(), this.memorySegment, info);
	}
    
}
