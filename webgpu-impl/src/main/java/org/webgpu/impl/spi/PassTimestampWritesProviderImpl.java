package org.webgpu.impl.spi;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;

import org.jspecify.annotations.NonNull;
import org.webgpu.api.QuerySet;
import org.webgpu.api.spi.PassTimestampWritesProvider;
import org.webgpu.panama.WGPUPassTimestampWrites;

/**
 * PassTimestampWritesProviderImpl
 */
public class PassTimestampWritesProviderImpl implements PassTimestampWritesProvider {
    private final Arena arena = Arena.ofAuto();

    @Override
    public MemorySegment initializer() {
        return WGPUPassTimestampWrites.allocate(arena);
    }

    @Override
    public QuerySet querySet(MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'querySet'");
    }

    @Override
    public int beginningOfPassWriteIndex(MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'beginningOfPassWriteIndex'");
    }

    @Override
    public int endOfPassWriteIndex(MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'endOfPassWriteIndex'");
    }

    @Override
    public void querySet(MemorySegment structPtr, QuerySet querySet) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'querySet'");
    }

    @Override
    public void beginningOfPassWriteIndex(MemorySegment structPtr, int beginningOfPassWriteIndex) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'beginningOfPassWriteIndex'");
    }

    @Override
    public void endOfPassWriteIndex(MemorySegment structPtr, int endOfPassWriteIndex) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'endOfPassWriteIndex'");
    }

}
