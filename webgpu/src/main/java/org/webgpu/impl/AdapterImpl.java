package org.webgpu.impl;

import static org.webgpu.extract.webgpu_h.C_INT;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.ValueLayout;
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
import org.webgpu.extract.WGPUSupportedFeatures;
import org.webgpu.extract.webgpu_h;

@SuppressWarnings("preview")
public record AdapterImpl(@NonNull MemorySegment ptr) implements Adapter, AutoCloseable {

	@Override
	public FeatureName[] features() {

		try (@SuppressWarnings("preview")
		Arena arena = Arena.ofConfined()) {

			// 1. Allocate a MemorySegment for the WGPUSupportedFeatures struct.
			// You'll need the MemoryLayout for WGPUSupportedFeatures.
			// Assuming WGPUSupportedFeatures.LAYOUT() provides the correct layout.
			MemorySegment featuresSegment = arena.allocate(WGPUSupportedFeatures.layout());

			// 2. Call the native function to populate the featuresSegment
			webgpu_h.wgpuAdapterGetFeatures(ptr, featuresSegment);

			// 3. Get the count of features
			// Assuming an accessor for 'featureCount' like
			// WGPUSupportedFeatures.featureCount$get()
			long featureCount = WGPUSupportedFeatures.featureCount(featuresSegment);

			var features = WGPUSupportedFeatures.features(featuresSegment);

			int[] featureNames = new int[(int) featureCount];
			FeatureName[] featureNamesArray = new FeatureName[(int) featureCount];
			for (int i = 0; i < featureCount; i++) {
				featureNames[i] = features.getAtIndex(C_INT, i);
			}

			for (int i = 0; i < featureNames.length; i++) {
				featureNamesArray[i] = FeatureName.values()[featureNames[i]];
			}

			return featureNamesArray;

		}

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
