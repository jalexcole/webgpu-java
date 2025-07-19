package org.webgpu.impl;

import java.lang.foreign.MemorySegment;

import org.webgpu.api.BindGroup;
import org.webgpu.api.Buffer;
import org.webgpu.api.Color;
import org.webgpu.api.IndexFormat;
import org.webgpu.api.RenderBundle;
import org.webgpu.api.RenderPassEncoder;
import org.webgpu.api.RenderPipeline;

public record RenderPassEncoderImpl(MemorySegment ptr) implements RenderPassEncoder {

    @Override
    public void beginOcclusionQuery(int queryIndex) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'beginOcclusionQuery'");
    }

    @Override
    public void draw(int vertex_count, int instance_count, int first_vertex, int first_instance) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'draw'");
    }

    @Override
    public void drawIndexed(int index_count, int instance_count, int first_index, int base_vertex, int first_instance) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'drawIndexed'");
    }

    @Override
    public void drawIndexedIndirect(Buffer indirect_buffer, long indirect_offset) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'drawIndexedIndirect'");
    }

    @Override
    public void drawIndirect(Buffer indirect_buffer, long indirect_offset) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'drawIndirect'");
    }

    @Override
    public void end() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'end'");
    }

    @Override
    public void endOcclusionQuery() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'endOcclusionQuery'");
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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'popDebugGroup'");
    }

    @Override
    public void pushDebugGroup(String groupLabel) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'pushDebugGroup'");
    }

    @Override
    public void setBindGroup(int groupIndex, BindGroup group, int[] dynamicOffsets) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setBindGroup'");
    }

    @Override
    public void setBlendConstant(Color color) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setBlendConstant'");
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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setPipeline'");
    }

    @Override
    public void setScissorRect(int x, int y, int width, int height) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setScissorRect'");
    }

    @Override
    public void setStencilReference(int reference) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setStencilReference'");
    }

    @Override
    public void setVertexBuffer(int slot, Buffer buffer) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setVertexBuffer'");
    }

    @Override
    public void setViewport(float x, float y, float width, float height, float minDepth, float maxDepth) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setViewport'");
    }

    @Override
    public void addRef() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addRef'");
    }

    @Override
    public void release() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'release'");
    }
    
}
