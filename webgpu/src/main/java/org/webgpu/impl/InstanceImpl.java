package org.webgpu.impl;

import java.lang.foreign.MemorySegment;

import org.webgpu.Instance;
import org.webgpu.WGPU;
import org.webgpu.extract.webgpu_h;

public record InstanceImpl(MemorySegment ptr) implements Instance, AutoCloseable{

	@Override
	public void close() throws Exception {
		webgpu_h.wgpuInstanceRelease(this.ptr());
	}
    
}
