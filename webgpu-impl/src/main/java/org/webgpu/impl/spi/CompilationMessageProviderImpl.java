package org.webgpu.impl.spi;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;

import org.jspecify.annotations.NullMarked;
import org.webgpu.api.CompilationMessageType;
import org.webgpu.api.spi.CompilationMessageProvider;
import org.webgpu.impl.util.StringViewMapper;
import org.webgpu.panama.WGPUCompilationMessage;

@NullMarked
public class CompilationMessageProviderImpl implements CompilationMessageProvider {

    private final Arena arena = Arena.ofAuto();

    @Override
    public MemorySegment initializer() {
        return WGPUCompilationMessage.allocate(arena);
    }

    @Override
    public String message(MemorySegment structPtr) {
        return StringViewMapper.map(WGPUCompilationMessage.message(structPtr));
    }

    @Override
    public CompilationMessageType type(MemorySegment structPtr) {
        
        final var value = WGPUCompilationMessage.type(structPtr);
        return CompilationMessageType.values()[value];
    }

    @Override
    public long lineNum(MemorySegment structPtr) {
        return WGPUCompilationMessage.lineNum(structPtr);
    }

    @Override
    public long linePos(MemorySegment structPtr) {
        return WGPUCompilationMessage.linePos(structPtr);
    }

    @Override
    public long offset(MemorySegment structPtr) {
        return WGPUCompilationMessage.offset(structPtr);
    }

    @Override
    public long length(MemorySegment structPtr) {
        return WGPUCompilationMessage.length(structPtr);
    }

    @Override
    public void message(MemorySegment structPtr, String message) {
        WGPUCompilationMessage.message(structPtr, StringViewMapper.map(message, arena));
    }

    @Override
    public void type(MemorySegment structPtr, CompilationMessageType type) {
        WGPUCompilationMessage.type(structPtr, type.value());
    }

    @Override
    public void lineNum(MemorySegment structPtr, long lineNum) {
        WGPUCompilationMessage.lineNum(structPtr, lineNum);
    }

    @Override
    public void linePos(MemorySegment structPtr, long linePos) {
        WGPUCompilationMessage.linePos(structPtr, linePos);
    }

    @Override
    public void offset(MemorySegment structPtr, long offset) {
        WGPUCompilationMessage.offset(structPtr, offset);
    }

    @Override
    public void length(MemorySegment structPtr, long length) {
        WGPUCompilationMessage.length(structPtr, length);
    }

}
