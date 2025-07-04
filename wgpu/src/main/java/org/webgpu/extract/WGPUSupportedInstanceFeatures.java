// Generated by jextract
package org.webgpu.extract;

import java.lang.invoke.*;
import java.lang.foreign.*;
import java.nio.ByteOrder;
import java.util.*;
import java.util.function.*;
import java.util.stream.*;

import static java.lang.foreign.ValueLayout.*;
import static java.lang.foreign.MemoryLayout.PathElement.*;

/**
 * {@snippet lang = c :
 * struct WGPUSupportedInstanceFeatures {
 *     size_t featureCount;
 *     const WGPUInstanceFeatureName *features;
 * }
 * }
 */
public class WGPUSupportedInstanceFeatures {

    WGPUSupportedInstanceFeatures() {
        // Should not be called directly
    }

    private static final GroupLayout $LAYOUT = MemoryLayout.structLayout(
            webgpu_h.C_LONG.withName("featureCount"),
            webgpu_h.C_POINTER.withName("features")).withName("WGPUSupportedInstanceFeatures");

    /**
     * The layout of this struct
     */
    public static final GroupLayout layout() {
        return $LAYOUT;
    }

    private static final OfLong featureCount$LAYOUT = (OfLong) $LAYOUT.select(groupElement("featureCount"));

    /**
     * Layout for field:
     * {@snippet lang = c : * size_t featureCount
     * }
     */
    public static final OfLong featureCount$layout() {
        return featureCount$LAYOUT;
    }

    private static final long featureCount$OFFSET = 0;

    /**
     * Offset for field:
     * {@snippet lang = c : * size_t featureCount
     * }
     */
    public static final long featureCount$offset() {
        return featureCount$OFFSET;
    }

    /**
     * Getter for field:
     * {@snippet lang = c : * size_t featureCount
     * }
     */
    public static long featureCount(MemorySegment struct) {
        return struct.get(featureCount$LAYOUT, featureCount$OFFSET);
    }

    /**
     * Setter for field:
     * {@snippet lang = c : * size_t featureCount
     * }
     */
    public static void featureCount(MemorySegment struct, long fieldValue) {
        struct.set(featureCount$LAYOUT, featureCount$OFFSET, fieldValue);
    }

    private static final AddressLayout features$LAYOUT = (AddressLayout) $LAYOUT.select(groupElement("features"));

    /**
     * Layout for field:
     * {@snippet lang = c : * const WGPUInstanceFeatureName *features
     * }
     */
    public static final AddressLayout features$layout() {
        return features$LAYOUT;
    }

    private static final long features$OFFSET = 8;

    /**
     * Offset for field:
     * {@snippet lang = c : * const WGPUInstanceFeatureName *features
     * }
     */
    public static final long features$offset() {
        return features$OFFSET;
    }

    /**
     * Getter for field:
     * {@snippet lang = c : * const WGPUInstanceFeatureName *features
     * }
     */
    public static MemorySegment features(MemorySegment struct) {
        return struct.get(features$LAYOUT, features$OFFSET);
    }

    /**
     * Setter for field:
     * {@snippet lang = c : * const WGPUInstanceFeatureName *features
     * }
     */
    public static void features(MemorySegment struct, MemorySegment fieldValue) {
        struct.set(features$LAYOUT, features$OFFSET, fieldValue);
    }

    /**
     * Obtains a slice of {@code arrayParam} which selects the array element at
     * {@code index}.
     * The returned segment has address
     * {@code arrayParam.address() + index * layout().byteSize()}
     */
    public static MemorySegment asSlice(MemorySegment array, long index) {
        return array.asSlice(layout().byteSize() * index);
    }

    /**
     * The size (in bytes) of this struct
     */
    public static long sizeof() {
        return layout().byteSize();
    }

    /**
     * Allocate a segment of size {@code layout().byteSize()} using
     * {@code allocator}
     */
    public static MemorySegment allocate(SegmentAllocator allocator) {
        return allocator.allocate(layout());
    }

    /**
     * Allocate an array of size {@code elementCount} using {@code allocator}.
     * The returned segment has size {@code elementCount * layout().byteSize()}.
     */
    public static MemorySegment allocateArray(long elementCount, SegmentAllocator allocator) {
        return allocator.allocate(MemoryLayout.sequenceLayout(elementCount, layout()));
    }

    /**
     * Reinterprets {@code addr} using target {@code arena} and
     * {@code cleanupAction} (if any).
     * The returned segment has size {@code layout().byteSize()}
     */
    public static MemorySegment reinterpret(MemorySegment addr, Arena arena, Consumer<MemorySegment> cleanup) {
        return reinterpret(addr, 1, arena, cleanup);
    }

    /**
     * Reinterprets {@code addr} using target {@code arena} and
     * {@code cleanupAction} (if any).
     * The returned segment has size {@code elementCount * layout().byteSize()}
     */
    public static MemorySegment reinterpret(MemorySegment addr, long elementCount, Arena arena,
            Consumer<MemorySegment> cleanup) {
        return addr.reinterpret(layout().byteSize() * elementCount, arena, cleanup);
    }
}
