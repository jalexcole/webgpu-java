package org.webgpu.impl;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.junit.jupiter.api.Test;
import org.webgpu.api.WGPU;
import org.webgpu.exceptions.RequestAdaptorError;

public class AdapterImplTest {
    @Test
    void testClose() {
    }

    @Test
    void testEquals() {

    }

    @Test
    void testFeatures() throws InterruptedException, ExecutionException, RequestAdaptorError, TimeoutException {
        WGPU.createInstance(null).requestAdapterAsync(null).get(1000, TimeUnit.MICROSECONDS).features();
    }

    @Test
    void testGetDownlevelCapabilities() throws InterruptedException, ExecutionException, RequestAdaptorError {
        WGPU.createInstance(null).requestAdapterAsync(null).get().getDownlevelCapabilities();
    }

    @Test
    void testGetInfo() throws InterruptedException, ExecutionException, RequestAdaptorError {
        WGPU.createInstance(null).requestAdapterAsync(null).get().getInfo();

    }

    @Test
    void testGetTextureFormatFeatures() throws InterruptedException, ExecutionException, RequestAdaptorError {
        WGPU.createInstance(null).requestAdapterAsync(null).get().getTextureFormatFeatures(null);

    }

    @Test
    void testHashCode() throws InterruptedException, ExecutionException, RequestAdaptorError {
        WGPU.createInstance(null).requestAdapterAsync(null).get().hashCode();

    }

    @Test
    void testLimits() throws InterruptedException, ExecutionException, RequestAdaptorError {
        WGPU.createInstance(null).requestAdapterAsync(null).get().limits();

    }

    @Test
    void testRelease() throws InterruptedException, ExecutionException, RequestAdaptorError {
        WGPU.createInstance(null).requestAdapterAsync(null).get().release();

    }

    @Test
    void testRequestDevice() throws InterruptedException, ExecutionException, RequestAdaptorError {
        WGPU.createInstance(null).requestAdapterAsync(null).get().requestDevice(null).get();

    }

    @Test
    void testToString() throws InterruptedException, ExecutionException, RequestAdaptorError {
        WGPU.createInstance(null).requestAdapterAsync(null).get().toString();

    }
}
