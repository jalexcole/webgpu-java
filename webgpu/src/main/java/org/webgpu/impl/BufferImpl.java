package org.webgpu.impl;

import java.lang.foreign.MemorySegment;

import org.webgpu.api.Buffer;
import org.webgpu.api.BufferMapState;
import org.webgpu.api.BufferUsage;

public record BufferImpl(MemorySegment ptr) implements Buffer {

    @Override
    public void destroy() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'destroy'");
    }

    @Override
    public BufferMapState getMapState() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getMapState'");
    }

    @Override
    public int getSize() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getSize'");
    }

    @Override
    public BufferUsage getUsage() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getUsage'");
    }
    
}
