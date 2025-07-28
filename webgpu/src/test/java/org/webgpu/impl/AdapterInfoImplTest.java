package org.webgpu.impl;

import org.junit.jupiter.api.Test;
import org.webgpu.api.AdapterInfo;
import org.webgpu.api.WGPU;
import org.webgpu.exceptions.RequestAdaptorError;

import java.util.concurrent.ExecutionException;
import java.util.logging.Logger;

public class AdapterInfoImplTest {
    private static final Logger logger = Logger.getLogger(
            AdapterInfoImplTest.class.getName()
    );

    @Test
    void testAdapter() throws RequestAdaptorError, ExecutionException, InterruptedException {
        var instance = WGPU.createInstance(null);
        var adapter = instance.requestAdapter(null).get();

        AdapterInfo adapterInfo = adapter.getInfo();
        
    }

    @Test
    void testAdapterType() throws RequestAdaptorError, ExecutionException, InterruptedException {
        var instance = WGPU.createInstance(null);
        var adapter = instance.requestAdapter(null).get();

        AdapterInfo adapterInfo = adapter.getInfo();

        var adapterType = adapterInfo.adapterType();
        logger.info("AdapterType: " + adapterType);
    }

    @Test
    void testArchitecture() throws RequestAdaptorError, ExecutionException, InterruptedException{
        var instance = WGPU.createInstance(null);
        var adapter = instance.requestAdapter(null).get();

        AdapterInfo adapterInfo = adapter.getInfo();
        var architecture = adapterInfo.architecture();
        logger.info("Architecture: " + architecture);
    }

    @Test
    void testBackendType() throws RequestAdaptorError, ExecutionException, InterruptedException{
        var instance = WGPU.createInstance(null);
        var adapter = instance.requestAdapter(null).get();

        AdapterInfo adapterInfo = adapter.getInfo();
        var backendType = adapterInfo.backendType();
        logger.info("BackendType: " + backendType);
    }

    @Test
    void testDescription() throws RequestAdaptorError, ExecutionException, InterruptedException{
        var instance = WGPU.createInstance(null);
        var adapter = instance.requestAdapter(null).get();

        AdapterInfo adapterInfo = adapter.getInfo();
        var description = adapterInfo.description();
        logger.info("Description: " + description);
    }

    @Test
    void testDevice() throws RequestAdaptorError, ExecutionException, InterruptedException{
        var instance = WGPU.createInstance(null);
        var adapter = instance.requestAdapter(null).get();

        AdapterInfo adapterInfo = adapter.getInfo();
        var device = adapterInfo.device();

        logger.info("Device: " + device);
    }

    @Test
    void testDeviceId() throws RequestAdaptorError, ExecutionException, InterruptedException{
        var instance = WGPU.createInstance(null);
        var adapter = instance.requestAdapter(null).get();

        AdapterInfo adapterInfo = adapter.getInfo();
        var deviceId = adapterInfo.deviceId();

        logger.info("DeviceId: " + deviceId);
    }


    @Test
    void testVendor() throws RequestAdaptorError, ExecutionException, InterruptedException{
        var instance = WGPU.createInstance(null);
        var adapter = instance.requestAdapter(null).get();

        AdapterInfo adapterInfo = adapter.getInfo();
        var vendor = adapterInfo.vendor();

        logger.info("Vendor: " + vendor);
    }

    @Test
    void testVendorId() throws RequestAdaptorError, ExecutionException, InterruptedException{
        var instance = WGPU.createInstance(null);
        var adapter = instance.requestAdapter(null).get();

        AdapterInfo adapterInfo = adapter.getInfo();
        var vendorId = adapterInfo.vendorId();

        logger.info("VendorId: " + vendorId);
    }

    @Test
    void testToString() throws RequestAdaptorError, ExecutionException, InterruptedException {
        var instance = WGPU.createInstance(null);
        var adapter = instance.requestAdapter(null).get();

        AdapterInfo adapterInfo = adapter.getInfo();

        logger.info(adapterInfo.toString());
    }
}
