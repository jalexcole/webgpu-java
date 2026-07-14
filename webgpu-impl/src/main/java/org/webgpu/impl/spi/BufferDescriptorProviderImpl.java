package org.webgpu.impl.spi;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;
import java.util.EnumSet;
import java.util.Set;

import org.webgpu.api.BufferUsage;
import org.webgpu.api.spi.BufferDescriptorProvider;
import org.webgpu.impl.util.StringViewMapper;
import org.webgpu.panama.WGPUBufferDescriptor;
import org.webgpu.panama.webgpu_h;

public class BufferDescriptorProviderImpl implements BufferDescriptorProvider {

    private final Arena arena = Arena.ofAuto();
	@Override
	public MemorySegment initializer() {
        return WGPUBufferDescriptor.allocate(arena);
	}

	@Override
	public String label(MemorySegment structPtr) {
        var stringView = WGPUBufferDescriptor.label(structPtr);
        return StringViewMapper.map(stringView);
	}

	@Override
	public EnumSet<BufferUsage> usage(MemorySegment structPtr) {
		throw new UnsupportedOperationException("Unimplemented method 'usage'");
	}

	@Override
	public long size(MemorySegment structPtr) {
        return WGPUBufferDescriptor.size(structPtr);
	}

	@Override
	public boolean mappedAtCreation(MemorySegment structPtr) {
        return WGPUBufferDescriptor.mappedAtCreation(structPtr) == webgpu_h.WGPU_TRUE();
	}

	@Override
	public void label(MemorySegment structPtr, String label) {
		WGPUBufferDescriptor.label(structPtr, StringViewMapper.map(label, arena));
	}

	@Override
	public void usage(MemorySegment structPtr, Set<BufferUsage> usage) {
		throw new UnsupportedOperationException("Unimplemented method 'usage'");
	}

	@Override
	public void size(MemorySegment structPtr, long size) {
		WGPUBufferDescriptor.size(structPtr, size);
	}

	@Override
	public void mappedAtCreation(MemorySegment structPtr, boolean mappedAtCreation) {
		final int bool;
		if (mappedAtCreation) {
			bool = webgpu_h.WGPU_TRUE();
		} else {
			bool = webgpu_h.WGPU_FALSE();
		}
		WGPUBufferDescriptor.mappedAtCreation(structPtr, bool);
	}
}