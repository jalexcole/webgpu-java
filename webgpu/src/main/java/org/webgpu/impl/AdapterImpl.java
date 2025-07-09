package org.webgpu.impl;

import java.lang.foreign.MemorySegment;
import java.time.Instant;

import org.jspecify.annotations.NonNull;

import org.webgpu.Adapter;
import org.webgpu.AdapterInfo;
import org.webgpu.DownlevelCapabilities;
import org.webgpu.Features;
import org.webgpu.Limits;
import org.webgpu.TextureFormat;
import org.webgpu.TextureFormatFeatures;
import org.webgpu.WGPU;

public record AdapterImpl(@NonNull MemorySegment ptr) implements Adapter, AutoCloseable {

	@Override
	public Features features() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'features'");
	}

	@Override
	public Limits limits() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'limits'");
	}

	@Override
	public AdapterInfo getInfo() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'getInfo'");
	}

	@Override
	public DownlevelCapabilities getDownlevelCapabilities() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'getDownlevelCapabilities'");
	}

	@Override
	public TextureFormatFeatures getTextureFormatFeatures(TextureFormat format) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'getTextureFormatFeatures'");
	}

	@Override
	public Instant getPresentationTimestamp() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'getPresentationTimestamp'");
	}

	@Override
	public void close() throws Exception {
		WGPU.adapterRelease(this);
	}
    
}
