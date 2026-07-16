package org.webgpu.impl.util;

import java.lang.foreign.MemorySegment;
import java.lang.invoke.CallSite;
import java.lang.invoke.LambdaMetafactory;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

import org.jspecify.annotations.NullMarked;
import org.webgpu.api.WGPUStruct;
import org.webgpu.api.exceptions.WGPUException;

@NullMarked
public final class StructTools {

    @FunctionalInterface
    private interface SegmentGetter {
        <T extends WGPUStruct> MemorySegment get(T struct);
    }

    private static final SegmentGetter GETTER;

    static {
        try {
            final MethodHandles.Lookup lookup = MethodHandles.privateLookupIn(WGPUStruct.class, MethodHandles.lookup());

            final MethodHandle getter = lookup.findGetter(
                    WGPUStruct.class,
                    "memorySegment",
                    MemorySegment.class);

            final CallSite callSite = LambdaMetafactory.metafactory(
                    lookup,
                    "get",
                    MethodType.methodType(SegmentGetter.class),
                    MethodType.methodType(MemorySegment.class, WGPUStruct.class),
                    getter,
                    getter.type());

            final var getterInit = (SegmentGetter) callSite.getTarget().invokeExact();

            if (getterInit != null) {
                GETTER = getterInit;
            } else {
                throw new WGPUException("Could not build struct tool ptr fetcher.");
            }

        } catch (Throwable t) {
            throw new ExceptionInInitializerError(t);
        }

    }

    private StructTools() {

    }

    public static <T extends WGPUStruct> MemorySegment fetchSegment(T struct) {
        return GETTER.get(struct);
    }

    /**
     * Places a memory segment into a new instance of the specified struct type.
     * WGPUStructs consist of two constructors:
     * {@code public class WGPUStructImpl extends WGPUStruct { 
     *  public WGPUStructImpl() {
     *      this(PROVIDER.initializer());
     * }
     * private WGPUStructImpl(MemorySegment segment) {
     *     this.memorySegment = segment;
     *  }
     * }
     * }
     * 
     * This function uses a var handle to invoke the private constructor to create a
     * new instance of the struct with the provided memory segment.
     *
     * @param <T>     the type of the struct
     * @param segment the memory segment to place
     * @param type    the class of the struct type
     * @return a new instance of the struct with the memory segment placed
     */
    public static <T extends WGPUStruct> T placeSegment(MemorySegment segment, Class<T> type) {
        try {
            var lookup = MethodHandles.privateLookupIn(type, MethodHandles.lookup());
            var ctor = lookup.findConstructor(type, MethodType.methodType(void.class, MemorySegment.class));
            return (T) ctor.invoke(segment);
        } catch (Throwable t) {
            throw new WGPUException("Could not place struct from segment." + type.getName(), t);
        }
    }

}
