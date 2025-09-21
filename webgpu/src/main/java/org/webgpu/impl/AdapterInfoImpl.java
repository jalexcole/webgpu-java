package org.webgpu.impl;

import java.lang.foreign.MemorySegment;
import java.util.logging.Logger;

import org.webgpu.api.AdapterInfo;
import org.webgpu.api.AdapterType;
import org.webgpu.api.BackendType;
import org.webgpu.foreign.WGPUAdapterInfo;
import org.webgpu.util.StringView;

public record AdapterInfoImpl(MemorySegment ptr) implements AdapterInfo {

    private static final Logger logger = Logger.getLogger(AdapterInfoImpl.class.getName());

    @SuppressWarnings("preview")
	public MemorySegment ptr() {
        return ptr;
    }
    @Override
    public String vendor() {

        return new StringView(WGPUAdapterInfo.vendor(ptr)).string();
    }
    @Override
    public String architecture() {
        var architecture = WGPUAdapterInfo.architecture(this.ptr);

        logger.info("Architecture raw: " + architecture);
        return new StringView(WGPUAdapterInfo.architecture(ptr)).string();
    }
    @Override
    public String device() {
        return new StringView(WGPUAdapterInfo.device(ptr)).string();
    }
    @Override
    public String description() {
        return new StringView(WGPUAdapterInfo.description(ptr)).string();
    }
    @Override
    public BackendType backendType() {


        return BackendType.fromValue(WGPUAdapterInfo.backendType(ptr));

    }
    @Override
    public AdapterType adapterType() {
        return AdapterType.values()[WGPUAdapterInfo.adapterType(ptr)];
    }
    @Override
    public int vendorId() {
        return WGPUAdapterInfo.vendorID(ptr);
    }
    @Override
    public int deviceId() {
        return WGPUAdapterInfo.deviceID(ptr);
    }


    @Override
    public String toString() {
        return "AdapterInfo[vendor: " + vendor()
                + ", architecture: " + architecture()
                +", device: " +device()
                + ", description: " + description()
                + ", backendType: "+backendType()
                +", adapterType: " + adapterType()
                + ", vendorId: " + vendorId()
                + ", deviceId: " + deviceId() + "]";
    }
}