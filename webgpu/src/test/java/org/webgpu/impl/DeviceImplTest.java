package org.webgpu.impl;

import static org.junit.jupiter.api.Assertions.assertFalse;

import java.lang.foreign.MemorySegment;
import java.util.concurrent.ExecutionException;
import java.util.logging.Logger;

import org.junit.jupiter.api.Test;
import org.webgpu.api.BufferDescriptor;
import org.webgpu.api.WGPU;
import org.webgpu.exceptions.RequestAdaptorError;

public class DeviceImplTest {

    private static final Logger logger = Logger
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
    void testCreateBindGroup() throws InterruptedException, ExecutionException, RequestAdaptorError {
        WGPU.createInstance(null)
                .requestAdapter(null)
                .get()
                .requestDevice(null)
                .get().createBindGroup(null);
    }

    @Test
    void testCreateBindGroupLayout() throws InterruptedException, ExecutionException, RequestAdaptorError {
        WGPU.createInstance(null)
                .requestAdapter(null)
                .get()
                .requestDevice(null)
                .get().createBindGroupLayout(null);
    }

    @Test
    void testCreateBuffer() throws InterruptedException, ExecutionException, RequestAdaptorError {

        
        WGPU.createInstance(null)
                .requestAdapter(null)
                .get()
                .requestDevice(null)
                .get().createBuffer(new BufferDescriptor());
    }

    @Test
    void testCreateCommandEncoder() throws InterruptedException, ExecutionException, RequestAdaptorError {
        WGPU.createInstance(null)
                .requestAdapter(null)
                .get()
                .requestDevice(null)
                .get().createCommandEncoder(null);
    }

    @Test
    void testCreateComputePipeline() throws InterruptedException, ExecutionException, RequestAdaptorError {
        WGPU.createInstance(null)
                .requestAdapter(null)
                .get()
                .requestDevice(null)
                .get().createComputePipeline(null);
    }

    @Test
    void testCreateComputePipelineAsync() throws InterruptedException, ExecutionException, RequestAdaptorError {
        WGPU.createInstance(null)
                .requestAdapter(null)
                .get()
                .requestDevice(null)
                .get().createComputePipelineAsync(null);
    }

    @Test
    void testCreatePipelineLayout() throws InterruptedException, ExecutionException, RequestAdaptorError {
        WGPU.createInstance(null)
                .requestAdapter(null)
                .get()
                .requestDevice(null)
                .get().createPipelineLayout(null);
    }

    @Test
    void testCreateQuerySet() throws InterruptedException, ExecutionException, RequestAdaptorError {
        WGPU.createInstance(null)
                .requestAdapter(null)
                .get()
                .requestDevice(null)
                .get().createQuerySet(null);
    }

    @Test
    void testCreateRenderBundleEncoder() throws InterruptedException, ExecutionException, RequestAdaptorError {
        WGPU.createInstance(null)
                .requestAdapter(null)
                .get()
                .requestDevice(null)
                .get().createRenderBundleEncoder(null);
    }

    @Test
    void testCreateRenderPipeline() throws InterruptedException, ExecutionException, RequestAdaptorError {
        WGPU.createInstance(null)
                .requestAdapter(null)
                .get()
                .requestDevice(null)
                .get().createRenderPipeline(null);
    }

    @Test
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
    void testCreateShaderModule() throws InterruptedException, ExecutionException, RequestAdaptorError {
        WGPU.createInstance(null)
                .requestAdapter(null)
                .get()
                .requestDevice(null)
                .get().createShaderModule(null);
    }

    @Test
    void testCreateTexture() throws InterruptedException, ExecutionException, RequestAdaptorError {
        WGPU.createInstance(null)
                .requestAdapter(null)
                .get()
                .requestDevice(null)
                .get().createTexture(null);
    }

    @Test
    void testDestroy() throws InterruptedException, ExecutionException, RequestAdaptorError {
        WGPU.createInstance(null)
                .requestAdapter(null)
                .get()
                .requestDevice(null)
                .get().destroy();
    }

    @Test
    void testFeatures() throws InterruptedException, ExecutionException, RequestAdaptorError {
        WGPU.createInstance(null)
                .requestAdapter(null)
                .get()
                .requestDevice(null)
                .get().features();
    }

    @Test
    void testImportExternalTexture() throws InterruptedException, ExecutionException, RequestAdaptorError {
        WGPU.createInstance(null)
                .requestAdapter(null)
                .get()
                .requestDevice(null)
                .get().importExternalTexture(null);
    }

    @Test
    void testLimits() throws InterruptedException, ExecutionException, RequestAdaptorError {
        WGPU.createInstance(null)
                .requestAdapter(null)
                .get()
                .requestDevice(null)
                .get().limits();
    }

    @Test
    void testPtr() throws InterruptedException, ExecutionException, RequestAdaptorError {
        var device = WGPU.createInstance(null)
                .requestAdapter(null)
                .get()
                .requestDevice(null)
                .get();

        assertFalse(device.ptr().equals(MemorySegment.NULL), "Device pointer should not be NULL");
        logger.info("Device pointer: " + device.ptr().address());
    }

    @Test
    void testQueue() throws InterruptedException, ExecutionException, RequestAdaptorError {
        WGPU.createInstance(null)
                .requestAdapter(null)
                .get()
                .requestDevice(null)
                .get().queue();
    }

    @Test
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
