package org.webgpu.impl.spi;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;

import org.jspecify.annotations.NonNull;
import org.webgpu.api.DeviceLost;
import org.webgpu.api.FeatureName;
import org.webgpu.api.Limits;
import org.webgpu.api.QueueDescriptor;
import org.webgpu.api.UncapturedError;
import org.webgpu.api.spi.DeviceDescriptorProvider;
import org.webgpu.panama.WGPUDeviceDescriptor;

/**
 * DeviceDescriptorProviderImpl
 */
public class DeviceDescriptorProviderImpl implements DeviceDescriptorProvider {
    private final Arena arena = Arena.ofAuto();

    @Override
    public MemorySegment initializer() {
        return WGPUDeviceDescriptor.allocate(arena);
    }

    @Override
    public String label(MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'label'");
    }

    @Override
    public FeatureName[] requiredFeatures(MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'requiredFeatures'");
    }

    @Override
    public Limits requiredLimits(MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'requiredLimits'");
    }

    @Override
    public QueueDescriptor defaultQueue(MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'defaultQueue'");
    }

    @Override
    public DeviceLost deviceLostCallbackInfo(MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deviceLostCallbackInfo'");
    }

    @Override
    public UncapturedError uncapturedErrorCallbackInfo(MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'uncapturedErrorCallbackInfo'");
    }

    @Override
    public void label(MemorySegment structPtr, String label) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'label'");
    }

    @Override
    public void requiredFeatures(MemorySegment structPtr, FeatureName[] requiredFeatures) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'requiredFeatures'");
    }

    @Override
    public void requiredLimits(MemorySegment structPtr, Limits requiredLimits) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'requiredLimits'");
    }

    @Override
    public void defaultQueue(MemorySegment structPtr, QueueDescriptor defaultQueue) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'defaultQueue'");
    }

    @Override
    public void deviceLostCallbackInfo(MemorySegment structPtr, DeviceLost deviceLostCallbackInfo) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deviceLostCallbackInfo'");
    }

    @Override
    public void uncapturedErrorCallbackInfo(MemorySegment structPtr,
            UncapturedError uncapturedErrorCallbackInfo) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'uncapturedErrorCallbackInfo'");
    }

}
