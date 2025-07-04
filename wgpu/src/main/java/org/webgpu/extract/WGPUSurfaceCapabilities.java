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
 * struct WGPUSurfaceCapabilities {
 *     WGPUChainedStruct *nextInChain;
 *     WGPUTextureUsage usages;
 *     size_t formatCount;
 *     const WGPUTextureFormat *formats;
 *     size_t presentModeCount;
 *     const WGPUPresentMode *presentModes;
 *     size_t alphaModeCount;
 *     const WGPUCompositeAlphaMode *alphaModes;
 * }
 * }
 */
public class WGPUSurfaceCapabilities {

    WGPUSurfaceCapabilities() {
        // Should not be called directly
    }

    private static final GroupLayout $LAYOUT = MemoryLayout.structLayout(
            webgpu_h.C_POINTER.withName("nextInChain"),
            webgpu_h.C_LONG_LONG.withName("usages"),
            webgpu_h.C_LONG.withName("formatCount"),
            webgpu_h.C_POINTER.withName("formats"),
            webgpu_h.C_LONG.withName("presentModeCount"),
            webgpu_h.C_POINTER.withName("presentModes"),
            webgpu_h.C_LONG.withName("alphaModeCount"),
            webgpu_h.C_POINTER.withName("alphaModes")).withName("WGPUSurfaceCapabilities");

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

    private static final OfLong usages$LAYOUT = (OfLong) $LAYOUT.select(groupElement("usages"));

    /**
     * Layout for field:
     * {@snippet lang = c : * WGPUTextureUsage usages
     * }
     */
    public static final OfLong usages$layout() {
        return usages$LAYOUT;
    }

    private static final long usages$OFFSET = 8;

    /**
     * Offset for field:
     * {@snippet lang = c : * WGPUTextureUsage usages
     * }
     */
    public static final long usages$offset() {
        return usages$OFFSET;
    }

    /**
     * Getter for field:
     * {@snippet lang = c : * WGPUTextureUsage usages
     * }
     */
    public static long usages(MemorySegment struct) {
        return struct.get(usages$LAYOUT, usages$OFFSET);
    }

    /**
     * Setter for field:
     * {@snippet lang = c : * WGPUTextureUsage usages
     * }
     */
    public static void usages(MemorySegment struct, long fieldValue) {
        struct.set(usages$LAYOUT, usages$OFFSET, fieldValue);
    }

    private static final OfLong formatCount$LAYOUT = (OfLong) $LAYOUT.select(groupElement("formatCount"));

    /**
     * Layout for field:
     * {@snippet lang = c : * size_t formatCount
     * }
     */
    public static final OfLong formatCount$layout() {
        return formatCount$LAYOUT;
    }

    private static final long formatCount$OFFSET = 16;

    /**
     * Offset for field:
     * {@snippet lang = c : * size_t formatCount
     * }
     */
    public static final long formatCount$offset() {
        return formatCount$OFFSET;
    }

    /**
     * Getter for field:
     * {@snippet lang = c : * size_t formatCount
     * }
     */
    public static long formatCount(MemorySegment struct) {
        return struct.get(formatCount$LAYOUT, formatCount$OFFSET);
    }

    /**
     * Setter for field:
     * {@snippet lang = c : * size_t formatCount
     * }
     */
    public static void formatCount(MemorySegment struct, long fieldValue) {
        struct.set(formatCount$LAYOUT, formatCount$OFFSET, fieldValue);
    }

    private static final AddressLayout formats$LAYOUT = (AddressLayout) $LAYOUT.select(groupElement("formats"));

    /**
     * Layout for field:
     * {@snippet lang = c : * const WGPUTextureFormat *formats
     * }
     */
    public static final AddressLayout formats$layout() {
        return formats$LAYOUT;
    }

    private static final long formats$OFFSET = 24;

    /**
     * Offset for field:
     * {@snippet lang = c : * const WGPUTextureFormat *formats
     * }
     */
    public static final long formats$offset() {
        return formats$OFFSET;
    }

    /**
     * Getter for field:
     * {@snippet lang = c : * const WGPUTextureFormat *formats
     * }
     */
    public static MemorySegment formats(MemorySegment struct) {
        return struct.get(formats$LAYOUT, formats$OFFSET);
    }

    /**
     * Setter for field:
     * {@snippet lang = c : * const WGPUTextureFormat *formats
     * }
     */
    public static void formats(MemorySegment struct, MemorySegment fieldValue) {
        struct.set(formats$LAYOUT, formats$OFFSET, fieldValue);
    }

    private static final OfLong presentModeCount$LAYOUT = (OfLong) $LAYOUT.select(groupElement("presentModeCount"));

    /**
     * Layout for field:
     * {@snippet lang = c : * size_t presentModeCount
     * }
     */
    public static final OfLong presentModeCount$layout() {
        return presentModeCount$LAYOUT;
    }

    private static final long presentModeCount$OFFSET = 32;

    /**
     * Offset for field:
     * {@snippet lang = c : * size_t presentModeCount
     * }
     */
    public static final long presentModeCount$offset() {
        return presentModeCount$OFFSET;
    }

    /**
     * Getter for field:
     * {@snippet lang = c : * size_t presentModeCount
     * }
     */
    public static long presentModeCount(MemorySegment struct) {
        return struct.get(presentModeCount$LAYOUT, presentModeCount$OFFSET);
    }

    /**
     * Setter for field:
     * {@snippet lang = c : * size_t presentModeCount
     * }
     */
    public static void presentModeCount(MemorySegment struct, long fieldValue) {
        struct.set(presentModeCount$LAYOUT, presentModeCount$OFFSET, fieldValue);
    }

    private static final AddressLayout presentModes$LAYOUT = (AddressLayout) $LAYOUT
            .select(groupElement("presentModes"));

    /**
     * Layout for field:
     * {@snippet lang = c : * const WGPUPresentMode *presentModes
     * }
     */
    public static final AddressLayout presentModes$layout() {
        return presentModes$LAYOUT;
    }

    private static final long presentModes$OFFSET = 40;

    /**
     * Offset for field:
     * {@snippet lang = c : * const WGPUPresentMode *presentModes
     * }
     */
    public static final long presentModes$offset() {
        return presentModes$OFFSET;
    }

    /**
     * Getter for field:
     * {@snippet lang = c : * const WGPUPresentMode *presentModes
     * }
     */
    public static MemorySegment presentModes(MemorySegment struct) {
        return struct.get(presentModes$LAYOUT, presentModes$OFFSET);
    }

    /**
     * Setter for field:
     * {@snippet lang = c : * const WGPUPresentMode *presentModes
     * }
     */
    public static void presentModes(MemorySegment struct, MemorySegment fieldValue) {
        struct.set(presentModes$LAYOUT, presentModes$OFFSET, fieldValue);
    }

    private static final OfLong alphaModeCount$LAYOUT = (OfLong) $LAYOUT.select(groupElement("alphaModeCount"));

    /**
     * Layout for field:
     * {@snippet lang = c : * size_t alphaModeCount
     * }
     */
    public static final OfLong alphaModeCount$layout() {
        return alphaModeCount$LAYOUT;
    }

    private static final long alphaModeCount$OFFSET = 48;

    /**
     * Offset for field:
     * {@snippet lang = c : * size_t alphaModeCount
     * }
     */
    public static final long alphaModeCount$offset() {
        return alphaModeCount$OFFSET;
    }

    /**
     * Getter for field:
     * {@snippet lang = c : * size_t alphaModeCount
     * }
     */
    public static long alphaModeCount(MemorySegment struct) {
        return struct.get(alphaModeCount$LAYOUT, alphaModeCount$OFFSET);
    }

    /**
     * Setter for field:
     * {@snippet lang = c : * size_t alphaModeCount
     * }
     */
    public static void alphaModeCount(MemorySegment struct, long fieldValue) {
        struct.set(alphaModeCount$LAYOUT, alphaModeCount$OFFSET, fieldValue);
    }

    private static final AddressLayout alphaModes$LAYOUT = (AddressLayout) $LAYOUT.select(groupElement("alphaModes"));

    /**
     * Layout for field:
     * {@snippet lang = c : * const WGPUCompositeAlphaMode *alphaModes
     * }
     */
    public static final AddressLayout alphaModes$layout() {
        return alphaModes$LAYOUT;
    }

    private static final long alphaModes$OFFSET = 56;

    /**
     * Offset for field:
     * {@snippet lang = c : * const WGPUCompositeAlphaMode *alphaModes
     * }
     */
    public static final long alphaModes$offset() {
        return alphaModes$OFFSET;
    }

    /**
     * Getter for field:
     * {@snippet lang = c : * const WGPUCompositeAlphaMode *alphaModes
     * }
     */
    public static MemorySegment alphaModes(MemorySegment struct) {
        return struct.get(alphaModes$LAYOUT, alphaModes$OFFSET);
    }

    /**
     * Setter for field:
     * {@snippet lang = c : * const WGPUCompositeAlphaMode *alphaModes
     * }
     */
    public static void alphaModes(MemorySegment struct, MemorySegment fieldValue) {
        struct.set(alphaModes$LAYOUT, alphaModes$OFFSET, fieldValue);
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
