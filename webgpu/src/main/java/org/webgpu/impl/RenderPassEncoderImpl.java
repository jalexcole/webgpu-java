package org.webgpu.impl;

import java.lang.foreign.MemorySegment;

import org.webgpu.api.BindGroup;
import org.webgpu.api.Buffer;
import org.webgpu.api.Color;
import org.webgpu.api.IndexFormat;
import org.webgpu.api.RenderBundle;
import org.webgpu.api.RenderPassEncoder;
import org.webgpu.api.RenderPipeline;
import org.webgpu.panama.foreign.webgpu_h;

public record RenderPassEncoderImpl(MemorySegment ptr) implements RenderPassEncoder {

    @Override
    public void beginOcclusionQuery(int queryIndex) {
        webgpu_h.wgpuRenderPassEncoderBeginOcclusionQuery(ptr, queryIndex);
    }

    @Override
    public void draw(int vertex_count, int instance_count, int first_vertex, int first_instance) {
        webgpu_h.wgpuRenderPassEncoderDraw(ptr, vertex_count, instance_count, first_vertex, first_instance);
    }

    @Override
    public void drawIndexed(int index_count, int instance_count, int first_index, int base_vertex, int first_instance) {
        webgpu_h.wgpuRenderPassEncoderDrawIndexed(ptr, index_count, instance_count, first_index, base_vertex,
                first_instance);
    }

    @Override
    public void drawIndexedIndirect(Buffer indirect_buffer, long indirect_offset) {
        webgpu_h.wgpuRenderPassEncoderDrawIndexedIndirect(ptr, ((BufferImpl) indirect_buffer).ptr(), indirect_offset);
    }

    @Override
    public void drawIndirect(Buffer indirect_buffer, long indirect_offset) {
        webgpu_h.wgpuRenderPassEncoderDrawIndirect(ptr, ((BufferImpl) indirect_buffer).ptr(), indirect_offset);
    }

    @Override
    public void end() {
        webgpu_h.wgpuRenderPassEncoderEnd(ptr);
    }

    @Override
    public void endOcclusionQuery() {
        webgpu_h.wgpuRenderPassEncoderEndOcclusionQuery(ptr);
    }

    @Override
    public void executeBundles(RenderBundle[] bundles) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'executeBundles'");
    }

    @Override
    public void insertDebugMarker(String markerLabel) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'insertDebugMarker'");
    }

    @Override
    public void popDebugGroup() {
        webgpu_h.wgpuRenderPassEncoderPopDebugGroup(ptr);
    }

    @Override
    public void pushDebugGroup(String groupLabel) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'pushDebugGroup'");
    }

    @Override
    public void setBindGroup(int groupIndex, BindGroup group, int[] dynamicOffsets) {
        var dynamicOffsetsSegment = MemorySegment.ofArray(dynamicOffsets);
        webgpu_h.wgpuRenderPassEncoderSetBindGroup(ptr, groupIndex, ((BindGroupImpl) group).ptr(),
                dynamicOffsets.length, dynamicOffsetsSegment);
    }

    @Override
    public void setBlendConstant(Color color) {
        webgpu_h.wgpuRenderPassEncoderSetBlendConstant(ptr, color.ptr());
    }

    @Override
    public void setIndexBuffer(Buffer buffer, IndexFormat format) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setIndexBuffer'");
    }

    @Override
    public void setLabel(String label) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setLabel'");
    }

    @Override
    public void setPipeline(RenderPipeline pipeline) {
        webgpu_h.wgpuRenderPassEncoderSetPipeline(ptr, ((RenderPipelineImpl) pipeline).ptr());
    }

    @Override
    public void setScissorRect(int x, int y, int width, int height) {
        webgpu_h.wgpuRenderPassEncoderSetScissorRect(ptr, x, y, width, height);
    }

    @Override
    public void setStencilReference(int reference) {
        webgpu_h.wgpuRenderPassEncoderSetStencilReference(ptr, reference);
    }

    @Override
    public void setVertexBuffer(int slot, Buffer buffer) {
        throw new UnsupportedOperationException("Unimplemented method 'setVertexBuffer'");
    }

    @Override
    public void setViewport(float x, float y, float width, float height, float minDepth, float maxDepth) {
        webgpu_h.wgpuRenderPassEncoderSetViewport(ptr, x, y, width, height, minDepth, maxDepth);
    }

    @Override
    public void addRef() {
        webgpu_h.wgpuRenderPassEncoderAddRef(ptr);
    }

    @Override
    public void release() {
        webgpu_h.wgpuRenderPassEncoderRelease(ptr);
    }

}
