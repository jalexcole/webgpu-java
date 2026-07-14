package org.webgpu.impl.spi;

import java.lang.foreign.MemorySegment;

import org.jspecify.annotations.NonNull;
import org.webgpu.api.AddressMode;
import org.webgpu.api.CompareFunction;
import org.webgpu.api.FilterMode;
import org.webgpu.api.MipmapFilterMode;
import org.webgpu.api.spi.SamplerDescriptorProvider;

/**
 * SamplerDescriptorProviderImpl
 */
public class SamplerDescriptorProviderImpl implements SamplerDescriptorProvider {

    @Override
    public @NonNull MemorySegment initializer() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'initializer'");
    }

    @Override
    public @NonNull String label(@NonNull MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'label'");
    }

    @Override
    public @NonNull AddressMode addressModeU(@NonNull MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addressModeU'");
    }

    @Override
    public @NonNull AddressMode addressModeV(@NonNull MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addressModeV'");
    }

    @Override
    public @NonNull AddressMode addressModeW(@NonNull MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addressModeW'");
    }

    @Override
    public @NonNull FilterMode magFilter(@NonNull MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'magFilter'");
    }

    @Override
    public @NonNull FilterMode minFilter(@NonNull MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'minFilter'");
    }

    @Override
    public @NonNull MipmapFilterMode mipmapFilter(@NonNull MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mipmapFilter'");
    }

    @Override
    public float lodMinClamp(@NonNull MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'lodMinClamp'");
    }

    @Override
    public float lodMaxClamp(@NonNull MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'lodMaxClamp'");
    }

    @Override
    public @NonNull CompareFunction compare(@NonNull MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'compare'");
    }

    @Override
    public short maxAnisotropy(@NonNull MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'maxAnisotropy'");
    }

    @Override
    public void label(@NonNull MemorySegment structPtr, @NonNull String label) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'label'");
    }

    @Override
    public void addressModeU(@NonNull MemorySegment structPtr, @NonNull AddressMode addressModeU) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addressModeU'");
    }

    @Override
    public void addressModeV(@NonNull MemorySegment structPtr, @NonNull AddressMode addressModeV) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addressModeV'");
    }

    @Override
    public void addressModeW(@NonNull MemorySegment structPtr, @NonNull AddressMode addressModeW) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addressModeW'");
    }

    @Override
    public void magFilter(@NonNull MemorySegment structPtr, @NonNull FilterMode magFilter) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'magFilter'");
    }

    @Override
    public void minFilter(@NonNull MemorySegment structPtr, @NonNull FilterMode minFilter) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'minFilter'");
    }

    @Override
    public void mipmapFilter(@NonNull MemorySegment structPtr, @NonNull MipmapFilterMode mipmapFilter) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mipmapFilter'");
    }

    @Override
    public void lodMinClamp(@NonNull MemorySegment structPtr, float lodMinClamp) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'lodMinClamp'");
    }

    @Override
    public void lodMaxClamp(@NonNull MemorySegment structPtr, float lodMaxClamp) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'lodMaxClamp'");
    }

    @Override
    public void compare(@NonNull MemorySegment structPtr, @NonNull CompareFunction compare) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'compare'");
    }

    @Override
    public void maxAnisotropy(@NonNull MemorySegment structPtr, short maxAnisotropy) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'maxAnisotropy'");
    }

}
