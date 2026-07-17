package org.webgpu.impl.spi;

import java.lang.foreign.MemorySegment;

import org.jspecify.annotations.NonNull;
import org.webgpu.api.PassTimestampWrites;
import org.webgpu.api.spi.ComputePassDescriptorProvider;

/**
 * ComputeStateProviderImpl
 */
public class ComputeStateProviderImpl implements ComputePassDescriptorProvider {

    @Override
    public MemorySegment initializer() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'initializer'");
    }

    @Override
    public String label(MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'label'");
    }

    @Override
    public PassTimestampWrites timestampWrites(MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'timestampWrites'");
    }

    @Override
    public void label(MemorySegment structPtr, String label) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'label'");
    }

    @Override
    public void timestampWrites(MemorySegment structPtr, PassTimestampWrites timestampWrites) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'timestampWrites'");
    }

}
