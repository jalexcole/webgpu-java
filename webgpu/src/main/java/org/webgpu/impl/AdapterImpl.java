package org.webgpu.impl;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;
import java.util.concurrent.Future;

import org.jspecify.annotations.NonNull;
import org.webgpu.api.Adapter;
import org.webgpu.api.AdapterInfo;
import org.webgpu.api.Device;
import org.webgpu.api.DeviceDescriptor;
import org.webgpu.api.DownlevelCapabilities;
import org.webgpu.api.FeatureName;
import org.webgpu.api.Limits;
import org.webgpu.api.TextureFormat;
import org.webgpu.api.TextureFormatFeatures;
import org.webgpu.extract.WGPUAdapterInfo;
import org.webgpu.extract.webgpu_h;

public record AdapterImpl(@NonNull MemorySegment ptr) implements Adapter, AutoCloseable {

	@Override
    public FeatureName[] features() {
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
		try {
			Arena arena = Arena.ofAuto();
			var adapterInfo = WGPUAdapterInfo.allocate(arena);
			webgpu_h.wgpuAdapterGetInfo(this.ptr, adapterInfo);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

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
	public void close() throws Exception {
		release();
	}

    @Override
    public Future<Device> requestDevice(@NonNull DeviceDescriptor descriptor) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'requestDevice'");
    }

    @Override
    public void release() {
        webgpu_h.wgpuAdapterRelease(this.ptr);
    }
    
}
