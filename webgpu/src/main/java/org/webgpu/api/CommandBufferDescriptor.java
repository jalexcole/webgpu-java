package org.webgpu.api;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;
import java.util.Optional;

import org.webgpu.foreign.WGPUCommandBufferDescriptor;
import org.webgpu.util.StringView;

public final class CommandBufferDescriptor implements DescriptorBase {

    private MemorySegment ptr;

	public MemorySegment ptr() {
        return ptr;
    }

    public CommandBufferDescriptor() {
        Arena arena = Arena.ofAuto();
        ptr = WGPUCommandBufferDescriptor.allocate(arena);
    }

    public String label() {
        return new StringView(WGPUCommandBufferDescriptor.label(ptr)).toString();
    }

    public void setLabel(String label) {
        try (Arena arena = Arena.ofConfined()) {
            var stringView = StringView.of(arena, label);
            WGPUCommandBufferDescriptor.label(ptr, stringView);
        }
    }

    public Optional<ChainedStruct> nextInChain() {
        return Optional.of(new ChainedStruct(WGPUCommandBufferDescriptor.nextInChain(ptr)));
    }
}
