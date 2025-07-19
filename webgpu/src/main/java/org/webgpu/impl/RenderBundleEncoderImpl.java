package org.webgpu.impl;

import java.lang.foreign.MemorySegment;

import org.webgpu.api.Buffer;
import org.webgpu.api.RenderBundle;
import org.webgpu.api.RenderBundleDescriptor;
import org.webgpu.api.RenderBundleEncoder;

public record RenderBundleEncoderImpl(MemorySegment ptr) implements RenderBundleEncoder {

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
    public void drawIndirect(Buffer indirect_buffer, long indirect_offset) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'drawIndirect'");
    }

    @Override
    public void drawIndexedIndirect(Buffer indirect_buffer, long indirect_offset) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'drawIndexedIndirect'");
    }

    @Override
    public RenderBundle finish(RenderBundleDescriptor descriptor) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'finish'");
    }

    @Override
    public void insertDebugMarker(String markerLabel) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'insertDebugMarker'");
    }
    
}
