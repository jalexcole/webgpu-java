package org.webgpu.impl;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.concurrent.ExecutionException;

import org.junit.jupiter.api.Test;
import org.webgpu.api.BufferDescriptor;
import org.webgpu.api.ComputePassEncoder;
import org.webgpu.api.WGPU;
import org.webgpu.exceptions.RequestAdaptorError;

public class ComputePassEncoderImplTest {
    @Test
    void testDispatchWorkgroups() throws InterruptedException, ExecutionException, RequestAdaptorError {
        var encoder = buildComputePassEncoder();
        
        encoder.dispatchWorkgroups(1, 1, 1);
    }

    private ComputePassEncoder buildComputePassEncoder() throws InterruptedException, ExecutionException, RequestAdaptorError {
        var instance = WGPU.createInstance(null);
        var adapter = instance.requestAdapter(null).get();
        var device = adapter.requestDevice(null).get();

        var computePassEncoder = device.createCommandEncoder(null);
        return computePassEncoder.beginComputePass(null);
    }

    @Test
    void testDispatchWorkgroupsIndirect() throws InterruptedException, ExecutionException, RequestAdaptorError {
        var instance = WGPU.createInstance(null);
        var adapter = instance.requestAdapter(null).get();
        var device = adapter.requestDevice(null).get();

        var commandEncoder = device.createCommandEncoder(null);
        var computePassEncoder = commandEncoder.beginComputePass(null);
        var bufferDescriptor = new BufferDescriptor();
        
        computePassEncoder.dispatchWorkgroupsIndirect(device.createBuffer(bufferDescriptor), 0);

        assertTrue(true);
    }

/*************  ✨ Windsurf Command ⭐  *************/
/**
 * Tests the end method of the ComputePassEncoder. This method
 * finalizes the compute pass encoder, ensuring that it properly
 * completes the encoding process without errors.
 *
 * @throws InterruptedException if the computation is interrupted.
 * @throws ExecutionException if an exception occurs during the execution.
 * @throws RequestAdaptorError if an error occurs while requesting the adapter.
 */

/*******  71021556-02a8-4cb5-8e86-43ad09f67a80  *******/
    @Test
    void testEnd() throws InterruptedException, ExecutionException, RequestAdaptorError {
        var encoder = buildComputePassEncoder();
        encoder.end();  
    }

    @Test
    void testEquals() {

    }

    @Test
    void testHashCode() throws InterruptedException, ExecutionException, RequestAdaptorError {
        var encoder = buildComputePassEncoder();
        encoder.hashCode();
    }

    @Test
    void testPtr() throws InterruptedException, ExecutionException, RequestAdaptorError {
        var encoder = buildComputePassEncoder();
        encoder.ptr();
    }

    @Test
    void testSetPipeline() throws InterruptedException, ExecutionException, RequestAdaptorError {
        var encoder = buildComputePassEncoder();
        encoder.setPipeline(null);
    }

    @Test
    void testToString() throws InterruptedException, ExecutionException, RequestAdaptorError {
        var encoder = buildComputePassEncoder();
        System.out.println(encoder.toString());
    }
}
