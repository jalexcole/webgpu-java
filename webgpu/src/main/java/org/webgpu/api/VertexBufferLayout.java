package org.webgpu.api;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;

import org.webgpu.foreign.WGPUVertexBufferLayout;

public class VertexBufferLayout {
    
    private final MemorySegment ptr;

    public VertexBufferLayout() {
        Arena arena = Arena.ofAuto();
        this.ptr = WGPUVertexBufferLayout.allocate(arena);
    }

    VertexBufferLayout(MemorySegment ptr) {
        this.ptr = ptr;
    }

    public int stepMode() {
        return WGPUVertexBufferLayout.stepMode(ptr);
    }

    public void setStepMode(int stepMode) {
        WGPUVertexBufferLayout.stepMode(ptr, stepMode);
    }

    public long arrayStride() {
        return WGPUVertexBufferLayout.arrayStride(ptr);
    }

    public void setArrayStride(long arrayStride) {
        WGPUVertexBufferLayout.arrayStride(ptr, arrayStride);
    }

    public long attributeCount() {
        return WGPUVertexBufferLayout.attributeCount(ptr);
    }

    public void setAttributeCount(long count) {
        WGPUVertexBufferLayout.attributeCount(ptr, count);
    }

    public VertexAttributes[] attributes() {
        throw new UnsupportedOperationException("Method not implemented yet: attributes()");
    }

    public void setAttributes(VertexAttributes[] attributes) {
        throw new UnsupportedOperationException("Method not implemented yet: setAttributes()");
    }

    MemorySegment ptr() {
        return ptr;
    }

    @Override
    public String toString() {
        return "VertexBufferLayout{" + "ptr=" + ptr + '}';
    }
}
