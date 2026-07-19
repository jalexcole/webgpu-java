package org.webgpu.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.ValueLayout;
import java.time.Duration;
import java.time.Instant;
import java.util.EnumSet;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

import org.junit.jupiter.api.Test;
import org.webgpu.api.Adapter;
import org.webgpu.api.BindGroup;
import org.webgpu.api.BindGroupDescriptor;
import org.webgpu.api.BindGroupEntry;
import org.webgpu.api.BindGroupLayout;
import org.webgpu.api.Buffer;
import org.webgpu.api.BufferDescriptor;
import org.webgpu.api.BufferUsage;
import org.webgpu.api.CommandBuffer;
import org.webgpu.api.CommandBufferDescriptor;
import org.webgpu.api.CommandEncoder;
import org.webgpu.api.CommandEncoderDescriptor;
import org.webgpu.api.ComputePassDescriptor;
import org.webgpu.api.ComputePassEncoder;
import org.webgpu.api.ComputePipeline;
import org.webgpu.api.ComputePipelineDescriptor;
import org.webgpu.api.ComputeState;
import org.webgpu.api.ConstantEntry;
import org.webgpu.api.Device;
import org.webgpu.api.DeviceDescriptor;
import org.webgpu.api.Instance;
import org.webgpu.api.InstanceDescriptor;
import org.webgpu.api.MapAsyncStatus;
import org.webgpu.api.MapMode;
import org.webgpu.api.Queue;
import org.webgpu.api.RequestAdapterOptions;
import org.webgpu.api.RequestAdapterStatus;
import org.webgpu.api.RequestDeviceStatus;
import org.webgpu.api.ShaderModule;
import org.webgpu.api.ShaderSourceWGSL;
import org.webgpu.api.WGPU;

class RunShaderApiIT {

    private static final Duration TIMEOUT = Duration.ofSeconds(10);

    @Test
    void runShaderWithApiOnly() {
        final Instance instance = WGPU.createInstance(new InstanceDescriptor());

        final Adapter adapter = requestAdapter(instance, TIMEOUT);
        final Device device = requestDevice(instance, adapter, TIMEOUT);
        final Queue queue = device.getQueue();

        final float[] matrixA = new float[] { 1.0f, 2.0f, 3.0f, 4.0f };
        final float[] matrixB = new float[] { 5.0f, 6.0f, 7.0f, 8.0f };
        final float[] expected = new float[] { 19.0f, 22.0f, 43.0f, 50.0f };

        final long bufferBytes = matrixA.length * Float.BYTES;

        final Buffer aBuffer = createStorageUploadBuffer(device, bufferBytes);
        final Buffer bBuffer = createStorageUploadBuffer(device, bufferBytes);
        final Buffer outputBuffer = createStorageOutputBuffer(device, bufferBytes);
        final Buffer readbackBuffer = createReadbackBuffer(device, bufferBytes);

        Arena dataArena = Arena.ofConfined();
        queue.writeBuffer(aBuffer, 0, dataArena.allocateFrom(ValueLayout.JAVA_FLOAT, matrixA), bufferBytes);
        queue.writeBuffer(bBuffer, 0, dataArena.allocateFrom(ValueLayout.JAVA_FLOAT, matrixB), bufferBytes);

        final ShaderSourceWGSL wgsl = new ShaderSourceWGSL();
        wgsl.code("""
                override SCALE: f32 = 1.0;

                @group(0) @binding(0)
                var<storage, read> a : array<f32>;

                @group(0) @binding(1)
                var<storage, read> b : array<f32>;

                @group(0) @binding(2)
                var<storage, read_write> outData : array<f32>;

                @compute @workgroup_size(4)
                fn main(@builtin(global_invocation_id) gid : vec3<u32>) {
                    let idx = gid.x;
                    if (idx >= 4u) {
                        return;
                    }

                    let row = idx / 2u;
                    let col = idx % 2u;

                    var sum : f32 = 0.0;
                    for (var k : u32 = 0u; k < 2u; k = k + 1u) {
                        sum = sum + a[row * 2u + k] * b[k * 2u + col];
                    }

                    outData[idx] = sum * SCALE;
                }
                """);

        final ShaderModule shaderModule = device.createShaderModule(wgsl);
        assertNotNull(shaderModule, "Shader module should be created");

        final ConstantEntry scaleConstant = new ConstantEntry();
        scaleConstant.key("SCALE");
        scaleConstant.value(1.0);

        final ComputeState computeState = new ComputeState();
        computeState.module(shaderModule);
        computeState.entryPoint("main");
        computeState.constants(new ConstantEntry[] { scaleConstant });

        final ComputePipelineDescriptor pipelineDescriptor = new ComputePipelineDescriptor();
        pipelineDescriptor.compute(computeState);

        final ComputePipeline pipeline = device.createComputePipeline(pipelineDescriptor);
        assertNotNull(pipeline, "Compute pipeline should be created");

        final BindGroupLayout bindGroupLayout = pipeline.getBindGroupLayout(0);
        assertNotNull(bindGroupLayout, "Bind group layout should be available from pipeline");

        final BindGroupEntry entryA = new BindGroupEntry();
        entryA.binding(0);
        entryA.buffer(aBuffer);
        entryA.offset(0);
        entryA.size(bufferBytes);

        final BindGroupEntry entryB = new BindGroupEntry();
        entryB.binding(1);
        entryB.buffer(bBuffer);
        entryB.offset(0);
        entryB.size(bufferBytes);

        final BindGroupEntry entryOut = new BindGroupEntry();
        entryOut.binding(2);
        entryOut.buffer(outputBuffer);
        entryOut.offset(0);
        entryOut.size(bufferBytes);

        final BindGroupDescriptor bindGroupDescriptor = new BindGroupDescriptor();
        bindGroupDescriptor.layout(bindGroupLayout);
        bindGroupDescriptor.entries(new BindGroupEntry[] { entryA, entryB, entryOut });

        final BindGroup bindGroup = device.createBindGroup(bindGroupDescriptor);
        assertNotNull(bindGroup, "Bind group should be created");

        final CommandEncoder encoder = device.createCommandEncoder(new CommandEncoderDescriptor());
        final ComputePassEncoder pass = encoder.beginComputePass(new ComputePassDescriptor());
        pass.setPipeline(pipeline);
        pass.setBindGroup(0, bindGroup, new int[0]);
        pass.dispatchWorkgroups(4, 1, 1);
        pass.end();

        encoder.copyBufferToBuffer(outputBuffer, 0, readbackBuffer, 0, bufferBytes);
        final CommandBuffer commands = encoder.finish(new CommandBufferDescriptor());
        queue.submit(new CommandBuffer[] { commands });

        final AtomicBoolean mapDone = new AtomicBoolean(false);
        final AtomicReference<MapAsyncStatus> mapStatus = new AtomicReference<>(MapAsyncStatus.NULL);
        final AtomicReference<String> mapMessage = new AtomicReference<>("");

        readbackBuffer.mapAsync((status, message) -> {
            mapStatus.set(status);
            mapMessage.set(message == null ? "" : message);
            mapDone.set(true);
        }, EnumSet.of(MapMode.READ), 0, bufferBytes);

        waitUntil(instance, mapDone::get, TIMEOUT, "Timed out waiting for mapAsync callback");

        assertEquals(MapAsyncStatus.SUCCESS, mapStatus.get(), "mapAsync failed: " + mapMessage.get());

        final MemorySegment mapped = readbackBuffer.getConstMappedRange(0, bufferBytes);
        final float[] actual = new float[expected.length];
        for (int i = 0; i < actual.length; i++) {
            actual[i] = mapped.getAtIndex(ValueLayout.JAVA_FLOAT, i);
        }

        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], actual[i], 1e-5f, "Mismatch at index " + i);
        }

        readbackBuffer.unmap();
        outputBuffer.destroy();
        readbackBuffer.destroy();
        aBuffer.destroy();
        bBuffer.destroy();
        device.destroy();
    }

    private static Adapter requestAdapter(Instance instance, Duration timeout) {
        final AtomicReference<RequestAdapterStatus> statusRef = new AtomicReference<>(RequestAdapterStatus.NULL);
        final AtomicReference<Adapter> adapterRef = new AtomicReference<>();
        final AtomicReference<String> messageRef = new AtomicReference<>("");
        final AtomicBoolean done = new AtomicBoolean(false);

        instance.requestAdapter((status, adapter, message) -> {
            statusRef.set(status);
            adapterRef.set(adapter);
            messageRef.set(message == null ? "" : message);
            done.set(true);
        }, new RequestAdapterOptions());

        waitUntil(instance, done::get, timeout, "Timed out waiting for adapter request");
        assertEquals(RequestAdapterStatus.SUCCESS, statusRef.get(),
                "requestAdapter failed: " + messageRef.get());
        assertNotNull(adapterRef.get(), "Adapter should not be null on success");
        return adapterRef.get();
    }

    private static Device requestDevice(Instance instance, Adapter adapter, Duration timeout) {
        final AtomicReference<RequestDeviceStatus> statusRef = new AtomicReference<>(RequestDeviceStatus.NULL);
        final AtomicReference<Device> deviceRef = new AtomicReference<>();
        final AtomicReference<String> messageRef = new AtomicReference<>("");
        final AtomicBoolean done = new AtomicBoolean(false);

        adapter.requestDevice((status, device, message) -> {
            statusRef.set(status);
            deviceRef.set(device);
            messageRef.set(message == null ? "" : message);
            done.set(true);
        }, new DeviceDescriptor());

        waitUntil(instance, done::get, timeout, "Timed out waiting for device request");
        assertEquals(RequestDeviceStatus.SUCCESS, statusRef.get(),
                "requestDevice failed: " + messageRef.get());
        assertNotNull(deviceRef.get(), "Device should not be null on success");
        return deviceRef.get();
    }

    private static Buffer createStorageUploadBuffer(Device device, long size) {
        final BufferDescriptor descriptor = new BufferDescriptor();
        descriptor.size(size);
        descriptor.usage(EnumSet.of(BufferUsage.STORAGE, BufferUsage.COPY_DST));
        return device.createBuffer(descriptor);
    }

    private static Buffer createStorageOutputBuffer(Device device, long size) {
        final BufferDescriptor descriptor = new BufferDescriptor();
        descriptor.size(size);
        descriptor.usage(EnumSet.of(BufferUsage.STORAGE, BufferUsage.COPY_SRC));
        return device.createBuffer(descriptor);
    }

    private static Buffer createReadbackBuffer(Device device, long size) {
        final BufferDescriptor descriptor = new BufferDescriptor();
        descriptor.size(size);
        descriptor.usage(EnumSet.of(BufferUsage.MAP_READ, BufferUsage.COPY_DST));
        return device.createBuffer(descriptor);
    }

    private static void waitUntil(Instance instance, java.util.function.BooleanSupplier done, Duration timeout,
            String timeoutMessage) {
        final Instant deadline = Instant.now().plus(timeout);
        while (!done.getAsBoolean() && Instant.now().isBefore(deadline)) {
            instance.processEvents();
            Thread.yield();
        }
        assertTrue(done.getAsBoolean(), timeoutMessage);
    }
}
