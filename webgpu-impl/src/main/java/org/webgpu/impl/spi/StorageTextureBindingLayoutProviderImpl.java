package org.webgpu.impl.spi;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;

import org.jspecify.annotations.NonNull;
import org.webgpu.api.StorageTextureAccess;
import org.webgpu.api.TextureFormat;
import org.webgpu.api.TextureViewDimension;
import org.webgpu.api.spi.StorageTextureBindingLayoutProvider;
import org.webgpu.panama.WGPUStorageTextureBindingLayout;

/**
 * StorageTextureBindingLayoutProviderImpl
 */
public class StorageTextureBindingLayoutProviderImpl implements StorageTextureBindingLayoutProvider {

    private final Arena arena = Arena.ofAuto();

    @Override
    public MemorySegment initializer() {
        return WGPUStorageTextureBindingLayout.allocate(arena);
    }

    @Override
    public StorageTextureAccess access(MemorySegment structPtr) {
        return StorageTextureAccess.values()[WGPUStorageTextureBindingLayout.access(structPtr)];
    }

    @Override
    public TextureFormat format(MemorySegment structPtr) {
        return TextureFormat.values()[WGPUStorageTextureBindingLayout.format(structPtr)];
    }

    @Override
    public TextureViewDimension viewDimension(MemorySegment structPtr) {
        return TextureViewDimension.values()[WGPUStorageTextureBindingLayout.viewDimension(structPtr)];
    }

    @Override
    public void access(MemorySegment structPtr, StorageTextureAccess access) {
        WGPUStorageTextureBindingLayout.access(structPtr, access.value());
    }

    @Override
    public void format(MemorySegment structPtr, TextureFormat format) {
        WGPUStorageTextureBindingLayout.format(structPtr, format.value());
    }

    @Override
    public void viewDimension(MemorySegment structPtr, TextureViewDimension viewDimension) {
        WGPUStorageTextureBindingLayout.viewDimension(structPtr, viewDimension.value());
    }

}
