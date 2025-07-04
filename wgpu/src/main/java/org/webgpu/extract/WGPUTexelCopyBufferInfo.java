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
 * struct WGPUTexelCopyBufferInfo {
 *     WGPUTexelCopyBufferLayout layout;
 *     WGPUBuffer buffer;
 * }
 * }
 */
public class WGPUTexelCopyBufferInfo {

    WGPUTexelCopyBufferInfo() {
        // Should not be called directly
    }

    private static final GroupLayout $LAYOUT = MemoryLayout.structLayout(
            WGPUTexelCopyBufferLayout.layout().withName("layout"),
            webgpu_h.C_POINTER.withName("buffer")).withName("WGPUTexelCopyBufferInfo");

    /**
     * The layout of this struct
     */
    public static final GroupLayout layout() {
        return $LAYOUT;
    }

    private static final GroupLayout layout$LAYOUT = (GroupLayout) $LAYOUT.select(groupElement("layout"));

    /**
     * Layout for field:
     * {@snippet lang = c : * WGPUTexelCopyBufferLayout layout
     * }
     */
    public static final GroupLayout layout$layout() {
        return layout$LAYOUT;
    }

    private static final long layout$OFFSET = 0;

    /**
     * Offset for field:
     * {@snippet lang = c : * WGPUTexelCopyBufferLayout layout
     * }
     */
    public static final long layout$offset() {
        return layout$OFFSET;
    }

    /**
     * Getter for field:
     * {@snippet lang = c : * WGPUTexelCopyBufferLayout layout
     * }
     */
    public static MemorySegment layout(MemorySegment struct) {
        return struct.asSlice(layout$OFFSET, layout$LAYOUT.byteSize());
    }

    /**
     * Setter for field:
     * {@snippet lang = c : * WGPUTexelCopyBufferLayout layout
     * }
     */
    public static void layout(MemorySegment struct, MemorySegment fieldValue) {
        MemorySegment.copy(fieldValue, 0L, struct, layout$OFFSET, layout$LAYOUT.byteSize());
    }

    private static final AddressLayout buffer$LAYOUT = (AddressLayout) $LAYOUT.select(groupElement("buffer"));

    /**
     * Layout for field:
     * {@snippet lang = c : * WGPUBuffer buffer
     * }
     */
    public static final AddressLayout buffer$layout() {
        return buffer$LAYOUT;
    }

    private static final long buffer$OFFSET = 16;

    /**
     * Offset for field:
     * {@snippet lang = c : * WGPUBuffer buffer
     * }
     */
    public static final long buffer$offset() {
        return buffer$OFFSET;
    }

    /**
     * Getter for field:
     * {@snippet lang = c : * WGPUBuffer buffer
     * }
     */
    public static MemorySegment buffer(MemorySegment struct) {
        return struct.get(buffer$LAYOUT, buffer$OFFSET);
    }

    /**
     * Setter for field:
     * {@snippet lang = c : * WGPUBuffer buffer
     * }
     */
    public static void buffer(MemorySegment struct, MemorySegment fieldValue) {
        struct.set(buffer$LAYOUT, buffer$OFFSET, fieldValue);
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
