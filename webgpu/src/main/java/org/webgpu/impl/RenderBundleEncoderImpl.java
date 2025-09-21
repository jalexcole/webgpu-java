package org.webgpu.impl;

import java.lang.foreign.MemorySegment;

import org.webgpu.api.Buffer;
import org.webgpu.api.RenderBundle;
import org.webgpu.api.RenderBundleDescriptor;
import org.webgpu.api.RenderBundleEncoder;
import org.webgpu.panama.foreign.webgpu_h;

public record RenderBundleEncoderImpl(MemorySegment ptr) implements RenderBundleEncoder {

    @Override
    public void draw(int vertex_count, int instance_count, int first_vertex, int first_instance) {
        webgpu_h.wgpuRenderBundleEncoderDraw(ptr, vertex_count, instance_count, first_vertex, first_instance);
    }

    @Override
    public void drawIndexed(int index_count, int instance_count, int first_index, int base_vertex, int first_instance) {
        webgpu_h.wgpuRenderBundleEncoderDrawIndexed(ptr, index_count, instance_count, first_index, base_vertex,
                first_instance);
    }

    @Override
    public void drawIndirect(Buffer indirect_buffer, long indirect_offset) {
        webgpu_h.wgpuRenderBundleEncoderDrawIndirect(ptr, ((BufferImpl) indirect_buffer).ptr(), indirect_offset);
    }

    @Override
    public void drawIndexedIndirect(Buffer indirect_buffer, long indirect_offset) {
        webgpu_h.wgpuRenderBundleEncoderDrawIndexedIndirect(ptr, ((BufferImpl) indirect_buffer).ptr(), indirect_offset);
    }

    @Override
    public RenderBundle finish(RenderBundleDescriptor descriptor) {
        MemorySegment descriptorPtr = descriptor != null ? descriptor.ptr() : MemorySegment.NULL;
        MemorySegment renderBundlePtr = webgpu_h.wgpuRenderBundleEncoderFinish(ptr, descriptorPtr);
        return new RenderBundleImpl(renderBundlePtr);
    }

    @Override
    public void insertDebugMarker(String markerLabel) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'insertDebugMarker'");
    }

}
