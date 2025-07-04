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
 * struct WGPUVertexBufferLayout {
 *     WGPUChainedStruct *nextInChain;
 *     WGPUVertexStepMode stepMode;
 *     uint64_t arrayStride;
 *     size_t attributeCount;
 *     const WGPUVertexAttribute *attributes;
 * }
 * }
 */
public class WGPUVertexBufferLayout {

    WGPUVertexBufferLayout() {
        // Should not be called directly
    }

    private static final GroupLayout $LAYOUT = MemoryLayout.structLayout(
            webgpu_h.C_POINTER.withName("nextInChain"),
            webgpu_h.C_INT.withName("stepMode"),
            MemoryLayout.paddingLayout(4),
            webgpu_h.C_LONG_LONG.withName("arrayStride"),
            webgpu_h.C_LONG.withName("attributeCount"),
            webgpu_h.C_POINTER.withName("attributes")).withName("WGPUVertexBufferLayout");

    /**
     * The layout of this struct
     */
    public static final GroupLayout layout() {
        return $LAYOUT;
    }

    private static final AddressLayout nextInChain$LAYOUT = (AddressLayout) $LAYOUT.select(groupElement("nextInChain"));

    /**
     * Layout for field:
     * {@snippet lang = c : * WGPUChainedStruct *nextInChain
     * }
     */
    public static final AddressLayout nextInChain$layout() {
        return nextInChain$LAYOUT;
    }

    private static final long nextInChain$OFFSET = 0;

    /**
     * Offset for field:
     * {@snippet lang = c : * WGPUChainedStruct *nextInChain
     * }
     */
    public static final long nextInChain$offset() {
        return nextInChain$OFFSET;
    }

    /**
     * Getter for field:
     * {@snippet lang = c : * WGPUChainedStruct *nextInChain
     * }
     */
    public static MemorySegment nextInChain(MemorySegment struct) {
        return struct.get(nextInChain$LAYOUT, nextInChain$OFFSET);
    }

    /**
     * Setter for field:
     * {@snippet lang = c : * WGPUChainedStruct *nextInChain
     * }
     */
    public static void nextInChain(MemorySegment struct, MemorySegment fieldValue) {
        struct.set(nextInChain$LAYOUT, nextInChain$OFFSET, fieldValue);
    }

    private static final OfInt stepMode$LAYOUT = (OfInt) $LAYOUT.select(groupElement("stepMode"));

    /**
     * Layout for field:
     * {@snippet lang = c : * WGPUVertexStepMode stepMode
     * }
     */
    public static final OfInt stepMode$layout() {
        return stepMode$LAYOUT;
    }

    private static final long stepMode$OFFSET = 8;

    /**
     * Offset for field:
     * {@snippet lang = c : * WGPUVertexStepMode stepMode
     * }
     */
    public static final long stepMode$offset() {
        return stepMode$OFFSET;
    }

    /**
     * Getter for field:
     * {@snippet lang = c : * WGPUVertexStepMode stepMode
     * }
     */
    public static int stepMode(MemorySegment struct) {
        return struct.get(stepMode$LAYOUT, stepMode$OFFSET);
    }

    /**
     * Setter for field:
     * {@snippet lang = c : * WGPUVertexStepMode stepMode
     * }
     */
    public static void stepMode(MemorySegment struct, int fieldValue) {
        struct.set(stepMode$LAYOUT, stepMode$OFFSET, fieldValue);
    }

    private static final OfLong arrayStride$LAYOUT = (OfLong) $LAYOUT.select(groupElement("arrayStride"));

    /**
     * Layout for field:
     * {@snippet lang = c : * uint64_t arrayStride
     * }
     */
    public static final OfLong arrayStride$layout() {
        return arrayStride$LAYOUT;
    }

    private static final long arrayStride$OFFSET = 16;

    /**
     * Offset for field:
     * {@snippet lang = c : * uint64_t arrayStride
     * }
     */
    public static final long arrayStride$offset() {
        return arrayStride$OFFSET;
    }

    /**
     * Getter for field:
     * {@snippet lang = c : * uint64_t arrayStride
     * }
     */
    public static long arrayStride(MemorySegment struct) {
        return struct.get(arrayStride$LAYOUT, arrayStride$OFFSET);
    }

    /**
     * Setter for field:
     * {@snippet lang = c : * uint64_t arrayStride
     * }
     */
    public static void arrayStride(MemorySegment struct, long fieldValue) {
        struct.set(arrayStride$LAYOUT, arrayStride$OFFSET, fieldValue);
    }

    private static final OfLong attributeCount$LAYOUT = (OfLong) $LAYOUT.select(groupElement("attributeCount"));

    /**
     * Layout for field:
     * {@snippet lang = c : * size_t attributeCount
     * }
     */
    public static final OfLong attributeCount$layout() {
        return attributeCount$LAYOUT;
    }

    private static final long attributeCount$OFFSET = 24;

    /**
     * Offset for field:
     * {@snippet lang = c : * size_t attributeCount
     * }
     */
    public static final long attributeCount$offset() {
        return attributeCount$OFFSET;
    }

    /**
     * Getter for field:
     * {@snippet lang = c : * size_t attributeCount
     * }
     */
    public static long attributeCount(MemorySegment struct) {
        return struct.get(attributeCount$LAYOUT, attributeCount$OFFSET);
    }

    /**
     * Setter for field:
     * {@snippet lang = c : * size_t attributeCount
     * }
     */
    public static void attributeCount(MemorySegment struct, long fieldValue) {
        struct.set(attributeCount$LAYOUT, attributeCount$OFFSET, fieldValue);
    }

    private static final AddressLayout attributes$LAYOUT = (AddressLayout) $LAYOUT.select(groupElement("attributes"));

    /**
     * Layout for field:
     * {@snippet lang = c : * const WGPUVertexAttribute *attributes
     * }
     */
    public static final AddressLayout attributes$layout() {
        return attributes$LAYOUT;
    }

    private static final long attributes$OFFSET = 32;

    /**
     * Offset for field:
     * {@snippet lang = c : * const WGPUVertexAttribute *attributes
     * }
     */
    public static final long attributes$offset() {
        return attributes$OFFSET;
    }

    /**
     * Getter for field:
     * {@snippet lang = c : * const WGPUVertexAttribute *attributes
     * }
     */
    public static MemorySegment attributes(MemorySegment struct) {
        return struct.get(attributes$LAYOUT, attributes$OFFSET);
    }

    /**
     * Setter for field:
     * {@snippet lang = c : * const WGPUVertexAttribute *attributes
     * }
     */
    public static void attributes(MemorySegment struct, MemorySegment fieldValue) {
        struct.set(attributes$LAYOUT, attributes$OFFSET, fieldValue);
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
