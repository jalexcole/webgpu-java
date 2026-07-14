package org.webgpu.impl.spi;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;
import java.util.EnumSet;
import java.util.Set;

import org.jspecify.annotations.NullMarked;
import org.webgpu.api.BufferBindingLayout;
import org.webgpu.api.SamplerBindingLayout;
import org.webgpu.api.SamplerBindingType;
import org.webgpu.api.ShaderStage;
import org.webgpu.api.StorageTextureAccess;
import org.webgpu.api.StorageTextureBindingLayout;
import org.webgpu.api.TextureBindingLayout;
import org.webgpu.api.TextureFormat;
import org.webgpu.api.TextureSampleType;
import org.webgpu.api.TextureViewDimension;
import org.webgpu.api.spi.BindGroupLayoutEntryProvider;
import org.webgpu.impl.util.BitPacker;
import org.webgpu.panama.WGPUBindGroupLayoutEntry;
import org.webgpu.panama.WGPUSamplerBindingLayout;
import org.webgpu.panama.WGPUStorageTextureBindingLayout;
import org.webgpu.panama.WGPUTextureBindingLayout;

@NullMarked
public class BindGroupLayoutEntryProviderImpl implements BindGroupLayoutEntryProvider {

    private final Arena arena = Arena.ofAuto();

    @Override
    public MemorySegment initializer() {
        return WGPUBindGroupLayoutEntry.allocate(arena);
    }

    @Override
    public int binding(MemorySegment structPtr) {
        return WGPUBindGroupLayoutEntry.binding(structPtr);
    }

    @Override
    public EnumSet<ShaderStage> visibility(MemorySegment structPtr) {
        var visibility = BitPacker.unpack(WGPUBindGroupLayoutEntry.visibility(structPtr), ShaderStage.class);
        return visibility instanceof EnumSet<ShaderStage> enumSet ? enumSet : EnumSet.copyOf(visibility);
    }

    @Override
    public int bindingArraySize(MemorySegment structPtr) {
        return WGPUBindGroupLayoutEntry.bindingArraySize(structPtr);
    }

    @Override
    public BufferBindingLayout buffer(MemorySegment structPtr) {
        return toBufferBindingLayout(structPtr);
    }

    public BufferBindingLayout toBufferBindingLayout(MemorySegment structPtr) {
        var layout = WGPUBindGroupLayoutEntry.buffer(structPtr);
        var bufferBindingLayout = new BufferBindingLayout();
        bufferBindingLayout.type(new BufferBindingLayoutProviderImpl().type(layout));
        bufferBindingLayout.hasDynamicOffset(new BufferBindingLayoutProviderImpl().hasDynamicOffset(layout));
        bufferBindingLayout.minBindingSize(new BufferBindingLayoutProviderImpl().minBindingSize(layout));
        return bufferBindingLayout;
    }

    @Override
    public SamplerBindingLayout sampler(MemorySegment structPtr) {
        var layout = WGPUBindGroupLayoutEntry.sampler(structPtr);
        var samplerBindingLayout = new SamplerBindingLayout();
        samplerBindingLayout.type(SamplerBindingType.values()[WGPUSamplerBindingLayout.type(layout)]);
        return samplerBindingLayout;
    }

    @Override
    public TextureBindingLayout texture(MemorySegment structPtr) {
        var layout = WGPUBindGroupLayoutEntry.texture(structPtr);
        var textureBindingLayout = new TextureBindingLayout();
        textureBindingLayout.sampleType(TextureSampleType.values()[WGPUTextureBindingLayout.sampleType(layout)]);
        textureBindingLayout
                .viewDimension(TextureViewDimension.values()[WGPUTextureBindingLayout.viewDimension(layout)]);
        textureBindingLayout.multisampled(WGPUTextureBindingLayout.multisampled(layout) != 0);
        return textureBindingLayout;
    }

    @Override
    public StorageTextureBindingLayout storageTexture(MemorySegment structPtr) {
        var layout = WGPUBindGroupLayoutEntry.storageTexture(structPtr);
        var storageTextureBindingLayout = new StorageTextureBindingLayout();
        storageTextureBindingLayout
                .access(StorageTextureAccess.values()[WGPUStorageTextureBindingLayout.access(layout)]);
        storageTextureBindingLayout.format(TextureFormat.values()[WGPUStorageTextureBindingLayout.format(layout)]);
        storageTextureBindingLayout
                .viewDimension(TextureViewDimension.values()[WGPUStorageTextureBindingLayout.viewDimension(layout)]);
        return storageTextureBindingLayout;
    }

    @Override
    public void binding(MemorySegment structPtr, int binding) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'binding'");
    }

    @Override
    public void visibility(MemorySegment structPtr, Set<ShaderStage> visibility) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'visibility'");
    }

    @Override
    public void bindingArraySize(MemorySegment structPtr, int bindingArraySize) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'bindingArraySize'");
    }

    @Override
    public void buffer(MemorySegment structPtr, BufferBindingLayout buffer) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buffer'");
    }

    @Override
    public void sampler(MemorySegment structPtr, SamplerBindingLayout sampler) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'sampler'");
    }

    @Override
    public void texture(MemorySegment structPtr, TextureBindingLayout texture) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'texture'");
    }

    @Override
    public void storageTexture(MemorySegment structPtr, StorageTextureBindingLayout storageTexture) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'storageTexture'");
    }
}