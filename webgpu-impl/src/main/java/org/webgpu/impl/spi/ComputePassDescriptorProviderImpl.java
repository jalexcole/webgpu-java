package org.webgpu.impl.spi;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;

import org.jspecify.annotations.NullMarked;
import org.webgpu.api.PassTimestampWrites;
import org.webgpu.api.spi.ComputePassDescriptorProvider;
import org.webgpu.impl.util.StringViewMapper;
import org.webgpu.impl.util.StructTools;
import org.webgpu.panama.WGPUComputePassDescriptor;

@NullMarked
public class ComputePassDescriptorProviderImpl implements ComputePassDescriptorProvider {

    private final Arena arena = Arena.ofAuto();

    @Override
    public MemorySegment initializer() {
        return WGPUComputePassDescriptor.allocate(arena);
    }

    @Override
    public String label(MemorySegment structPtr) {
        return StringViewMapper.map(WGPUComputePassDescriptor.label(structPtr));
    }

    @Override
    public PassTimestampWrites timestampWrites(MemorySegment structPtr) {
        final var seg = WGPUComputePassDescriptor.timestampWrites(structPtr);        
        return StructTools.placeSegment(seg, PassTimestampWrites.class);
    }

    @Override
    public void label(MemorySegment structPtr, String label) {
        WGPUComputePassDescriptor.label(structPtr, org.webgpu.impl.util.StringViewMapper.map(label, arena));
    }

    @Override
    public void timestampWrites(MemorySegment structPtr, PassTimestampWrites timestampWrites) {
        WGPUComputePassDescriptor.timestampWrites(structPtr, StructTools.fetchSegment(timestampWrites));
    }

}
