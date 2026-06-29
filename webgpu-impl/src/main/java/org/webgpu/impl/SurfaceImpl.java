package org.webgpu.impl;

import java.lang.foreign.MemorySegment;

import org.webgpu.api.Adapter;
import org.webgpu.api.Status;
import org.webgpu.api.Surface;
import org.webgpu.api.SurfaceCapabilities;
import org.webgpu.api.SurfaceConfiguration;
import org.webgpu.api.SurfaceTexture;

public class SurfaceImpl implements Surface {

	private final MemorySegment memorySegment;
	public SurfaceImpl(MemorySegment memorySegment) {
	    this.memorySegment = memorySegment;
	}


	@Override
	public void configure(SurfaceConfiguration config) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'configure'");
	}

	@Override
	public Status getCapabilities(Adapter adapter, SurfaceCapabilities capabilities) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'getCapabilities'");
	}

	@Override
	public void getCurrentTexture(SurfaceTexture surfaceTexture) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'getCurrentTexture'");
	}

	@Override
	public Status present() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'present'");
	}

	@Override
	public void unconfigure() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'unconfigure'");
	}

	@Override
	public void setLabel(String label) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'setLabel'");
	}
    
}
