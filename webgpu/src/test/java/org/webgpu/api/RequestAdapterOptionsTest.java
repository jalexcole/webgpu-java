package org.webgpu.api;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

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
        logger.info("BackendType: {}", adapterOptions.backendType());
        assertNotNull(adapterOptions);

    }
    @Test
    void testSetBackendType() {
        var adapterOptions = new RequestAdapterOptions();
        adapterOptions.backendType(BackendType.Vulkan);
        logger.info("BackendType set to: {}", adapterOptions.backendType());

    }

    @Test
    void testCompatibleSurface() {
        var adapterOptions = new RequestAdapterOptions();
        var compatibleSurface = adapterOptions.compatibleSurface();
        logger.info("CompatibleSurface: {}", compatibleSurface);
        assertNotNull(compatibleSurface);
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

        logger.info("NextInChain: {}", adapterOptions.nextInChain());
        assertNotNull(adapterOptions);
    }

    @Test
    void testPowerPreference() {
        var adapterOptions = new RequestAdapterOptions();
        var powerPreference = adapterOptions.powerPreference();
        logger.info("PowerPreference: {}", powerPreference);
        assertNotNull(powerPreference);
    }

    @Test
    void testToString() {
        var adapterOptions = new RequestAdapterOptions();
        logger.info(adapterOptions.toString());
    }
}
