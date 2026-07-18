package org.webgpu.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.ValueLayout;
import java.lang.reflect.Field;
import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.BooleanSupplier;

import org.junit.jupiter.api.Test;
import org.webgpu.api.BufferUsage;
import org.webgpu.api.CallbackMode;
import org.webgpu.api.DeviceDescriptor;
import org.webgpu.api.InstanceDescriptor;
import org.webgpu.api.MapAsyncStatus;
import org.webgpu.api.MapMode;
import org.webgpu.api.RequestAdapterOptions;
import org.webgpu.api.RequestAdapterStatus;
import org.webgpu.api.RequestDeviceStatus;
import org.webgpu.api.SType;
import org.webgpu.impl.spi.WGPUProviderImpl;
import org.webgpu.impl.util.StringViewMapper;
import org.webgpu.impl.util.StructTools;
import org.webgpu.panama.WGPUBufferMapCallback;
import org.webgpu.panama.WGPUBufferMapCallbackInfo;
import org.webgpu.panama.WGPUBufferDescriptor;
import org.webgpu.panama.WGPUBindGroupDescriptor;
import org.webgpu.panama.WGPUBindGroupEntry;
import org.webgpu.panama.WGPUChainedStruct;
import org.webgpu.panama.WGPUCommandBufferDescriptor;
import org.webgpu.panama.WGPUCommandEncoderDescriptor;
import org.webgpu.panama.WGPUComputePassDescriptor;
import org.webgpu.panama.WGPUComputePipelineDescriptor;
import org.webgpu.panama.WGPUComputeState;
import org.webgpu.panama.WGPURequestAdapterCallback;
import org.webgpu.panama.WGPURequestAdapterCallbackInfo;
import org.webgpu.panama.WGPURequestDeviceCallback;
import org.webgpu.panama.WGPURequestDeviceCallbackInfo;
import org.webgpu.panama.WGPUShaderModuleDescriptor;
import org.webgpu.panama.WGPUShaderSourceWGSL;
import org.webgpu.panama.webgpu_h;

public class RunShaderIT {

    private static final long F32_BYTES = Float.BYTES;
    private static final int MATRIX_DIM = 2;
    private static final int ELEMENT_COUNT = MATRIX_DIM * MATRIX_DIM;
    private static final long BUFFER_BYTES = ELEMENT_COUNT * F32_BYTES;
    private static final Duration TIMEOUT = Duration.ofSeconds(10);

    @Test
    void runShader() throws Exception {
        final var provider = new WGPUProviderImpl();
        final var instance = provider.createInstance(new InstanceDescriptor());
        final MemorySegment instancePtr = instancePtr(instance);

        final MemorySegment adapterPtr = requestAdapterBlocking(instance, instancePtr, new RequestAdapterOptions(),
                TIMEOUT);
        final MemorySegment devicePtr = requestDeviceBlocking(instance, adapterPtr, new DeviceDescriptor(), TIMEOUT);
        final MemorySegment queuePtr = webgpu_h.wgpuDeviceGetQueue(devicePtr);
        assertNotEquals(MemorySegment.NULL, queuePtr, "Failed to get device queue");

        final float[] matrixA = new float[] {
                1.0f, 2.0f,
                3.0f, 4.0f
        };
        final float[] matrixB = new float[] {
                5.0f, 6.0f,
                7.0f, 8.0f
        };
        final float[] expected = new float[] {
                19.0f, 22.0f,
                43.0f, 50.0f
        };

        final long storageCopyDstUsage = BufferUsage.STORAGE.value() | BufferUsage.COPY_DST.value();
        final long storageCopySrcUsage = BufferUsage.STORAGE.value() | BufferUsage.COPY_SRC.value();
        final long mapReadCopyDstUsage = BufferUsage.MAP_READ.value() | BufferUsage.COPY_DST.value();

        final MemorySegment aBufferPtr = createBuffer(devicePtr, BUFFER_BYTES, storageCopyDstUsage);
        final MemorySegment bBufferPtr = createBuffer(devicePtr, BUFFER_BYTES, storageCopyDstUsage);
        final MemorySegment outputBufferPtr = createBuffer(devicePtr, BUFFER_BYTES, storageCopySrcUsage);
        final MemorySegment readbackBufferPtr = createBuffer(devicePtr, BUFFER_BYTES, mapReadCopyDstUsage);

        try (Arena dataArena = Arena.ofConfined()) {
            webgpu_h.wgpuQueueWriteBuffer(queuePtr, aBufferPtr, 0,
                    dataArena.allocateFrom(ValueLayout.JAVA_FLOAT, matrixA), BUFFER_BYTES);
            webgpu_h.wgpuQueueWriteBuffer(queuePtr, bBufferPtr, 0,
                    dataArena.allocateFrom(ValueLayout.JAVA_FLOAT, matrixB), BUFFER_BYTES);
        }

        final MemorySegment shaderModulePtr = createShaderModule(devicePtr, """
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

                    outData[idx] = sum;
                }
                """);
        assertNotEquals(MemorySegment.NULL, shaderModulePtr, "Failed to create shader module");

        final MemorySegment computePipelinePtr = createComputePipeline(devicePtr, shaderModulePtr, "main");
        assertNotEquals(MemorySegment.NULL, computePipelinePtr, "Failed to create compute pipeline");

        final MemorySegment bindGroupLayoutPtr = webgpu_h.wgpuComputePipelineGetBindGroupLayout(computePipelinePtr, 0);
        assertNotEquals(MemorySegment.NULL, bindGroupLayoutPtr, "Failed to get bind group layout from pipeline");

        final MemorySegment bindGroupPtr = createBindGroup(
                devicePtr,
                bindGroupLayoutPtr,
                aBufferPtr,
                bBufferPtr,
                outputBufferPtr,
                BUFFER_BYTES);
        assertNotEquals(MemorySegment.NULL, bindGroupPtr, "Failed to create bind group");

        submitComputePass(
                devicePtr,
                queuePtr,
                computePipelinePtr,
                bindGroupPtr,
                outputBufferPtr,
                readbackBufferPtr,
                BUFFER_BYTES);

        final float[] actual = mapAndReadF32(instance, readbackBufferPtr, BUFFER_BYTES, ELEMENT_COUNT, TIMEOUT);
        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], actual[i], 1e-5f,
                    "Matrix output mismatch at index " + i);
        }

        webgpu_h.wgpuBufferUnmap(readbackBufferPtr);
        webgpu_h.wgpuBufferDestroy(outputBufferPtr);
        webgpu_h.wgpuBufferDestroy(readbackBufferPtr);
        webgpu_h.wgpuBufferDestroy(aBufferPtr);
        webgpu_h.wgpuBufferDestroy(bBufferPtr);
        webgpu_h.wgpuDeviceDestroy(devicePtr);
    }

    private static MemorySegment createBuffer(MemorySegment devicePtr, long size, long usageFlags) {
        try (Arena arena = Arena.ofConfined()) {
            final MemorySegment descriptor = WGPUBufferDescriptor.allocate(arena);
            WGPUBufferDescriptor.nextInChain(descriptor, MemorySegment.NULL);
            WGPUBufferDescriptor.label(descriptor, StringViewMapper.map("", arena));
            WGPUBufferDescriptor.usage(descriptor, usageFlags);
            WGPUBufferDescriptor.size(descriptor, size);
            WGPUBufferDescriptor.mappedAtCreation(descriptor, webgpu_h.WGPU_FALSE());

            final MemorySegment buffer = webgpu_h.wgpuDeviceCreateBuffer(devicePtr, descriptor);
            assertNotEquals(MemorySegment.NULL, buffer, "Failed to create buffer");
            return buffer;
        }
    }

    private static MemorySegment createShaderModule(MemorySegment devicePtr, String wgslSource) {
        try (Arena arena = Arena.ofConfined()) {
            final MemorySegment moduleDescriptor = WGPUShaderModuleDescriptor.allocate(arena);
            final MemorySegment wgslDescriptor = WGPUShaderSourceWGSL.allocate(arena);

            final MemorySegment chain = WGPUShaderSourceWGSL.chain(wgslDescriptor);
            WGPUChainedStruct.next(chain, MemorySegment.NULL);
            WGPUChainedStruct.sType(chain, SType.SHADER_SOURCE_WGSL.value());

            WGPUShaderSourceWGSL.code(wgslDescriptor, StringViewMapper.map(wgslSource, arena));
            WGPUShaderModuleDescriptor.nextInChain(moduleDescriptor, chain);
            WGPUShaderModuleDescriptor.label(moduleDescriptor, StringViewMapper.map("", arena));

            return webgpu_h.wgpuDeviceCreateShaderModule(devicePtr, moduleDescriptor);
        }
    }

    private static MemorySegment createComputePipeline(MemorySegment devicePtr, MemorySegment shaderModulePtr,
            String entryPoint) {
        try (Arena arena = Arena.ofConfined()) {
            final MemorySegment computeState = WGPUComputeState.allocate(arena);
            WGPUComputeState.nextInChain(computeState, MemorySegment.NULL);
            WGPUComputeState.module(computeState, shaderModulePtr);
            WGPUComputeState.entryPoint(computeState, StringViewMapper.map(entryPoint, arena));
            WGPUComputeState.constantCount(computeState, 0);
            WGPUComputeState.constants(computeState, MemorySegment.NULL);

            final MemorySegment pipelineDescriptor = WGPUComputePipelineDescriptor.allocate(arena);
            WGPUComputePipelineDescriptor.nextInChain(pipelineDescriptor, MemorySegment.NULL);
            WGPUComputePipelineDescriptor.label(pipelineDescriptor, StringViewMapper.map("", arena));
            WGPUComputePipelineDescriptor.layout(pipelineDescriptor, MemorySegment.NULL);
            WGPUComputePipelineDescriptor.compute(pipelineDescriptor, computeState);

            return webgpu_h.wgpuDeviceCreateComputePipeline(devicePtr, pipelineDescriptor);
        }
    }

    private static MemorySegment createBindGroup(MemorySegment devicePtr, MemorySegment bindGroupLayoutPtr,
            MemorySegment aBufferPtr, MemorySegment bBufferPtr, MemorySegment outBufferPtr, long bindingSize) {
        try (Arena arena = Arena.ofConfined()) {
            final MemorySegment entries = WGPUBindGroupEntry.allocateArray(3, arena);

            final MemorySegment aEntry = WGPUBindGroupEntry.asSlice(entries, 0);
            WGPUBindGroupEntry.nextInChain(aEntry, MemorySegment.NULL);
            WGPUBindGroupEntry.binding(aEntry, 0);
            WGPUBindGroupEntry.buffer(aEntry, aBufferPtr);
            WGPUBindGroupEntry.offset(aEntry, 0);
            WGPUBindGroupEntry.size(aEntry, bindingSize);
            WGPUBindGroupEntry.sampler(aEntry, MemorySegment.NULL);
            WGPUBindGroupEntry.textureView(aEntry, MemorySegment.NULL);

            final MemorySegment bEntry = WGPUBindGroupEntry.asSlice(entries, 1);
            WGPUBindGroupEntry.nextInChain(bEntry, MemorySegment.NULL);
            WGPUBindGroupEntry.binding(bEntry, 1);
            WGPUBindGroupEntry.buffer(bEntry, bBufferPtr);
            WGPUBindGroupEntry.offset(bEntry, 0);
            WGPUBindGroupEntry.size(bEntry, bindingSize);
            WGPUBindGroupEntry.sampler(bEntry, MemorySegment.NULL);
            WGPUBindGroupEntry.textureView(bEntry, MemorySegment.NULL);

            final MemorySegment outEntry = WGPUBindGroupEntry.asSlice(entries, 2);
            WGPUBindGroupEntry.nextInChain(outEntry, MemorySegment.NULL);
            WGPUBindGroupEntry.binding(outEntry, 2);
            WGPUBindGroupEntry.buffer(outEntry, outBufferPtr);
            WGPUBindGroupEntry.offset(outEntry, 0);
            WGPUBindGroupEntry.size(outEntry, bindingSize);
            WGPUBindGroupEntry.sampler(outEntry, MemorySegment.NULL);
            WGPUBindGroupEntry.textureView(outEntry, MemorySegment.NULL);

            final MemorySegment descriptor = WGPUBindGroupDescriptor.allocate(arena);
            WGPUBindGroupDescriptor.nextInChain(descriptor, MemorySegment.NULL);
            WGPUBindGroupDescriptor.label(descriptor, StringViewMapper.map("", arena));
            WGPUBindGroupDescriptor.layout(descriptor, bindGroupLayoutPtr);
            WGPUBindGroupDescriptor.entryCount(descriptor, 3);
            WGPUBindGroupDescriptor.entries(descriptor, entries);

            return webgpu_h.wgpuDeviceCreateBindGroup(devicePtr, descriptor);
        }
    }

    private static void submitComputePass(MemorySegment devicePtr, MemorySegment queuePtr, MemorySegment pipelinePtr,
            MemorySegment bindGroupPtr, MemorySegment outputBufferPtr, MemorySegment readbackBufferPtr,
            long bufferBytes) {
        try (Arena arena = Arena.ofConfined()) {
            final MemorySegment commandEncoderDescriptor = WGPUCommandEncoderDescriptor.allocate(arena);
            WGPUCommandEncoderDescriptor.nextInChain(commandEncoderDescriptor, MemorySegment.NULL);
            WGPUCommandEncoderDescriptor.label(commandEncoderDescriptor, StringViewMapper.map("", arena));
            final MemorySegment commandEncoderPtr = webgpu_h.wgpuDeviceCreateCommandEncoder(devicePtr,
                    commandEncoderDescriptor);

            final MemorySegment computePassDescriptor = WGPUComputePassDescriptor.allocate(arena);
            WGPUComputePassDescriptor.nextInChain(computePassDescriptor, MemorySegment.NULL);
            WGPUComputePassDescriptor.label(computePassDescriptor, StringViewMapper.map("", arena));
            WGPUComputePassDescriptor.timestampWrites(computePassDescriptor, MemorySegment.NULL);

            final MemorySegment computePassEncoderPtr = webgpu_h.wgpuCommandEncoderBeginComputePass(
                    commandEncoderPtr,
                    computePassDescriptor);
            webgpu_h.wgpuComputePassEncoderSetPipeline(computePassEncoderPtr, pipelinePtr);
            webgpu_h.wgpuComputePassEncoderSetBindGroup(computePassEncoderPtr, 0, bindGroupPtr, 0,
                    MemorySegment.NULL);
            webgpu_h.wgpuComputePassEncoderDispatchWorkgroups(computePassEncoderPtr, 1, 1, 1);
            webgpu_h.wgpuComputePassEncoderEnd(computePassEncoderPtr);

            webgpu_h.wgpuCommandEncoderCopyBufferToBuffer(commandEncoderPtr, outputBufferPtr, 0, readbackBufferPtr, 0,
                    bufferBytes);

            final MemorySegment commandBufferDescriptor = WGPUCommandBufferDescriptor.allocate(arena);
            WGPUCommandBufferDescriptor.nextInChain(commandBufferDescriptor, MemorySegment.NULL);
            WGPUCommandBufferDescriptor.label(commandBufferDescriptor, StringViewMapper.map("", arena));
            final MemorySegment commandBufferPtr = webgpu_h.wgpuCommandEncoderFinish(commandEncoderPtr,
                    commandBufferDescriptor);

            final MemorySegment commandsArray = arena.allocate(ValueLayout.ADDRESS);
            commandsArray.set(ValueLayout.ADDRESS, 0, commandBufferPtr);
            webgpu_h.wgpuQueueSubmit(queuePtr, 1, commandsArray);
        }
    }

    private static MemorySegment requestAdapterBlocking(InstanceImpl instance, MemorySegment instancePtr,
            RequestAdapterOptions options,
            Duration timeout) {
        final AtomicReference<RequestAdapterStatus> status = new AtomicReference<>();
        final AtomicReference<MemorySegment> adapter = new AtomicReference<>();
        final AtomicReference<String> message = new AtomicReference<>("");

        try (Arena arena = Arena.ofConfined()) {
            final MemorySegment callbackInfo = WGPURequestAdapterCallbackInfo.allocate(arena);
            final MemorySegment callback = WGPURequestAdapterCallback.allocate(
                    (int nativeStatus, MemorySegment nativeAdapter, MemorySegment nativeMessage,
                            MemorySegment userData1,
                            MemorySegment userData2) -> {
                        status.set(RequestAdapterStatus.values()[nativeStatus]);
                        if (nativeAdapter != MemorySegment.NULL) {
                            adapter.set(nativeAdapter);
                        }
                        if (nativeMessage != MemorySegment.NULL) {
                            message.set(StringViewMapper.map(nativeMessage));
                        }
                    },
                    arena);

            WGPURequestAdapterCallbackInfo.callback(callbackInfo, callback);
            WGPURequestAdapterCallbackInfo.mode(callbackInfo, CallbackMode.ALLOW_PROCESS_EVENTS.value());
            WGPURequestAdapterCallbackInfo.nextInChain(callbackInfo, MemorySegment.NULL);
            WGPURequestAdapterCallbackInfo.userdata1(callbackInfo, MemorySegment.NULL);
            WGPURequestAdapterCallbackInfo.userdata2(callbackInfo, MemorySegment.NULL);

            webgpu_h.wgpuInstanceRequestAdapter(
                    arena,
                    instancePtr,
                    StructTools.fetchSegment(options),
                    callbackInfo);

            waitForCallback(instance, () -> status.get() != null, timeout, "adapter request callback");
        }

        assertSame(RequestAdapterStatus.SUCCESS, status.get(),
                "Adapter request failed: " + status.get() + " message=" + message.get());
        assertNotNull(adapter.get(), "Adapter callback returned null adapter");
        return adapter.get();
    }

    private static MemorySegment requestDeviceBlocking(InstanceImpl instance, MemorySegment adapterPtr,
            DeviceDescriptor descriptor,
            Duration timeout) {
        final AtomicReference<RequestDeviceStatus> status = new AtomicReference<>();
        final AtomicReference<MemorySegment> device = new AtomicReference<>();
        final AtomicReference<String> message = new AtomicReference<>("");

        try (Arena arena = Arena.ofConfined()) {
            final MemorySegment callbackInfo = WGPURequestDeviceCallbackInfo.allocate(arena);
            final MemorySegment callback = WGPURequestDeviceCallback.allocate(
                    (int nativeStatus, MemorySegment nativeDevice, MemorySegment nativeMessage, MemorySegment userData1,
                            MemorySegment userData2) -> {
                        status.set(RequestDeviceStatus.values()[nativeStatus]);
                        if (nativeDevice != MemorySegment.NULL) {
                            device.set(nativeDevice);
                        }
                        if (nativeMessage != MemorySegment.NULL) {
                            message.set(StringViewMapper.map(nativeMessage));
                        }
                    },
                    arena);

            WGPURequestDeviceCallbackInfo.callback(callbackInfo, callback);
            WGPURequestDeviceCallbackInfo.mode(callbackInfo, CallbackMode.ALLOW_PROCESS_EVENTS.value());
            WGPURequestDeviceCallbackInfo.nextInChain(callbackInfo, MemorySegment.NULL);
            WGPURequestDeviceCallbackInfo.userdata1(callbackInfo, MemorySegment.NULL);
            WGPURequestDeviceCallbackInfo.userdata2(callbackInfo, MemorySegment.NULL);

            webgpu_h.wgpuAdapterRequestDevice(
                    arena,
                    adapterPtr,
                    StructTools.fetchSegment(descriptor),
                    callbackInfo);

            waitForCallback(instance, () -> status.get() != null, timeout, "device request callback");
        }

        assertSame(RequestDeviceStatus.SUCCESS, status.get(),
                "Device request failed: " + status.get() + " message=" + message.get());
        assertNotNull(device.get(), "Device callback returned null device");
        return device.get();
    }

    private static float[] mapAndReadF32(InstanceImpl instance, MemorySegment bufferPtr, long byteSize, int floatCount,
            Duration timeout) {
        final AtomicReference<MapAsyncStatus> mapStatus = new AtomicReference<>();

        try (Arena arena = Arena.ofConfined()) {
            final MemorySegment callbackInfo = WGPUBufferMapCallbackInfo.allocate(arena);
            final MemorySegment callback = WGPUBufferMapCallback.allocate(
                    (int nativeStatus, MemorySegment nativeMessage, MemorySegment userData1,
                            MemorySegment userData2) -> mapStatus.set(MapAsyncStatus.values()[nativeStatus]),
                    arena);

            WGPUBufferMapCallbackInfo.callback(callbackInfo, callback);
            WGPUBufferMapCallbackInfo.mode(callbackInfo, CallbackMode.ALLOW_PROCESS_EVENTS.value());
            WGPUBufferMapCallbackInfo.nextInChain(callbackInfo, MemorySegment.NULL);
            WGPUBufferMapCallbackInfo.userdata1(callbackInfo, MemorySegment.NULL);
            WGPUBufferMapCallbackInfo.userdata2(callbackInfo, MemorySegment.NULL);

            webgpu_h.wgpuBufferMapAsync(
                    arena,
                    bufferPtr,
                    MapMode.READ.value(),
                    0,
                    byteSize,
                    callbackInfo);

            waitForCallback(instance, () -> mapStatus.get() != null, timeout, "buffer map callback");
        }

        assertSame(MapAsyncStatus.SUCCESS, mapStatus.get(), "Buffer mapAsync failed: " + mapStatus.get());

        final MemorySegment mappedData = webgpu_h.wgpuBufferGetConstMappedRange(bufferPtr, 0, byteSize);
        assertNotEquals(MemorySegment.NULL, mappedData, "Mapped range was null");

        final float[] values = new float[floatCount];
        for (int i = 0; i < floatCount; i++) {
            values[i] = mappedData.get(ValueLayout.JAVA_FLOAT, (long) i * F32_BYTES);
        }
        return values;
    }

    private static void waitForCallback(InstanceImpl instance, BooleanSupplier completed, Duration timeout,
            String operation) {
        final Instant deadline = Instant.now().plus(timeout);
        while (Instant.now().isBefore(deadline)) {
            if (completed.getAsBoolean()) {
                return;
            }
            instance.processEvents();
        }

        throw new AssertionError("Timed out waiting for " + operation);
    }

    private static MemorySegment instancePtr(InstanceImpl instance) throws Exception {
        final Field field = InstanceImpl.class.getDeclaredField("memorySegment");
        field.setAccessible(true);
        return (MemorySegment) field.get(instance);
    }
}
