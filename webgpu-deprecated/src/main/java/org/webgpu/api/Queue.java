package org.webgpu.api;


import java.util.concurrent.Future;

public interface Queue {
    

    public Future<QueueWorkDone> onSubmittedWorkDone();

    public void setLabel(String label);

    public void submit(CommandBuffer[] commands);

    public void writeBuffer(Buffer buffer, long bufferOffset, byte[] data, int offset, int size);

    public void writeTexture(TexelCopyTextureInfo destination, byte[] data, TexelCopyBufferLayout dataLayout,
            Extent3D writeSize);
    
    public void release();

    public long submitForIndex(CommandBuffer[] commands);
}
