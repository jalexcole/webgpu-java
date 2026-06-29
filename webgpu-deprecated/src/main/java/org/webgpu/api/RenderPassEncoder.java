package org.webgpu.api;

import java.lang.foreign.MemorySegment;

public interface RenderPassEncoder {
    public void beginOcclusionQuery(int queryIndex);

    public void draw(int vertex_count, int instance_count, int first_vertex, int first_instance);

    public void drawIndexed(int index_count, int instance_count, int first_index, int base_vertex, int first_instance);

    public void drawIndexedIndirect(Buffer indirect_buffer, long indirect_offset);

    public void drawIndirect(Buffer indirect_buffer, long indirect_offset);

    public void end();

    public void endOcclusionQuery();

    public void executeBundles(RenderBundle[] bundles);

    public void insertDebugMarker(String markerLabel);

    public void popDebugGroup();

    public void pushDebugGroup(String groupLabel);

    public void setBindGroup(int groupIndex, BindGroup group, int[] dynamicOffsets);

    public void setBlendConstant(Color color);

    public void setIndexBuffer(Buffer buffer, IndexFormat format);

    public void setLabel(String label);

    public void setPipeline(RenderPipeline pipeline);

    public void setScissorRect(int x, int y, int width, int height);

    public void setStencilReference(int reference);

    public void setVertexBuffer(int slot, Buffer buffer);

    public void setViewport(float x, float y, float width, float height, float minDepth, float maxDepth);

    public void addRef();

    public void release();
}
