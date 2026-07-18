package org.webgpu.impl.spi;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;

import org.webgpu.api.AddressMode;
import org.webgpu.api.CompareFunction;
import org.webgpu.api.FilterMode;
import org.webgpu.api.MipmapFilterMode;
import org.webgpu.api.spi.SamplerDescriptorProvider;
import org.webgpu.panama.WGPUSamplerDescriptor;

/**
 * SamplerDescriptorProviderImpl
 */
public class SamplerDescriptorProviderImpl implements SamplerDescriptorProvider {
    private final Arena arena = Arena.ofAuto();

    @Override
    public MemorySegment initializer() {
        return WGPUSamplerDescriptor.allocate(arena);
    }

    @Override
    public String label(MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'label'");
    }

    @Override
    public AddressMode addressModeU(MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addressModeU'");
    }

    @Override
    public AddressMode addressModeV(MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addressModeV'");
    }

    @Override
    public AddressMode addressModeW(MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addressModeW'");
    }

    @Override
    public FilterMode magFilter(MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'magFilter'");
    }

    @Override
    public FilterMode minFilter(MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'minFilter'");
    }

    @Override
    public MipmapFilterMode mipmapFilter(MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mipmapFilter'");
    }

    @Override
    public float lodMinClamp(MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'lodMinClamp'");
    }

    @Override
    public float lodMaxClamp(MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'lodMaxClamp'");
    }

    @Override
    public CompareFunction compare(MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'compare'");
    }

    @Override
    public short maxAnisotropy(MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'maxAnisotropy'");
    }

    @Override
    public void label(MemorySegment structPtr, String label) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'label'");
    }

    @Override
    public void addressModeU(MemorySegment structPtr, AddressMode addressModeU) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addressModeU'");
    }

    @Override
    public void addressModeV(MemorySegment structPtr, AddressMode addressModeV) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addressModeV'");
    }

    @Override
    public void addressModeW(MemorySegment structPtr, AddressMode addressModeW) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addressModeW'");
    }

    @Override
    public void magFilter(MemorySegment structPtr, FilterMode magFilter) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'magFilter'");
    }

    @Override
    public void minFilter(MemorySegment structPtr, FilterMode minFilter) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'minFilter'");
    }

    @Override
    public void mipmapFilter(MemorySegment structPtr, MipmapFilterMode mipmapFilter) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mipmapFilter'");
    }

    @Override
    public void lodMinClamp(MemorySegment structPtr, float lodMinClamp) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'lodMinClamp'");
    }

    @Override
    public void lodMaxClamp(MemorySegment structPtr, float lodMaxClamp) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'lodMaxClamp'");
    }

    @Override
    public void compare(MemorySegment structPtr, CompareFunction compare) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'compare'");
    }

    @Override
    public void maxAnisotropy(MemorySegment structPtr, short maxAnisotropy) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'maxAnisotropy'");
    }

}
