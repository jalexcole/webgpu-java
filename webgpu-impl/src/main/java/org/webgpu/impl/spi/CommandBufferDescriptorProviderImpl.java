package org.webgpu.impl.spi;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;
import java.util.Objects;

import org.jspecify.annotations.NullMarked;
import org.webgpu.api.spi.CommandBufferDescriptorProvider;
import org.webgpu.impl.util.StringViewMapper;
import org.webgpu.panama.WGPUCommandBufferDescriptor;

@NullMarked
public class CommandBufferDescriptorProviderImpl implements CommandBufferDescriptorProvider{

    @SuppressWarnings("null")
	private final Arena arena = Arena.ofAuto();
	
	@Override
	public MemorySegment initializer() {
        return WGPUCommandBufferDescriptor.allocate(arena);
	}

	@Override
	public String label(MemorySegment structPtr) {
		Objects.requireNonNull(structPtr);
		var stringView = WGPUCommandBufferDescriptor.label(structPtr);
		Objects.requireNonNull(stringView);
        return StringViewMapper.map(stringView);
	}

	@Override
	public void label(MemorySegment structPtr, String label) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'label'");
	}
    
}