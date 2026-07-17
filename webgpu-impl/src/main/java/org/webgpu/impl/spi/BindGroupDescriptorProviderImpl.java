package org.webgpu.impl.spi;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;

import org.jspecify.annotations.NullMarked;
import org.webgpu.api.BindGroupEntry;
import org.webgpu.api.BindGroupLayout;
import org.webgpu.api.spi.BindGroupDescriptorProvider;
import org.webgpu.impl.BindGroupLayoutImpl;
import org.webgpu.impl.util.StringViewMapper;
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
		throw new UnsupportedOperationException("Unimplemented method 'entries'");
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
		throw new UnsupportedOperationException("Unimplemented method 'entries'");
	}

    
    
}
