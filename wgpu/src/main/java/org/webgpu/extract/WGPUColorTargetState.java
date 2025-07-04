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
 * struct WGPUColorTargetState {
 *     WGPUChainedStruct *nextInChain;
 *     WGPUTextureFormat format;
 *     const WGPUBlendState *blend;
 *     WGPUColorWriteMask writeMask;
 * }
 * }
 */
public class WGPUColorTargetState {

    WGPUColorTargetState() {
        // Should not be called directly
    }

    private static final GroupLayout $LAYOUT = MemoryLayout.structLayout(
            webgpu_h.C_POINTER.withName("nextInChain"),
            webgpu_h.C_INT.withName("format"),
            MemoryLayout.paddingLayout(4),
            webgpu_h.C_POINTER.withName("blend"),
            webgpu_h.C_LONG_LONG.withName("writeMask")).withName("WGPUColorTargetState");

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

    private static final OfInt format$LAYOUT = (OfInt) $LAYOUT.select(groupElement("format"));

    /**
     * Layout for field:
     * {@snippet lang = c : * WGPUTextureFormat format
     * }
     */
    public static final OfInt format$layout() {
        return format$LAYOUT;
    }

    private static final long format$OFFSET = 8;

    /**
     * Offset for field:
     * {@snippet lang = c : * WGPUTextureFormat format
     * }
     */
    public static final long format$offset() {
        return format$OFFSET;
    }

    /**
     * Getter for field:
     * {@snippet lang = c : * WGPUTextureFormat format
     * }
     */
    public static int format(MemorySegment struct) {
        return struct.get(format$LAYOUT, format$OFFSET);
    }

    /**
     * Setter for field:
     * {@snippet lang = c : * WGPUTextureFormat format
     * }
     */
    public static void format(MemorySegment struct, int fieldValue) {
        struct.set(format$LAYOUT, format$OFFSET, fieldValue);
    }

    private static final AddressLayout blend$LAYOUT = (AddressLayout) $LAYOUT.select(groupElement("blend"));

    /**
     * Layout for field:
     * {@snippet lang = c : * const WGPUBlendState *blend
     * }
     */
    public static final AddressLayout blend$layout() {
        return blend$LAYOUT;
    }

    private static final long blend$OFFSET = 16;

    /**
     * Offset for field:
     * {@snippet lang = c : * const WGPUBlendState *blend
     * }
     */
    public static final long blend$offset() {
        return blend$OFFSET;
    }

    /**
     * Getter for field:
     * {@snippet lang = c : * const WGPUBlendState *blend
     * }
     */
    public static MemorySegment blend(MemorySegment struct) {
        return struct.get(blend$LAYOUT, blend$OFFSET);
    }

    /**
     * Setter for field:
     * {@snippet lang = c : * const WGPUBlendState *blend
     * }
     */
    public static void blend(MemorySegment struct, MemorySegment fieldValue) {
        struct.set(blend$LAYOUT, blend$OFFSET, fieldValue);
    }

    private static final OfLong writeMask$LAYOUT = (OfLong) $LAYOUT.select(groupElement("writeMask"));

    /**
     * Layout for field:
     * {@snippet lang = c : * WGPUColorWriteMask writeMask
     * }
     */
    public static final OfLong writeMask$layout() {
        return writeMask$LAYOUT;
    }

    private static final long writeMask$OFFSET = 24;

    /**
     * Offset for field:
     * {@snippet lang = c : * WGPUColorWriteMask writeMask
     * }
     */
    public static final long writeMask$offset() {
        return writeMask$OFFSET;
    }

    /**
     * Getter for field:
     * {@snippet lang = c : * WGPUColorWriteMask writeMask
     * }
     */
    public static long writeMask(MemorySegment struct) {
        return struct.get(writeMask$LAYOUT, writeMask$OFFSET);
    }

    /**
     * Setter for field:
     * {@snippet lang = c : * WGPUColorWriteMask writeMask
     * }
     */
    public static void writeMask(MemorySegment struct, long fieldValue) {
        struct.set(writeMask$LAYOUT, writeMask$OFFSET, fieldValue);
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
