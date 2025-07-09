package org.webgpu;

import java.lang.foreign.MemorySegment;
import java.time.Instant;

import org.webgpu.extract.webgpu_h;

public interface Adapter {
    /**
     * The features which can be used to create devices on this adapter.
     * 
     * @return
     */
    public Features features();
    
    /**
     * The best limits which can be used to create devices on this adapter.
     * 
     * @return
     */
    public Limits limits();

    /**
     * Get info about the adapter itself.
     * 
     * @return
     */
    public AdapterInfo getInfo();
    
    /**
     * Get info about the adapter itself.
     * 
     * @return
     */
    public DownlevelCapabilities getDownlevelCapabilities();

    /**
     * Returns the features supported for a given texture format by this adapter.
     * 
     * @apiNote Note that the WebGPU spec further restricts the available usages/features. To
     * disable these restrictions on a device, request the
     * {@code Features#TEXTURE_ADAPTER_SPECIFIC_FORMAT_FEATURES} feature
     * 
     * @param format
     * @return
     */
    public TextureFormatFeatures getTextureFormatFeatures(TextureFormat format);
    
    /**
     * Generates a timestamp using the clock used by the presentation engine.
     * 
     * When comparing completely opaque timestamp systems, we need a way of
     * generating timestamps that signal the exact same time. You can do this by
     * calling your own timestamp function immediately after a call to this
     * function. This should result in timestamps that are 0.5 to 5 microseconds
     * apart. There are locks that must be taken during the call, so don’t call your
     * function before.
     * 
     * @return
     */
    public Instant getPresentationTimestamp();

}
