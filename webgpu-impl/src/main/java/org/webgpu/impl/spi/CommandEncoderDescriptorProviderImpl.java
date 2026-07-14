package org.webgpu.impl.spi;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;

import org.webgpu.api.spi.CommandEncoderDescriptorProvider;
import org.webgpu.impl.util.StringViewMapper;
import org.webgpu.panama.WGPUCommandEncoderDescriptor;

public class CommandEncoderDescriptorProviderImpl implements CommandEncoderDescriptorProvider {

    private final Arena arena = Arena.ofAuto();

    @Override
    public MemorySegment initializer() {
        return WGPUCommandEncoderDescriptor.allocate(arena);
    }

    @Override
    public String label(MemorySegment structPtr) {
        return StringViewMapper.map(WGPUCommandEncoderDescriptor.label(structPtr));
    }

    @Override
    public void label(MemorySegment structPtr, String label) {
        WGPUCommandEncoderDescriptor.label(structPtr, StringViewMapper.map(label, arena));
    }
}
