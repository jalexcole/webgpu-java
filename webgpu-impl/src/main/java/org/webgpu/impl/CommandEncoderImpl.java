package org.webgpu.impl;

import java.lang.foreign.MemorySegment;

import org.webgpu.api.Buffer;
import org.webgpu.api.CommandBuffer;
import org.webgpu.api.CommandBufferDescriptor;
import org.webgpu.api.CommandEncoder;
import org.webgpu.api.ComputePassDescriptor;
import org.webgpu.api.ComputePassEncoder;
import org.webgpu.api.Extent3D;
import org.webgpu.api.QuerySet;
import org.webgpu.api.RenderPassDescriptor;
import org.webgpu.api.RenderPassEncoder;
import org.webgpu.api.TexelCopyBufferInfo;
import org.webgpu.api.TexelCopyTextureInfo;

class CommandEncoderImpl implements CommandEncoder {

    private final MemorySegment memorySegment;

    public CommandEncoderImpl(MemorySegment memorySegment) {
        this.memorySegment = memorySegment;
    }

    @Override
    public CommandBuffer finish(CommandBufferDescriptor descriptor) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'finish'");
    }

    @Override
    public ComputePassEncoder beginComputePass(ComputePassDescriptor descriptor) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'beginComputePass'");
    }

    @Override
    public RenderPassEncoder beginRenderPass(RenderPassDescriptor descriptor) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'beginRenderPass'");
    }

    @Override
    public void copyBufferToBuffer(Buffer source, long sourceOffset, Buffer destination, long destinationOffset,
            long size) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'copyBufferToBuffer'");
    }

    @Override
    public void copyBufferToTexture(TexelCopyBufferInfo source, TexelCopyTextureInfo destination, Extent3D copySize) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'copyBufferToTexture'");
    }

    @Override
    public void copyTextureToBuffer(TexelCopyTextureInfo source, TexelCopyBufferInfo destination, Extent3D copySize) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'copyTextureToBuffer'");
    }

    @Override
    public void copyTextureToTexture(TexelCopyTextureInfo source, TexelCopyTextureInfo destination, Extent3D copySize) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'copyTextureToTexture'");
    }

    @Override
    public void clearBuffer(Buffer buffer, long offset, long size) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'clearBuffer'");
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
    public void resolveQuerySet(QuerySet querySet, int firstQuery, int queryCount, Buffer destination,
            long destinationOffset) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'resolveQuerySet'");
    }

    @Override
    public void writeTimestamp(QuerySet querySet, int queryIndex) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'writeTimestamp'");
    }

    @Override
    public void setLabel(String label) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setLabel'");
    }
}
