package org.webgpu.impl.spi;

import java.lang.foreign.MemorySegment;

import org.webgpu.api.ConstantEntry;
import org.webgpu.api.ShaderModule;
import org.webgpu.api.VertexBufferLayout;
import org.webgpu.api.spi.VertexStateProvider;

/**
 * VertexStateProviderImpl
 */
public class VertexStateProviderImpl implements VertexStateProvider {

    @Override
    public MemorySegment initializer() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'initializer'");
    }

    @Override
    public ShaderModule module(MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'module'");
    }

    @Override
    public String entryPoint(MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'entryPoint'");
    }

    @Override
    public ConstantEntry[] constants(MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'constants'");
    }

    @Override
    public VertexBufferLayout[] buffers(MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buffers'");
    }

    @Override
    public void module(MemorySegment structPtr, ShaderModule module) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'module'");
    }

    @Override
    public void entryPoint(MemorySegment structPtr, String entryPoint) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'entryPoint'");
    }

    @Override
    public void constants(MemorySegment structPtr, ConstantEntry[] constants) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'constants'");
    }

    @Override
    public void buffers(MemorySegment structPtr, VertexBufferLayout[] buffers) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buffers'");
    }

}
