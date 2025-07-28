package org.webgpu.api;

import static org.junit.jupiter.api.Assertions.assertFalse;


import java.lang.foreign.MemorySegment;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class RequestAdapterOptionsTest {

    private static final Logger logger = LoggerFactory.getLogger(RequestAdapterOptionsTest.class);
    @Test
    void testPtr() {
        var adapterOptions = new RequestAdapterOptions();

        assertFalse(adapterOptions.ptr().equals(MemorySegment.NULL));
    }

    @Test
    void testBackendType() {
        var adapterOptions = new RequestAdapterOptions();
        adapterOptions.backendType();

    }

    void testSetBackendType() {
        var adapterOptions = new RequestAdapterOptions();
        adapterOptions.backendType(BackendType.Vulkan);
    }

    @Test
    void testCompatibleSurface() {
        var adapterOptions = new RequestAdapterOptions();
        adapterOptions.compatibleSurface();
    }

    

    @Test
    void testFeatureLevel() {
        var adapterOptions = new RequestAdapterOptions();
        adapterOptions.featureLevel();
    }

    

    @Test
    void testForceFallbackAdapter() {
        var adapterOptions = new RequestAdapterOptions();
        adapterOptions.forceFallbackAdapter();
    }

    

    @Test
    void testNextInChain() {
        var adapterOptions = new RequestAdapterOptions();
        adapterOptions.nextInChain();
    }

    @Test
    void testPowerPreference() {
        var adapterOptions = new RequestAdapterOptions();
        adapterOptions.powerPreference();
    }

    @Test
    void testToString() {
        var adapterOptions = new RequestAdapterOptions();
        logger.info(adapterOptions.toString());
    }
}
