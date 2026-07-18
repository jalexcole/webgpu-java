package org.webgpu.impl;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.webgpu.api.Adapter;
import org.webgpu.api.Buffer;
import org.webgpu.api.BufferDescriptor;
import org.webgpu.api.BufferUsage;
import org.webgpu.api.Device;
import org.webgpu.api.DeviceDescriptor;
import org.webgpu.api.InstanceDescriptor;
import org.webgpu.api.RequestAdapter;
import org.webgpu.api.RequestAdapterOptions;
import org.webgpu.api.RequestAdapterStatus;
import org.webgpu.api.RequestDevice;
import org.webgpu.api.RequestDeviceStatus;
import org.webgpu.api.SupportedFeatures;
import org.webgpu.impl.spi.WGPUProviderImpl;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;

import java.util.EnumSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class BufferImplTest {
    @Test
    void testDestroy() {

    }

    @Test
    void testGetConstMappedRange() {

    }

    @Test
    void testGetMapState() {
        WGPUProviderImpl provider = new WGPUProviderImpl();

        InstanceImpl instance = provider.createInstance(new InstanceDescriptor());
        final AtomicReference<AdapterImpl> adapterHolder = new AtomicReference<>(null);
        instance.requestAdapter(new RequestAdapter() {

            @Override
            public void apply(RequestAdapterStatus status, Adapter adapter, String message) {
                adapterHolder.set((AdapterImpl) adapter);
                System.out.println("Adapter request status: " + status);
                System.out.println("Adapter request message: " + message);
            }
            
        }, new RequestAdapterOptions());
        assertNotNull(adapterHolder.get(), "Adapter request failed, adapter is null");
        final AtomicReference<Device> deviceHolder = new AtomicReference<>();
        adapterHolder.get().requestDevice(new RequestDevice() {

            @Override
            public void apply(RequestDeviceStatus status, Device device, String message) {
                System.out.println("Device request status: " + status.toString());
                System.out.println("Device request message: " + message);
                deviceHolder.set(device);
            }
            
        }, new DeviceDescriptor());

        BufferDescriptor bufferDescriptor = new BufferDescriptor();
        bufferDescriptor.size(1024);
        bufferDescriptor.usage(EnumSet.of(BufferUsage.STORAGE));
        final Buffer buffer = deviceHolder.get().createBuffer(bufferDescriptor);
        SupportedFeatures features = new SupportedFeatures();
        deviceHolder.get().getFeatures(features);

        assertNotNull(deviceHolder.get(), "Device request failed, device is null");

        System.out.println(features.toString());
    }

    

    @Test
    void testGetMappedRange() {

    }

    @Test
    void testGetSize() {

    }

    @Test
    void testGetUsage() {

    }

    @Test
    void testMapAsync() {

    }

    @Test
    void testReadMappedRange() {

    }

    @Test
    @Disabled
    void testSetLabel() {
        try (Arena arena = Arena.ofAuto()) {
            MemorySegment bufferSegment = arena.allocate(0);
            BufferImpl buffer = new BufferImpl(bufferSegment);
            
            assertDoesNotThrow(() -> 
                buffer.setLabel("Test Label")
            );
        }
    }

    @Test
    void testUnmap() {

    }

    @Test
    void testWriteMappedRange() {

    }
}
