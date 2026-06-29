package org.webgpu.api;


public interface RenderBundleEncoder extends ObjectBase, EncoderBase {
    public void draw(int vertex_count, int instance_count, int first_vertex, int first_instance);
    public void drawIndexed(int index_count, int instance_count, int first_index, int base_vertex, int first_instance);
    public void drawIndirect(Buffer indirect_buffer, long indirect_offset);

    public void drawIndexedIndirect(Buffer indirect_buffer, long indirect_offset);
    
    public RenderBundle finish(RenderBundleDescriptor descriptor);

    public void insertDebugMarker(String markerLabel);

    
}
