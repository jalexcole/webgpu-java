package org.webgpu.impl;

import java.lang.foreign.MemorySegment;
import java.util.concurrent.Future;

import org.webgpu.api.Buffer;
import org.webgpu.api.CommandBuffer;
import org.webgpu.api.Extent3D;
import org.webgpu.api.Queue;
import org.webgpu.api.QueueWorkDone;
import org.webgpu.api.TexelCopyBufferLayout;
import org.webgpu.api.TexelCopyTextureInfo;
import org.webgpu.extract.webgpu_h;

public record QueueImpl(MemorySegment ptr) implements Queue {

    @Override
    public Future<QueueWorkDone> onSubmittedWorkDone() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'onSubmittedWorkDone'");
    }

    @Override
    public void setLabel(String label) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setLabel'");
    }

    @Override
    public void submit(CommandBuffer[] commands) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'submit'");
    }

    @Override
    public void writeBuffer(Buffer buffer, long bufferOffset, byte[] data, int offset, int size) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'writeBuffer'");
    }

    @Override
    public void writeTexture(TexelCopyTextureInfo destination, byte[] data, TexelCopyBufferLayout dataLayout,
            Extent3D writeSize) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'writeTexture'");
    }

    @Override
    public void release() {
        webgpu_h.wgpuQueueRelease(ptr);
    }

    @Override
    public long submitForIndex(CommandBuffer[] commands) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'submitForIndex'");
    }
    

    static Queue getQueue(DeviceImpl device) {
        return new QueueImpl(webgpu_h.wgpuDeviceGetQueue(device.ptr()));
    }

    private static MemorySegment onSubmittedWorkDone(QueueImpl queue, QueueWorkDone callback) {
        
        throw new UnsupportedOperationException("Unimplemented method 'onSubmittedWorkDone'");
    }
}
