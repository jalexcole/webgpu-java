package org.webgpu.impl.spi;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;

import org.jspecify.annotations.NullMarked;
import org.webgpu.api.CompilationMessage;
import org.webgpu.api.spi.CompilationInfoProvider;
import org.webgpu.impl.util.StructTools;
import org.webgpu.panama.WGPUCompilationInfo;
import org.webgpu.panama.WGPUCompilationMessage;

@NullMarked
public class CompilationInfoProviderImpl implements CompilationInfoProvider {

    private final Arena arena = Arena.ofAuto();

    @Override
    public MemorySegment initializer() {
        return WGPUCompilationInfo.allocate(arena);
    }

    @Override
    public CompilationMessage[] messages(MemorySegment structPtr) {
        var ptr = WGPUCompilationInfo.messages(structPtr);
        if (ptr == null || ptr.equals(MemorySegment.NULL)) {
            return new CompilationMessage[0];
        }
        long count = WGPUCompilationInfo.messageCount(structPtr);
        CompilationMessage[] out = new CompilationMessage[(int) count];
        for (int i = 0; i < count; i++) {
            var slice = WGPUCompilationMessage.asSlice(ptr, i);
            out[i] = StructTools.placeSegment(slice, CompilationMessage.class);
        }
        return out;
    }

    @Override
    public void messages(MemorySegment structPtr, CompilationMessage[] messages) {
        if (messages == null || messages.length == 0) {
            WGPUCompilationInfo.messages(structPtr, MemorySegment.NULL);
            WGPUCompilationInfo.messageCount(structPtr, 0);
            return;
        }
        var array = WGPUCompilationMessage.allocateArray(messages.length, arena);
        for (int i = 0; i < messages.length; i++) {
            var dest = WGPUCompilationMessage.asSlice(array, i);
            var src = StructTools.fetchSegment(messages[i]);
            MemorySegment.copy(src, 0, dest, 0, WGPUCompilationMessage.layout().byteSize());
        }
        WGPUCompilationInfo.messages(structPtr, array);
        WGPUCompilationInfo.messageCount(structPtr, messages.length);
    }

}
