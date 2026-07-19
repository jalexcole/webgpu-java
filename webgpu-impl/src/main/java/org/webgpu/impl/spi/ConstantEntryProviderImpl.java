package org.webgpu.impl.spi;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;

import org.webgpu.api.spi.ConstantEntryProvider;
import org.webgpu.impl.util.StringViewMapper;
import org.webgpu.panama.WGPUConstantEntry;

/**
 * ConstantEntryProviderImpl
 */
public class ConstantEntryProviderImpl implements ConstantEntryProvider {

    private final Arena arena = Arena.ofAuto();

    @Override
    public MemorySegment initializer() {
        return WGPUConstantEntry.allocate(arena);
    }

    @Override
    public String key(MemorySegment structPtr) {
        return StringViewMapper.map(WGPUConstantEntry.key(structPtr));
    }

    @Override
    public double value(MemorySegment structPtr) {
        return WGPUConstantEntry.value(structPtr);
    }

    @Override
    public void key(MemorySegment structPtr, String key) {
        WGPUConstantEntry.key(structPtr, StringViewMapper.map(key, arena));
    }

    @Override
    public void value(MemorySegment structPtr, double value) {
        WGPUConstantEntry.value(structPtr, value);
    }

}
