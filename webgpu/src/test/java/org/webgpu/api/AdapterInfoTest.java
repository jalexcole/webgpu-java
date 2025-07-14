package org.webgpu.api;

import org.junit.jupiter.api.Test;

public class AdapterInfoTest {


    @Test
    void testAdapter() {
        AdapterInfo adapterInfo = new AdapterInfo();
        
    }

    @Test
    void testAdapterType() {
        var adapterInfo = new AdapterInfo();

        var adapterType = adapterInfo.adapterType();
        System.out.println(adapterType);
    }

    @Test
    void testArchitecture() {
        var adapterInfo = new AdapterInfo();
        var architecture = adapterInfo.architecture();
    }

    @Test
    void testBackendType() {
        var adapterInfo = new AdapterInfo();
        var backendType = adapterInfo.backendType();
    }

    @Test
    void testDescription() {
        var adapterInfo = new AdapterInfo();
        var description = adapterInfo.description();
    }

    @Test
    void testDevice() {
        var adapterInfo = new AdapterInfo();
        var device = adapterInfo.device();
    }

    @Test
    void testDeviceId() {
        var adapterInfo = new AdapterInfo();
        var deviceId = adapterInfo.deviceId();
    }


    @Test
    void testVendor() {
        var adapterInfo = new AdapterInfo();
        var vendor = adapterInfo.vendor();
    }

    @Test
    void testVendorId() {
        var adapterInfo = new AdapterInfo();
        var vendorId = adapterInfo.vendorId();
    }
}
