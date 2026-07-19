package org.webgpu.impl.spi;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;

import org.jspecify.annotations.NullMarked;

import org.webgpu.api.spi.QueueDescriptorProvider;
import org.webgpu.impl.util.StringViewMapper;
import org.webgpu.panama.WGPUQueueDescriptor;

@NullMarked
public class QueueDescriptorProviderImpl implements QueueDescriptorProvider {
    private final Arena arena = Arena.ofAuto();

    @Override
    public MemorySegment initializer() {
        return WGPUQueueDescriptor.allocate(arena);
    }

    @Override
    public String label(MemorySegment structPtr) {
        return StringViewMapper.map(WGPUQueueDescriptor.label(structPtr));
    }

    @Override
    public void label(MemorySegment structPtr, String label) {
        final MemorySegment labelSegment = StringViewMapper.map(label, arena);
        WGPUQueueDescriptor.label(structPtr, labelSegment);
    }

}
