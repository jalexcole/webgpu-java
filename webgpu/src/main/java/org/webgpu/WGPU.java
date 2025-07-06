package org.webgpu;

import java.lang.foreign.Arena;
import java.lang.foreign.Linker;
import java.lang.foreign.MemorySegment;
import java.time.Duration;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;
import org.webgpu.extract.WGPUInstanceDescriptor;
import org.webgpu.extract.webgpu_h;

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
        try (Arena arena = Arena.ofConfined()) {
            if (descriptor == null) {
                var instance = webgpu_h.wgpuCreateInstance(MemorySegment.NULL);
                return new Instance(instance);
            }

            var wgpuDescriptor = arena.allocate(WGPUInstanceDescriptor.layout());

            

            var instance = webgpu_h.wgpuCreateInstance(wgpuDescriptor);
            return new Instance(instance);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        throw new UnsupportedOperationException("Unimplemented method 'createInstance'");
    }

    public static void getInstanceFeatures(SupportedFeatures... features) {
        throw new UnsupportedOperationException("Unimplemented method 'getInstanceFeatures'");
    }

    public static void getInstanceLimits(InstanceLimits... limits) {
        throw new UnsupportedOperationException("Unimplemented method 'getInstanceLimits'");
    }

    public static int hasInstanceFeature(int feature) {
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

    public static int adapterHasFeature(@NonNull Adapter adapter, int feature) {
        throw new UnsupportedOperationException("Unimplemented method 'adapterHasFeature'");
    }

    public static CompletableFuture<?> adapterRequestDevice(@NonNull Adapter adapter,
            @NonNull final DeviceDescriptor[] descriptors, @NonNull RequestDeviceCallbackInfo callbackInfo) {
        throw new UnsupportedOperationException("Unimplemented method 'adapterRequestDevice'");
    }

    public static void adapterAddRef(@NonNull Adapter adapter) {
        throw new UnsupportedOperationException("Unimplemented method 'adapterAddRef'");
    }

    public static void adapterRelease(@NonNull Adapter adapter) {
        throw new UnsupportedOperationException("Unimplemented method 'adapterRelease'");
    }

    public static void adapterInfoFreeMembers(@NonNull AdapterInfo info) {
        throw new UnsupportedOperationException("Unimplemented method 'adapterInfoFreeMembers'");
    }

    public static void bindGroupSetLabel(@NonNull BindGroup bindGroup, String label) {
        throw new UnsupportedOperationException("Unimplemented method 'bindGroupSetLabel'");
    }

    public static void bindGroupAddRef(@NonNull BindGroup bindGroup) {
        throw new UnsupportedOperationException("Unimplemented method 'bindGroupAddRef'");
    }

    public static void bindGroupRelease(@NonNull BindGroup bindGroup) {
        throw new UnsupportedOperationException("Unimplemented method 'bindGroupRelease'");
    }

    public static void bindGroupLayoutSetLabel(@NonNull BindGroupLayout bindGroupLayout, String label) {
        throw new UnsupportedOperationException("Unimplemented method 'bindGroupLayoutSetLabel'");
    }

    public static void bindGroupLayoutAddRef(@NonNull BindGroupLayout bindGroupLayout) {
        throw new UnsupportedOperationException("Unimplemented method 'bindGroupLayoutAddRef'");
    }

    public static void bindGroupLayoutRelease(@NonNull BindGroupLayout bindGroupLayout) {
        throw new UnsupportedOperationException("Unimplemented method 'bindGroupLayoutRelease'");
    }

    public static void bufferDestroy(@NonNull Buffer buffer) {
        throw new UnsupportedOperationException("Unimplemented method 'bufferDestroy'");
    }

    public static Object bufferGetConstMappedRange(@NonNull Buffer buffer, long offset, long size) {
        throw new UnsupportedOperationException("Unimplemented method 'wgpuBufferGetConstMappedRange'");
    }

    public static Object bufferGetMappedRange(@NonNull Buffer buffer, long offset, long size) {
        throw new UnsupportedOperationException("Unimplemented method 'wgpuBufferGetMappedRange'");
    }

    public static int bufferGetMapState(@NonNull Buffer buffer) {
        throw new UnsupportedOperationException("Unimplemented method 'bufferGetMapState'");
    }

    public static final long bufferGetSize(@NonNull Buffer buffer) {
        throw new UnsupportedOperationException("Unimplemented method 'bufferGetSize'");
    }

    public static final CompletableFuture<?> bufferMapAsync(@NonNull Buffer buffer, int mode, long offset, long size) {
        throw new UnsupportedOperationException("Unimplemented method 'bufferMapAsync'");
    }

    public static final int bufferReadMappedRange(@NonNull Buffer buffer, long offset, byte[] data, long size) {
        throw new UnsupportedOperationException("Unimplemented method 'bufferReadMappedRange'");
    }

    public static final void bufferSetLabel(@NonNull Buffer buffer, String label) {
        throw new UnsupportedOperationException("Unimplemented method 'bufferSetLabel'");
    }

    public static final void bufferUnmap(@NonNull Buffer buffer) {
        throw new UnsupportedOperationException("Unimplemented method 'bufferUnmap'");
    }

    public static final Status bufferWriteMappedRange(@NonNull Buffer buffer, long offset, byte[] data, long size) {
        throw new UnsupportedOperationException("Unimplemented method 'bufferWriteMappedRange'");
    }

    public static final void bufferAddRef(@NonNull Buffer buffer) {
        throw new UnsupportedOperationException("Unimplemented method 'bufferAddRef'");
    }

    public static final void bufferRelease(@NonNull Buffer buffer) {
        throw new UnsupportedOperationException("Unimplemented method 'bufferRelease'");
    }

    public static void commandBufferSetLabel(@NonNull CommandBuffer commandBuffer, String label) {
        throw new UnsupportedOperationException("Unimplemented method 'commandBufferSetLabel'");
    }

    public static void commandBufferAddRef(@NonNull CommandBuffer commandBuffer) {
        throw new UnsupportedOperationException("Unimplemented method 'commandBufferAddRef'");
    }

    public static void commandBufferRelease(@NonNull CommandBuffer commandBuffer) {
        throw new UnsupportedOperationException("Unimplemented method 'commandBufferRelease'");
    }

    public static ComputePassEncoder commandEncoderBeginComputePass(@NonNull CommandEncoder commandEncoder,
            @NonNull ComputePassDescriptor descriptor) {
        throw new UnsupportedOperationException("Unimplemented method 'commandEncoderBeginComputePass'");
    }

    public static final RenderPassEncoder commandEncoderBeginRenderPass(@NonNull CommandEncoder commandEncoder,
            @NonNull RenderPassDescriptor descriptor) {
        throw new UnsupportedOperationException("Unimplemented method 'commandEncoderBeginRenderPass'");
    }

    public static final void commandEncoderClearBuffer(@NonNull CommandEncoder commandEncoder, @NonNull Buffer buffer,
            long offset, long size) {
        throw new UnsupportedOperationException("Unimplemented method 'commandEncoderClearBuffer'");
    }

    public static final void commandEncoderCopyBufferToBuffer(@NonNull CommandEncoder commandEncoder,
            @NonNull Buffer source, long sourceOffset, @NonNull Buffer destination, long destinationOffset, long size) {
        throw new UnsupportedOperationException("Unimplemented method 'commandEncoderCopyBufferToBuffer'");
    }

    public static final void commandEncoderCopyBufferToTexture(@NonNull CommandEncoder commandEncoder,
            @NonNull final TexelCopyBufferInfo source, @NonNull final TexelCopyTextureInfo destination,
            @NonNull final Extend3D copySize) {
        throw new UnsupportedOperationException("Unimplemented method 'commandEncoderCopyBufferToTexture'");
    }

    public static final void commandEncoderCopyTextureToBuffer(@NonNull CommandEncoder commandEncoder,
            @NonNull final TexelCopyTextureInfo source, @NonNull final TexelCopyBufferInfo destination,
            @NonNull final Extend3D copySize) {
        throw new UnsupportedOperationException("Unimplemented method 'commandEncoderCopyTextureToBuffer'");
    }

    public static final void commandEncoderCopyTextureToTexture(@NonNull CommandEncoder commandEncoder,
            @NonNull final TexelCopyTextureInfo source, @NonNull final TexelCopyTextureInfo destination,
            @NonNull final Extend3D copySize) {
        throw new UnsupportedOperationException("Unimplemented method 'commandEncoderCopyTextureToTexture'");
    }

    public static final CommandBuffer commandEncoderFinish(@NonNull CommandEncoder commandEncoder,
            @NonNull CommandBufferDescriptor descriptor) {
        throw new UnsupportedOperationException("Unimplemented method 'commandEncoderFinish'");
    }

    public static void commandEncoderInsertDebugMarker(@NonNull CommandEncoder commandEncoder, String markerLabel) {
        throw new UnsupportedOperationException("Unimplemented method 'commandEncoderInsertDebugMarker'");
    }

    public static void commandEncoderPopDebugGroup(@NonNull CommandEncoder commandEncoder) {
        throw new UnsupportedOperationException("Unimplemented method 'commandEncoderPopDebugGroup'");
    }

    public static void commandEncoderPushDebugGroup(@NonNull CommandEncoder commandEncoder, String groupLabel) {
        throw new UnsupportedOperationException("Unimplemented method 'commandEncoderPushDebugGroup'");
    }

    public static void commandEncoderSetLabel(@NonNull CommandEncoder commandEncoder, String label) {
        throw new UnsupportedOperationException("Unimplemented method 'commandEncoderSetLabel'");
    }

    public static void commandEncoderWriteTimestamp(@NonNull CommandEncoder commandEncoder, @NonNull QuerySet querySet,
            int queryIndex) {
        throw new UnsupportedOperationException("Unimplemented method 'commandEncoderWriteTimestamp'");
    }

    public static void commandEncoderAddRef(@NonNull CommandEncoder commandEncoder) {
        throw new UnsupportedOperationException("Unimplemented method 'commandEncoderAddRef'");
    }

    public static void commandEncoderRelease(@NonNull CommandEncoder commandEncoder) {
        throw new UnsupportedOperationException("Unimplemented method 'commandEncoderRelease'");
    }

    public static final void computePassEncoderDispatchWorkgroups(@NonNull ComputePassEncoder computePassEncoder,
            int workgroupCountX,
            int workgroupCountY, int workgroupCountZ) {
        throw new UnsupportedOperationException("Unimplemented method 'computePassEncoderDispatchWorkgroups'");
    }

    public static final void computePassEncoderDispatchWorkgroupsIndirect(
            @NonNull ComputePassEncoder computePassEncoder,
            @NonNull Buffer indirectBuffer, int indirectOffset) {
        throw new UnsupportedOperationException("Unimplemented method 'computePassEncoderDipatchWorkgroupsIndirect'");
    }

    public static final void computePassEncoderEnd(@NonNull ComputePassEncoder computePassEncoder) {
        throw new UnsupportedOperationException("Unimplemented method 'computePassEncoderEnd'");
    }

    public static final void computePassEncoderInsertDebugMarker(@NonNull ComputePassEncoder computePassEncoder,
            String markerLabel) {
        throw new UnsupportedOperationException("Unimplemented method 'computePassEncoderInsertDebugMarker'");
    }

    public static final void computePassEncoderPopDebugGroup(@NonNull ComputePassEncoder computePassEncoder) {
        throw new UnsupportedOperationException("Unimplemented method 'computePassEncoderPopDebugGroup'");
    }

    public static final void computePassEncoderPushDebugGroup(@NonNull ComputePassEncoder computePassEncoder,
            String groupLabel) {
        throw new UnsupportedOperationException("Unimplemented method 'computePassEncoderPushDebugGroup'");
    }

    public static final void computePassEncoderSetBindGroup(@NonNull ComputePassEncoder computePassEncoder,
            int groupIndex,
            @NonNull BindGroup group, long dynamicOffsetCount, int... dynamicOffsets) {
        throw new UnsupportedOperationException("Unimplemented method 'computePassEncoderSetBindGroup'");
    }

    public static final void computePassEncoderSetLabel(@NonNull ComputePassEncoder computePassEncoder, String label) {
        throw new UnsupportedOperationException("Unimplemented method 'computePassEncoderSetLabel'");
    }

    public static final void computePassEncoderSetPipeline(@NonNull ComputePassEncoder computePassEncoder,
            @NonNull ComputePipeline pipeline) {
        throw new UnsupportedOperationException("Unimplemented method 'computePassEncoderSetPipeline'");
    }

    public static final void computePassEncoderAddRef(@NonNull ComputePassEncoder computePassEncoder) {
        throw new UnsupportedOperationException("Unimplemented method 'computePassEncoderAddRef'");
    }

    public static final void computePassEncoderRelease(@NonNull ComputePassEncoder computePassEncoder) {
        throw new UnsupportedOperationException("Unimplemented method 'computePassEncoderRelease'");
    }

    public static final void computePipelineGetBindGroupLayout(@NonNull ComputePipeline computePipeline,
            int groupIndex) {
        throw new UnsupportedOperationException("Unimplemented method 'computePipelineGetBindGroupLayout'");
    }

    public static final void computePipelineSetLabel(@NonNull ComputePipeline computePipeline, String label) {
        throw new UnsupportedOperationException("Unimplemented method 'computePipelineSetLabel'");
    }

    public static final void computePipelineAddRef(@NonNull ComputePipeline computePipeline) {
        throw new UnsupportedOperationException("Unimplemented method 'computePipelineAddRef'");
    }

    public static final void computePipelineRelease(@NonNull ComputePipeline computePipeline) {
        throw new UnsupportedOperationException("Unimplemented method 'computePipelineRelease'");
    }

    public static final BindGroup deviceCreateBindGroup(@NonNull Device device,
            @NonNull BindGroupDescriptor descriptor) {
        throw new UnsupportedOperationException("Unimplemented method 'deviceCreateBindGroup'");
    }

    public static final BindGroupLayout deviceCreateBindGroupLayout(@NonNull Device device,
            @NonNull BindGroupLayoutDescriptor descriptor) {
        throw new UnsupportedOperationException("Unimplemented method 'deviceCreateBindGroupLayout'");
    }

    public static final Buffer deviceCreateBuffer(@NonNull Device device, @NonNull final BufferDescriptor descriptor) {
        throw new UnsupportedOperationException("Unimplemented method 'deviceCreateBuffer'");
    }

    public static final CommandBuffer deviceCreateCommandBuffer(@NonNull Device device,
            @NonNull CommandBufferDescriptor descriptor) {
        throw new UnsupportedOperationException("Unimplemented method 'deviceCreateCommandBuffer'");
    }

    public static ComputePipeline deviceCreateComputePipeline(@NonNull Device device,
            @NonNull ComputePipelineDescriptor descriptor) {
        throw new UnsupportedOperationException("Unimplemented method 'deviceCreateComputePipeline'");
    }

    public static final CompletableFuture<?> deviceCreateComputePipelineAsync(@NonNull Device device,
            @NonNull CreateComputePipelineAsyncCallbackInfo callbackInfo) {
        throw new UnsupportedOperationException("Unimplemented method 'deviceCreateComputePipelineAsync'");
    }

    public static final PipelineLayout deviceCreatePipelineLayout(@NonNull Device device,
            @NonNull PipelineLayoutDescriptor descriptor) {
        throw new UnsupportedOperationException("Unimplemented method 'deviceCreatePipelineLayout'");
    }

    public static final QuerySet deviceCreateQuerySet(@NonNull Device device,
            @NonNull QuerySetDescriptor descriptor) {
        throw new UnsupportedOperationException("Unimplemented method 'deviceCreateQuerySet'");
    }

    public static final RenderBundleEncoder deviceCreateRenderBundleEncoder(@NonNull Device device,
            @NonNull RenderBundleEncoderDescriptor descriptor) {
        throw new UnsupportedOperationException("Unimplemented method 'deviceCreateRenderBundleEncoder'");
    }

    public static final RenderPipeline deviceCreateRenderPipeline(@NonNull Device device,
            @NonNull RenderPipelineDescriptor descriptor) {
        throw new UnsupportedOperationException("Unimplemented method 'deviceCreateRenderPipeline'");
    }

    public static final CompletableFuture<?> deviceCreateRenderPipelineAsync(@NonNull Device device,
            @NonNull RenderPipelineDescriptor descriptor,
            @NonNull CreateRenderPipelineAsyncCallbackInfo callbackInfo) {
        throw new UnsupportedOperationException("Unimplemented method 'deviceCreateRenderPipelineAsync'");
    }

    public static final Sampler deviceCreateSampler(@NonNull Device device,
            @NonNull SamplerDescriptor descriptor) {
        throw new UnsupportedOperationException("Unimplemented method 'deviceCreateSampler'");
    }

    public static final ShaderModule deviceCreateShaderModule(@NonNull Device device,
            @NonNull final ShaderModuleDescriptor descriptor) {
        throw new UnsupportedOperationException("Unimplemented method 'deviceCreateShaderModule'");
    }

    public static final Texture deviceCreateTexture(@NonNull Device device,
            @NonNull TextureDescriptor descriptor) {
        throw new UnsupportedOperationException("Unimplemented method 'deviceCreateTexture'");
    }

    public static final void deviceDestroy(@NonNull Device device) {
        throw new UnsupportedOperationException("Unimplemented method 'deviceDestroy'");
    }

    public static final Status deviceGetAdapterInfo(@NonNull Device device, @NonNull AdapterInfo adapterInfo) {
        throw new UnsupportedOperationException("Unimplemented method 'deviceGetAdapterInfo'");
    }

    public static void deviceGetFeatures(@NonNull Device device, @NonNull SupportedFeatures features) {
        throw new UnsupportedOperationException("Unimplemented method 'deviceGetFeatures'");
    }

    public static final Status deviceGetLimits(@NonNull Device device, @NonNull Limits limits) {
        throw new UnsupportedOperationException("Unimplemented method 'deviceGetLimits'");
    }

    public static final Future<?>[] deviceGetLostFuture(@NonNull Device device) {
        throw new UnsupportedOperationException("Unimplemented method 'deviceGetLostFuture'");
    }

    public static final Queue deviceGetQueue(@NonNull Device device) {
        throw new UnsupportedOperationException("Unimplemented method 'deviceGetQueue'");
    }

    public static final boolean deviceHasFeature(@NonNull Device device, @NonNull FeatureName feature) {
        throw new UnsupportedOperationException("Unimplemented method 'deviceHasFeature'");
    }

    public static final Future<?> devicePopErrorScope(@NonNull Device device, @NonNull PopErrorScopeCallback callback) {
        throw new UnsupportedOperationException("Unimplemented method 'devicePopErrorScope'");
    }

    public static final void devicePushErrorScope(@NonNull Device device, ErrorFilter filter) {
        throw new UnsupportedOperationException("Unimplemented method 'devicePushErrorScope'");
    }

    public static final void deviceSetLabel(@NonNull Device device, @NonNull String label) {
        throw new UnsupportedOperationException("Unimplemented method 'deviceSetLabel'");
    }

    public static final void deviceAddRef(@NonNull Device device) {
        throw new UnsupportedOperationException("Unimplemented method 'deviceAddRef'");
    }

    public static void deviceRelease(@NonNull Device device) {
        throw new UnsupportedOperationException("Unimplemented method 'deviceRelease'");
    }

    public static Surface instanceCreateSurface(@NonNull Instance instance,
            @NonNull SurfaceDescriptor descriptor) {
        throw new UnsupportedOperationException("Unimplemented method 'instanceCreateSurface'");
    }

    public static Status instanceGetWGSLLanguageFeatures(@NonNull Instance instance,
            @NonNull SupportedWGSLLanguageFeatures features) {
        throw new UnsupportedOperationException("Unimplemented method 'instanceGetWGSLLanguageFeatures'");
    }

    public static boolean instanceHasWGSLLanguageFeature(@NonNull Instance instance,
            @NonNull WGSLLanguageFeatureName feature) {
        throw new UnsupportedOperationException("Unimplemented method 'instanceHasWGSLLanguageFeature'");
    }

    public static void instanceProcessEvents(@NonNull Instance instance) {
        throw new UnsupportedOperationException("Unimplemented method 'instanceProcessEvents'");
    }

    public static Future<?> instanceRequestAdapter(@NonNull Instance instance,
            @NonNull RequestAdapterCallbackInfo callback) {
        throw new UnsupportedOperationException("Unimplemented method 'instanceRequestAdapter'");
    }

    public static WaitStatus instanceWaitAny(@NonNull Instance instance, @NonNull Future<?>[] futures,
            Duration timeout) {
        throw new UnsupportedOperationException("Unimplemented method 'instanceWaitAny'");
    }

    public static void instanceAddRef(@NonNull Instance instance) {
        throw new UnsupportedOperationException("Unimplemented method 'instanceAddRef'");
    }

    public static void instanceRelease(@NonNull Instance instance) {
        throw new UnsupportedOperationException("Unimplemented method 'instanceRelease'");
    }

    public static void pipelineLayoutSetLabel(@NonNull PipelineLayout pipelineLayout, String label) {
        throw new UnsupportedOperationException("Unimplemented method 'pipelineLayoutSetLabel'");
    }

    public static void pipelineLayoutAddRef(@NonNull PipelineLayout pipelineLayout) {
        throw new UnsupportedOperationException("Unimplemented method 'pipelineLayoutAddRef'");
    }

    public static void pipelineLayoutRelease(@NonNull PipelineLayout pipelineLayout) {
        throw new UnsupportedOperationException("Unimplemented method 'pipelineLayoutRelease'");
    }

    public static void querySetDestroy(@NonNull QuerySet querySet) {
        throw new UnsupportedOperationException("Unimplemented method 'querySetDestroy'");
    }

    public static int querySetGetCount(@NonNull QuerySet querySet) {
        throw new UnsupportedOperationException("Unimplemented method 'querySetGetCount'");
    }

    public static QueryType querySetGetType(@NonNull QuerySet querySet) {
        throw new UnsupportedOperationException("Unimplemented method 'querySetGetType'");
    }

    public static void querySetSetLabel(@NonNull QuerySet querySet, String label) {
        throw new UnsupportedOperationException("Unimplemented method 'querySetSetLabel'");
    }

    public static void querySetAddRef(@NonNull QuerySet querySet) {
        throw new UnsupportedOperationException("Unimplemented method 'querySetAddRef'");
    }

    public static void querySetRelease(@NonNull QuerySet querySet) {
        throw new UnsupportedOperationException("Unimplemented method 'querySetRelease'");
    }

    public static Future<?> queueOnSubmittedWorkDone(@NonNull Queue queue,
            @NonNull QueueWorkDoneCallbackInfo callbackInfo) {
        throw new UnsupportedOperationException("Unimplemented method 'queueOnSubmittedWorkDone'");
    }

    public static void queueSetLabel(@NonNull Queue queue, String label) {
        throw new UnsupportedOperationException("Unimplemented method 'queueSetLabel'");
    }

    public static void queueSubmit(@NonNull Queue queue, @NonNull CommandBuffer... commands) {
        throw new UnsupportedOperationException("Unimplemented method 'queueSubmit'");
    }

    public static void queueWriteBuffer(@NonNull Queue queue, @NonNull Buffer buffer, long offset,
            @NonNull byte[] data) {
        throw new UnsupportedOperationException("Unimplemented method 'queueWriteBuffer'");
    }

    public static void queueWriteTexture(@NonNull Queue queue, @NonNull TexelCopyTextureInfo destination,
            @NonNull byte[] data, TexelCopyBufferLayout dataLayout, final Extend3D writeSize) {
        throw new UnsupportedOperationException("Unimplemented method 'queueWriteTexture'");
    }

    public static void queueAddRef(@NonNull Queue queue) {
        throw new UnsupportedOperationException("Unimplemented method 'queueAddRef'");
    }

    public static void queueRelease(@NonNull Queue queue) {
        throw new UnsupportedOperationException("Unimplemented method 'queueRelease'");
    }

    public static void renderPassSetLabel(@NonNull RenderPass renderPass, String label) {
        throw new UnsupportedOperationException("Unimplemented method 'renderPassSetLabel'");
    }

    public static void renderBundleAddRef(@NonNull RenderBundle renderBundle) {
        throw new UnsupportedOperationException("Unimplemented method 'renderBundleAddRef'");
    }

    public static void renderBundleRelease(@NonNull RenderBundle renderBundle) {
        throw new UnsupportedOperationException("Unimplemented method 'renderBundleRelease'");
    }

    public static void renderBundleEncoderDraw(@NonNull RenderBundleEncoder renderBundleEncoder,
            int vertexCount, int instanceCount, int firstVertex, int firstInstance) {
        throw new UnsupportedOperationException("Unimplemented method 'renderBundleEncoderDraw'");
    }

    public static void renderBundleEncoderDrawIndexed(@NonNull RenderBundleEncoder renderBundleEncoder,
            int indexCount, int instanceCount, int firstIndex, int baseVertex, int firstInstance) {
        throw new UnsupportedOperationException("Unimplemented method 'renderBundleEncoderDrawIndexed'");
    }

    public static void renderBundleEncoderDrawIndexedIndirect(@NonNull RenderBundleEncoder renderBundleEncoder,
            @NonNull Buffer indirectBuffer, long indirectOffset) {
        throw new UnsupportedOperationException("Unimplemented method 'renderBundleEncoderDrawIndexedIndirect'");
    }

    public static void renderBundleEncoderDrawIndirect(@NonNull RenderBundleEncoder renderBundleEncoder,
            @NonNull Buffer indirectBuffer, long indirectOffset) {
        throw new UnsupportedOperationException("Unimplemented method 'renderBundleEncoderDrawIndirect'");
    }

    public static RenderBundle renderBundleEncoderFinish(@NonNull RenderBundleEncoder renderBundleEncoder,
            @NonNull RenderBundleDescriptor descriptor) {
        throw new UnsupportedOperationException("Unimplemented method 'renderBundleEncoderFinish'");
    }

    public static void renderBundleEncoderInsertDebugMarker(@NonNull RenderBundleEncoder renderBundleEncoder,
            String markerLabel) {
        throw new UnsupportedOperationException("Unimplemented method 'renderBundleEncoderInsertDebugMarker'");
    }

    public static void renderBundleEncoderPopDebugGroup(@NonNull RenderBundleEncoder renderBundleEncoder) {
        throw new UnsupportedOperationException("Unimplemented method 'renderBundleEncoderPopDebugGroup'");
    }

    public static void renderBundleEncoderPushDebugGroup(@NonNull RenderBundleEncoder renderBundleEncoder,
            String groupLabel) {
        throw new UnsupportedOperationException("Unimplemented method 'renderBundleEncoderPushDebugGroup'");
    }

    public static void renderBundleEncoderSetBindGroup(@NonNull RenderBundleEncoder renderBundleEncoder,
            int groupIndex, @NonNull BindGroup bindGroup, int dynamicOffsetCount, int[] dynamicOffsets) {
        throw new UnsupportedOperationException("Unimplemented method 'renderBundleEncoderSetBindGroup'");
    }

    public static void renderBundleEncoderSetIndexBuffer(@NonNull RenderBundleEncoder renderBundleEncoder,
            @NonNull Buffer buffer, @NonNull IndexFormat format, long offset, long size) {
        throw new UnsupportedOperationException("Unimplemented method 'renderBundleEncoderSetIndexBuffer'");
    }

    public static void renderBundleEncoderSetPipeline(@NonNull RenderBundleEncoder renderBundleEncoder,
            @NonNull RenderPipeline renderPipeline) {
        throw new UnsupportedOperationException("Unimplemented method 'renderBundleEncoderSetPipeline'");
    }

    public static void renderBundleEncoderSetVertexBuffer(@NonNull RenderBundleEncoder renderBundleEncoder,
            int slot, @NonNull Buffer buffer, long offset, long size) {
        throw new UnsupportedOperationException("Unimplemented method 'renderBundleEncoderSetVertexBuffer'");
    }

    public static void renderBundleEncoderAddRef(RenderBundleEncoder renderBundleEncoder) {
        throw new UnsupportedOperationException("Unimplemented method 'renderBundleEncoderAddRef'");
    }

    public static void renderBundleEncoderRelease(RenderBundleEncoder renderBundleEncoder) {
        throw new UnsupportedOperationException("Unimplemented method 'renderBundleEncoderRelease'");
    }

    public static void renderPassEncoderBeginOcclusionQuery(@NonNull RenderPassEncoder renderPassEncoder,
            int queryIndex) {
        throw new UnsupportedOperationException("Unimplemented method 'renderPassEncoderBeginOcclusionQuery'");
    }

    public static void renderPassEncoderDraw(@NonNull RenderPassEncoder renderPassEncoder, int vertexCount,
            int instanceCount, int firstVertex, int firstInstance) {
        throw new UnsupportedOperationException("Unimplemented method 'renderPassEncoderDraw'");
    }

    public static void renderPassEncoderDrawIndexed(@NonNull RenderPassEncoder renderPassEncoder, int indexCount,
            int instanceCount, int firstIndex, int baseVertex, int firstInstance) {
        throw new UnsupportedOperationException("Unimplemented method 'renderPassEncoderDrawIndexed'");
    }

    public static void renderPassEncoderDrawIndexedIndirect(@NonNull RenderPassEncoder renderPassEncoder,
            @NonNull Buffer indirectBuffer, long indirectOffset) {
        throw new UnsupportedOperationException("Unimplemented method 'renderPassEncoderDrawIndexedIndirect'");
    }

    public static void renderPassEncoderDrawIndirect(@NonNull RenderPassEncoder renderPassEncoder,
            @NonNull Buffer indirectBuffer, long indirectOffset) {
        throw new UnsupportedOperationException("Unimplemented method 'renderPassEncoderDrawIndirect'");
    }

    public static void renderPassEncoderEnd(@NonNull RenderPassEncoder renderPassEncoder) {
        throw new UnsupportedOperationException("Unimplemented method 'renderPassEncoderEnd'");
    }

    public static void renderPassEncoderEndOcclusionQuery(@NonNull RenderPassEncoder renderPassEncoder) {
        throw new UnsupportedOperationException("Unimplemented method 'renderPassEncoderEndOcclusionQuery'");
    }

    public static void renderPassEncoderExecuteBundles(@NonNull RenderPassEncoder renderPassEncoder,
            @NonNull RenderBundle... bundles) {
        throw new UnsupportedOperationException("Unimplemented method 'renderPassEncoderExecuteBundles'");
    }

    public static void renderPassEncoderInsertDebugMarker(@NonNull RenderPassEncoder renderPassEncoder,
            String markerLabel) {
        throw new UnsupportedOperationException("Unimplemented method 'renderPassEncoderInsertDebugMarker'");
    }

    public static void renderPassEncoderPopDebugGroup(@NonNull RenderPassEncoder renderPassEncoder) {
        throw new UnsupportedOperationException("Unimplemented method 'renderPassEncoderPopDebugGroup'");
    }

    public static void renderPassEncoderPushDebugGroup(@NonNull RenderPassEncoder renderPassEncoder,
            String groupLabel) {
        throw new UnsupportedOperationException("Unimplemented method 'renderPassEncoderPushDebugGroup'");
    }

    public static void renderPassEncoderSetBindGroup(@NonNull RenderPassEncoder renderPassEncoder, int groupIndex,
            @NonNull BindGroup bindGroup, int dynamicOffsetCount, int[] dynamicOffsets) {
        throw new UnsupportedOperationException("Unimplemented method 'renderPassEncoderSetBindGroup'");
    }

    public static void renderPassEncoderSetBlendConstants(@NonNull RenderPassEncoder renderPassEncoder,
            @NonNull Color color) {
        throw new UnsupportedOperationException("Unimplemented method 'renderPassEncoderSetBlendConstants'");
    }

    public static void renderPassEncoderSetIndexBuffer(@NonNull RenderPassEncoder renderPassEncoder,
            @NonNull Buffer buffer, @NonNull IndexFormat format, long offset, long size) {
        throw new UnsupportedOperationException("Unimplemented method 'renderPassEncoderSetIndexBuffer'");
    }

    public static void renderPassEncoderSetLabel(@NonNull RenderPassEncoder renderPassEncoder, String label) {
        throw new UnsupportedOperationException("Unimplemented method 'renderPassEncoderSetLabel'");
    }

    public static void renderPassEncoderSetPipeline(@NonNull RenderPassEncoder renderPassEncoder,
            @NonNull RenderPipeline renderPipeline) {
        throw new UnsupportedOperationException("Unimplemented method 'renderPassEncoderSetPipeline'");
    }

    public static void renderPassEncoderSetScissorRect(@NonNull RenderPassEncoder renderPassEncoder, int x,
            int y, int width, int height) {
        throw new UnsupportedOperationException("Unimplemented method 'renderPassEncoderSetScissorRect'");
    }

    public static void renderPassEncoderSetStencilReference(@NonNull RenderPassEncoder renderPassEncoder,
            int reference) {
        throw new UnsupportedOperationException("Unimplemented method 'renderPassEncoderSetStencilReference'");
    }

    public static void renderPassEncoderSetVertexBuffer(@NonNull RenderPassEncoder renderPassEncoder, int slot,
            @NonNull Buffer buffer, long offset, long size) {
        throw new UnsupportedOperationException("Unimplemented method 'renderPassEncoderSetVertexBuffer'");
    }

    public static void renderPassEncoderSetViewport(@NonNull RenderPassEncoder renderPassEncoder, float x,
            float y, float width, float height, float minDepth, float maxDepth) {
        throw new UnsupportedOperationException("Unimplemented method 'renderPassEncoderSetViewport'");
    }

    public static void renderPassEncoderAddRef(RenderPassEncoder renderPassEncoder) {
        throw new UnsupportedOperationException("Unimplemented method 'renderPassEncoderAddRef'");
    }

    public static void renderPassEncoderRelease(RenderPassEncoder renderPassEncoder) {
        throw new UnsupportedOperationException("Unimplemented method 'renderPassEncoderRelease'");
    }

    public static void renderPipelineGetBindGroupLayout(@NonNull RenderPipeline renderPipeline, int groupIndex) {
        throw new UnsupportedOperationException("Unimplemented method 'renderPipelineGetBindGroupLayout'");
    }

    public static void renderPipelineSetLabel(@NonNull RenderPipeline renderPipeline, String label) {
        throw new UnsupportedOperationException("Unimplemented method 'renderPipelineSetLabel'");
    }

    public static void renderPipelineAddRef(RenderPipeline renderPipeline) {
        throw new UnsupportedOperationException("Unimplemented method 'renderPipelineAddRef'");
    }

    public static void renderPipelineRelease(RenderPipeline renderPipeline) {
        throw new UnsupportedOperationException("Unimplemented method 'renderPipelineRelease'");
    }

    public static void samplerSetLabel(@NonNull Sampler sampler, String label) {
        throw new UnsupportedOperationException("Unimplemented method 'samplerSetLabel'");
    }

    public static void samplerAddRef(Sampler sampler) {
        throw new UnsupportedOperationException("Unimplemented method 'samplerAddRef'");
    }

    public static void samplerRelease(Sampler sampler) {
        throw new UnsupportedOperationException("Unimplemented method 'samplerRelease'");
    }

    public static void shaderModuleGetCompilationInfo(@NonNull ShaderModule shaderModule,
            @NonNull CompilationInfoCallbackInfo callbackInfo) {
        throw new UnsupportedOperationException("Unimplemented method 'shaderModuleGetCompilationInfo'");
    }

    public static void shaderModuleSetLabel(@NonNull ShaderModule shaderModule, String label) {
        throw new UnsupportedOperationException("Unimplemented method 'shaderModuleSetLabel'");
    }

    public static void shaderModuleAddRef(ShaderModule shaderModule) {
        throw new UnsupportedOperationException("Unimplemented method 'shaderModuleAddRef'");
    }

    public static void shaderModuleRelease(ShaderModule shaderModule) {
        throw new UnsupportedOperationException("Unimplemented method 'shaderModuleRelease'");
    }

    public static void supportedFeaturesFreeMembers(@NonNull SupportedFeatures features) {
        throw new UnsupportedOperationException("Unimplemented method 'supportedFeaturesFreeMembers'");
    }

    public static void supportedInstanceFeaturesFreeMembers(
            @NonNull SupportedInstanceFeatures supportedInstanceFeatures) {
        throw new UnsupportedOperationException("Unimplemented method 'supportedInstanceFeaturesFreeMembers'");
    }

    public static void supportedWGSLLLanguageFeatureFreeMembers(
            @NonNull SupportedWGSLLanguageFeatures supportedWGSLLanguageFeatures) {
        throw new UnsupportedOperationException("Unimplemented method 'supportedWGSLLanguageFeatureFreeMembers'");
    }

    public static void surfaceConfigure(@NonNull Surface surface, @NonNull SurfaceConfiguration configuration) {
        throw new UnsupportedOperationException("Unimplemented method 'surfaceConfigure'");
    }

    public static Status surfaceGetCapabilities(@NonNull Surface surface, @NonNull Adapter adapter,
            @NonNull SurfaceCapabilities capabilities) {
        throw new UnsupportedOperationException("Unimplemented method 'surfaceGetCapabilities'");
    }

    public static void surfaceGetCurrentTexture(@NonNull Surface surface, @NonNull SurfaceTexture currentTexture) {
        throw new UnsupportedOperationException("Unimplemented method 'surfaceGetCurrentTexture'");
    }

    public static Status surfacePresent(Surface surface) {
        throw new UnsupportedOperationException("Unimplemented method 'surfacePresent'");
    }

    public static void surfaceSetLabel(@NonNull Surface surface, String label) {
        throw new UnsupportedOperationException("Unimplemented method 'surfaceSetLabel'");
    }

    public static void surfaceUnconfigure(@NonNull Surface surface) {
        throw new UnsupportedOperationException("Unimplemented method 'surfaceUnconfigure'");
    }

    public static void surfaceAddRef(@NonNull Surface surface) {
        throw new UnsupportedOperationException("Unimplemented method 'surfaceAddRef'");
    }

    public static void surfaceRelease(@NonNull Surface surface) {
        throw new UnsupportedOperationException("Unimplemented method 'surfaceRelease'");
    }

    public static void surfaceCapabilitiesFreeMembers(@NonNull SurfaceCapabilities capabilities) {
        throw new UnsupportedOperationException("Unimplemented method 'surfaceCapabilitiesFreeMembers'");
    }

    public static TextureView textureCreateView(@NonNull Texture texture,
            @NonNull TextureViewDescriptor descriptor) {
        throw new UnsupportedOperationException("Unimplemented method 'textureCreateView'");
    }

    public static void textureDestroy(@NonNull Texture texture) {
        throw new UnsupportedOperationException("Unimplemented method 'textureDestroy'");
    }

    public static int textureGetDepthOrArrayLayers(@NonNull Texture texture) {
        throw new UnsupportedOperationException("Unimplemented method 'textureGetDepthOrArrayLayers'");
    }

    public static TextureDimension textureGetDimension(@NonNull Texture texture) {
        throw new UnsupportedOperationException("Unimplemented method 'textureGetDimension'");
    }

    public static TextureFormat textureGetFormat(@NonNull Texture texture) {
        throw new UnsupportedOperationException("Unimplemented method 'textureGetFormat'");
    }

    public static int textureGetHeight(@NonNull Texture texture) {
        throw new UnsupportedOperationException("Unimplemented method 'textureGetHeight'");
    }

    public static int textureGetMipLevelCount(@NonNull Texture texture) {
        throw new UnsupportedOperationException("Unimplemented method 'textureGetMipLevelCount'");
    }

    public static int textureGetSampleCount(@NonNull Texture texture) {
        throw new UnsupportedOperationException("Unimplemented method 'textureGetSampleCount'");
    }

    public static int textureGetUsage(@NonNull Texture texture) {
        throw new UnsupportedOperationException("Unimplemented method 'textureGetUsage'");
    }

    public static int textureGetWidth(@NonNull Texture texture) {
        throw new UnsupportedOperationException("Unimplemented method 'textureGetWidth'");
    }

    public static void textureSetLabel(@NonNull Texture texture, String label) {
        throw new UnsupportedOperationException("Unimplemented method 'textureSetLabel'");
    }

    public static void textureAddRef(@NonNull Texture texture) {
        throw new UnsupportedOperationException("Unimplemented method 'textureAddRef'");
    }

    public static void textureRelease(@NonNull Texture texture) {
        throw new UnsupportedOperationException("Unimplemented method 'textureRelease'");
    }

    public static void textureViewSetLabel(@NonNull TextureView textureView, String label) {
        throw new UnsupportedOperationException("Unimplemented method 'textureViewSetLabel'");
    }

    public static void textureViewAddRef(@NonNull TextureView textureView) {
        throw new UnsupportedOperationException("Unimplemented method 'textureViewAddRef'");
    }

}
