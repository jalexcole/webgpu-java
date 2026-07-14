package org.webgpu.impl.spi;

import java.lang.foreign.MemorySegment;

import org.jspecify.annotations.NonNull;
import org.webgpu.api.PassTimestampWrites;
import org.webgpu.api.spi.ComputePassDescriptorProvider;

/**
 * ComputeStateProviderImpl
 */
public class ComputeStateProviderImpl implements ComputePassDescriptorProvider{

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
    public @NonNull PassTimestampWrites timestampWrites(@NonNull MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'timestampWrites'");
    }

    @Override
    public void label(@NonNull MemorySegment structPtr, @NonNull String label) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'label'");
    }

    @Override
    public void timestampWrites(@NonNull MemorySegment structPtr, @NonNull PassTimestampWrites timestampWrites) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'timestampWrites'");
    }

}
