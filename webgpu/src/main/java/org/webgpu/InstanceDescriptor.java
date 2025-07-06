package org.webgpu;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;

import org.webgpu.extract.WGPUInstanceDescriptor;

public class InstanceDescriptor {

    @SuppressWarnings("preview")
    private MemorySegment descriptorPtr;

    public InstanceDescriptor() {
        try (@SuppressWarnings("preview")
        Arena arena = Arena.ofConfined()) {
            descriptorPtr = WGPUInstanceDescriptor.allocate(arena);
            

            
        }
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

    public long requiredFeatureCount() {
        return WGPUInstanceDescriptor.requiredFeatureCount(descriptorPtr);
    }

    public void requiredFeatureCount(long fieldValue) {
        WGPUInstanceDescriptor.requiredFeatureCount(descriptorPtr, fieldValue);
    }

    @SuppressWarnings("preview")
    public MemorySegment requiredFeatures() {
        return WGPUInstanceDescriptor.requiredFeatures(descriptorPtr);
    }

    public void requiredFeatures(@SuppressWarnings("preview") MemorySegment fieldValue) {
        WGPUInstanceDescriptor.requiredFeatures(descriptorPtr, fieldValue);
    }

    @SuppressWarnings("preview")
    public MemorySegment requiredLimits() {
        return WGPUInstanceDescriptor.requiredLimits(descriptorPtr);
    }

    public void requiredLimits(@SuppressWarnings("preview") MemorySegment fieldValue) {
        WGPUInstanceDescriptor.requiredLimits(descriptorPtr, fieldValue);
    }
    

}
