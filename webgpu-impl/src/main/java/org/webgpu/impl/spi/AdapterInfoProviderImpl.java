package org.webgpu.impl.spi;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;

import org.jspecify.annotations.NullMarked;
import org.webgpu.api.AdapterType;
import org.webgpu.api.BackendType;
import org.webgpu.api.spi.AdapterInfoProvider;
import org.webgpu.impl.util.StringViewMapper;
import org.webgpu.panama.WGPUAdapterInfo;

@NullMarked
public class AdapterInfoProviderImpl implements AdapterInfoProvider {

    private final Arena arena = Arena.ofAuto();

    public AdapterInfoProviderImpl() {

    }

    @Override
    public MemorySegment initializer() {
        return WGPUAdapterInfo.allocate(arena);
    }

    @Override
    public String vendor(MemorySegment structPtr) {
        return StringViewMapper.map(WGPUAdapterInfo.vendor(structPtr));
    }

    @Override
    public String architecture(MemorySegment structPtr) {
        return StringViewMapper.map(WGPUAdapterInfo.architecture(structPtr));
    }

    @Override
    public String device(MemorySegment structPtr) {
        return StringViewMapper.map(WGPUAdapterInfo.device(structPtr));
    }

    @Override
    public String description(MemorySegment structPtr) {
        return StringViewMapper.map(WGPUAdapterInfo.description(structPtr));
    }

    @Override
    public BackendType backendType(MemorySegment structPtr) {
        var backendType = WGPUAdapterInfo.backendType(structPtr);
        return BackendType.values()[backendType];
    }

    @Override
    public AdapterType adapterType(MemorySegment structPtr) {
        var adapterType = WGPUAdapterInfo.adapterType(structPtr);
        return AdapterType.values()[adapterType];
    }

    @Override
    public int vendorID(MemorySegment structPtr) {
        return WGPUAdapterInfo.vendorID(structPtr);
    }

    @Override
    public int deviceID(MemorySegment structPtr) {
        return WGPUAdapterInfo.deviceID(structPtr);
    }

    @Override
    public int subgroupMinSize(MemorySegment structPtr) {
        return WGPUAdapterInfo.subgroupMinSize(structPtr);
    }

    @Override
    public int subgroupMaxSize(MemorySegment structPtr) {
        return WGPUAdapterInfo.subgroupMaxSize(structPtr);
    }

    @Override
    public void vendor(MemorySegment structPtr, String vendor) {
        WGPUAdapterInfo.vendor(structPtr, StringViewMapper.map(vendor, arena));
    }

    @Override
    public void architecture(MemorySegment structPtr, String architecture) {
        WGPUAdapterInfo.architecture(structPtr, StringViewMapper.map(architecture, arena));
    }

    @Override
    public void device(MemorySegment structPtr, String device) {
        WGPUAdapterInfo.device(structPtr, StringViewMapper.map(device, arena));
    }

    @Override
    public void description(MemorySegment structPtr, String description) {
        WGPUAdapterInfo.description(structPtr, StringViewMapper.map(description, arena));
    }

    @Override
    public void backendType(MemorySegment structPtr, BackendType backendType) {
        WGPUAdapterInfo.backendType(structPtr, backendType.value());
    }

    @Override
    public void adapterType(MemorySegment structPtr, AdapterType adapterType) {
        WGPUAdapterInfo.adapterType(structPtr, adapterType.value());
    }

    @Override
    public void vendorID(MemorySegment structPtr, int vendorID) {
        WGPUAdapterInfo.vendorID(structPtr, vendorID);
    }

    @Override
    public void deviceID(MemorySegment structPtr, int deviceID) {
        WGPUAdapterInfo.deviceID(structPtr, deviceID);
    }

    @Override
    public void subgroupMinSize(MemorySegment structPtr, int subgroupMinSize) {
        WGPUAdapterInfo.subgroupMinSize(structPtr, subgroupMinSize);
    }

    @Override
    public void subgroupMaxSize(MemorySegment structPtr, int subgroupMaxSize) {
        WGPUAdapterInfo.subgroupMaxSize(structPtr, subgroupMaxSize);
    }


}
