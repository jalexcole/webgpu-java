package org.webgpu.api;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;
import java.util.Optional;

import org.webgpu.panama.foreign.WGPUDeviceDescriptor;
import org.webgpu.util.StringView;

public class DeviceDescriptor {
    private MemorySegment ptr;

    public DeviceDescriptor() {
        try {
            Arena arena = Arena.ofAuto();
            ptr = WGPUDeviceDescriptor.allocate(arena);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Optional<ChainedStruct> nextInChain() {

        return Optional.of(new ChainedStruct(WGPUDeviceDescriptor.nextInChain(ptr)));
    }

    public String label() {
        return StringView.map(WGPUDeviceDescriptor.label(ptr));
    }

    public void setLabel(String label) {
        try (Arena arena = Arena.ofConfined()) {
            var stringView = StringView.of(arena, label);
            WGPUDeviceDescriptor.label(ptr, stringView);
        }
    }

    public long requiredFeatureCount() {
        return WGPUDeviceDescriptor.requiredFeatureCount(ptr);
    }

    public MemorySegment ptr() {
        return ptr;
    }

}
