package org.webgpu.impl;

import java.lang.foreign.MemorySegment;

import org.jspecify.annotations.NullMarked;
import org.webgpu.api.Buffer;
import org.webgpu.api.CommandBufferDescriptor;
import org.webgpu.api.CommandEncoder;
import org.webgpu.api.ComputePassDescriptor;
import org.webgpu.api.Extent3D;
import org.webgpu.api.QuerySet;
import org.webgpu.api.RenderPassDescriptor;
import org.webgpu.api.TexelCopyBufferInfo;
import org.webgpu.api.TexelCopyTextureInfo;
import org.webgpu.api.exceptions.WGPUException;
import org.webgpu.impl.util.StringViewMapper;
import org.webgpu.panama.webgpu_h;

@NullMarked
public class CommandEncoderImpl implements CommandEncoder {

    private final MemorySegment memorySegment;

    public CommandEncoderImpl(MemorySegment memorySegment) {
        this.memorySegment = memorySegment;
    }

    @Override
    public CommandBufferImpl finish(CommandBufferDescriptor descriptor) {
        throw new UnsupportedOperationException("Unimplemented method 'finish'");
    }

    @Override
    public ComputePassEncoderImpl beginComputePass(ComputePassDescriptor descriptor) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'beginComputePass'");
    }

    @Override
    public RenderPassEncoderImpl beginRenderPass(RenderPassDescriptor descriptor) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'beginRenderPass'");
    }

    @Override
    public void copyBufferToBuffer(Buffer source, long sourceOffset, Buffer destination, long destinationOffset,
            long size) {
        webgpu_h.wgpuCommandEncoderCopyBufferToBuffer(this.memorySegment, ((BufferImpl) source).ptr(), sourceOffset,
                ((BufferImpl) destination).ptr(), destinationOffset, size);
    }

    @Override
    public void copyBufferToTexture(TexelCopyBufferInfo source, TexelCopyTextureInfo destination, Extent3D copySize) {
        throw new UnsupportedOperationException("Unimplemented method 'copyBufferToTexture'");
    }

    @Override
    public void copyTextureToBuffer(TexelCopyTextureInfo source, TexelCopyBufferInfo destination, Extent3D copySize) {
        throw new UnsupportedOperationException("Unimplemented method 'copyTextureToBuffer'");
    }

    @Override
    public void copyTextureToTexture(TexelCopyTextureInfo source, TexelCopyTextureInfo destination, Extent3D copySize) {
        throw new UnsupportedOperationException("Unimplemented method 'copyTextureToTexture'");
    }

    @Override
    public void clearBuffer(Buffer buffer, long offset, long size) {
        webgpu_h.wgpuCommandEncoderClearBuffer(this.memorySegment, ((BufferImpl) buffer).ptr(), offset, size);
    }

    @Override
    public void insertDebugMarker(String markerLabel) {
        webgpu_h.wgpuCommandEncoderInsertDebugMarker(this.memorySegment, StringViewMapper.map(markerLabel));
    }

    @Override
    public void popDebugGroup() {
        webgpu_h.wgpuCommandEncoderPopDebugGroup(this.memorySegment);
    }

    @Override
    public void pushDebugGroup(String groupLabel) {
        webgpu_h.wgpuCommandEncoderPushDebugGroup(this.memorySegment, StringViewMapper.map(groupLabel));
    }

    @Override
    public void resolveQuerySet(QuerySet querySet, int firstQuery, int queryCount, Buffer destination,
            long destinationOffset) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'resolveQuerySet'");
    }

    @Override
    public void writeTimestamp(QuerySet querySet, int queryIndex) {
        QuerySetImpl querySetImpl = (QuerySetImpl) querySet;
        webgpu_h.wgpuCommandEncoderWriteTimestamp(memorySegment, querySetImpl.ptr(), queryIndex);
    }

    @Override
    public void setLabel(String label) {
        throw new WGPUException(new UnsupportedOperationException("Unimplemented method 'setLabel'"));
    }
}
