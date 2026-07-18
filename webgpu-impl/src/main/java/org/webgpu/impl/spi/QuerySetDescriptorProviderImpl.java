package org.webgpu.impl.spi;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;

import org.webgpu.api.QueryType;
import org.webgpu.api.spi.QuerySetDescriptorProvider;
import org.webgpu.impl.util.StringViewMapper;
import org.webgpu.panama.WGPUQuerySetDescriptor;

/**
 * QuerySetDescriptorProviderImpl
 */
public class QuerySetDescriptorProviderImpl implements QuerySetDescriptorProvider {
    private final Arena arena = Arena.ofAuto();

    @Override
    public MemorySegment initializer() {
        return WGPUQuerySetDescriptor.allocate(arena);
    }

    @Override
    public String label(MemorySegment structPtr) {
        return StringViewMapper.map(WGPUQuerySetDescriptor.label(structPtr));
    }

    @Override
    public QueryType type(MemorySegment structPtr) {
        final int typeValue = WGPUQuerySetDescriptor.type(structPtr);
        return QueryType.values()[typeValue];
    }

    @Override
    public int count(MemorySegment structPtr) {
        return WGPUQuerySetDescriptor.count(structPtr);
    }

    @Override
    public void label(MemorySegment structPtr, String label) {
        try (Arena labelArena = Arena.ofAuto()) {
            final MemorySegment labelSegment = StringViewMapper.map(label, labelArena);
            WGPUQuerySetDescriptor.label(structPtr, labelSegment);
        }
    }

    @Override
    public void type(MemorySegment structPtr, QueryType type) {
        int typeValue = type.value();
        WGPUQuerySetDescriptor.type(structPtr, typeValue);
    }

    @Override
    public void count(MemorySegment structPtr, int count) {
        WGPUQuerySetDescriptor.count(structPtr, count);
    }

}
