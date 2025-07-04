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
 * struct WGPUCompilationInfo {
 *     WGPUChainedStruct *nextInChain;
 *     size_t messageCount;
 *     const WGPUCompilationMessage *messages;
 * }
 * }
 */
public class WGPUCompilationInfo {

    WGPUCompilationInfo() {
        // Should not be called directly
    }

    private static final GroupLayout $LAYOUT = MemoryLayout.structLayout(
            webgpu_h.C_POINTER.withName("nextInChain"),
            webgpu_h.C_LONG.withName("messageCount"),
            webgpu_h.C_POINTER.withName("messages")).withName("WGPUCompilationInfo");

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

    private static final OfLong messageCount$LAYOUT = (OfLong) $LAYOUT.select(groupElement("messageCount"));

    /**
     * Layout for field:
     * {@snippet lang = c : * size_t messageCount
     * }
     */
    public static final OfLong messageCount$layout() {
        return messageCount$LAYOUT;
    }

    private static final long messageCount$OFFSET = 8;

    /**
     * Offset for field:
     * {@snippet lang = c : * size_t messageCount
     * }
     */
    public static final long messageCount$offset() {
        return messageCount$OFFSET;
    }

    /**
     * Getter for field:
     * {@snippet lang = c : * size_t messageCount
     * }
     */
    public static long messageCount(MemorySegment struct) {
        return struct.get(messageCount$LAYOUT, messageCount$OFFSET);
    }

    /**
     * Setter for field:
     * {@snippet lang = c : * size_t messageCount
     * }
     */
    public static void messageCount(MemorySegment struct, long fieldValue) {
        struct.set(messageCount$LAYOUT, messageCount$OFFSET, fieldValue);
    }

    private static final AddressLayout messages$LAYOUT = (AddressLayout) $LAYOUT.select(groupElement("messages"));

    /**
     * Layout for field:
     * {@snippet lang = c : * const WGPUCompilationMessage *messages
     * }
     */
    public static final AddressLayout messages$layout() {
        return messages$LAYOUT;
    }

    private static final long messages$OFFSET = 16;

    /**
     * Offset for field:
     * {@snippet lang = c : * const WGPUCompilationMessage *messages
     * }
     */
    public static final long messages$offset() {
        return messages$OFFSET;
    }

    /**
     * Getter for field:
     * {@snippet lang = c : * const WGPUCompilationMessage *messages
     * }
     */
    public static MemorySegment messages(MemorySegment struct) {
        return struct.get(messages$LAYOUT, messages$OFFSET);
    }

    /**
     * Setter for field:
     * {@snippet lang = c : * const WGPUCompilationMessage *messages
     * }
     */
    public static void messages(MemorySegment struct, MemorySegment fieldValue) {
        struct.set(messages$LAYOUT, messages$OFFSET, fieldValue);
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
