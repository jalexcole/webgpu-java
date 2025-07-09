package org.webgpu;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.concurrent.ExecutionException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.webgpu.extract.webgpu_h;
import org.webgpu.impl.AdapterImpl;
import org.webgpu.impl.InstanceImpl;

public class WGPUTest {


    @Test
    void testCreateInstance() {
        var nullDescriptorInstance = WGPU.createInstance(null);

        assertNotNull(nullDescriptorInstance);

        var descriptorInstance = new InstanceDescriptor();
        assertNotNull(WGPU.createInstance(descriptorInstance));
    }
    @Test
    void testAdapterAddRef() throws InterruptedException, ExecutionException {
        var instance = WGPU.createInstance(null);
        var adapter = WGPU.instanceRequestAdapter((InstanceImpl)instance, new RequestAdapterOptions()).get();
        WGPU.adapterAddRef((AdapterImpl) adapter);
    }

    @Test
    void testAdapterGetFeatures() throws InterruptedException, ExecutionException {
        var instance = WGPU.createInstance(null);
        var adapter = WGPU.instanceRequestAdapter((InstanceImpl)instance, null).get();
        WGPU.adapterGetFeatures(adapter);
    }

    @Test
    void testAdapterGetInfo() throws InterruptedException, ExecutionException {
        var instance = WGPU.createInstance(null);
        var adapter = WGPU.instanceRequestAdapter((InstanceImpl)instance, null).get();
        WGPU.adapterGetInfo(adapter);
    }

    @Test
    void testAdapterGetLimits() throws InterruptedException, ExecutionException {
        var instance = WGPU.createInstance(null);
        var adapter = WGPU.instanceRequestAdapter((InstanceImpl)instance, null).get();
        WGPU.adapterGetLimits(adapter);
    }

    @Test
    void testAdapterHasFeature() throws InterruptedException, ExecutionException {
        var instance = WGPU.createInstance(null);
        var adapter = WGPU.instanceRequestAdapter((InstanceImpl)instance, new RequestAdapterOptions()).get();
        WGPU.adapterHasFeature((AdapterImpl) adapter, FeatureName.UNDEFINED);
        
    }

    @Test
    void testAdapterInfoFreeMembers() {
        AdapterInfo adapterInfo = new AdapterInfo();
        WGPU.adapterInfoFreeMembers(adapterInfo);
    }

    @Test
    void testAdapterRelease() throws InterruptedException, ExecutionException {
        var instance = WGPU.createInstance(null);
        var adapter = WGPU.instanceRequestAdapter((InstanceImpl)instance, null).get();
        WGPU.adapterRelease((AdapterImpl) adapter);
    }

    @Test
    void testAdapterRequestDevice() throws InterruptedException, ExecutionException {
        var instance = WGPU.createInstance(null);
        var adapter = WGPU.instanceRequestAdapter((InstanceImpl)instance, null).get();
        WGPU.adapterRequestDevice((AdapterImpl)adapter, null);
    }

    @Test
    void testBindGroupAddRef() throws InterruptedException, ExecutionException {
        var instance = WGPU.createInstance(null);
        var adapter = WGPU.instanceRequestAdapter((InstanceImpl)instance, null).get();
        var device = WGPU.adapterRequestDevice((AdapterImpl) adapter, null).get();
        var bindgroup = WGPU.deviceCreateBindGroup(device, null);
        WGPU.bindGroupAddRef(bindgroup);
    }

    @Test
    void testBindGroupLayoutAddRef() throws InterruptedException, ExecutionException {
        var instance = WGPU.createInstance(null);
        var adapter = WGPU.instanceRequestAdapter((InstanceImpl)instance, null).get();
        var device = WGPU.adapterRequestDevice((AdapterImpl) adapter, null).get();
        var bindGroupLayout = WGPU.deviceCreateBindGroupLayout(device, null);
        WGPU.bindGroupLayoutAddRef(bindGroupLayout);
    }

    @Test
    void testBindGroupLayoutRelease() throws InterruptedException, ExecutionException {
        var instance = WGPU.createInstance(null);
        var adapter = WGPU.instanceRequestAdapter((InstanceImpl)instance, null).get();
        var device = WGPU.adapterRequestDevice((AdapterImpl) adapter, null).get();
        var bindGroupLayout = WGPU.deviceCreateBindGroupLayout(device, null);
        WGPU.bindGroupLayoutRelease(bindGroupLayout);
    }

    /**
     * Verifies that setting a label on a bind group layout works.
     */
    @Test
    void testBindGroupLayoutSetLabel() throws InterruptedException, ExecutionException {
        var instance = WGPU.createInstance(null);
        var adapter = WGPU.instanceRequestAdapter((InstanceImpl)instance, null).get();
        var device = WGPU.adapterRequestDevice((AdapterImpl) adapter, null).get();
        var bindGroupLayout = WGPU.deviceCreateBindGroupLayout(device, null);
        WGPU.bindGroupLayoutSetLabel(bindGroupLayout, "test");
    }

    @Test
    void testBindGroupRelease() throws InterruptedException, ExecutionException {
        var instance = WGPU.createInstance(null);
        var adapter = WGPU.instanceRequestAdapter((InstanceImpl)instance, null).get();
        var device = WGPU.adapterRequestDevice((AdapterImpl) adapter, null).get();
        var bindgroup = WGPU.deviceCreateBindGroup(device, null);
        WGPU.bindGroupRelease(bindgroup);
    }

    @Test
    void testBindGroupSetLabel() throws InterruptedException, ExecutionException {
        var instance = WGPU.createInstance(null);
        var adapter = WGPU.instanceRequestAdapter((InstanceImpl)instance, null).get();
        var device = WGPU.adapterRequestDevice((AdapterImpl) adapter, null).get();
        var bindgroup = WGPU.deviceCreateBindGroup(device, null);
        WGPU.bindGroupSetLabel(bindgroup, "test");
    }

    @Test
    void testBufferAddRef() throws InterruptedException, ExecutionException {
        var instance = WGPU.createInstance(null);
        var adapter = WGPU.instanceRequestAdapter((InstanceImpl)instance, null).get();
        var device = WGPU.adapterRequestDevice((AdapterImpl) adapter, null).get();
        var buffer = WGPU.deviceCreateBuffer(device, null);
        WGPU.bufferAddRef(buffer);
    }

    @Test
    void testBufferDestroy() throws InterruptedException, ExecutionException {
        var instance = WGPU.createInstance(null);
        var adapter = WGPU.instanceRequestAdapter((InstanceImpl)instance, null).get();
        var device = WGPU.adapterRequestDevice((AdapterImpl) adapter, null).get();
        var buffer = WGPU.deviceCreateBuffer(device, null);
        WGPU.bufferDestroy(buffer);
    }

    @Test
    void testBufferGetConstMappedRange() throws InterruptedException, ExecutionException {
        var instance = WGPU.createInstance(null);
        var adapter = WGPU.instanceRequestAdapter((InstanceImpl)instance, null).get();
        var device = WGPU.adapterRequestDevice((AdapterImpl) adapter, null).get();
        var buffer = WGPU.deviceCreateBuffer(device, null);
        WGPU.bufferGetConstMappedRange(buffer, 0, 0);
    }

    @Test
    void testBufferGetMapState() throws InterruptedException, ExecutionException {
        var instance = WGPU.createInstance(null);
        var adapter = WGPU.instanceRequestAdapter((InstanceImpl)instance, null).get();
        var device = WGPU.adapterRequestDevice((AdapterImpl) adapter, null).get();
        var buffer = WGPU.deviceCreateBuffer(device, null);
        WGPU.bufferGetMapState(buffer);
    }

    @Test
    void testBufferGetMappedRange() throws InterruptedException, ExecutionException {
        var instance = WGPU.createInstance(null);
        var adapter = WGPU.instanceRequestAdapter((InstanceImpl)instance, null).get();
        var device = WGPU.adapterRequestDevice((AdapterImpl) adapter, null).get();
        var buffer = WGPU.deviceCreateBuffer(device, null);
        WGPU.bufferGetMappedRange(buffer, 0, 0);
    }

    @Test
    void testBufferGetSize() throws InterruptedException, ExecutionException {
        var instance = WGPU.createInstance(null);
        var adapter = WGPU.instanceRequestAdapter((InstanceImpl)instance, null).get();
        var device = WGPU.adapterRequestDevice((AdapterImpl) adapter, null).get();
        var buffer = WGPU.deviceCreateBuffer(device, null);
        WGPU.bufferGetSize(buffer);
    }

    @Test
    void testBufferMapAsync() throws InterruptedException, ExecutionException {
        var instance = WGPU.createInstance(null);
        var adapter = WGPU.instanceRequestAdapter((InstanceImpl)instance, null).get();
        var device = WGPU.adapterRequestDevice((AdapterImpl) adapter, null).get();
        var buffer = WGPU.deviceCreateBuffer(device, null);
        WGPU.bufferMapAsync(buffer, 0, 0, 0);
    }

    @Test
    void testBufferReadMappedRange() throws InterruptedException, ExecutionException {
        var instance = WGPU.createInstance(null);
        var adapter = WGPU.instanceRequestAdapter((InstanceImpl)instance, null).get();
        var device = WGPU.adapterRequestDevice((AdapterImpl) adapter, null).get();
        var buffer = WGPU.deviceCreateBuffer(device, null);
        WGPU.bufferReadMappedRange(buffer, 0, new byte[0], 0);
    }

    @Test
    void testBufferRelease() throws InterruptedException, ExecutionException {
        var instance = WGPU.createInstance(null);
        var adapter = WGPU.instanceRequestAdapter((InstanceImpl)instance, null).get();
        var device = WGPU.adapterRequestDevice((AdapterImpl) adapter, null).get();
        var buffer = WGPU.deviceCreateBuffer(device, null);
        WGPU.bufferRelease(buffer);
    }

    @Test
    void testBufferSetLabel() throws InterruptedException, ExecutionException {
        var instance = WGPU.createInstance(null);
        var adapter = WGPU.instanceRequestAdapter((InstanceImpl)instance, null).get();
        var device = WGPU.adapterRequestDevice((AdapterImpl) adapter, null).get();
        var buffer = WGPU.deviceCreateBuffer(device, null);
        WGPU.bufferSetLabel(buffer, "test");
    }

    @Test
    void testBufferUnmap() throws InterruptedException, ExecutionException {
        var instance = WGPU.createInstance(null);
        var adapter = WGPU.instanceRequestAdapter((InstanceImpl)instance, null).get();
        var device = WGPU.adapterRequestDevice((AdapterImpl) adapter, null).get();
        var buffer = WGPU.deviceCreateBuffer(device, null);
        WGPU.bufferUnmap(buffer);
    }

    @Test
    void testBufferWriteMappedRange() throws InterruptedException, ExecutionException {
        var instance = WGPU.createInstance(null);
        var adapter = WGPU.instanceRequestAdapter((InstanceImpl)instance, null).get();
        var device = WGPU.adapterRequestDevice((AdapterImpl) adapter, null).get();
        var buffer = WGPU.deviceCreateBuffer(device, null);
        WGPU.bufferWriteMappedRange(buffer, 0, new byte[0], 0);
    }

    @Test
    void testCommandBufferAddRef() {
        throw new UnsupportedOperationException();
    }

    @Test
    void testCommandBufferRelease() throws InterruptedException, ExecutionException {
        var instance = WGPU.createInstance(null);
        var adapter = WGPU.instanceRequestAdapter((InstanceImpl)instance, null).get();
        var device = WGPU.adapterRequestDevice((AdapterImpl) adapter, null).get();
        var commandBuffer = WGPU.deviceCreateCommandBuffer(device, null);
        WGPU.commandBufferRelease(commandBuffer);
    }

    @Test
    void testCommandBufferSetLabel() throws InterruptedException, ExecutionException {
        var instance = WGPU.createInstance(null);
        var adapter = WGPU.instanceRequestAdapter((InstanceImpl)instance, null).get();
        var device = WGPU.adapterRequestDevice((AdapterImpl) adapter, null).get();
        var commandBuffer = WGPU.deviceCreateCommandBuffer(device, null);
        WGPU.commandBufferSetLabel(commandBuffer, "test");
    }

    @Test
    void testCommandEncoderAddRef() {
        throw new UnsupportedOperationException();
    }

    @Test
    void testCommandEncoderBeginComputePass() {
        throw new UnsupportedOperationException();
    }

    @Test
    void testCommandEncoderBeginRenderPass() {
        throw new UnsupportedOperationException();
    }

    @Test
    void testCommandEncoderClearBuffer() {
        throw new UnsupportedOperationException();
    }

    @Test
    void testCommandEncoderCopyBufferToBuffer() {
        throw new UnsupportedOperationException();
    }

    @Test
    void testCommandEncoderCopyBufferToTexture() {
        throw new UnsupportedOperationException();
    }

    @Test
    void testCommandEncoderCopyTextureToBuffer() {
        throw new UnsupportedOperationException();
    }

    @Test
    void testCommandEncoderCopyTextureToTexture() {
        throw new UnsupportedOperationException();
    }

    @Test
    void testCommandEncoderFinish() {
        throw new UnsupportedOperationException();
    }

    @Test
    void testCommandEncoderInsertDebugMarker() {
        throw new UnsupportedOperationException();
    }

    @Test
    void testCommandEncoderPopDebugGroup() {
        throw new UnsupportedOperationException();
    }

    @Test
    void testCommandEncoderPushDebugGroup() {
        throw new UnsupportedOperationException();
    }

    @Test
    void testCommandEncoderRelease() {
        throw new UnsupportedOperationException();
    }

    @Test
    void testCommandEncoderSetLabel() {
        throw new UnsupportedOperationException();
    }

    @Test
    void testCommandEncoderWriteTimestamp() {
        throw new UnsupportedOperationException();
    }

    @Test
    void testComputePassEncoderAddRef() {
        throw new UnsupportedOperationException();
    }

    @Test
    void testComputePassEncoderDispatchWorkgroups() {
        throw new UnsupportedOperationException();
    }

    @Test
    void testComputePassEncoderDispatchWorkgroupsIndirect() {
        throw new UnsupportedOperationException();
    }

    @Test
    void testComputePassEncoderEnd() {
        throw new UnsupportedOperationException();
    }

    @Test
    void testComputePassEncoderInsertDebugMarker() {
        throw new UnsupportedOperationException();
    }

    @Test
    void testComputePassEncoderPopDebugGroup() {
        throw new UnsupportedOperationException();
    }

    @Test
    void testComputePassEncoderPushDebugGroup() {
        throw new UnsupportedOperationException();
    }

    @Test
    void testComputePassEncoderRelease() {
        throw new UnsupportedOperationException();
    }

    @Test
    void testComputePassEncoderSetBindGroup() {
        throw new UnsupportedOperationException();
    }

    @Test
    void testComputePassEncoderSetLabel() {
        throw new UnsupportedOperationException();
    }

    @Test
    void testComputePassEncoderSetPipeline() {
        throw new UnsupportedOperationException();
    }

    @Test
    void testComputePipelineAddRef() {
        throw new UnsupportedOperationException();
    }

    @Test
    void testComputePipelineGetBindGroupLayout() {
        throw new UnsupportedOperationException();
    }

    @Test
    void testComputePipelineRelease() {
        throw new UnsupportedOperationException();
    }

    @Test
    void testComputePipelineSetLabel() {
        throw new UnsupportedOperationException();
    }

    @Test
    void testDeviceAddRef() {
        throw new UnsupportedOperationException();
    }

    @Test
    void testDeviceCreateBindGroup() {
        throw new UnsupportedOperationException();
    }

    @Test
    void testDeviceCreateBindGroupLayout() {
        throw new UnsupportedOperationException();
    }

    @Test
    void testDeviceCreateBuffer() {
        throw new UnsupportedOperationException();
    }

    @Test
    void testDeviceCreateCommandBuffer() {
        throw new UnsupportedOperationException();
    }

    @Test
    void testDeviceCreateComputePipeline() {
        throw new UnsupportedOperationException();
    }

    @Test
    void testDeviceCreateComputePipelineAsync() {
        throw new UnsupportedOperationException();
    }

    @Test
    void testDeviceCreatePipelineLayout() {
        throw new UnsupportedOperationException();
    }

    @Test
    void testDeviceCreateQuerySet() {
        throw new UnsupportedOperationException();
    }

    @Test
    void testDeviceCreateRenderBundleEncoder() throws InterruptedException, ExecutionException {
        var instance = WGPU.createInstance(null);
        var adapter = WGPU.instanceRequestAdapter((InstanceImpl)instance, null).get();
        var device = WGPU.adapterRequestDevice((AdapterImpl) adapter, null).get();
        var renderBundleEncoder = WGPU.deviceCreateRenderBundleEncoder(device, null);
    }

    @Test
    void testDeviceCreateRenderPipeline() throws InterruptedException, ExecutionException {
        var instance = WGPU.createInstance(null);
        var adapter = WGPU.instanceRequestAdapter((InstanceImpl)instance, null).get();
        var device = WGPU.adapterRequestDevice((AdapterImpl) adapter, null).get();
        var renderPipeline = WGPU.deviceCreateRenderPipeline(device, null);
    }

    @Test
    void testDeviceCreateRenderPipelineAsync() {

    }

    @Test
    void testDeviceCreateSampler() throws InterruptedException, ExecutionException {
        var instance = WGPU.createInstance(null);
        var adapter = WGPU.instanceRequestAdapter((InstanceImpl)instance, null).get();
        var device = WGPU.adapterRequestDevice((AdapterImpl) adapter, null).get();
        var sampler = WGPU.deviceCreateSampler(device, null);
    }

    @Test
    void testDeviceCreateShaderModule() throws InterruptedException, ExecutionException {
        var instance = WGPU.createInstance(null);
        var adapter = WGPU.instanceRequestAdapter((InstanceImpl)instance, null).get();
        var device = WGPU.adapterRequestDevice((AdapterImpl) adapter, null).get();
        var shaderModule = WGPU.deviceCreateShaderModule(device, null);
    }

    @Test
    void testDeviceCreateTexture() throws InterruptedException, ExecutionException {
        var instance = WGPU.createInstance(null);
        var adapter = WGPU.instanceRequestAdapter((InstanceImpl)instance, null).get();
        var device = WGPU.adapterRequestDevice((AdapterImpl) adapter, null).get();
        var texture = WGPU.deviceCreateTexture(device, null);
    }

    @Test
    void testDeviceDestroy() throws InterruptedException, ExecutionException {
        var instance = WGPU.createInstance(null);
        var adapter = WGPU.instanceRequestAdapter((InstanceImpl)instance, null).get();
        var device = WGPU.adapterRequestDevice((AdapterImpl) adapter, null).get();
        WGPU.deviceDestroy(device);
    }

    @Test
    void testDeviceGetAdapterInfo() throws InterruptedException, ExecutionException {
        var instance = WGPU.createInstance(null);
        var adapter = WGPU.instanceRequestAdapter((InstanceImpl)instance, null).get();
        var device = WGPU.adapterRequestDevice((AdapterImpl) adapter, null).get();
        WGPU.deviceGetAdapterInfo(device, null);
    }

    @Test
    void testDeviceGetFeatures() throws InterruptedException, ExecutionException {
        var instance = WGPU.createInstance(null);
        var adapter = WGPU.instanceRequestAdapter((InstanceImpl)instance, null).get();
        var device = WGPU.adapterRequestDevice((AdapterImpl) adapter, null).get();
        WGPU.deviceGetFeatures(device, null);
    }

    @Test
    void testDeviceGetLimits() throws InterruptedException, ExecutionException {
        var instance = WGPU.createInstance(null);
        var adapter = WGPU.instanceRequestAdapter((InstanceImpl)instance, null).get();
        var device = WGPU.adapterRequestDevice((AdapterImpl) adapter, null).get();
        WGPU.deviceGetLimits(device, null);
    }

    @Test
    void testDeviceGetLostFuture() throws InterruptedException, ExecutionException {
        var instance = WGPU.createInstance(null);
        var adapter = WGPU.instanceRequestAdapter((InstanceImpl)instance, null).get();
        var device = WGPU.adapterRequestDevice((AdapterImpl) adapter, null).get();
        WGPU.deviceGetLostFuture(device);
    }

    @Test
    void testDeviceGetQueue() throws InterruptedException, ExecutionException {
        var instance = WGPU.createInstance(null);
        var adapter = WGPU.instanceRequestAdapter((InstanceImpl)instance, null).get();
        var device = WGPU.adapterRequestDevice((AdapterImpl) adapter, null).get();
        WGPU.deviceGetQueue(device);
    }

    @Test
    void testDeviceHasFeature() throws InterruptedException, ExecutionException {
        var instance = WGPU.createInstance(null);
        var adapter = WGPU.instanceRequestAdapter((InstanceImpl)instance, null).get();
        var device = WGPU.adapterRequestDevice((AdapterImpl) adapter, null).get();
        WGPU.deviceHasFeature(device, null);
    }

    @Test
    void testDevicePopErrorScope() throws InterruptedException, ExecutionException {
        var instance = WGPU.createInstance(null);
        var adapter = WGPU.instanceRequestAdapter((InstanceImpl)instance, null).get();
        var device = WGPU.adapterRequestDevice((AdapterImpl) adapter, null).get();
        WGPU.devicePopErrorScope(device, null);
    }

    @Test
    void testDevicePushErrorScope() throws InterruptedException, ExecutionException {
        var instance = WGPU.createInstance(null);
        var adapter = WGPU.instanceRequestAdapter((InstanceImpl)instance, null).get();
        var device = WGPU.adapterRequestDevice((AdapterImpl) adapter, null).get();
    }

    @Test
    void testDeviceRelease() throws InterruptedException, ExecutionException {
        var instance = WGPU.createInstance(null);
        var adapter = WGPU.instanceRequestAdapter((InstanceImpl)instance, null).get();
        var device = WGPU.adapterRequestDevice((AdapterImpl) adapter, null).get();
        WGPU.deviceRelease(device);
    }

    @Test
    void testDeviceSetLabel() throws InterruptedException, ExecutionException {
        var instance = WGPU.createInstance(null);
        var adapter = WGPU.instanceRequestAdapter((InstanceImpl)instance, null).get();
        var device = WGPU.adapterRequestDevice((AdapterImpl) adapter, null).get();
        WGPU.deviceSetLabel(device, "test");
    }

    @Test
    void testGetInstanceLimits() {
        throw new UnsupportedOperationException();
    }

    @Test
    void testGetProgAddress() {
        throw new UnsupportedOperationException();
    }

    @Test
    void testHasInstanceFeature() {
        var instance = WGPU.createInstance(null);

        
        throw new UnsupportedOperationException();
    }

    @Test
    void testInstanceAddRef() {
        var instance = WGPU.createInstance(null);
        
        WGPU.instanceAddRef((InstanceImpl)instance);
    }

    @Test
    void testInstanceCreateSurface() {
        var instance = WGPU.createInstance(null);

        WGPU.instanceCreateSurface((InstanceImpl)instance, new SurfaceDescriptor());
    }

    @Test
    void testInstanceGetWGSLLanguageFeatures() {
        var instance = WGPU.createInstance(null);

        WGPU.instanceGetWGSLLanguageFeatures((InstanceImpl)instance, null);
    }

    @Test
    void testInstanceHasWGSLLanguageFeature() {
        var instance = WGPU.createInstance(null);

        WGPU.instanceHasWGSLLanguageFeature((InstanceImpl)instance, null);
    }

    @Test
    void testInstanceProcessEvents() {

    }

    @Test
    void testInstanceRelease() {
        var instance = WGPU.createInstance(null);

        WGPU.instanceRelease((InstanceImpl)instance);
    }

    @Test
    void testInstanceRequestAdapter() {
        var instance = WGPU.createInstance(null);

        WGPU.instanceRequestAdapter((InstanceImpl)instance, null);
    }

    @Test
    void testInstanceWaitAny() {
        
    }

    @Test
    void testPipelineLayoutAddRef() throws InterruptedException, ExecutionException {
        var instance = WGPU.createInstance(null);

        var adapter = WGPU.instanceRequestAdapter((InstanceImpl)instance, null).get();
        var device = WGPU.adapterRequestDevice((AdapterImpl) adapter, null).get();

        var pipelineLayout = WGPU.deviceCreatePipelineLayout(device, null);
        WGPU.pipelineLayoutAddRef(pipelineLayout);
    }

    @Test
    void testPipelineLayoutRelease() throws InterruptedException, ExecutionException {
        var instance = WGPU.createInstance(null);

        var adapter = WGPU.instanceRequestAdapter((InstanceImpl)instance, null).get();
        var device = WGPU.adapterRequestDevice((AdapterImpl) adapter, null).get();

        var pipelineLayout = WGPU.deviceCreatePipelineLayout(device, null);
        WGPU.pipelineLayoutRelease(pipelineLayout);
    }

    @Test
    void testPipelineLayoutSetLabel() throws InterruptedException, ExecutionException {
        var instance = WGPU.createInstance(null);

        var adapter = WGPU.instanceRequestAdapter((InstanceImpl)instance, null).get();
        var device = WGPU.adapterRequestDevice((AdapterImpl) adapter, null).get();

        var pipelineLayout = WGPU.deviceCreatePipelineLayout(device, null);
        WGPU.pipelineLayoutSetLabel(pipelineLayout, "test");
    }

    @Test
    void testQuerySetAddRef() throws InterruptedException, ExecutionException {
        var instance = WGPU.createInstance(null);

        var adapter = WGPU.instanceRequestAdapter((InstanceImpl)instance, null).get();
        var device = WGPU.adapterRequestDevice((AdapterImpl) adapter, null).get();

        var querySet = WGPU.deviceCreateQuerySet(device, null);
        WGPU.querySetAddRef(querySet);
    }

    @Test
    void testQuerySetDestroy() throws InterruptedException, ExecutionException {
        var instance = WGPU.createInstance(null);

        var adapter = WGPU.instanceRequestAdapter((InstanceImpl)instance, null).get();
        var device = WGPU.adapterRequestDevice((AdapterImpl) adapter, null).get();

        var querySet = WGPU.deviceCreateQuerySet(device, null);
        WGPU.querySetDestroy(querySet);
    }

    @Test
    void testQuerySetGetCount() throws InterruptedException, ExecutionException {
        var instance = WGPU.createInstance(null);

        var adapter = WGPU.instanceRequestAdapter((InstanceImpl)instance, null).get();
        var device = WGPU.adapterRequestDevice((AdapterImpl) adapter, null).get();

        var querySet = WGPU.deviceCreateQuerySet(device, null);
        WGPU.querySetGetCount(querySet);
    }

    @Test
    void testQuerySetGetType() throws InterruptedException, ExecutionException {
        var instance = WGPU.createInstance(null);

        var adapter = WGPU.instanceRequestAdapter((InstanceImpl)instance, null).get();
        var device = WGPU.adapterRequestDevice((AdapterImpl) adapter, null).get();

        var querySet = WGPU.deviceCreateQuerySet(device, null);
        WGPU.querySetGetType(querySet);
    }

    @Test
    void testQuerySetRelease() throws InterruptedException, ExecutionException {
        var instance = WGPU.createInstance(null);

        var adapter = WGPU.instanceRequestAdapter((InstanceImpl)instance, null).get();
        var device = WGPU.adapterRequestDevice((AdapterImpl) adapter, null).get();

        var querySet = WGPU.deviceCreateQuerySet(device, null);
        WGPU.querySetRelease(querySet);
    }

    @Test
    void testQuerySetSetLabel() throws InterruptedException, ExecutionException {
        var instance = WGPU.createInstance(null);

        var adapter = WGPU.instanceRequestAdapter((InstanceImpl)instance, null).get();
        var device = WGPU.adapterRequestDevice((AdapterImpl) adapter, null).get();

        var querySet = WGPU.deviceCreateQuerySet(device, null);
        WGPU.querySetSetLabel(querySet, "test");
    }

    @Test
    void testQueueAddRef() throws InterruptedException, ExecutionException {
        var instance = WGPU.createInstance(null);

        var adapter = WGPU.instanceRequestAdapter((InstanceImpl)instance, null).get();
        var device = WGPU.adapterRequestDevice((AdapterImpl) adapter, null).get();

        var queue = WGPU.deviceGetQueue(device);
        WGPU.queueAddRef(queue);
    }

    @Test
    void testQueueOnSubmittedWorkDone() throws InterruptedException, ExecutionException {
        var instance = WGPU.createInstance(null);
        var adapter = WGPU.instanceRequestAdapter((InstanceImpl)instance, null).get();
        var device = WGPU.adapterRequestDevice((AdapterImpl) adapter, null).get();

        var queue = WGPU.deviceGetQueue(device);
        WGPU.queueOnSubmittedWorkDone(queue, null);
    }

    @Test
    void testQueueRelease() throws InterruptedException, ExecutionException {
        var instance = WGPU.createInstance(null);
        var adapter = WGPU.instanceRequestAdapter((InstanceImpl)instance, null).get();
        var device = WGPU.adapterRequestDevice((AdapterImpl) adapter, null).get();

        var queue = WGPU.deviceGetQueue(device);
        WGPU.queueRelease(queue);
    }

    @Test
    void testQueueSetLabel() throws InterruptedException, ExecutionException {
        var instance = WGPU.createInstance(null);
        var adapter = WGPU.instanceRequestAdapter((InstanceImpl)instance, null).get();
        var device = WGPU.adapterRequestDevice((AdapterImpl) adapter, null).get();

        var queue = WGPU.deviceGetQueue(device);
        WGPU.queueSetLabel(queue, "test");
    }

    @Test
    void testQueueSubmit() {

    }

    @Test
    void testQueueWriteBuffer() {

    }

    @Test
    void testQueueWriteTexture() {

    }

    @Test
    void testRenderBundleAddRef() {

    }

    @Test
    void testRenderBundleEncoderAddRef() {

    }

    @Test
    void testRenderBundleEncoderDraw() {

    }

    @Test
    void testRenderBundleEncoderDrawIndexed() {

    }

    @Test
    void testRenderBundleEncoderDrawIndexedIndirect() {

    }

    @Test
    void testRenderBundleEncoderDrawIndirect() {

    }

    @Test
    void testRenderBundleEncoderFinish() {

    }

    @Test
    void testRenderBundleEncoderInsertDebugMarker() {

    }

    @Test
    void testRenderBundleEncoderPopDebugGroup() {

    }

    @Test
    void testRenderBundleEncoderPushDebugGroup() {

    }

    @Test
    void testRenderBundleEncoderRelease() {

    }

    @Test
    void testRenderBundleEncoderSetBindGroup() {

    }

    @Test
    void testRenderBundleEncoderSetIndexBuffer() {

    }

    @Test
    void testRenderBundleEncoderSetPipeline() {

    }

    @Test
    void testRenderBundleEncoderSetVertexBuffer() {

    }

    @Test
    void testRenderBundleRelease() {

    }

    @Test
    void testRenderPassEncoderAddRef() {

    }

    @Test
    void testRenderPassEncoderBeginOcclusionQuery() {

    }

    @Test
    void testRenderPassEncoderDraw() {

    }

    @Test
    void testRenderPassEncoderDrawIndexed() {

    }

    @Test
    void testRenderPassEncoderDrawIndexedIndirect() {

    }

    @Test
    void testRenderPassEncoderDrawIndirect() {

    }

    @Test
    void testRenderPassEncoderEnd() {

    }

    @Test
    void testRenderPassEncoderEndOcclusionQuery() {

    }

    @Test
    void testRenderPassEncoderExecuteBundles() {

    }

    @Test
    void testRenderPassEncoderInsertDebugMarker() {

    }

    @Test
    void testRenderPassEncoderPopDebugGroup() {

    }

    @Test
    void testRenderPassEncoderPushDebugGroup() {

    }

    @Test
    void testRenderPassEncoderRelease() {

    }

    @Test
    void testRenderPassEncoderSetBindGroup() {

    }

    @Test
    void testRenderPassEncoderSetBlendConstants() {

    }

    @Test
    void testRenderPassEncoderSetIndexBuffer() {

    }

    @Test
    void testRenderPassEncoderSetLabel() {

    }

    @Test
    void testRenderPassEncoderSetPipeline() {

    }

    @Test
    void testRenderPassEncoderSetScissorRect() {

    }

    @Test
    void testRenderPassEncoderSetStencilReference() {

    }

    @Test
    void testRenderPassEncoderSetVertexBuffer() {

    }

    @Test
    void testRenderPassEncoderSetViewport() {

    }

    @Test
    void testRenderPassSetLabel() {

    }

    @Test
    void testRenderPipelineAddRef() {

    }

    @Test
    void testRenderPipelineGetBindGroupLayout() {

    }

    @Test
    void testRenderPipelineRelease() {

    }

    @Test
    void testRenderPipelineSetLabel() {

    }

    @Test
    void testSamplerAddRef() {

    }

    @Test
    void testSamplerRelease() {

    }

    @Test
    void testSamplerSetLabel() {

    }

    @Test
    void testShaderModuleAddRef() {

    }

    @Test
    void testShaderModuleGetCompilationInfo() {

    }

    @Test
    void testShaderModuleRelease() {

    }

    @Test
    void testShaderModuleSetLabel() {

    }

    @Test
    void testSupportedFeaturesFreeMembers() {

    }

    @Test
    void testSupportedInstanceFeaturesFreeMembers() {

    }

    @Test
    void testSupportedWGSLLLanguageFeatureFreeMembers() {

    }

    @Test
    void testSurfaceAddRef() {

    }

    @Test
    void testSurfaceCapabilitiesFreeMembers() {

    }

    @Test
    void testSurfaceConfigure() {

    }

    @Test
    void testSurfaceGetCapabilities() {

    }

    @Test
    void testSurfaceGetCurrentTexture() {

    }

    @Test
    void testSurfacePresent() {

    }

    @Test
    void testSurfaceRelease() {

    }

    @Test
    void testSurfaceSetLabel() {

    }

    @Test
    void testSurfaceUnconfigure() {

    }

    @Test
    void testTextureAddRef() {

    }

    @Test
    void testTextureCreateView() {

    }

    @Test
    void testTextureDestroy() {

    }

    @Test
    void testTextureGetDepthOrArrayLayers() {

    }

    @Test
    void testTextureGetDimension() {

    }

    @Test
    void testTextureGetFormat() {

    }

    @Test
    void testTextureGetHeight() {

    }

    @Test
    void testTextureGetMipLevelCount() {

    }

    @Test
    void testTextureGetSampleCount() {

    }

    @Test
    void testTextureGetUsage() {

    }

    @Test
    void testTextureGetWidth() {

    }

    @Test
    void testTextureRelease() {

    }

    @Test
    void testTextureSetLabel() {

    }

    @Test
    void testTextureViewAddRef() {

    }

    @Test
    void testTextureViewSetLabel() {

    }

    @Test
    void testAdapterAddRef2() {
        
    }
}
