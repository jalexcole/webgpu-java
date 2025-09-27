package org.webgpu.impl;

import java.lang.foreign.MemorySegment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.webgpu.api.AdapterInfo;
import org.webgpu.api.AdapterType;
import org.webgpu.api.BackendType;
import org.webgpu.panama.foreign.WGPUAdapterInfo;
import org.webgpu.util.StringView;

public record AdapterInfoImpl(MemorySegment ptr) implements AdapterInfo {

    private static final Logger logger = LoggerFactory.getLogger(AdapterInfoImpl.class.getName());

    @SuppressWarnings("preview")
    public MemorySegment ptr() {
        return ptr;
    }

    @Override
    public String vendor() {

        return StringView.map(WGPUAdapterInfo.vendor(ptr));
    }

    @Override
    public String architecture() {
        var architecture = WGPUAdapterInfo.architecture(this.ptr);

        logger.info("Architecture raw: {}", architecture);
        return StringView.map(WGPUAdapterInfo.architecture(ptr));
    }

    @Override
    public String device() {
        return StringView.map(WGPUAdapterInfo.device(ptr));
    }

    @Override
    public String description() {
        return StringView.map(WGPUAdapterInfo.description(ptr));
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
                + ", device: " + device()
                + ", description: " + description()
                + ", backendType: " + backendType()
                + ", adapterType: " + adapterType()
                + ", vendorId: " + vendorId()
                + ", deviceId: " + deviceId() + "]";
    }
}