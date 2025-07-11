package org.webgpu.impl;

import java.util.concurrent.ExecutionException;

import org.junit.jupiter.api.Test;
import org.webgpu.api.WGPU;

public class AdapterImplTest {
    @Test
    void testClose() {
    }

    @Test
    void testEquals() {

    }

    @Test
    void testFeatures() throws InterruptedException, ExecutionException {
        WGPU.createInstance(null).requestAdapter(null).get().features();
    }

    @Test
    void testGetDownlevelCapabilities() throws InterruptedException, ExecutionException {
        WGPU.createInstance(null).requestAdapter(null).get().getDownlevelCapabilities();
    }

    @Test
    void testGetInfo() throws InterruptedException, ExecutionException {
        WGPU.createInstance(null).requestAdapter(null).get().getInfo();

    }

    @Test
    void testGetTextureFormatFeatures() throws InterruptedException, ExecutionException {
        WGPU.createInstance(null).requestAdapter(null).get().getTextureFormatFeatures(null);

    }

    @Test
    void testHashCode() throws InterruptedException, ExecutionException {
        WGPU.createInstance(null).requestAdapter(null).get().hashCode();

    }

    @Test
    void testLimits() throws InterruptedException, ExecutionException {
        WGPU.createInstance(null).requestAdapter(null).get().limits();

    }

    @Test
    void testPtr() {

    }

    @Test
    void testRelease() throws InterruptedException, ExecutionException {
        WGPU.createInstance(null).requestAdapter(null).get().release();

    }

    @Test
    void testRequestDevice() throws InterruptedException, ExecutionException {
        WGPU.createInstance(null).requestAdapter(null).get().requestDevice(null).get();

    }

    @Test
    void testToString() throws InterruptedException, ExecutionException {
        WGPU.createInstance(null).requestAdapter(null).get().toString();

    }
}
