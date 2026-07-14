package org.webgpu.impl.spi;

import java.lang.foreign.MemorySegment;

import org.webgpu.api.CompilationMessageType;
import org.webgpu.api.spi.CompilationMessageProvider;

/**
 * CompilationMessageProviderImpl
 */
public class CompilationMessageProviderImpl implements CompilationMessageProvider {

    @Override
    public MemorySegment initializer() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'initializer'");
    }

    @Override
    public String message(MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'message'");
    }

    @Override
    public CompilationMessageType type(MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'type'");
    }

    @Override
    public long lineNum(MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'lineNum'");
    }

    @Override
    public long linePos(MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'linePos'");
    }

    @Override
    public long offset(MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'offset'");
    }

    @Override
    public long length(MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'length'");
    }

    @Override
    public void message(MemorySegment structPtr, String message) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'message'");
    }

    @Override
    public void type(MemorySegment structPtr, CompilationMessageType type) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'type'");
    }

    @Override
    public void lineNum(MemorySegment structPtr, long lineNum) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'lineNum'");
    }

    @Override
    public void linePos(MemorySegment structPtr, long linePos) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'linePos'");
    }

    @Override
    public void offset(MemorySegment structPtr, long offset) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'offset'");
    }

    @Override
    public void length(MemorySegment structPtr, long length) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'length'");
    }

}
