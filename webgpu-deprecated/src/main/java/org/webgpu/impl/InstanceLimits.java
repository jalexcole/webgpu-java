package org.webgpu.impl;

import java.lang.foreign.MemorySegment;

public record InstanceLimits(MemorySegment memorySegment) {
    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(InstanceLimits.class);
}
