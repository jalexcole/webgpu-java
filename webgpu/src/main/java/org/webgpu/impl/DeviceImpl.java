package org.webgpu.impl;

import java.lang.foreign.MemorySegment;

import org.webgpu.api.Device;

public record DeviceImpl(MemorySegment ptr) implements Device {
    
}
