package org.webgpu.impl.spi;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;

import org.jspecify.annotations.NullMarked;
import org.webgpu.api.BindGroupEntry;
import org.webgpu.api.BindGroupLayout;
import org.webgpu.api.spi.BindGroupDescriptorProvider;
import org.webgpu.impl.BindGroupLayoutImpl;
import org.webgpu.impl.util.StructTools;
import org.webgpu.impl.util.StringViewMapper;
import org.webgpu.panama.WGPUBindGroupEntry;
import org.webgpu.panama.WGPUBindGroupDescriptor;

@NullMarked
public class BindGroupDescriptorProviderImpl implements BindGroupDescriptorProvider {

	private final Arena arena = Arena.ofAuto();

	@Override
	public MemorySegment initializer() {
		return WGPUBindGroupDescriptor.allocate(arena);
	}

	@Override
	public String label(MemorySegment structPtr) {
		return StringViewMapper.map(WGPUBindGroupDescriptor.label(structPtr));
	}

	@SuppressWarnings("null")
	@Override
	public BindGroupLayout layout(MemorySegment structPtr) {
		final MemorySegment layoutPtr = WGPUBindGroupDescriptor.layout(structPtr);

		return new BindGroupLayoutImpl(layoutPtr);
	}

	@Override
	public BindGroupEntry[] entries(MemorySegment structPtr) {
		final long entryCount = WGPUBindGroupDescriptor.entryCount(structPtr);
		final MemorySegment entriesPtr = WGPUBindGroupDescriptor.entries(structPtr);
		if (entriesPtr == null || entriesPtr.equals(MemorySegment.NULL) || entryCount == 0) {
			return new BindGroupEntry[0];
		}

		final var result = new BindGroupEntry[(int) entryCount];
		final var entryProvider = new BindGroupEntryProviderImpl();
		for (int i = 0; i < entryCount; i++) {
			final MemorySegment entryPtr = WGPUBindGroupEntry.asSlice(entriesPtr, i);
			final var entry = new BindGroupEntry();
			entry.binding(entryProvider.binding(entryPtr));
			entry.buffer(entryProvider.buffer(entryPtr));
			entry.offset(entryProvider.offset(entryPtr));
			entry.size(entryProvider.size(entryPtr));
			entry.sampler(entryProvider.sampler(entryPtr));
			entry.textureView(entryProvider.textureView(entryPtr));
			result[i] = entry;
		}
		return result;
	}

	@Override
	public void label(MemorySegment structPtr, String label) {
		WGPUBindGroupDescriptor.label(structPtr, StringViewMapper.map(label, arena));
	}

	@Override
	public void layout(MemorySegment structPtr, BindGroupLayout layout) {
		WGPUBindGroupDescriptor.layout(structPtr, ((BindGroupLayoutImpl) layout).ptr());
	}

	@Override
	public void entries(MemorySegment structPtr, BindGroupEntry[] entries) {
		if (entries == null || entries.length == 0) {
			WGPUBindGroupDescriptor.entries(structPtr, MemorySegment.NULL);
			WGPUBindGroupDescriptor.entryCount(structPtr, 0);
			return;
		}

		final MemorySegment entriesPtr = WGPUBindGroupEntry.allocateArray(entries.length, arena);
		for (int i = 0; i < entries.length; i++) {
			final MemorySegment src = StructTools.fetchSegment(entries[i]);
			final MemorySegment dest = WGPUBindGroupEntry.asSlice(entriesPtr, i);
			MemorySegment.copy(src, 0, dest, 0, WGPUBindGroupEntry.layout().byteSize());
		}

		WGPUBindGroupDescriptor.entries(structPtr, entriesPtr);
		WGPUBindGroupDescriptor.entryCount(structPtr, entries.length);
	}

}
