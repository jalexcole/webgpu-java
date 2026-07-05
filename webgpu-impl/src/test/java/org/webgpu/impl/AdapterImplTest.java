package org.webgpu.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.webgpu.api.Adapter;
import org.webgpu.api.AdapterInfo;
import org.webgpu.api.Device;
import org.webgpu.api.DeviceDescriptor;
import org.webgpu.api.FeatureName;
import org.webgpu.api.Instance;
import org.webgpu.api.Limits;
import org.webgpu.api.RequestAdapterOptions;
import org.webgpu.api.RequestAdapterStatus;
import org.webgpu.api.RequestDeviceStatus;
import org.webgpu.api.Status;
import org.webgpu.api.SupportedFeatures;
import org.webgpu.api.WGPU;

public class AdapterImplTest {


    private AdapterImpl adapter;

    @BeforeEach
    void createAdapter() {
        Instance instance = WGPU.createInstance(null);

        var options = new RequestAdapterOptions();

        instance.requestAdapter((RequestAdapterStatus status, Adapter adapter, String message) -> {
            this.adapter = (AdapterImpl) adapter;
            System.out.println("Request Adapter Callback: status=" + status + ", adapter=" + adapter + ", message=" + message);
            assertNotNull(status);
            assertNotNull(adapter);
            assertNotNull(message);
        }, options);

    }


    @Test
    void testGetFeatures() {
        assertThrows(UnsupportedOperationException.class, () -> {
            var features = new SupportedFeatures();
            adapter.getFeatures(features);
            System.out.println("Supported Features: " + features);
        });
    }

    @Test
    void testGetInfo() {
        var adapterInfo = new AdapterInfo();
        var status = adapter.getInfo(adapterInfo);
        assertEquals(Status.SUCCESS, status);

        System.out.println("Adapter Info: " + adapterInfo);
    }

    @Test
    void testGetLimits() {
        Limits limits = new Limits();
        var status = adapter.getLimits(limits);
        assertEquals(Status.SUCCESS, status);
        System.out.println("Adapter Limits: " + limits);
    }

    @Test
    void testHasFeature() {
        boolean hasFeature = adapter.hasFeature(FeatureName.TEXTURE_COMPRESSION_BC);

        System.out.println("Adapter has feature TEXTURE_COMPRESSION_BC: " + hasFeature);
    }

    @Test
    void testRequestDevice() {
        var deviceDescriptor = new DeviceDescriptor();
        adapter.requestDevice((RequestDeviceStatus status, Device device, String message) -> {
            System.out.println("Request Device Callback: status=" + status + ", device=" + device + ", message=" + message);
            assertNotNull(status);
            assertNotNull(device);
            assertNotNull(message);
        }, deviceDescriptor);
    }
}
