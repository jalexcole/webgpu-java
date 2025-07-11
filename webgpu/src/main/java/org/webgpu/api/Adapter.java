package org.webgpu.api;

import java.util.concurrent.Future;

import org.jspecify.annotations.NonNull;

public interface Adapter {

    /**
     * Requests a device from the adapter.
     * 
     * This is a one-time action: if a device is returned successfully, the adapter
     * becomes "consumed".
     * 
     * @param descriptor
     * @return
     * 
     * 
     */
    public Future<Device> requestDevice(@NonNull DeviceDescriptor descriptor);

    /**
     * The features which can be used to create devices on this adapter.
     * Get the list of {@link FeatureName} values supported by the adapter.
     * 
     * @return
     */
    public FeatureName[] features();
    
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
    
    public void release();

}
