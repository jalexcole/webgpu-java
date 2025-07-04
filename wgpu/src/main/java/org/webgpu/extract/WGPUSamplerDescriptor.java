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
 * struct WGPUSamplerDescriptor {
 *     WGPUChainedStruct *nextInChain;
 *     WGPUStringView label;
 *     WGPUAddressMode addressModeU;
 *     WGPUAddressMode addressModeV;
 *     WGPUAddressMode addressModeW;
 *     WGPUFilterMode magFilter;
 *     WGPUFilterMode minFilter;
 *     WGPUMipmapFilterMode mipmapFilter;
 *     float lodMinClamp;
 *     float lodMaxClamp;
 *     WGPUCompareFunction compare;
 *     uint16_t maxAnisotropy;
 * }
 * }
 */
public class WGPUSamplerDescriptor {

    WGPUSamplerDescriptor() {
        // Should not be called directly
    }

    private static final GroupLayout $LAYOUT = MemoryLayout.structLayout(
            webgpu_h.C_POINTER.withName("nextInChain"),
            WGPUStringView.layout().withName("label"),
            webgpu_h.C_INT.withName("addressModeU"),
            webgpu_h.C_INT.withName("addressModeV"),
            webgpu_h.C_INT.withName("addressModeW"),
            webgpu_h.C_INT.withName("magFilter"),
            webgpu_h.C_INT.withName("minFilter"),
            webgpu_h.C_INT.withName("mipmapFilter"),
            webgpu_h.C_FLOAT.withName("lodMinClamp"),
            webgpu_h.C_FLOAT.withName("lodMaxClamp"),
            webgpu_h.C_INT.withName("compare"),
            webgpu_h.C_SHORT.withName("maxAnisotropy"),
            MemoryLayout.paddingLayout(2)).withName("WGPUSamplerDescriptor");

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

    private static final GroupLayout label$LAYOUT = (GroupLayout) $LAYOUT.select(groupElement("label"));

    /**
     * Layout for field:
     * {@snippet lang = c : * WGPUStringView label
     * }
     */
    public static final GroupLayout label$layout() {
        return label$LAYOUT;
    }

    private static final long label$OFFSET = 8;

    /**
     * Offset for field:
     * {@snippet lang = c : * WGPUStringView label
     * }
     */
    public static final long label$offset() {
        return label$OFFSET;
    }

    /**
     * Getter for field:
     * {@snippet lang = c : * WGPUStringView label
     * }
     */
    public static MemorySegment label(MemorySegment struct) {
        return struct.asSlice(label$OFFSET, label$LAYOUT.byteSize());
    }

    /**
     * Setter for field:
     * {@snippet lang = c : * WGPUStringView label
     * }
     */
    public static void label(MemorySegment struct, MemorySegment fieldValue) {
        MemorySegment.copy(fieldValue, 0L, struct, label$OFFSET, label$LAYOUT.byteSize());
    }

    private static final OfInt addressModeU$LAYOUT = (OfInt) $LAYOUT.select(groupElement("addressModeU"));

    /**
     * Layout for field:
     * {@snippet lang = c : * WGPUAddressMode addressModeU
     * }
     */
    public static final OfInt addressModeU$layout() {
        return addressModeU$LAYOUT;
    }

    private static final long addressModeU$OFFSET = 24;

    /**
     * Offset for field:
     * {@snippet lang = c : * WGPUAddressMode addressModeU
     * }
     */
    public static final long addressModeU$offset() {
        return addressModeU$OFFSET;
    }

    /**
     * Getter for field:
     * {@snippet lang = c : * WGPUAddressMode addressModeU
     * }
     */
    public static int addressModeU(MemorySegment struct) {
        return struct.get(addressModeU$LAYOUT, addressModeU$OFFSET);
    }

    /**
     * Setter for field:
     * {@snippet lang = c : * WGPUAddressMode addressModeU
     * }
     */
    public static void addressModeU(MemorySegment struct, int fieldValue) {
        struct.set(addressModeU$LAYOUT, addressModeU$OFFSET, fieldValue);
    }

    private static final OfInt addressModeV$LAYOUT = (OfInt) $LAYOUT.select(groupElement("addressModeV"));

    /**
     * Layout for field:
     * {@snippet lang = c : * WGPUAddressMode addressModeV
     * }
     */
    public static final OfInt addressModeV$layout() {
        return addressModeV$LAYOUT;
    }

    private static final long addressModeV$OFFSET = 28;

    /**
     * Offset for field:
     * {@snippet lang = c : * WGPUAddressMode addressModeV
     * }
     */
    public static final long addressModeV$offset() {
        return addressModeV$OFFSET;
    }

    /**
     * Getter for field:
     * {@snippet lang = c : * WGPUAddressMode addressModeV
     * }
     */
    public static int addressModeV(MemorySegment struct) {
        return struct.get(addressModeV$LAYOUT, addressModeV$OFFSET);
    }

    /**
     * Setter for field:
     * {@snippet lang = c : * WGPUAddressMode addressModeV
     * }
     */
    public static void addressModeV(MemorySegment struct, int fieldValue) {
        struct.set(addressModeV$LAYOUT, addressModeV$OFFSET, fieldValue);
    }

    private static final OfInt addressModeW$LAYOUT = (OfInt) $LAYOUT.select(groupElement("addressModeW"));

    /**
     * Layout for field:
     * {@snippet lang = c : * WGPUAddressMode addressModeW
     * }
     */
    public static final OfInt addressModeW$layout() {
        return addressModeW$LAYOUT;
    }

    private static final long addressModeW$OFFSET = 32;

    /**
     * Offset for field:
     * {@snippet lang = c : * WGPUAddressMode addressModeW
     * }
     */
    public static final long addressModeW$offset() {
        return addressModeW$OFFSET;
    }

    /**
     * Getter for field:
     * {@snippet lang = c : * WGPUAddressMode addressModeW
     * }
     */
    public static int addressModeW(MemorySegment struct) {
        return struct.get(addressModeW$LAYOUT, addressModeW$OFFSET);
    }

    /**
     * Setter for field:
     * {@snippet lang = c : * WGPUAddressMode addressModeW
     * }
     */
    public static void addressModeW(MemorySegment struct, int fieldValue) {
        struct.set(addressModeW$LAYOUT, addressModeW$OFFSET, fieldValue);
    }

    private static final OfInt magFilter$LAYOUT = (OfInt) $LAYOUT.select(groupElement("magFilter"));

    /**
     * Layout for field:
     * {@snippet lang = c : * WGPUFilterMode magFilter
     * }
     */
    public static final OfInt magFilter$layout() {
        return magFilter$LAYOUT;
    }

    private static final long magFilter$OFFSET = 36;

    /**
     * Offset for field:
     * {@snippet lang = c : * WGPUFilterMode magFilter
     * }
     */
    public static final long magFilter$offset() {
        return magFilter$OFFSET;
    }

    /**
     * Getter for field:
     * {@snippet lang = c : * WGPUFilterMode magFilter
     * }
     */
    public static int magFilter(MemorySegment struct) {
        return struct.get(magFilter$LAYOUT, magFilter$OFFSET);
    }

    /**
     * Setter for field:
     * {@snippet lang = c : * WGPUFilterMode magFilter
     * }
     */
    public static void magFilter(MemorySegment struct, int fieldValue) {
        struct.set(magFilter$LAYOUT, magFilter$OFFSET, fieldValue);
    }

    private static final OfInt minFilter$LAYOUT = (OfInt) $LAYOUT.select(groupElement("minFilter"));

    /**
     * Layout for field:
     * {@snippet lang = c : * WGPUFilterMode minFilter
     * }
     */
    public static final OfInt minFilter$layout() {
        return minFilter$LAYOUT;
    }

    private static final long minFilter$OFFSET = 40;

    /**
     * Offset for field:
     * {@snippet lang = c : * WGPUFilterMode minFilter
     * }
     */
    public static final long minFilter$offset() {
        return minFilter$OFFSET;
    }

    /**
     * Getter for field:
     * {@snippet lang = c : * WGPUFilterMode minFilter
     * }
     */
    public static int minFilter(MemorySegment struct) {
        return struct.get(minFilter$LAYOUT, minFilter$OFFSET);
    }

    /**
     * Setter for field:
     * {@snippet lang = c : * WGPUFilterMode minFilter
     * }
     */
    public static void minFilter(MemorySegment struct, int fieldValue) {
        struct.set(minFilter$LAYOUT, minFilter$OFFSET, fieldValue);
    }

    private static final OfInt mipmapFilter$LAYOUT = (OfInt) $LAYOUT.select(groupElement("mipmapFilter"));

    /**
     * Layout for field:
     * {@snippet lang = c : * WGPUMipmapFilterMode mipmapFilter
     * }
     */
    public static final OfInt mipmapFilter$layout() {
        return mipmapFilter$LAYOUT;
    }

    private static final long mipmapFilter$OFFSET = 44;

    /**
     * Offset for field:
     * {@snippet lang = c : * WGPUMipmapFilterMode mipmapFilter
     * }
     */
    public static final long mipmapFilter$offset() {
        return mipmapFilter$OFFSET;
    }

    /**
     * Getter for field:
     * {@snippet lang = c : * WGPUMipmapFilterMode mipmapFilter
     * }
     */
    public static int mipmapFilter(MemorySegment struct) {
        return struct.get(mipmapFilter$LAYOUT, mipmapFilter$OFFSET);
    }

    /**
     * Setter for field:
     * {@snippet lang = c : * WGPUMipmapFilterMode mipmapFilter
     * }
     */
    public static void mipmapFilter(MemorySegment struct, int fieldValue) {
        struct.set(mipmapFilter$LAYOUT, mipmapFilter$OFFSET, fieldValue);
    }

    private static final OfFloat lodMinClamp$LAYOUT = (OfFloat) $LAYOUT.select(groupElement("lodMinClamp"));

    /**
     * Layout for field:
     * {@snippet lang = c : * float lodMinClamp
     * }
     */
    public static final OfFloat lodMinClamp$layout() {
        return lodMinClamp$LAYOUT;
    }

    private static final long lodMinClamp$OFFSET = 48;

    /**
     * Offset for field:
     * {@snippet lang = c : * float lodMinClamp
     * }
     */
    public static final long lodMinClamp$offset() {
        return lodMinClamp$OFFSET;
    }

    /**
     * Getter for field:
     * {@snippet lang = c : * float lodMinClamp
     * }
     */
    public static float lodMinClamp(MemorySegment struct) {
        return struct.get(lodMinClamp$LAYOUT, lodMinClamp$OFFSET);
    }

    /**
     * Setter for field:
     * {@snippet lang = c : * float lodMinClamp
     * }
     */
    public static void lodMinClamp(MemorySegment struct, float fieldValue) {
        struct.set(lodMinClamp$LAYOUT, lodMinClamp$OFFSET, fieldValue);
    }

    private static final OfFloat lodMaxClamp$LAYOUT = (OfFloat) $LAYOUT.select(groupElement("lodMaxClamp"));

    /**
     * Layout for field:
     * {@snippet lang = c : * float lodMaxClamp
     * }
     */
    public static final OfFloat lodMaxClamp$layout() {
        return lodMaxClamp$LAYOUT;
    }

    private static final long lodMaxClamp$OFFSET = 52;

    /**
     * Offset for field:
     * {@snippet lang = c : * float lodMaxClamp
     * }
     */
    public static final long lodMaxClamp$offset() {
        return lodMaxClamp$OFFSET;
    }

    /**
     * Getter for field:
     * {@snippet lang = c : * float lodMaxClamp
     * }
     */
    public static float lodMaxClamp(MemorySegment struct) {
        return struct.get(lodMaxClamp$LAYOUT, lodMaxClamp$OFFSET);
    }

    /**
     * Setter for field:
     * {@snippet lang = c : * float lodMaxClamp
     * }
     */
    public static void lodMaxClamp(MemorySegment struct, float fieldValue) {
        struct.set(lodMaxClamp$LAYOUT, lodMaxClamp$OFFSET, fieldValue);
    }

    private static final OfInt compare$LAYOUT = (OfInt) $LAYOUT.select(groupElement("compare"));

    /**
     * Layout for field:
     * {@snippet lang = c : * WGPUCompareFunction compare
     * }
     */
    public static final OfInt compare$layout() {
        return compare$LAYOUT;
    }

    private static final long compare$OFFSET = 56;

    /**
     * Offset for field:
     * {@snippet lang = c : * WGPUCompareFunction compare
     * }
     */
    public static final long compare$offset() {
        return compare$OFFSET;
    }

    /**
     * Getter for field:
     * {@snippet lang = c : * WGPUCompareFunction compare
     * }
     */
    public static int compare(MemorySegment struct) {
        return struct.get(compare$LAYOUT, compare$OFFSET);
    }

    /**
     * Setter for field:
     * {@snippet lang = c : * WGPUCompareFunction compare
     * }
     */
    public static void compare(MemorySegment struct, int fieldValue) {
        struct.set(compare$LAYOUT, compare$OFFSET, fieldValue);
    }

    private static final OfShort maxAnisotropy$LAYOUT = (OfShort) $LAYOUT.select(groupElement("maxAnisotropy"));

    /**
     * Layout for field:
     * {@snippet lang = c : * uint16_t maxAnisotropy
     * }
     */
    public static final OfShort maxAnisotropy$layout() {
        return maxAnisotropy$LAYOUT;
    }

    private static final long maxAnisotropy$OFFSET = 60;

    /**
     * Offset for field:
     * {@snippet lang = c : * uint16_t maxAnisotropy
     * }
     */
    public static final long maxAnisotropy$offset() {
        return maxAnisotropy$OFFSET;
    }

    /**
     * Getter for field:
     * {@snippet lang = c : * uint16_t maxAnisotropy
     * }
     */
    public static short maxAnisotropy(MemorySegment struct) {
        return struct.get(maxAnisotropy$LAYOUT, maxAnisotropy$OFFSET);
    }

    /**
     * Setter for field:
     * {@snippet lang = c : * uint16_t maxAnisotropy
     * }
     */
    public static void maxAnisotropy(MemorySegment struct, short fieldValue) {
        struct.set(maxAnisotropy$LAYOUT, maxAnisotropy$OFFSET, fieldValue);
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
