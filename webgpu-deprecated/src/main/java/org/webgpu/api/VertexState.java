package org.webgpu.api;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;
import java.util.Optional;

import org.webgpu.panama.foreign.WGPUVertexState;
import org.webgpu.impl.ShaderModuleImpl;
import org.webgpu.util.StringView;

public class VertexState {
    private final MemorySegment ptr;

    public VertexState() {
        Arena arena = Arena.ofAuto();
        this.ptr = WGPUVertexState.allocate(arena);
    }

    public final Optional<ChainedStruct> nextInChain() {
        final var chainedStructPtr = WGPUVertexState.nextInChain(ptr);

        if (chainedStructPtr.equals(MemorySegment.NULL)) {
            return Optional.empty();
        }

        return Optional.of(new ChainedStruct(WGPUVertexState.nextInChain(ptr)));
    }

    public final ShaderModule module() {
        return new ShaderModuleImpl(WGPUVertexState.module(ptr));
    }

    public final void setModule(ShaderModule module) {
        if (!(module instanceof ShaderModuleImpl)) {
            throw new IllegalArgumentException("Module must be an instance of ShaderModuleImpl");
        }
        WGPUVertexState.module(ptr, ((ShaderModuleImpl) module).ptr());
    }

    public final String entryPoint() {
        return StringView.map(WGPUVertexState.entryPoint(ptr));
    }

    public final void setEntryPoint(String entryPoint) {
        try (Arena arena = Arena.ofConfined()) {
            var stringView = StringView.of(arena, entryPoint);
            WGPUVertexState.entryPoint(ptr, stringView);
        }
    }

    public final long constantCount() {
        return WGPUVertexState.constantCount(ptr);
    }

    public final void setConstantCount(long count) {
        WGPUVertexState.constantCount(ptr, count);
    }

    public final ConstantEntry[] constants() {
        final long count = constantCount();
        final ConstantEntry[] entries = new ConstantEntry[(int) count];

        final var constantsPtr = WGPUVertexState.constants(this.ptr);

        throw new UnsupportedOperationException("Method not implemented yet: constants()");
    }

    public final void setConstants(ConstantEntry[] constants) {
        throw new UnsupportedOperationException("Method not implemented yet: setConstants()");
    }

    public final long bufferCount() {
        return WGPUVertexState.bufferCount(ptr);
    }

    public final void setBufferCount(long count) {
        WGPUVertexState.bufferCount(ptr, count);
    }

    public final VertexBufferLayout[] buffers() {
        throw new UnsupportedOperationException("Method not implemented yet: buffers()");
    }

    public final void setBuffers(VertexBufferLayout[] buffers) {
        throw new UnsupportedOperationException("Method not implemented yet: setBuffers()");
    }

}
