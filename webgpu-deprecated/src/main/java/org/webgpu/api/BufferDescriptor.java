package org.webgpu.api;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;
import java.util.Optional;

import org.webgpu.panama.foreign.WGPUBufferDescriptor;

public final class BufferDescriptor implements DescriptorBase {
    private final MemorySegment ptr;

    public BufferDescriptor() {
        try {
            Arena arena = Arena.ofAuto();
            ptr = WGPUBufferDescriptor.allocate(arena);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Optional<ChainedStruct> nextInChain() {
        return Optional.of(new ChainedStruct(WGPUBufferDescriptor.nextInChain(ptr)));
    }

    public String label() {
        throw new UnsupportedOperationException("Unimplemented method 'label'");
    }

    public long usage() {
        return WGPUBufferDescriptor.usage(ptr);
    }

    public long size() {
        return WGPUBufferDescriptor.size(ptr);
    }

    public boolean mappedAtCreation() {
        final var value = WGPUBufferDescriptor.mappedAtCreation(ptr);
        return value == 1;
    }

    public MemorySegment ptr() {
        return ptr;
    }
}
