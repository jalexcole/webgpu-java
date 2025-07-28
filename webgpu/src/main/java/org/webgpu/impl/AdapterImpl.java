package org.webgpu.impl;

import static org.webgpu.extract.webgpu_h.C_INT;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;
import java.util.Arrays;
import java.util.concurrent.Future;
import java.util.logging.Logger;

import org.jspecify.annotations.NonNull;
import org.webgpu.api.Adapter;
import org.webgpu.api.Device;
import org.webgpu.api.DeviceDescriptor;
import org.webgpu.api.DownlevelCapabilities;
import org.webgpu.api.FeatureName;
import org.webgpu.api.Limits;
import org.webgpu.api.TextureFormat;
import org.webgpu.api.TextureFormatFeatures;
import org.webgpu.extract.WGPUAdapterInfo;
import org.webgpu.extract.WGPULimits;
import org.webgpu.extract.WGPUSupportedFeatures;
import org.webgpu.extract.webgpu_h;

@SuppressWarnings("preview")
public record AdapterImpl(@NonNull MemorySegment ptr, Arena arena) implements Adapter, AutoCloseable {

	private static final Logger logger = Logger.getLogger(AdapterImpl.class.getName());

	@Override
	public FeatureName[] features() {

		try (@SuppressWarnings("preview")
		Arena arena = Arena.ofConfined()) {

			// 1. Allocate a MemorySegment for the WGPUSupportedFeatures struct.
			// You'll need the MemoryLayout for WGPUSupportedFeatures.
			// Assuming WGPUSupportedFeatures.LAYOUT() provides the correct layout.
			MemorySegment featuresSegment = WGPUSupportedFeatures.allocate(arena);

			// 2. Call the native function to populate the featuresSegment
			webgpu_h.wgpuAdapterGetFeatures(ptr, featuresSegment);
			logger.fine("AdapterImpl.features() called, featuresSegment: " + featuresSegment);
			// 3. Get the count of features
			// Assuming an accessor for 'featureCount' like
			// WGPUSupportedFeatures.featureCount$get()
			long featureCount = WGPUSupportedFeatures.featureCount(featuresSegment);
			logger.fine("AdapterImpl.features() featureCount: " + featureCount);
			var features = WGPUSupportedFeatures.features(featuresSegment);
			logger.fine("AdapterImpl.features() features: " + features);
			int[] featureNames = new int[(int) featureCount];
			FeatureName[] featureNamesArray = new FeatureName[(int) featureCount];
			for (int i = 0; i < featureCount; i++) {
				featureNames[i] = features.getAtIndex(C_INT, i);
			}
			logger.fine("AdapterImpl.features() featureNames: " + Arrays.toString(featureNames));
			for (int i = 0; i < featureNames.length; i++) {
				try {
					featureNamesArray[i] = FeatureName.fromValue(featureNames[i]);
				} catch (IllegalArgumentException e) {
					logger.warning("Unknown feature name value: " + featureNames[i]);
					featureNamesArray[i] = FeatureName.FORCE32;
				}
				
			}

			return featureNamesArray;

		}

	}

	@Override
	public Limits limits() {
		try {
			Arena arena = Arena.ofAuto();
			MemorySegment ptr = WGPULimits.allocate(arena);
			var status = webgpu_h.wgpuAdapterGetLimits(this.ptr, ptr);
			logger.fine("AdapterImpl.limits() called, status: " + status);
			return new LimitsImpl(ptr);
		} catch (Exception e) {
			throw new RuntimeException("Failed to get adapter limits", e);
		}
	}

	@Override
	public AdapterInfoImpl getInfo() {
		try {
			Arena arena = Arena.ofAuto();
			var adapterInfo = WGPUAdapterInfo.allocate(arena);
			var status = webgpu_h.wgpuAdapterGetInfo(this.ptr, adapterInfo);

			if (status != webgpu_h.WGPUStatus_Success()) {
				throw new RuntimeException("Failed to get adapter info. Status: " + status);
			}

			return new AdapterInfoImpl(adapterInfo);

		} catch (Exception e) {
			throw new RuntimeException(e);
		}
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
