package org.webgpu.impl;

import static org.junit.jupiter.api.Assertions.assertFalse;

import java.lang.foreign.MemorySegment;
import java.util.concurrent.ExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.webgpu.api.BufferDescriptor;
import org.webgpu.api.WGPU;
import org.webgpu.exceptions.RequestAdaptorError;

public class DeviceImplTest {

    private static final Logger logger = LoggerFactory
            .getLogger(DeviceImplTest.class.getName());

    @Test
    void testAdapterInfo() throws InterruptedException, ExecutionException, RequestAdaptorError {
        WGPU.createInstance(null)
                .requestAdapter(null)
                .get()
                .requestDevice(null)
                .get()
                .adapterInfo();
    }

    @Test
    @Disabled
    void testCreateBindGroup() throws InterruptedException, ExecutionException, RequestAdaptorError {
        WGPU.createInstance(null)
                .requestAdapter(null)
                .get()
                .requestDevice(null)
                .get().createBindGroup(null);
    }

    @Test
    @Disabled
    void testCreateBindGroupLayout() throws InterruptedException, ExecutionException, RequestAdaptorError {
        WGPU.createInstance(null)
                .requestAdapter(null)
                .get()
                .requestDevice(null)
                .get().createBindGroupLayout(null);
    }

    @Test
    @Disabled
    void testCreateBuffer() throws InterruptedException, ExecutionException, RequestAdaptorError {

        WGPU.createInstance(null)
                .requestAdapter(null)
                .get()
                .requestDevice(null)
                .get().createBuffer(new BufferDescriptor());
    }

    @Test
    @Disabled
    void testCreateCommandEncoder() throws InterruptedException, ExecutionException, RequestAdaptorError {
        WGPU.createInstance(null)
                .requestAdapter(null)
                .get()
                .requestDevice(null)
                .get().createCommandEncoder(null);
    }

    @Test
    @Disabled
    void testCreateComputePipeline() throws InterruptedException, ExecutionException, RequestAdaptorError {
        WGPU.createInstance(null)
                .requestAdapter(null)
                .get()
                .requestDevice(null)
                .get().createComputePipeline(null);
    }

    @Test
    @Disabled
    void testCreateComputePipelineAsync() throws InterruptedException, ExecutionException, RequestAdaptorError {
        WGPU.createInstance(null)
                .requestAdapter(null)
                .get()
                .requestDevice(null)
                .get().createComputePipelineAsync(null);
    }

    @Test
    @Disabled
    void testCreatePipelineLayout() throws InterruptedException, ExecutionException, RequestAdaptorError {
        WGPU.createInstance(null)
                .requestAdapter(null)
                .get()
                .requestDevice(null)
                .get().createPipelineLayout(null);
    }

    @Test
    @Disabled
    void testCreateQuerySet() throws InterruptedException, ExecutionException, RequestAdaptorError {
        WGPU.createInstance(null)
                .requestAdapter(null)
                .get()
                .requestDevice(null)
                .get().createQuerySet(null);
    }

    @Test
    @Disabled
    void testCreateRenderBundleEncoder() throws InterruptedException, ExecutionException, RequestAdaptorError {
        WGPU.createInstance(null)
                .requestAdapter(null)
                .get()
                .requestDevice(null)
                .get().createRenderBundleEncoder(null);
    }

    @Test
    @Disabled
    void testCreateRenderPipeline() throws InterruptedException, ExecutionException, RequestAdaptorError {
        WGPU.createInstance(null)
                .requestAdapter(null)
                .get()
                .requestDevice(null)
                .get().createRenderPipeline(null);
    }

    @Test
    @Disabled
    void testCreateRenderPipelineAsync() throws InterruptedException, ExecutionException, RequestAdaptorError {
        WGPU.createInstance(null)
                .requestAdapter(null)
                .get()
                .requestDevice(null)
                .get().createRenderPipelineAsync(null);
    }

    @Test
    void testCreateSampler() throws InterruptedException, ExecutionException, RequestAdaptorError {
        WGPU.createInstance(null)
                .requestAdapter(null)
                .get()
                .requestDevice(null)
                .get().createSampler(null);
    }

    @Test
    @Disabled
    void testCreateShaderModule() throws InterruptedException, ExecutionException, RequestAdaptorError {
        WGPU.createInstance(null)
                .requestAdapter(null)
                .get()
                .requestDevice(null)
                .get().createShaderModule(null);
    }

    @Test
    @Disabled
    void testCreateTexture() throws InterruptedException, ExecutionException, RequestAdaptorError {
        WGPU.createInstance(null)
                .requestAdapter(null)
                .get()
                .requestDevice(null)
                .get().createTexture(null);
    }

    @Test
    @Disabled
    void testDestroy() throws InterruptedException, ExecutionException, RequestAdaptorError {
        WGPU.createInstance(null)
                .requestAdapter(null)
                .get()
                .requestDevice(null)
                .get().destroy();
    }

    @Test
    @Disabled
    void testFeatures() throws InterruptedException, ExecutionException, RequestAdaptorError {
        WGPU.createInstance(null)
                .requestAdapter(null)
                .get()
                .requestDevice(null)
                .get().features();
    }

    @Test
    @Disabled
    void testImportExternalTexture() throws InterruptedException, ExecutionException, RequestAdaptorError {
        WGPU.createInstance(null)
                .requestAdapter(null)
                .get()
                .requestDevice(null)
                .get().importExternalTexture(null);
    }

    @Test
    @Disabled
    void testLimits() throws InterruptedException, ExecutionException, RequestAdaptorError {
        WGPU.createInstance(null)
                .requestAdapter(null)
                .get()
                .requestDevice(null)
                .get().limits();
    }

    @Test
    @Disabled
    void testPtr() throws InterruptedException, ExecutionException, RequestAdaptorError {
        var device = WGPU.createInstance(null)
                .requestAdapter(null)
                .get()
                .requestDevice(null)
                .get();

        assertFalse(device.ptr().equals(MemorySegment.NULL), "Device pointer should not be NULL");
        logger.info("Device pointer: {}", device.ptr().address());
    }

    @Test
    @Disabled
    void testQueue() throws InterruptedException, ExecutionException, RequestAdaptorError {
        WGPU.createInstance(null)
                .requestAdapter(null)
                .get()
                .requestDevice(null)
                .get().queue();
    }

    @Test
    @Disabled
    void testToString() throws InterruptedException, ExecutionException, RequestAdaptorError {
        var device = WGPU.createInstance(null)
                .requestAdapter(null)
                .get()
                .requestDevice(null)
                .get();

        String deviceString = device.toString();
        logger.info("Device toString: " + deviceString);
        assertFalse(deviceString.isEmpty(), "Device toString should not be empty");
    }
}
