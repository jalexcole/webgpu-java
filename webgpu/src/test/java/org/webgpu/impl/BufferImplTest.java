package org.webgpu.impl;

import java.util.concurrent.ExecutionException;
import java.util.logging.Logger;

import org.junit.jupiter.api.Test;
import org.webgpu.api.Buffer;
import org.webgpu.api.BufferDescriptor;
import org.webgpu.api.WGPU;
import org.webgpu.exceptions.RequestAdaptorError;

public class BufferImplTest {

    private static final Logger logger = Logger.getLogger(BufferImplTest.class.getName());
    @Test
    void testDestroy() throws InterruptedException, ExecutionException, RequestAdaptorError {
        final var instance = WGPU.createInstance(null);
        var adapter = instance.requestAdapter(null).get();
        var device = adapter.requestDevice(null).get();
        var bufferDescriptor = new BufferDescriptor();
        bufferDescriptor.mappedAtCreation();
        logger.info("Creating buffer...: " + bufferDescriptor);
        Buffer buffer = device.createBuffer(bufferDescriptor);
        logger.info("Buffer created: " + buffer);

        try {buffer.destroy();} catch (Exception e) {
            logger.severe("Failed to destroy buffer: " + e.getMessage());
        } finally {
            throw new RuntimeException("Test exception");
        }
        // logger.info("Buffer destroyed: " + buffer);
    }

    @Test
    void testEquals() {

    }

    @Test
    void testGetMapState() throws InterruptedException, ExecutionException, RequestAdaptorError {
        final var instance = WGPU.createInstance(null);
        var adapter = instance.requestAdapter(null).get();
        var device = adapter.requestDevice(null).get();
        var bufferDescriptor = new BufferDescriptor();

        logger.info("Creating buffer...: " + bufferDescriptor);
        var buffer = device.createBuffer(bufferDescriptor);
        logger.info("Buffer created: " + buffer);

        var mapState = buffer.getMapState();
        logger.info("Buffer map state: " + mapState);
    }

    @Test
    void testGetSize() throws InterruptedException, ExecutionException, RequestAdaptorError {
        final var instance = WGPU.createInstance(null);
        var adapter = instance.requestAdapter(null).get();
        var device = adapter.requestDevice(null).get();
        var bufferDescriptor = new BufferDescriptor();

        logger.info("Creating buffer...: " + bufferDescriptor);
        var buffer = device.createBuffer(bufferDescriptor);
        logger.info("Buffer created: " + buffer);

        var size = buffer.getSize();
        logger.info("Buffer size: " + size);
    }

    @Test
    void testGetUsage() throws InterruptedException, ExecutionException, RequestAdaptorError {
        final var instance = WGPU.createInstance(null);
        var adapter = instance.requestAdapter(null).get();
        var device = adapter.requestDevice(null).get();
        var bufferDescriptor = new BufferDescriptor();

        logger.info("Creating buffer...: " + bufferDescriptor);
        var buffer = device.createBuffer(bufferDescriptor);
        logger.info("Buffer created: " + buffer);

        var usage = buffer.getUsage();
        logger.info("Buffer usage: " + usage);
    }

    @Test
    void testHashCode() throws InterruptedException, ExecutionException, RequestAdaptorError {
        final var instance = WGPU.createInstance(null);
        var adapter = instance.requestAdapter(null).get();
        var device = adapter.requestDevice(null).get();
        var bufferDescriptor = new BufferDescriptor();

        logger.info("Creating buffer...: " + bufferDescriptor);
        var buffer = device.createBuffer(bufferDescriptor);
        logger.info("Buffer created: " + buffer);

        int hashCode = buffer.hashCode();
        logger.info("Buffer hash code: " + hashCode);
    }

    @Test
    void testPtr() {

    }

    @Test
    void testToString() throws InterruptedException, ExecutionException, RequestAdaptorError {
        final var instance = WGPU.createInstance(null);
        var adapter = instance.requestAdapter(null).get();
        var device = adapter.requestDevice(null).get();
        var bufferDescriptor = new BufferDescriptor();

        logger.info("Creating buffer...: " + bufferDescriptor);
        var buffer = device.createBuffer(bufferDescriptor);
        logger.info("Buffer created: " + buffer);

        String str = buffer.toString();
        logger.info("Buffer toString: " + str);
    }
}
