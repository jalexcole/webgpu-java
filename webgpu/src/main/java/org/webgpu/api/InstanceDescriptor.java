package org.webgpu.api;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;

import org.webgpu.panama.foreign.WGPUInstanceDescriptor;

public final class InstanceDescriptor implements DescriptorBase {

    @SuppressWarnings("preview")
    private MemorySegment descriptorPtr;

    public InstanceDescriptor() {

        @SuppressWarnings("preview")
        Arena arena = Arena.ofAuto();
        descriptorPtr = WGPUInstanceDescriptor.allocate(arena);

    }

    @SuppressWarnings("preview")
    MemorySegment address() {
        return descriptorPtr;
    }

    @SuppressWarnings("preview")
    public MemorySegment getSegment() {
        return descriptorPtr;
    }

    // Convenience methods operating on the wrapped segment
    @SuppressWarnings("preview")
    public MemorySegment nextInChain() {
        return WGPUInstanceDescriptor.nextInChain(descriptorPtr);
    }

    public void nextInChain(@SuppressWarnings("preview") MemorySegment fieldValue) {
        WGPUInstanceDescriptor.nextInChain(descriptorPtr, fieldValue);
    }

    @Override
    public String toString() {
        return "InstanceDescriptor [descriptorPtr=" + descriptorPtr + "]";
    }

}
