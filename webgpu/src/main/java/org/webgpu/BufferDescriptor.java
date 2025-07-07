package org.webgpu;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;
import java.util.Optional;

import org.webgpu.extract.WGPUBufferDescriptor;

public class BufferDescriptor {
    private MemorySegment descriptorPtr;

    // public Optional<String> label() {

    // }

    public BufferDescriptor() {
        try (Arena arena = Arena.ofConfined()) {
            descriptorPtr = WGPUBufferDescriptor.allocate(arena);
        }
    }

    public Optional<ChainedStruct> nextInChain() {
        return Optional.of(new ChainedStruct(WGPUBufferDescriptor.nextInChain(descriptorPtr)));
    }

    public String label() {
        throw new UnsupportedOperationException("Unimplemented method 'label'");
    }

    public long usage() {
        throw new UnsupportedOperationException("Unimplemented method 'usage'");
    }

    public long size() {
        throw new UnsupportedOperationException("Unimplemented method 'size'");
    }

    public int mappedAtCreation() {
        throw new UnsupportedOperationException("Unimplemented method 'mappedAtCreation'");
    }

    public MemorySegment ptr() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'ptr'");
    }
}
