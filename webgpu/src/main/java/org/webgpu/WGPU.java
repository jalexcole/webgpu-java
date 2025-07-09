package org.webgpu;

import java.lang.foreign.Arena;
import java.lang.foreign.Linker;
import java.lang.foreign.MemorySegment;
import java.time.Duration;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;
import org.webgpu.extract.WGPUInstanceDescriptor;
import org.webgpu.extract.WGPURequestAdapterCallback;
import org.webgpu.extract.WGPURequestAdapterCallbackInfo;
import org.webgpu.extract.WGPURequestAdapterOptions;
import org.webgpu.extract.WGPURequestDeviceCallback;
import org.webgpu.extract.webgpu_h;
import org.webgpu.impl.AdapterImpl;
import org.webgpu.impl.InstanceImpl;

public class WGPU {
    @SuppressWarnings("preview")
    static final Linker NATIVE_LINKER = Linker.nativeLinker();
    static {
        try {
            System.load("/Users/alex/dev/webgpu-java/webgpu/src/main/resources/libwgpu_native.dylib");
        } catch (SecurityException e) {
            System.out.println(e.getMessage());
        } catch (final UnsatisfiedLinkError e) {
            System.out.println(e.getMessage());
        }
    }

    @SuppressWarnings("preview")
    public static Instance createInstance(@Nullable InstanceDescriptor descriptor) {
        return new InstanceImpl(
                webgpu_h.wgpuCreateInstance(descriptor != null ? descriptor.address() : MemorySegment.NULL));
        
    }

    public static void getInstanceFeatures(SupportedFeatures... features) {

        throw new UnsupportedOperationException("Unimplemented method 'getInstanceFeatures'");
    }

    public static void getInstanceLimits(InstanceLimits... limits) {
        throw new UnsupportedOperationException("Unimplemented method 'getInstanceLimits'");
    }

    public static boolean hasInstanceFeature(InstanceFeatureName feature) {
        throw new UnsupportedOperationException("Unimplemented method 'hasInstanceFeature'");
    }

    public static Proc getProgAddress(String procName) {

        throw new UnsupportedOperationException("Unimplemented method 'getProgAddress'");
    }

    public static void adapterGetFeatures(@NonNull Adapter adapter, @NonNull SupportedFeatures... features) {
        throw new UnsupportedOperationException("Unimplemented method 'adapterGetFeatures'");
    }

    public static int adapterGetInfo(@NonNull Adapter adapter, @NonNull AdapterInfo... info) {
        throw new UnsupportedOperationException("Unimplemented method 'adapterGetInfo'");
    }

    public static int adapterGetLimits(@NonNull Adapter adapter, @NonNull Limits... limits) {
        throw new UnsupportedOperationException("Unimplemented method 'adapterGetLimits'");
    }

    public static boolean adapterHasFeature(@NonNull AdapterImpl adapter, FeatureName feature) {
        var result = webgpu_h.wgpuAdapterHasFeature(adapter.ptr(), feature.value());

        if (result != 0) {
            return true;
        }

        return false;

    }

    public static CompletableFuture<Device> adapterRequestDevice(@NonNull AdapterImpl adapter,
            @NonNull final DeviceDescriptor[] descriptors) {
        throw new UnsupportedOperationException("Unimplemented method 'adapterRequestDevice'");
    }

    public static void adapterAddRef(@NonNull AdapterImpl adapter) {
        webgpu_h.wgpuAdapterAddRef(adapter.ptr());
    }

    public static void adapterRelease(@NonNull AdapterImpl adapter) {
        webgpu_h.wgpuAdapterRelease(adapter.ptr());
    }

    public static void adapterInfoFreeMembers(@NonNull AdapterInfo info) {
        webgpu_h.wgpuAdapterInfoFreeMembers(info.ptr());
    }

    public static void bindGroupSetLabel(@NonNull BindGroup bindGroup, String label) {
        webgpu_h.wgpuBindGroupSetLabel(bindGroup.ptr(), new StringView(label).ptr());
    }

    public static void bindGroupAddRef(@NonNull BindGroup bindGroup) {
        webgpu_h.wgpuBindGroupAddRef(bindGroup.ptr());
    }

    public static void bindGroupRelease(@NonNull BindGroup bindGroup) {
        webgpu_h.wgpuBindGroupRelease(bindGroup.ptr());
    }

    public static void bindGroupLayoutSetLabel(@NonNull BindGroupLayout bindGroupLayout, String label) {
        webgpu_h.wgpuBindGroupLayoutSetLabel(bindGroupLayout.ptr(), new StringView(label).ptr());
    }

    public static void bindGroupLayoutAddRef(@NonNull BindGroupLayout bindGroupLayout) {
        webgpu_h.wgpuBindGroupLayoutAddRef(bindGroupLayout.ptr());
    }

    public static void bindGroupLayoutRelease(@NonNull BindGroupLayout bindGroupLayout) {
        webgpu_h.wgpuBindGroupLayoutRelease(bindGroupLayout.ptr());
    }

    public static void bufferDestroy(@NonNull Buffer buffer) {
        webgpu_h.wgpuBufferDestroy(buffer.ptr());
    }

    public static Object bufferGetConstMappedRange(@NonNull Buffer buffer, long offset, long size) {
        throw new UnsupportedOperationException("Unimplemented method 'wgpuBufferGetConstMappedRange'");
    }

    public static Object bufferGetMappedRange(@NonNull Buffer buffer, long offset, long size) {
        throw new UnsupportedOperationException("Unimplemented method 'wgpuBufferGetMappedRange'");
    }

    public static BufferMapState bufferGetMapState(@NonNull Buffer buffer) {
        return BufferMapState.set(webgpu_h.wgpuBufferGetMapState(buffer.ptr()));
    }

    public static final long bufferGetSize(@NonNull Buffer buffer) {
        return webgpu_h.wgpuBufferGetSize(buffer.ptr());
    }

    public static final CompletableFuture<?> bufferMapAsync(@NonNull Buffer buffer, int mode, long offset, long size) {
        throw new UnsupportedOperationException("Unimplemented method 'bufferMapAsync'");
    }

    public static final int bufferReadMappedRange(@NonNull Buffer buffer, long offset, byte[] data, long size) {
        throw new UnsupportedOperationException("Unimplemented method 'bufferReadMappedRange'");
    }

    public static final void bufferSetLabel(@NonNull Buffer buffer, String label) {
        webgpu_h.wgpuBufferSetLabel(buffer.ptr(), new StringView(label).ptr());
    }

    public static final void bufferUnmap(@NonNull Buffer buffer) {
        webgpu_h.wgpuBufferUnmap(buffer.ptr());
    }

    public static final Status bufferWriteMappedRange(@NonNull Buffer buffer, long offset, byte[] data, long size) {
        throw new UnsupportedOperationException("Unimplemented method 'bufferWriteMappedRange'");
    }

    public static final void bufferAddRef(@NonNull Buffer buffer) {
        webgpu_h.wgpuBufferAddRef(buffer.ptr());
    }

    public static final void bufferRelease(@NonNull Buffer buffer) {
        webgpu_h.wgpuBufferRelease(buffer.ptr());
    }

    public static void commandBufferSetLabel(@NonNull CommandBuffer commandBuffer, String label) {
        webgpu_h.wgpuCommandBufferSetLabel(commandBuffer.ptr(), new StringView(label).ptr());
    }

    public static void commandBufferAddRef(@NonNull CommandBuffer commandBuffer) {
        webgpu_h.wgpuCommandBufferAddRef(commandBuffer.ptr());
    }

    public static void commandBufferRelease(@NonNull CommandBuffer commandBuffer) {
        webgpu_h.wgpuCommandBufferRelease(commandBuffer.ptr());
    }

    public static ComputePassEncoder commandEncoderBeginComputePass(@NonNull CommandEncoder commandEncoder,
            @NonNull ComputePassDescriptor descriptor) {
        return new ComputePassEncoder(
                webgpu_h.wgpuCommandEncoderBeginComputePass(commandEncoder.ptr(), descriptor.ptr()));
    }

    public static final RenderPassEncoder commandEncoderBeginRenderPass(@NonNull CommandEncoder commandEncoder,
            @NonNull RenderPassDescriptor descriptor) {
        return new RenderPassEncoder(
                webgpu_h.wgpuCommandEncoderBeginRenderPass(commandEncoder.ptr(), descriptor.ptr()));
    }

    public static final void commandEncoderClearBuffer(@NonNull CommandEncoder commandEncoder, @NonNull Buffer buffer,
            long offset, long size) {
        webgpu_h.wgpuCommandEncoderClearBuffer(commandEncoder.ptr(), buffer.ptr(), offset, size);
    }

    public static final void commandEncoderCopyBufferToBuffer(@NonNull CommandEncoder commandEncoder,
            @NonNull Buffer source, long sourceOffset, @NonNull Buffer destination, long destinationOffset, long size) {
        webgpu_h.wgpuCommandEncoderCopyBufferToBuffer(commandEncoder.ptr(), source.ptr(), sourceOffset,
                destination.ptr(), destinationOffset, size);
    }

    public static final void commandEncoderCopyBufferToTexture(@NonNull CommandEncoder commandEncoder,
            @NonNull final TexelCopyBufferInfo source, @NonNull final TexelCopyTextureInfo destination,
            @NonNull final Extend3D copySize) {
        webgpu_h.wgpuCommandEncoderCopyBufferToTexture(commandEncoder.ptr(), source.ptr(), destination.ptr(),
                copySize.ptr());
    }

    public static final void commandEncoderCopyTextureToBuffer(@NonNull CommandEncoder commandEncoder,
            @NonNull final TexelCopyTextureInfo source, @NonNull final TexelCopyBufferInfo destination,
            @NonNull final Extend3D copySize) {
        webgpu_h.wgpuCommandEncoderCopyTextureToBuffer(commandEncoder.ptr(), source.ptr(), destination.ptr(),
                copySize.ptr());
    }

    public static final void commandEncoderCopyTextureToTexture(@NonNull CommandEncoder commandEncoder,
            @NonNull final TexelCopyTextureInfo source, @NonNull final TexelCopyTextureInfo destination,
            @NonNull final Extend3D copySize) {
        webgpu_h.wgpuCommandEncoderCopyTextureToTexture(commandEncoder.ptr(), source.ptr(), destination.ptr(),
                copySize.ptr());
    }

    public static final CommandBuffer commandEncoderFinish(@NonNull CommandEncoder commandEncoder,
            @NonNull CommandBufferDescriptor descriptor) {
        return new CommandBuffer(webgpu_h.wgpuCommandEncoderFinish(commandEncoder.ptr(), descriptor.ptr()));
    }

    public static void commandEncoderInsertDebugMarker(@NonNull CommandEncoder commandEncoder, String markerLabel) {
        webgpu_h.wgpuCommandEncoderInsertDebugMarker(commandEncoder.ptr(), new StringView(markerLabel).ptr());
    }

    public static void commandEncoderPopDebugGroup(@NonNull CommandEncoder commandEncoder) {
        webgpu_h.wgpuCommandEncoderPopDebugGroup(commandEncoder.ptr());
    }

    public static void commandEncoderPushDebugGroup(@NonNull CommandEncoder commandEncoder, String groupLabel) {
        webgpu_h.wgpuCommandEncoderPushDebugGroup(commandEncoder.ptr(), new StringView(groupLabel).ptr());
    }

    public static void commandEncoderSetLabel(@NonNull CommandEncoder commandEncoder, String label) {
        webgpu_h.wgpuCommandEncoderSetLabel(commandEncoder.ptr(), new StringView(label).ptr());
    }

    public static void commandEncoderWriteTimestamp(@NonNull CommandEncoder commandEncoder, @NonNull QuerySet querySet,
            int queryIndex) {
        webgpu_h.wgpuCommandEncoderWriteTimestamp(commandEncoder.ptr(), querySet.ptr(), queryIndex);
    }

    public static void commandEncoderAddRef(@NonNull CommandEncoder commandEncoder) {
        webgpu_h.wgpuCommandEncoderAddRef(commandEncoder.ptr());
    }

    public static void commandEncoderRelease(@NonNull CommandEncoder commandEncoder) {
        webgpu_h.wgpuCommandEncoderRelease(commandEncoder.ptr());
    }

    public static final void computePassEncoderDispatchWorkgroups(@NonNull ComputePassEncoder computePassEncoder,
            int workgroupCountX,
            int workgroupCountY, int workgroupCountZ) {
        webgpu_h.wgpuComputePassEncoderDispatchWorkgroups(computePassEncoder.ptr(), workgroupCountX, workgroupCountY,
                workgroupCountZ);
    }

    public static final void computePassEncoderDispatchWorkgroupsIndirect(
            @NonNull ComputePassEncoder computePassEncoder,
            @NonNull Buffer indirectBuffer, int indirectOffset) {
        webgpu_h.wgpuComputePassEncoderDispatchWorkgroupsIndirect(computePassEncoder.ptr(), indirectBuffer.ptr(),
                indirectOffset);
    }

    public static final void computePassEncoderEnd(@NonNull ComputePassEncoder computePassEncoder) {
        webgpu_h.wgpuComputePassEncoderEnd(computePassEncoder.ptr());
    }

    public static final void computePassEncoderInsertDebugMarker(@NonNull ComputePassEncoder computePassEncoder,
            String markerLabel) {
        webgpu_h.wgpuComputePassEncoderInsertDebugMarker(computePassEncoder.ptr(), new StringView(markerLabel).ptr());
    }

    public static final void computePassEncoderPopDebugGroup(@NonNull ComputePassEncoder computePassEncoder) {
        webgpu_h.wgpuComputePassEncoderPopDebugGroup(computePassEncoder.ptr());
    }

    public static final void computePassEncoderPushDebugGroup(@NonNull ComputePassEncoder computePassEncoder,
            String groupLabel) {
        webgpu_h.wgpuComputePassEncoderPushDebugGroup(computePassEncoder.ptr(), new StringView(groupLabel).ptr());
    }

    @SuppressWarnings("preview")
    public static final void computePassEncoderSetBindGroup(@NonNull ComputePassEncoder computePassEncoder,
            int groupIndex,
            @NonNull BindGroup group, long dynamicOffsetCount, int... dynamicOffsets) {
        webgpu_h.wgpuComputePassEncoderSetBindGroup(computePassEncoder.ptr(), groupIndex, group.ptr(),
                dynamicOffsetCount, MemorySegment.ofArray(dynamicOffsets));
    }

    public static final void computePassEncoderSetLabel(@NonNull ComputePassEncoder computePassEncoder, String label) {
        webgpu_h.wgpuComputePassEncoderSetLabel(computePassEncoder.ptr(), new StringView(label).ptr());
    }

    public static final void computePassEncoderSetPipeline(@NonNull ComputePassEncoder computePassEncoder,
            @NonNull ComputePipeline pipeline) {
        webgpu_h.wgpuComputePassEncoderSetPipeline(computePassEncoder.ptr(), pipeline.ptr());
    }

    public static final void computePassEncoderAddRef(@NonNull ComputePassEncoder computePassEncoder) {
        webgpu_h.wgpuComputePassEncoderAddRef(computePassEncoder.ptr());
    }

    public static final void computePassEncoderRelease(@NonNull ComputePassEncoder computePassEncoder) {
        webgpu_h.wgpuComputePassEncoderRelease(computePassEncoder.ptr());
    }

    public static final void computePipelineGetBindGroupLayout(@NonNull ComputePipeline computePipeline,
            int groupIndex) {
        webgpu_h.wgpuComputePipelineGetBindGroupLayout(computePipeline.ptr(), groupIndex);
    }

    public static final void computePipelineSetLabel(@NonNull ComputePipeline computePipeline, String label) {
        webgpu_h.wgpuComputePipelineSetLabel(computePipeline.ptr(), new StringView(label).ptr());
    }

    public static final void computePipelineAddRef(@NonNull ComputePipeline computePipeline) {
        webgpu_h.wgpuComputePipelineAddRef(computePipeline.ptr());
    }

    public static final void computePipelineRelease(@NonNull ComputePipeline computePipeline) {
        webgpu_h.wgpuComputePipelineRelease(computePipeline.ptr());
    }

    public static final BindGroup deviceCreateBindGroup(@NonNull Device device,
            @NonNull BindGroupDescriptor descriptor) {
        return new BindGroup(webgpu_h.wgpuDeviceCreateBindGroup(device.ptr(), descriptor.ptr()));
    }

    public static final BindGroupLayout deviceCreateBindGroupLayout(@NonNull Device device,
            @Nullable BindGroupLayoutDescriptor descriptor) {
        return new BindGroupLayout(webgpu_h.wgpuDeviceCreateBindGroupLayout(device.ptr(), descriptor.ptr()));
    }

    public static final Buffer deviceCreateBuffer(@NonNull Device device, @NonNull final BufferDescriptor descriptor) {
        return new Buffer(webgpu_h.wgpuDeviceCreateBuffer(device.ptr(), descriptor.ptr()));
    }

    public static final CommandBuffer deviceCreateCommandBuffer(@NonNull Device device,
            @NonNull CommandBufferDescriptor descriptor) {
        throw new UnsupportedOperationException("Unimplemented method 'deviceCreateCommandBuffer'");
    }

    public static ComputePipeline deviceCreateComputePipeline(@NonNull Device device,
            @NonNull ComputePipelineDescriptor descriptor) {
        return new ComputePipeline(webgpu_h.wgpuDeviceCreateComputePipeline(device.ptr(), descriptor.ptr()));
    }

    public static final CompletableFuture<?> deviceCreateComputePipelineAsync(@NonNull Device device,
            @NonNull CreateComputePipelineAsyncCallbackInfo callbackInfo) {
        throw new UnsupportedOperationException("Unimplemented method 'deviceCreateComputePipelineAsync'");
    }

    public static final PipelineLayout deviceCreatePipelineLayout(@NonNull Device device,
            @NonNull PipelineLayoutDescriptor descriptor) {
        return new PipelineLayout(webgpu_h.wgpuDeviceCreatePipelineLayout(device.ptr(), descriptor.ptr()));
    }

    public static final QuerySet deviceCreateQuerySet(@NonNull Device device,
            @NonNull QuerySetDescriptor descriptor) {
        return new QuerySet(webgpu_h.wgpuDeviceCreateQuerySet(device.ptr(), descriptor.ptr()));
    }

    public static final RenderBundleEncoder deviceCreateRenderBundleEncoder(@NonNull Device device,
            @NonNull RenderBundleEncoderDescriptor descriptor) {
        return new RenderBundleEncoder(webgpu_h.wgpuDeviceCreateRenderBundleEncoder(device.ptr(), descriptor.ptr()));
    }

    public static final RenderPipeline deviceCreateRenderPipeline(@NonNull Device device,
            @NonNull RenderPipelineDescriptor descriptor) {
        return new RenderPipeline(webgpu_h.wgpuDeviceCreateRenderPipeline(device.ptr(), descriptor.ptr()));
    }

    public static final CompletableFuture<?> deviceCreateRenderPipelineAsync(@NonNull Device device,
            @NonNull RenderPipelineDescriptor descriptor,
            @NonNull CreateRenderPipelineAsyncCallbackInfo callbackInfo) {
        throw new UnsupportedOperationException("Unimplemented method 'deviceCreateRenderPipelineAsync'");
    }

    public static final Sampler deviceCreateSampler(@NonNull Device device,
            @NonNull SamplerDescriptor descriptor) {
        return new Sampler(webgpu_h.wgpuDeviceCreateSampler(device.ptr(), descriptor.ptr()));
    }

    public static final ShaderModule deviceCreateShaderModule(@NonNull Device device,
            @NonNull final ShaderModuleDescriptor descriptor) {
        return new ShaderModule(webgpu_h.wgpuDeviceCreateShaderModule(device.ptr(), descriptor.ptr()));
    }

    public static final Texture deviceCreateTexture(@NonNull Device device,
            @NonNull TextureDescriptor descriptor) {
        return new Texture(webgpu_h.wgpuDeviceCreateTexture(device.ptr(), descriptor.ptr()));
    }

    public static final void deviceDestroy(@NonNull Device device) {
        webgpu_h.wgpuDeviceDestroy(device.ptr());
    }

    public static final Status deviceGetAdapterInfo(@NonNull Device device, @NonNull AdapterInfo adapterInfo) {
        throw new UnsupportedOperationException("Unimplemented method 'deviceGetAdapterInfo'");
    }

    public static void deviceGetFeatures(@NonNull Device device, @NonNull SupportedFeatures features) {
        webgpu_h.wgpuDeviceGetFeatures(device.ptr(), features.ptr());
    }

    public static final Status deviceGetLimits(@NonNull Device device, @NonNull Limits limits) {
        final var statusCode = (webgpu_h.wgpuDeviceGetLimits(device.ptr(), limits.ptr()));

        if (statusCode == Status.Success.value()) {
            return Status.Success;
        } else {
            return Status.Error;
        }
    }

    public static final Future<?>[] deviceGetLostFuture(@NonNull Device device) {
        throw new UnsupportedOperationException("Unimplemented method 'deviceGetLostFuture'");
    }

    public static final Queue deviceGetQueue(@NonNull Device device) {
        return new Queue(webgpu_h.wgpuDeviceGetQueue(device.ptr()));
    }

    public static final boolean deviceHasFeature(@NonNull Device device, @NonNull FeatureName feature) {
        var hasFeature = webgpu_h.wgpuDeviceHasFeature(device.ptr(), feature.value());
        return hasFeature != 0;
    }

    public static final Future<?> devicePopErrorScope(@NonNull Device device, @NonNull PopErrorScopeCallback callback) {
        throw new UnsupportedOperationException("Unimplemented method 'devicePopErrorScope'");
    }

    public static final void devicePushErrorScope(@NonNull Device device, ErrorFilter filter) {
        webgpu_h.wgpuDevicePushErrorScope(device.ptr(), filter.value());
    }

    public static final void deviceSetLabel(@NonNull Device device, @NonNull String label) {
        webgpu_h.wgpuDeviceSetLabel(device.ptr(), new StringView(label).ptr());
    }

    public static final void deviceAddRef(@NonNull Device device) {
        webgpu_h.wgpuDeviceAddRef(device.ptr());
    }

    public static void deviceRelease(@NonNull Device device) {
        webgpu_h.wgpuDeviceRelease(device.ptr());
    }

    @SuppressWarnings("preview")
    public static Surface instanceCreateSurface(@NonNull InstanceImpl instance,
            @Nullable SurfaceDescriptor descriptor) {

        if (descriptor == null) {
            return new Surface(webgpu_h.wgpuInstanceCreateSurface(instance.ptr(), MemorySegment.NULL));
        }
        return new Surface(webgpu_h.wgpuInstanceCreateSurface(instance.ptr(), descriptor.ptr()));
    }

    public static Status instanceGetWGSLLanguageFeatures(@NonNull InstanceImpl instance,
            @NonNull SupportedWGSLLanguageFeatures features) {
        var statusCode = (webgpu_h.wgpuInstanceGetWGSLLanguageFeatures(instance.ptr(), features.ptr()));

        if (statusCode == Status.Success.value()) {
            return Status.Success;
        } else {
            return Status.Error;
        }
    }

    public static boolean instanceHasWGSLLanguageFeature(@NonNull InstanceImpl instance,
            @NonNull WGSLLanguageFeatureName feature) {
        var hasFeature = webgpu_h.wgpuInstanceHasWGSLLanguageFeature(instance.ptr(), feature.value());
        return hasFeature != 0;
    }

    public static void instanceProcessEvents(@NonNull InstanceImpl instance) {
        webgpu_h.wgpuInstanceProcessEvents(instance.ptr());
    }

    public static Future<Adapter> instanceRequestAdapter(@NonNull InstanceImpl instance, @Nullable RequestAdapterOptions options) {

        if (options == null) {
            options = new RequestAdapterOptions();
        }

        try (Arena arena = Arena.ofShared()) {

            var requestAdapterCallbackInfoPtr = WGPURequestAdapterCallbackInfo.allocate(arena);

            WGPURequestAdapterCallbackInfo.callback(requestAdapterCallbackInfoPtr, null);

            MemorySegment futurePtr = webgpu_h.wgpuInstanceRequestAdapter(arena, instance.ptr(), options.ptr(),
                    MemorySegment.NULL);

            return new Future<Adapter>() {

                @Override
                public boolean cancel(boolean mayInterruptIfRunning) {
                    // TODO Auto-generated method stub
                    throw new UnsupportedOperationException("Unimplemented method 'cancel'");
                }

                @Override
                public boolean isCancelled() {
                    // TODO Auto-generated method stub
                    throw new UnsupportedOperationException("Unimplemented method 'isCancelled'");
                }

                @Override
                public boolean isDone() {
                    
                    // TODO Auto-generated method stub
                    throw new UnsupportedOperationException("Unimplemented method 'isDone'");
                }

                @Override
                public Adapter get() throws InterruptedException, ExecutionException {
                    // TODO Auto-generated method stub
                    throw new UnsupportedOperationException("Unimplemented method 'get'");
                }

                @Override
                public Adapter get(long timeout, TimeUnit unit)
                        throws InterruptedException, ExecutionException, TimeoutException {
                    // TODO Auto-generated method stub
                    throw new UnsupportedOperationException("Unimplemented method 'get'");
                }

            };
        }

    }

    public static WaitStatus instanceWaitAny(@NonNull Instance instance, @NonNull Future<?>[] futures,
            Duration timeout) {
        throw new UnsupportedOperationException("Unimplemented method 'instanceWaitAny'");
    }

    public static void instanceAddRef(@NonNull InstanceImpl instance) {
        webgpu_h.wgpuInstanceAddRef(instance.ptr());
    }

    public static void instanceRelease(@NonNull InstanceImpl instance) {
        webgpu_h.wgpuInstanceRelease(instance.ptr());
    }

    public static void pipelineLayoutSetLabel(@NonNull PipelineLayout pipelineLayout, String label) {
        webgpu_h.wgpuPipelineLayoutSetLabel(pipelineLayout.ptr(), new StringView(label).ptr());
    }

    public static void pipelineLayoutAddRef(@NonNull PipelineLayout pipelineLayout) {
        webgpu_h.wgpuPipelineLayoutAddRef(pipelineLayout.ptr());
    }

    public static void pipelineLayoutRelease(@NonNull PipelineLayout pipelineLayout) {
        webgpu_h.wgpuPipelineLayoutRelease(pipelineLayout.ptr());
    }

    public static void querySetDestroy(@NonNull QuerySet querySet) {
        webgpu_h.wgpuQuerySetDestroy(querySet.ptr());
    }

    public static int querySetGetCount(@NonNull QuerySet querySet) {
        return webgpu_h.wgpuQuerySetGetCount(querySet.ptr());
    }

    public static QueryType querySetGetType(@NonNull QuerySet querySet) {
        var queryTypeCode = webgpu_h.wgpuQuerySetGetType(querySet.ptr());
        return QueryType.values()[queryTypeCode];
    }

    public static void querySetSetLabel(@NonNull QuerySet querySet, String label) {
        webgpu_h.wgpuQuerySetSetLabel(querySet.ptr(), new StringView(label).ptr());
    }

    public static void querySetAddRef(@NonNull QuerySet querySet) {
        webgpu_h.wgpuQuerySetAddRef(querySet.ptr());
    }

    public static void querySetRelease(@NonNull QuerySet querySet) {
        webgpu_h.wgpuQuerySetRelease(querySet.ptr());
    }

    public static Future<?> queueOnSubmittedWorkDone(@NonNull Queue queue,
            @NonNull QueueWorkDoneCallbackInfo callbackInfo) {
        throw new UnsupportedOperationException("Unimplemented method 'queueOnSubmittedWorkDone'");
    }

    public static void queueSetLabel(@NonNull Queue queue, String label) {
        webgpu_h.wgpuQueueSetLabel(queue.ptr(), new StringView(label).ptr());
    }

    public static void queueSubmit(@NonNull Queue queue, @NonNull CommandBuffer... commands) {

        webgpu_h.wgpuQueueSubmit(queue.ptr(), commands.length, commands[0].ptr());
    }

    @SuppressWarnings("preview")
    public static void queueWriteBuffer(@NonNull Queue queue, @NonNull Buffer buffer, long offset,
            @NonNull byte[] data) {
        webgpu_h.wgpuQueueWriteBuffer(queue.ptr(), buffer.ptr(), offset, MemorySegment.ofArray(data), data.length);
    }

    @SuppressWarnings("preview")
    public static void queueWriteTexture(@NonNull Queue queue, @NonNull TexelCopyTextureInfo destination,
            @NonNull byte[] data, TexelCopyBufferLayout dataLayout, final Extend3D writeSize) {
        webgpu_h.wgpuQueueWriteTexture(queue.ptr(), destination.ptr(), MemorySegment.ofArray(data), (long) data.length,
                dataLayout.ptr(), writeSize.ptr());
    }

    public static void queueAddRef(@NonNull Queue queue) {
        webgpu_h.wgpuQueueAddRef(queue.ptr());
    }

    public static void queueRelease(@NonNull Queue queue) {
        webgpu_h.wgpuQueueRelease(queue.ptr());
    }

    public static void renderPassSetLabel(@NonNull RenderPass renderPass, String label) {
        throw new UnsupportedOperationException("Unimplemented method 'renderPassSetLabel'");
    }

    public static void renderBundleAddRef(@NonNull RenderBundle renderBundle) {
        webgpu_h.wgpuRenderBundleAddRef(renderBundle.ptr());
    }

    public static void renderBundleRelease(@NonNull RenderBundle renderBundle) {
        webgpu_h.wgpuRenderBundleRelease(renderBundle.ptr());
    }

    public static void renderBundleEncoderDraw(@NonNull RenderBundleEncoder renderBundleEncoder,
            int vertexCount, int instanceCount, int firstVertex, int firstInstance) {
        webgpu_h.wgpuRenderBundleEncoderDraw(renderBundleEncoder.ptr(), vertexCount, instanceCount, firstVertex,
                firstInstance);
    }

    public static void renderBundleEncoderDrawIndexed(@NonNull RenderBundleEncoder renderBundleEncoder,
            int indexCount, int instanceCount, int firstIndex, int baseVertex, int firstInstance) {
        webgpu_h.wgpuRenderBundleEncoderDrawIndexed(renderBundleEncoder.ptr(), indexCount, instanceCount, firstIndex,
                baseVertex, firstInstance);
    }

    public static void renderBundleEncoderDrawIndexedIndirect(@NonNull RenderBundleEncoder renderBundleEncoder,
            @NonNull Buffer indirectBuffer, long indirectOffset) {
        webgpu_h.wgpuRenderBundleEncoderDrawIndexedIndirect(renderBundleEncoder.ptr(), indirectBuffer.ptr(),
                indirectOffset);
    }

    public static void renderBundleEncoderDrawIndirect(@NonNull RenderBundleEncoder renderBundleEncoder,
            @NonNull Buffer indirectBuffer, long indirectOffset) {
        webgpu_h.wgpuRenderBundleEncoderDrawIndirect(renderBundleEncoder.ptr(), indirectBuffer.ptr(), indirectOffset);
    }

    public static RenderBundle renderBundleEncoderFinish(@NonNull RenderBundleEncoder renderBundleEncoder,
            @NonNull RenderBundleDescriptor descriptor) {
        return new RenderBundle(webgpu_h.wgpuRenderBundleEncoderFinish(renderBundleEncoder.ptr(), descriptor.ptr()));
    }

    public static void renderBundleEncoderInsertDebugMarker(@NonNull RenderBundleEncoder renderBundleEncoder,
            String markerLabel) {
        webgpu_h.wgpuRenderBundleEncoderInsertDebugMarker(renderBundleEncoder.ptr(), new StringView(markerLabel).ptr());
    }

    public static void renderBundleEncoderPopDebugGroup(@NonNull RenderBundleEncoder renderBundleEncoder) {
        webgpu_h.wgpuRenderBundleEncoderPopDebugGroup(renderBundleEncoder.ptr());
    }

    public static void renderBundleEncoderPushDebugGroup(@NonNull RenderBundleEncoder renderBundleEncoder,
            String groupLabel) {
        webgpu_h.wgpuRenderBundleEncoderPushDebugGroup(renderBundleEncoder.ptr(), new StringView(groupLabel).ptr());
    }

    @SuppressWarnings("preview")
    public static void renderBundleEncoderSetBindGroup(@NonNull RenderBundleEncoder renderBundleEncoder,
            int groupIndex, @NonNull BindGroup bindGroup, int dynamicOffsetCount, int[] dynamicOffsets) {
        webgpu_h.wgpuRenderBundleEncoderSetBindGroup(renderBundleEncoder.ptr(), groupIndex, bindGroup.ptr(),
                dynamicOffsetCount, MemorySegment.ofArray(dynamicOffsets));
    }

    public static void renderBundleEncoderSetIndexBuffer(@NonNull RenderBundleEncoder renderBundleEncoder,
            @NonNull Buffer buffer, @NonNull IndexFormat format, long offset, long size) {
        webgpu_h.wgpuRenderBundleEncoderSetIndexBuffer(renderBundleEncoder.ptr(), buffer.ptr(), format.value(), offset,
                size);
    }

    public static void renderBundleEncoderSetPipeline(@NonNull RenderBundleEncoder renderBundleEncoder,
            @NonNull RenderPipeline renderPipeline) {
        webgpu_h.wgpuRenderBundleEncoderSetPipeline(renderBundleEncoder.ptr(), renderPipeline.ptr());
    }

    public static void renderBundleEncoderSetVertexBuffer(@NonNull RenderBundleEncoder renderBundleEncoder,
            int slot, @NonNull Buffer buffer, long offset, long size) {
        webgpu_h.wgpuRenderBundleEncoderSetVertexBuffer(renderBundleEncoder.ptr(), slot, buffer.ptr(), offset, size);
    }

    public static void renderBundleEncoderAddRef(RenderBundleEncoder renderBundleEncoder) {
        webgpu_h.wgpuRenderBundleEncoderAddRef(renderBundleEncoder.ptr());
    }

    public static void renderBundleEncoderRelease(RenderBundleEncoder renderBundleEncoder) {
        webgpu_h.wgpuRenderBundleEncoderRelease(renderBundleEncoder.ptr());
    }

    public static void renderPassEncoderBeginOcclusionQuery(@NonNull RenderPassEncoder renderPassEncoder,
            int queryIndex) {
        webgpu_h.wgpuRenderPassEncoderBeginOcclusionQuery(renderPassEncoder.ptr(), queryIndex);
    }

    public static void renderPassEncoderDraw(@NonNull RenderPassEncoder renderPassEncoder, int vertexCount,
            int instanceCount, int firstVertex, int firstInstance) {
        webgpu_h.wgpuRenderPassEncoderDraw(renderPassEncoder.ptr(), vertexCount, instanceCount, firstVertex,
                firstInstance);
    }

    public static void renderPassEncoderDrawIndexed(@NonNull RenderPassEncoder renderPassEncoder, int indexCount,
            int instanceCount, int firstIndex, int baseVertex, int firstInstance) {
        webgpu_h.wgpuRenderPassEncoderDrawIndexed(renderPassEncoder.ptr(), indexCount, instanceCount, firstIndex,
                baseVertex, firstInstance);
    }

    public static void renderPassEncoderDrawIndexedIndirect(@NonNull RenderPassEncoder renderPassEncoder,
            @NonNull Buffer indirectBuffer, long indirectOffset) {
        webgpu_h.wgpuRenderPassEncoderDrawIndexedIndirect(renderPassEncoder.ptr(), indirectBuffer.ptr(),
                indirectOffset);
    }

    public static void renderPassEncoderDrawIndirect(@NonNull RenderPassEncoder renderPassEncoder,
            @NonNull Buffer indirectBuffer, long indirectOffset) {
        webgpu_h.wgpuRenderPassEncoderDrawIndirect(renderPassEncoder.ptr(), indirectBuffer.ptr(), indirectOffset);
    }

    public static void renderPassEncoderEnd(@NonNull RenderPassEncoder renderPassEncoder) {
        webgpu_h.wgpuRenderPassEncoderEnd(renderPassEncoder.ptr());
    }

    public static void renderPassEncoderEndOcclusionQuery(@NonNull RenderPassEncoder renderPassEncoder) {
        webgpu_h.wgpuRenderPassEncoderEndOcclusionQuery(renderPassEncoder.ptr());
    }

    public static void renderPassEncoderExecuteBundles(@NonNull RenderPassEncoder renderPassEncoder,
            @NonNull RenderBundle... bundles) {
        throw new UnsupportedOperationException("Unimplemented method 'renderPassEncoderExecuteBundles'");
    }

    public static void renderPassEncoderInsertDebugMarker(@NonNull RenderPassEncoder renderPassEncoder,
            String markerLabel) {
        webgpu_h.wgpuRenderPassEncoderInsertDebugMarker(renderPassEncoder.ptr(), new StringView(markerLabel).ptr());
    }

    public static void renderPassEncoderPopDebugGroup(@NonNull RenderPassEncoder renderPassEncoder) {
        webgpu_h.wgpuRenderPassEncoderPopDebugGroup(renderPassEncoder.ptr());
    }

    public static void renderPassEncoderPushDebugGroup(@NonNull RenderPassEncoder renderPassEncoder,
            String groupLabel) {
        webgpu_h.wgpuRenderPassEncoderPushDebugGroup(renderPassEncoder.ptr(), new StringView(groupLabel).ptr());
    }

    @SuppressWarnings("preview")
    public static void renderPassEncoderSetBindGroup(@NonNull RenderPassEncoder renderPassEncoder, int groupIndex,
            @NonNull BindGroup bindGroup, int dynamicOffsetCount, int[] dynamicOffsets) {
        webgpu_h.wgpuRenderPassEncoderSetBindGroup(renderPassEncoder.ptr(), groupIndex, bindGroup.ptr(),
                dynamicOffsetCount, MemorySegment.ofArray(dynamicOffsets));
    }

    public static void renderPassEncoderSetBlendConstant(@NonNull RenderPassEncoder renderPassEncoder,
            @NonNull Color color) {
        webgpu_h.wgpuRenderPassEncoderSetBlendConstant(renderPassEncoder.ptr(), color.ptr());
    }

    public static void renderPassEncoderSetIndexBuffer(@NonNull RenderPassEncoder renderPassEncoder,
            @NonNull Buffer buffer, @NonNull IndexFormat format, long offset, long size) {
        webgpu_h.wgpuRenderPassEncoderSetIndexBuffer(renderPassEncoder.ptr(), buffer.ptr(), format.value(), offset,
                size);
    }

    public static void renderPassEncoderSetLabel(@NonNull RenderPassEncoder renderPassEncoder, String label) {
        webgpu_h.wgpuRenderPassEncoderSetLabel(renderPassEncoder.ptr(), new StringView(label).ptr());
    }

    public static void renderPassEncoderSetPipeline(@NonNull RenderPassEncoder renderPassEncoder,
            @NonNull RenderPipeline renderPipeline) {
        webgpu_h.wgpuRenderPassEncoderSetPipeline(renderPassEncoder.ptr(), renderPipeline.ptr());
    }

    public static void renderPassEncoderSetScissorRect(@NonNull RenderPassEncoder renderPassEncoder, int x,
            int y, int width, int height) {
        webgpu_h.wgpuRenderPassEncoderSetScissorRect(renderPassEncoder.ptr(), x, y, width, height);
    }

    public static void renderPassEncoderSetStencilReference(@NonNull RenderPassEncoder renderPassEncoder,
            int reference) {
        webgpu_h.wgpuRenderPassEncoderSetStencilReference(renderPassEncoder.ptr(), reference);
    }

    public static void renderPassEncoderSetVertexBuffer(@NonNull RenderPassEncoder renderPassEncoder, int slot,
            @NonNull Buffer buffer, long offset, long size) {
        webgpu_h.wgpuRenderPassEncoderSetVertexBuffer(renderPassEncoder.ptr(), slot, buffer.ptr(), offset, size);
    }

    public static void renderPassEncoderSetViewport(@NonNull RenderPassEncoder renderPassEncoder, float x,
            float y, float width, float height, float minDepth, float maxDepth) {
        webgpu_h.wgpuRenderPassEncoderSetViewport(renderPassEncoder.ptr(), x, y, width, height, minDepth, maxDepth);
    }

    public static final void renderPassEncoderAddRef(@NonNull RenderPassEncoder renderPassEncoder) {
        webgpu_h.wgpuRenderPassEncoderAddRef(renderPassEncoder.ptr());
    }

    public static final void renderPassEncoderRelease(RenderPassEncoder renderPassEncoder) {
        webgpu_h.wgpuRenderPassEncoderRelease(renderPassEncoder.ptr());
    }

    public static void renderPipelineGetBindGroupLayout(@NonNull RenderPipeline renderPipeline, int groupIndex) {
        webgpu_h.wgpuRenderPipelineGetBindGroupLayout(renderPipeline.ptr(), groupIndex);
    }

    public static void renderPipelineSetLabel(@NonNull RenderPipeline renderPipeline, String label) {
        webgpu_h.wgpuRenderPipelineSetLabel(renderPipeline.ptr(), new StringView(label).ptr());
    }

    public static void renderPipelineAddRef(RenderPipeline renderPipeline) {
        webgpu_h.wgpuRenderPipelineAddRef(renderPipeline.ptr());
    }

    public static void renderPipelineRelease(RenderPipeline renderPipeline) {
        webgpu_h.wgpuRenderPipelineRelease(renderPipeline.ptr());
    }

    public static void samplerSetLabel(@NonNull Sampler sampler, String label) {
        webgpu_h.wgpuSamplerSetLabel(sampler.ptr(), new StringView(label).ptr());
    }

    public static void samplerAddRef(Sampler sampler) {
        webgpu_h.wgpuSamplerAddRef(sampler.ptr());
    }

    public static void samplerRelease(Sampler sampler) {
        webgpu_h.wgpuSamplerRelease(sampler.ptr());
    }

    public static void shaderModuleGetCompilationInfo(@NonNull ShaderModule shaderModule,
            @NonNull CompilationInfoCallbackInfo callbackInfo) {
        throw new UnsupportedOperationException("Unimplemented method 'shaderModuleGetCompilationInfo'");
    }

    public static void shaderModuleSetLabel(@NonNull ShaderModule shaderModule, String label) {
        throw new UnsupportedOperationException("Unimplemented method 'shaderModuleSetLabel'");
    }

    public static void shaderModuleAddRef(ShaderModule shaderModule) {

    }

    public static void shaderModuleRelease(ShaderModule shaderModule) {
        throw new UnsupportedOperationException("Unimplemented method 'shaderModuleRelease'");
    }

    public static void supportedFeaturesFreeMembers(@NonNull SupportedFeatures features) {
        webgpu_h.wgpuSupportedFeaturesFreeMembers(features.ptr());
    }

    public static void supportedInstanceFeaturesFreeMembers(
            @NonNull SupportedInstanceFeatures supportedInstanceFeatures) {
        throw new UnsupportedOperationException("Unimplemented method 'supportedInstanceFeaturesFreeMembers'");
    }

    public static void supportedWGSLLLanguageFeatureFreeMembers(
            @NonNull SupportedWGSLLanguageFeatures supportedWGSLLanguageFeatures) {
        webgpu_h.wgpuSupportedWGSLLanguageFeaturesFreeMembers(supportedWGSLLanguageFeatures.ptr());
    }

    public static void surfaceConfigure(@NonNull Surface surface, @NonNull SurfaceConfiguration configuration) {
        webgpu_h.wgpuSurfaceConfigure(surface.ptr(), configuration.ptr());
    }

    public static Status surfaceGetCapabilities(@NonNull Surface surface, @NonNull AdapterImpl adapter,
            @NonNull SurfaceCapabilities capabilities) {
        final int statusCode = (webgpu_h.wgpuSurfaceGetCapabilities(surface.ptr(), adapter.ptr(), capabilities.ptr()));

        if (statusCode == Status.Success.value()) {
            return Status.Success;
        } else {
            return Status.Error;
        }
    }

    public static void surfaceGetCurrentTexture(@NonNull Surface surface, @NonNull SurfaceTexture currentTexture) {
        webgpu_h.wgpuSurfaceGetCurrentTexture(surface.ptr(), currentTexture.ptr());
    }

    public static Status surfacePresent(Surface surface) {
        final int statusCode = (webgpu_h.wgpuSurfacePresent(surface.ptr()));

        if (statusCode == Status.Success.value()) {
            return Status.Success;
        } else {
            return Status.Error;
        }
    }

    public static void surfaceSetLabel(@NonNull Surface surface, String label) {
        webgpu_h.wgpuSurfaceSetLabel(surface.ptr(), new StringView(label).ptr());
    }

    public static void surfaceUnconfigure(@NonNull Surface surface) {
        webgpu_h.wgpuSurfaceUnconfigure(surface.ptr());
    }

    public static void surfaceAddRef(@NonNull Surface surface) {
        webgpu_h.wgpuSurfaceAddRef(surface.ptr());
    }

    public static void surfaceRelease(@NonNull Surface surface) {
        webgpu_h.wgpuSurfaceRelease(surface.ptr());
    }

    public static void surfaceCapabilitiesFreeMembers(@NonNull SurfaceCapabilities capabilities) {
        webgpu_h.wgpuSurfaceCapabilitiesFreeMembers(capabilities.ptr());
    }

    public static TextureView textureCreateView(@NonNull Texture texture,
            @NonNull TextureViewDescriptor descriptor) {
        return new TextureView(webgpu_h.wgpuTextureCreateView(texture.ptr(), descriptor.ptr()));
    }

    public static void textureDestroy(@NonNull Texture texture) {
        webgpu_h.wgpuTextureDestroy(texture.ptr());
    }

    public static int textureGetDepthOrArrayLayers(@NonNull Texture texture) {
        return webgpu_h.wgpuTextureGetDepthOrArrayLayers(texture.ptr());
    }

    public static TextureDimension textureGetDimension(@NonNull Texture texture) {
        final var dimension = (webgpu_h.wgpuTextureGetDimension(texture.ptr()));

        if (dimension == TextureDimension.ONE_D.value()) {
            return TextureDimension.ONE_D;
        } else if (dimension == TextureDimension.TWO_D.value()) {
            return TextureDimension.TWO_D;
        } else if (dimension == TextureDimension.THREE_D.value()) {
            return TextureDimension.THREE_D;
        } else {
            return TextureDimension.UNDEFINED;
        }
    }

    /**
     * Gets the format of a texture.
     *
     * @param texture the texture whose format should be queried
     * @return the format of the given texture
     */
    public static TextureFormat textureGetFormat(@NonNull Texture texture) {
        var format = webgpu_h.wgpuTextureGetFormat(texture.ptr());

        return TextureFormat.values()[format];
    }

    public static int textureGetHeight(@NonNull Texture texture) {
        return webgpu_h.wgpuTextureGetHeight(texture.ptr());
    }

    public static int textureGetMipLevelCount(@NonNull Texture texture) {
        return webgpu_h.wgpuTextureGetMipLevelCount(texture.ptr());
    }

    public static int textureGetSampleCount(@NonNull Texture texture) {
        return webgpu_h.wgpuTextureGetSampleCount(texture.ptr());
    }

    public static long textureGetUsage(@NonNull Texture texture) {
        return webgpu_h.wgpuTextureGetUsage(texture.ptr());
    }

    public static int textureGetWidth(@NonNull Texture texture) {
        return webgpu_h.wgpuTextureGetWidth(texture.ptr());
    }

    public static void textureSetLabel(@NonNull Texture texture, String label) {
        webgpu_h.wgpuTextureSetLabel(texture.ptr(), new StringView(label).ptr());
    }

    public static void textureAddRef(@NonNull Texture texture) {
        webgpu_h.wgpuTextureAddRef(texture.ptr());
    }

    public static void textureRelease(@NonNull Texture texture) {
        webgpu_h.wgpuTextureRelease(texture.ptr());
    }

    public static void textureViewSetLabel(@NonNull TextureView textureView, String label) {
        webgpu_h.wgpuTextureViewSetLabel(textureView.ptr(), new StringView(label).ptr());
    }

    public static void textureViewAddRef(@NonNull TextureView textureView) {
        webgpu_h.wgpuTextureViewAddRef(textureView.ptr());
    }

    public static void hasInstanceFeature(Instance instance, Object object) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'hasInstanceFeature'");
    }

}
