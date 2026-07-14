package org.webgpu.impl.spi;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Supplier;

import org.webgpu.api.WGPUStruct;
import org.webgpu.api.exceptions.WGPUException;
import org.webgpu.api.spi.AdapterInfoProvider;
import org.webgpu.api.spi.BindGroupDescriptorProvider;
import org.webgpu.api.spi.BindGroupEntryProvider;
import org.webgpu.api.spi.BindGroupLayoutDescriptorProvider;
import org.webgpu.api.spi.BindGroupLayoutEntryProvider;
import org.webgpu.api.spi.BlendComponentProvider;
import org.webgpu.api.spi.BlendStateProvider;
import org.webgpu.api.spi.BufferBindingLayoutProvider;
import org.webgpu.api.spi.BufferDescriptorProvider;
import org.webgpu.api.spi.ColorProvider;
import org.webgpu.api.spi.ColorTargetStateProvider;
import org.webgpu.api.spi.CommandBufferDescriptorProvider;
import org.webgpu.api.spi.CommandEncoderDescriptorProvider;
import org.webgpu.api.spi.CompatibilityModeLimitsProvider;
import org.webgpu.api.spi.CompilationInfoProvider;
import org.webgpu.api.spi.CompilationMessageProvider;
import org.webgpu.api.spi.ComputePassDescriptorProvider;
import org.webgpu.api.spi.ComputePipelineDescriptorProvider;
import org.webgpu.api.spi.ComputeStateProvider;
import org.webgpu.api.spi.ConstantEntryProvider;
import org.webgpu.api.spi.DepthStencilStateProvider;
import org.webgpu.api.spi.DeviceDescriptorProvider;
import org.webgpu.api.spi.Extent3DProvider;
import org.webgpu.api.spi.ExternalTextureBindingEntryProvider;
import org.webgpu.api.spi.ExternalTextureBindingLayoutProvider;
import org.webgpu.api.spi.FragmentStateProvider;
import org.webgpu.api.spi.FutureProvider;
import org.webgpu.api.spi.FutureWaitInfoProvider;
import org.webgpu.api.spi.InstanceDescriptorProvider;
import org.webgpu.api.spi.InstanceLimitsProvider;
import org.webgpu.api.spi.LimitsProvider;
import org.webgpu.api.spi.MultisampleStateProvider;
import org.webgpu.api.spi.Origin3DProvider;
import org.webgpu.api.spi.PassTimestampWritesProvider;
import org.webgpu.api.spi.PipelineLayoutDescriptorProvider;
import org.webgpu.api.spi.PrimitiveStateProvider;
import org.webgpu.api.spi.QuerySetDescriptorProvider;
import org.webgpu.api.spi.QueueDescriptorProvider;
import org.webgpu.api.spi.RenderBundleDescriptorProvider;
import org.webgpu.api.spi.RenderBundleEncoderDescriptorProvider;
import org.webgpu.api.spi.RenderPassColorAttachmentProvider;
import org.webgpu.api.spi.RenderPassDepthStencilAttachmentProvider;
import org.webgpu.api.spi.RenderPassDescriptorProvider;
import org.webgpu.api.spi.RenderPassMaxDrawCountProvider;
import org.webgpu.api.spi.RenderPipelineDescriptorProvider;
import org.webgpu.api.spi.RequestAdapterOptionsProvider;
import org.webgpu.api.spi.RequestAdapterWebXROptionsProvider;
import org.webgpu.api.spi.SamplerBindingLayoutProvider;
import org.webgpu.api.spi.SamplerDescriptorProvider;
import org.webgpu.api.spi.ShaderModuleDescriptorProvider;
import org.webgpu.api.spi.ShaderSourceSPIRVProvider;
import org.webgpu.api.spi.ShaderSourceWGSLProvider;
import org.webgpu.api.spi.StencilFaceStateProvider;
import org.webgpu.api.spi.StorageTextureBindingLayoutProvider;
import org.webgpu.api.spi.StructProviderRegistry;
import org.webgpu.api.spi.SupportedFeaturesProvider;
import org.webgpu.api.spi.SupportedInstanceFeaturesProvider;
import org.webgpu.api.spi.SupportedWGSLLanguageFeaturesProvider;
import org.webgpu.api.spi.SurfaceCapabilitiesProvider;
import org.webgpu.api.spi.SurfaceColorManagementProvider;
import org.webgpu.api.spi.SurfaceConfigurationProvider;
import org.webgpu.api.spi.SurfaceDescriptorProvider;
import org.webgpu.api.spi.SurfaceSourceAndroidNativeWindowProvider;
import org.webgpu.api.spi.SurfaceSourceMetalLayerProvider;
import org.webgpu.api.spi.SurfaceSourceWaylandSurfaceProvider;
import org.webgpu.api.spi.SurfaceSourceWindowsHWNDProvider;
import org.webgpu.api.spi.SurfaceSourceXCBWindowProvider;
import org.webgpu.api.spi.SurfaceSourceXlibWindowProvider;
import org.webgpu.api.spi.SurfaceTextureProvider;
import org.webgpu.api.spi.TexelCopyBufferInfoProvider;
import org.webgpu.api.spi.TexelCopyBufferLayoutProvider;
import org.webgpu.api.spi.TexelCopyTextureInfoProvider;
import org.webgpu.api.spi.TextureBindingLayoutProvider;
import org.webgpu.api.spi.TextureBindingViewDimensionProvider;
import org.webgpu.api.spi.TextureComponentSwizzleDescriptorProvider;
import org.webgpu.api.spi.TextureComponentSwizzleProvider;
import org.webgpu.api.spi.TextureDescriptorProvider;
import org.webgpu.api.spi.TextureViewDescriptorProvider;
import org.webgpu.api.spi.VertexAttributeProvider;
import org.webgpu.api.spi.VertexBufferLayoutProvider;
import org.webgpu.api.spi.VertexStateProvider;
import org.webgpu.api.spi.WGPUProvider;

public class WGPUStructProviderRegistry implements StructProviderRegistry {

    private static final Map<Class<?>, Supplier<?>> registry = new ConcurrentHashMap<>();

    public WGPUStructProviderRegistry() {
        @SuppressWarnings("unchecked")
        Class<? extends WGPUStruct>[] subclasses = (Class<? extends WGPUStruct>[]) WGPUStruct.class
                .getPermittedSubclasses();
        registry.putIfAbsent(AdapterInfoProvider.class, AdapterInfoProviderImpl::new);
        registry.putIfAbsent(BindGroupDescriptorProvider.class, BindGroupDescriptorProviderImpl::new);
        registry.putIfAbsent(BindGroupEntryProvider.class, BindGroupEntryProviderImpl::new);
        registry.putIfAbsent(BindGroupLayoutDescriptorProvider.class, BindGroupLayoutDescriptorProviderImpl::new);
        registry.putIfAbsent(BindGroupLayoutEntryProvider.class, BindGroupLayoutEntryProviderImpl::new);
        registry.putIfAbsent(BlendComponentProvider.class, BlendComponentProviderImpl::new);
        registry.putIfAbsent(BlendStateProvider.class, BlendStateProviderImpl::new);
        registry.putIfAbsent(BufferBindingLayoutProvider.class, BufferBindingLayoutProviderImpl::new);
        registry.putIfAbsent(BufferDescriptorProvider.class, BufferDescriptorProviderImpl::new);
        registry.putIfAbsent(ColorProvider.class, ColorProviderImpl::new);
        registry.putIfAbsent(ColorTargetStateProvider.class, ColorTargetStateProviderImpl::new);
        registry.putIfAbsent(CommandBufferDescriptorProvider.class, CommandBufferDescriptorProviderImpl::new);
        registry.putIfAbsent(CommandEncoderDescriptorProvider.class, CommandEncoderDescriptorProviderImpl::new);
        registry.putIfAbsent(CompatibilityModeLimitsProvider.class, CompatibilityModeLimitsProviderImpl::new);
        registry.putIfAbsent(CompilationInfoProvider.class, CompilationInfoProviderImpl::new);
        registry.putIfAbsent(CompilationMessageProvider.class, CompilationMessageProviderImpl::new);
        registry.putIfAbsent(ComputePassDescriptorProvider.class, ComputePassDescriptorProviderImpl::new);
        registry.putIfAbsent(ComputePipelineDescriptorProvider.class, ComputePipelineDescriptorProviderImpl::new);
        registry.putIfAbsent(ComputeStateProvider.class, ComputeStateProviderImpl::new);
        registry.putIfAbsent(ConstantEntryProvider.class, ConstantEntryProviderImpl::new);
        registry.putIfAbsent(DepthStencilStateProvider.class, DepthStencilStateProviderImpl::new);
        registry.putIfAbsent(DeviceDescriptorProvider.class, DeviceDescriptorProviderImpl::new);
        registry.putIfAbsent(Extent3DProvider.class, Extent3DProviderImpl::new);
        registry.putIfAbsent(ExternalTextureBindingEntryProvider.class, ExternalTextureBindingEntryProviderImpl::new);
        registry.putIfAbsent(ExternalTextureBindingLayoutProvider.class, ExternalTextureBindingLayoutProviderImpl::new);
        registry.putIfAbsent(FragmentStateProvider.class, FragmentStateProviderImpl::new);
        registry.putIfAbsent(FutureProvider.class, FutureProviderImpl::new);
        registry.putIfAbsent(FutureWaitInfoProvider.class, FutureWaitInfoProviderImpl::new);
        registry.putIfAbsent(InstanceDescriptorProvider.class, InstanceDescriptorProviderImpl::new);
        registry.putIfAbsent(InstanceLimitsProvider.class, InstanceLimitsProviderImpl::new);
        registry.putIfAbsent(LimitsProvider.class, LimitsProviderImpl::new);
        registry.putIfAbsent(MultisampleStateProvider.class, MultisampleStateProviderImpl::new);
        registry.putIfAbsent(Origin3DProvider.class, Origin3DProviderImpl::new);
        registry.putIfAbsent(PassTimestampWritesProvider.class, PassTimestampWritesProviderImpl::new);
        registry.putIfAbsent(PipelineLayoutDescriptorProvider.class, PipelineLayoutDescriptorProviderImpl::new);
        registry.putIfAbsent(PrimitiveStateProvider.class, PrimitiveStateProviderImpl::new);
        registry.putIfAbsent(QuerySetDescriptorProvider.class, QuerySetDescriptorProviderImpl::new);
        registry.putIfAbsent(QueueDescriptorProvider.class, QueueDescriptorProviderImpl::new);
        registry.putIfAbsent(RenderBundleDescriptorProvider.class, RenderBundleDescriptorProviderImpl::new);
        registry.putIfAbsent(RenderBundleEncoderDescriptorProvider.class,
                RenderBundleEncoderDescriptorProviderImpl::new);
        registry.putIfAbsent(RenderPassColorAttachmentProvider.class, RenderPassColorAttachmentProviderImpl::new);
        registry.putIfAbsent(RenderPassDepthStencilAttachmentProvider.class,
                RenderPassDepthStencilAttachmentProviderImpl::new);
        registry.putIfAbsent(RenderPassDescriptorProvider.class, RenderPassDescriptorProviderImpl::new);
        registry.putIfAbsent(RenderPassMaxDrawCountProvider.class, RenderPassMaxDrawCountProviderImpl::new);
        registry.putIfAbsent(RenderPipelineDescriptorProvider.class, RenderPipelineDescriptorProviderImpl::new);
        registry.putIfAbsent(RequestAdapterOptionsProvider.class, RequestAdapterOptionsProviderImpl::new);
        registry.putIfAbsent(RequestAdapterWebXROptionsProvider.class, RequestAdapterWebXROptionsProviderImpl::new);
        registry.putIfAbsent(SamplerBindingLayoutProvider.class, SamplerBindingLayoutProviderImpl::new);
        registry.putIfAbsent(SamplerDescriptorProvider.class, SamplerDescriptorProviderImpl::new);
        registry.putIfAbsent(ShaderModuleDescriptorProvider.class, ShaderModuleDescriptorProviderImpl::new);
        registry.putIfAbsent(ShaderSourceSPIRVProvider.class, ShaderSourceSPIRVProviderImpl::new);
        registry.putIfAbsent(ShaderSourceWGSLProvider.class, ShaderSourceWGSLProviderImpl::new);
        registry.putIfAbsent(StencilFaceStateProvider.class, StencilFaceStateProviderImpl::new);
        registry.putIfAbsent(StorageTextureBindingLayoutProvider.class, StorageTextureBindingLayoutProviderImpl::new);
        registry.putIfAbsent(SupportedFeaturesProvider.class, SupportedFeaturesProviderImpl::new);
        registry.putIfAbsent(SupportedInstanceFeaturesProvider.class, SupportedInstanceFeaturesProviderImpl::new);
        registry.putIfAbsent(SupportedWGSLLanguageFeaturesProvider.class,
                SupportedWGSLLanguageFeaturesProviderImpl::new);
        registry.putIfAbsent(SurfaceCapabilitiesProvider.class, SurfaceCapabilitiesProviderImpl::new);
        registry.putIfAbsent(SurfaceColorManagementProvider.class, SurfaceColorManagementProviderImpl::new);
        registry.putIfAbsent(SurfaceConfigurationProvider.class, SurfaceConfigurationProviderImpl::new);
        registry.putIfAbsent(SurfaceDescriptorProvider.class, SurfaceDescriptorProviderImpl::new);
        registry.putIfAbsent(SurfaceSourceAndroidNativeWindowProvider.class,
                SurfaceSourceAndroidNativeWindowProviderImpl::new);
        registry.putIfAbsent(SurfaceSourceMetalLayerProvider.class, SurfaceSourceMetalLayerProviderImpl::new);
        registry.putIfAbsent(SurfaceSourceWaylandSurfaceProvider.class, SurfaceSourceWaylandSurfaceProviderImpl::new);
        registry.putIfAbsent(SurfaceSourceWindowsHWNDProvider.class, SurfaceSourceWindowsHWNDProviderImpl::new);
        registry.putIfAbsent(SurfaceSourceXCBWindowProvider.class, SurfaceSourceXCBWindowProviderImpl::new);
        registry.putIfAbsent(SurfaceSourceXlibWindowProvider.class, SurfaceSourceXlibWindowProviderImpl::new);
        registry.putIfAbsent(SurfaceTextureProvider.class, SurfaceTextureProviderImpl::new);
        registry.putIfAbsent(TexelCopyBufferInfoProvider.class, TexelCopyBufferInfoProviderImpl::new);
        registry.putIfAbsent(TexelCopyBufferLayoutProvider.class, TexelCopyBufferLayoutProviderImpl::new);
        registry.putIfAbsent(TexelCopyTextureInfoProvider.class, TexelCopyTextureInfoProviderImpl::new);
        registry.putIfAbsent(TextureBindingLayoutProvider.class, TextureBindingLayoutProviderImpl::new);
        registry.putIfAbsent(TextureBindingViewDimensionProvider.class, TextureBindingViewDimensionProviderImpl::new);
        registry.putIfAbsent(TextureComponentSwizzleDescriptorProvider.class,
                TextureComponentSwizzleDescriptorProviderImpl::new);
        registry.putIfAbsent(TextureComponentSwizzleProvider.class, TextureComponentSwizzleProviderImpl::new);
        registry.putIfAbsent(TextureDescriptorProvider.class, TextureDescriptorProviderImpl::new);
        registry.putIfAbsent(TextureViewDescriptorProvider.class, TextureViewDescriptorProviderImpl::new);
        registry.putIfAbsent(VertexAttributeProvider.class, VertexAttributeProviderImpl::new);
        registry.putIfAbsent(VertexBufferLayoutProvider.class, VertexBufferLayoutProviderImpl::new);
        registry.putIfAbsent(VertexStateProvider.class, VertexStateProviderImpl::new);
        registry.putIfAbsent(WGPUProvider.class, WGPUProviderImpl::new);

    }

    @SuppressWarnings("unchecked")
    @Override
    public <T> T get(Class<T> provider) {
        return (T) Optional.ofNullable(registry.get(provider))
                .orElseThrow(() -> new WGPUException("Unable to Lookup: " + provider.getName())).get();
    }

}
