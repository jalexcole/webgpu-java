package org.webgpu.impl.util;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;

import org.webgpu.api.CompatibilityModeLimits;
import org.webgpu.api.Limits;
import org.webgpu.panama.WGPULimits;

public class LimitsMapper {
    private LimitsMapper() {
        /* This utility class should not be instantiated */
    }

    

    public static <T extends Limits> MemorySegment map(T limits, Arena arena) {
        
        var limitsSegment = WGPULimits.allocate(arena);
        WGPULimits.nextInChain(limitsSegment, MemorySegment.NULL);

        // WGPULimits.maxBindGroups(limitsSegment, limits.maxBindGroups());
        // WGPULimits.maxDynamicStorageBuffersPerPipelineLayout(limitsSegment,
        //         limits.maxDynamicStorageBuffersPerPipelineLayout());
        // WGPULimits.maxDynamicUniformBuffersPerPipelineLayout(limitsSegment,
        //         limits.maxDynamicUniformBuffersPerPipelineLayout());
        

        if (limits instanceof CompatibilityModeLimits) {
            compatibilityModeLimits(limitsSegment);

        }
        
        return limitsSegment;
    }
    
    public static <T extends Limits> MemorySegment map(T limits) {
        final Arena arena = Arena.ofAuto();
        return map(limits, arena);
    }

    private static void compatibilityModeLimits(MemorySegment limitsSegment) {
        WGPULimits.maxBindGroups(limitsSegment, 4);
        WGPULimits.maxDynamicStorageBuffersPerPipelineLayout(limitsSegment, 8);
        WGPULimits.maxDynamicUniformBuffersPerPipelineLayout(limitsSegment, 8);
    }
}
