package org.webgpu.api;

import static org.webgpu.foreign.webgpu_h.WGPUBool;

import java.lang.foreign.MemorySegment;
import java.util.Optional;

import org.webgpu.foreign.WGPUMultisampleState;
import org.webgpu.foreign.webgpu_h;

public class MultisampleState {
    private final MemorySegment ptr;

    public MultisampleState(MemorySegment ptr) {
        this.ptr = ptr;
    }

    MemorySegment ptr() {
        return ptr;
    }

    public Optional<ChainedStruct> nextInChain() {
        var nextInChainPtr = WGPUMultisampleState.nextInChain(this.ptr);

        if (nextInChainPtr == MemorySegment.NULL || nextInChainPtr == null) {
            return Optional.empty();
        }
        return Optional.of(new ChainedStruct(nextInChainPtr));
    }

    public int count() {
        return WGPUMultisampleState.count(ptr);
    }

    public int mask() {
        return WGPUMultisampleState.mask(ptr);
    }

    public boolean alphaToCoverageEnabled() {
        return switch (WGPUMultisampleState.alphaToCoverageEnabled(ptr)) {
            case 0 -> false;
            case 1 -> true;
            default -> throw new AssertionError();
        }; // WGPUMultisampleState.alphaToCoverageEnabled(ptr);
    }
}
