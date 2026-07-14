package org.webgpu.impl.spi;

import java.lang.foreign.MemorySegment;

import org.jspecify.annotations.NonNull;
import org.webgpu.api.DeviceLost;
import org.webgpu.api.FeatureName;
import org.webgpu.api.Limits;
import org.webgpu.api.QueueDescriptor;
import org.webgpu.api.UncapturedError;
import org.webgpu.api.spi.DeviceDescriptorProvider;

/**
 * DeviceDescriptorProviderImpl
 */
public class DeviceDescriptorProviderImpl implements DeviceDescriptorProvider {

    @Override
    public @NonNull MemorySegment initializer() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'initializer'");
    }

    @Override
    public @NonNull String label(@NonNull MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'label'");
    }

    @Override
    public FeatureName @NonNull [] requiredFeatures(@NonNull MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'requiredFeatures'");
    }

    @Override
    public @NonNull Limits requiredLimits(@NonNull MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'requiredLimits'");
    }

    @Override
    public @NonNull QueueDescriptor defaultQueue(@NonNull MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'defaultQueue'");
    }

    @Override
    public @NonNull DeviceLost deviceLostCallbackInfo(@NonNull MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deviceLostCallbackInfo'");
    }

    @Override
    public @NonNull UncapturedError uncapturedErrorCallbackInfo(@NonNull MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'uncapturedErrorCallbackInfo'");
    }

    @Override
    public void label(@NonNull MemorySegment structPtr, @NonNull String label) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'label'");
    }

    @Override
    public void requiredFeatures(@NonNull MemorySegment structPtr, FeatureName @NonNull [] requiredFeatures) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'requiredFeatures'");
    }

    @Override
    public void requiredLimits(@NonNull MemorySegment structPtr, @NonNull Limits requiredLimits) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'requiredLimits'");
    }

    @Override
    public void defaultQueue(@NonNull MemorySegment structPtr, @NonNull QueueDescriptor defaultQueue) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'defaultQueue'");
    }

    @Override
    public void deviceLostCallbackInfo(@NonNull MemorySegment structPtr, @NonNull DeviceLost deviceLostCallbackInfo) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deviceLostCallbackInfo'");
    }

    @Override
    public void uncapturedErrorCallbackInfo(@NonNull MemorySegment structPtr,
            @NonNull UncapturedError uncapturedErrorCallbackInfo) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'uncapturedErrorCallbackInfo'");
    }

}
