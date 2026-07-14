package org.webgpu.impl.spi;

import java.lang.foreign.MemorySegment;

import org.jspecify.annotations.NonNull;
import org.webgpu.api.QueryType;
import org.webgpu.api.spi.QuerySetDescriptorProvider;

/**
 * QuerySetDescriptorProviderImpl
 */
public class QuerySetDescriptorProviderImpl implements QuerySetDescriptorProvider {

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
    public @NonNull QueryType type(@NonNull MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'type'");
    }

    @Override
    public int count(@NonNull MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'count'");
    }

    @Override
    public void label(@NonNull MemorySegment structPtr, @NonNull String label) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'label'");
    }

    @Override
    public void type(@NonNull MemorySegment structPtr, @NonNull QueryType type) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'type'");
    }

    @Override
    public void count(@NonNull MemorySegment structPtr, int count) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'count'");
    }

}
