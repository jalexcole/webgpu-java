package org.webgpu.api.internal;

import java.lang.foreign.MemorySegment;

import org.webgpu.api.WGPUStruct;

@FunctionalInterface
public interface WGPUStructFactory {

    <T extends WGPUStruct> T wrap(Class<T> type, MemorySegment segment);

}
