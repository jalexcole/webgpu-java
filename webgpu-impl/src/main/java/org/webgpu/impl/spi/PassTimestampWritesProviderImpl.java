package org.webgpu.impl.spi;

import java.lang.foreign.MemorySegment;

import org.jspecify.annotations.NonNull;
import org.webgpu.api.QuerySet;
import org.webgpu.api.spi.PassTimestampWritesProvider;

/**
 * PassTimestampWritesProviderImpl
 */
public class PassTimestampWritesProviderImpl implements PassTimestampWritesProvider {

    @Override
    public @NonNull MemorySegment initializer() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'initializer'");
    }

    @Override
    public @NonNull QuerySet querySet(@NonNull MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'querySet'");
    }

    @Override
    public int beginningOfPassWriteIndex(@NonNull MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'beginningOfPassWriteIndex'");
    }

    @Override
    public int endOfPassWriteIndex(@NonNull MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'endOfPassWriteIndex'");
    }

    @Override
    public void querySet(@NonNull MemorySegment structPtr, @NonNull QuerySet querySet) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'querySet'");
    }

    @Override
    public void beginningOfPassWriteIndex(@NonNull MemorySegment structPtr, int beginningOfPassWriteIndex) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'beginningOfPassWriteIndex'");
    }

    @Override
    public void endOfPassWriteIndex(@NonNull MemorySegment structPtr, int endOfPassWriteIndex) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'endOfPassWriteIndex'");
    }

}
