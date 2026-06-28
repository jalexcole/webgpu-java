package org.webgpu.impl.util;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;

import org.webgpu.api.InstanceDescriptor;
import org.webgpu.panama.WGPUInstanceDescriptor;

public class InstanceDescriptorMapper {
    

    public static MemorySegment map(InstanceDescriptor descriptor) {
        if (descriptor == null) {
            return MemorySegment.NULL;
        }

        Arena arena = Arena.ofAuto();

        var nativeDescriptor = arena.allocate(WGPUInstanceDescriptor.layout());

        WGPUInstanceDescriptor.nextInChain(nativeDescriptor, MemorySegment.NULL);
        


        return nativeDescriptor;
    }

}
