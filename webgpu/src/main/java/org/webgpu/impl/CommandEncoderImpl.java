package org.webgpu.impl;

import java.lang.foreign.MemorySegment;

public record CommandEncoderImpl(MemorySegment ptr)  {
    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(CommandEncoderImpl.class);
}
