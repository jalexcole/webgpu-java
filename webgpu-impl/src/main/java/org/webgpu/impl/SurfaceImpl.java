package org.webgpu.impl;

import java.lang.foreign.MemorySegment;

import org.jspecify.annotations.NullMarked;
import org.webgpu.api.Adapter;
import org.webgpu.api.Status;
import org.webgpu.api.Surface;
import org.webgpu.api.SurfaceCapabilities;
import org.webgpu.api.SurfaceConfiguration;
import org.webgpu.api.SurfaceTexture;
import org.webgpu.impl.util.StructTools;
import org.webgpu.panama.webgpu_h;

@NullMarked
public class SurfaceImpl implements Surface {

	private final MemorySegment memorySegment;
	public SurfaceImpl(MemorySegment memorySegment) {
	    this.memorySegment = memorySegment;
	}


	@Override
	public void configure(SurfaceConfiguration config) {
		final MemorySegment configPointer = StructTools.fetchSegment(config);
		webgpu_h.wgpuSurfaceConfigure(this.memorySegment, configPointer);
	}

	@Override
	public Status getCapabilities(Adapter adapter, SurfaceCapabilities capabilities) {
		final MemorySegment capabilitiesPointer = StructTools.fetchSegment(capabilities);
		final MemorySegment adapterPointer = ((AdapterImpl) adapter).ptr();
		final int status = webgpu_h.wgpuSurfaceGetCapabilities(this.memorySegment, adapterPointer, capabilitiesPointer);

		return Status.values()[status];
	}

	@Override
	public void getCurrentTexture(SurfaceTexture surfaceTexture) {
		final MemorySegment surfaceTexturePointer = StructTools.fetchSegment(surfaceTexture);
		webgpu_h.wgpuSurfaceGetCurrentTexture(this.memorySegment, surfaceTexturePointer);
	}

	@Override
	public Status present() {
		var result = webgpu_h.wgpuSurfacePresent(memorySegment);
		return Status.values()[result];
	}

	@Override
	public void unconfigure() {
		webgpu_h.wgpuSurfaceUnconfigure(memorySegment);
	}

	@Override
	public void setLabel(String label) {
		throw new UnsupportedOperationException("Unimplemented method 'setLabel'");
	}
    
}
