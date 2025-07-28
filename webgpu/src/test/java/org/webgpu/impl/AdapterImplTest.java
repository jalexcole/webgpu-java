package org.webgpu.impl;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.junit.jupiter.api.Test;
import org.webgpu.api.WGPU;
import org.webgpu.exceptions.RequestAdaptorError;

public class AdapterImplTest {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(AdapterImplTest.class.getName());
    @Test
    void testClose() {
        try (var adapter = (AdapterImpl) WGPU.createInstance(null).requestAdapter(null).get()) {
            adapter.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void testEquals() {

    }

    @Test
    void testFeatures() throws InterruptedException, ExecutionException, RequestAdaptorError, TimeoutException {
        WGPU.createInstance(null).requestAdapter(null).get(1000, TimeUnit.MICROSECONDS).features();
    }

    @Test
    void testGetInfo() throws InterruptedException, ExecutionException, RequestAdaptorError {
        WGPU.createInstance(null).requestAdapter(null).get().getInfo();

    }

    @Test
    void testHashCode() throws InterruptedException, ExecutionException, RequestAdaptorError {
        WGPU.createInstance(null).requestAdapter(null).get().hashCode();

    }

    @Test
    void testLimits() throws InterruptedException, ExecutionException, RequestAdaptorError {
        var limits = WGPU.createInstance(null).requestAdapter(null).get().limits();

        logger.fine("AdapterImpl.limits() called, limits: " + limits);

    }

    @Test
    void testRelease() throws InterruptedException, ExecutionException, RequestAdaptorError {
        WGPU.createInstance(null).requestAdapter(null).get().release();

    }

    @Test
    void testRequestDevice() throws InterruptedException, ExecutionException, RequestAdaptorError {
        WGPU.createInstance(null).requestAdapter(null).get().requestDevice(null).get();

    }

    @Test
    void testToString() throws InterruptedException, ExecutionException, RequestAdaptorError {
        WGPU.createInstance(null).requestAdapter(null).get().toString();

    }
}
