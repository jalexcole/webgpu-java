package org.webgpu.impl.util;

import java.lang.foreign.MemorySegment;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.invoke.VarHandle;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import org.jspecify.annotations.NullMarked;
import org.webgpu.api.WGPUStruct;
import org.webgpu.api.exceptions.WGPUException;

@NullMarked
public final class StructTools {

    @FunctionalInterface
    private interface SegmentGetter {
        MemorySegment get(WGPUStruct struct);
    }

    private static final Map<Class<? extends WGPUStruct>, SegmentGetter> GETTERS;

    private static final Map<Class<? extends WGPUStruct>, MethodHandle> CONSTRUCTORS;

    static {
        @SuppressWarnings("null")
        final var getters = new HashMap<Class<? extends WGPUStruct>, SegmentGetter>();
        @SuppressWarnings("null")
        final var constructors = new HashMap<Class<? extends WGPUStruct>, MethodHandle>();

        for (Class<?> candidate : WGPUStruct.class.getPermittedSubclasses()) {
            @SuppressWarnings("null")
            final Class<? extends WGPUStruct> type = candidate.asSubclass(WGPUStruct.class);
            getters.put(type, buildGetter(type));
            constructors.put(type, buildConstructor(type));
        }

        GETTERS = Map.copyOf(getters);
        CONSTRUCTORS = Map.copyOf(constructors);
    }

    private StructTools() {

    }

    public static <T extends WGPUStruct> MemorySegment fetchSegment(T struct) {
        final T nonNullStruct = Objects.requireNonNull(struct, "struct");
        final Class<? extends WGPUStruct> type = Objects
                .requireNonNull(nonNullStruct.getClass().asSubclass(WGPUStruct.class), "structType");
        final SegmentGetter getter = GETTERS.get(type);
        if (getter == null) {
            throw new WGPUException("No struct segment getter registered for " + type.getName());
        }
        return getter.get(nonNullStruct);
    }

    private static SegmentGetter buildGetter(Class<? extends WGPUStruct> type) {
        try {
            final MethodHandles.Lookup lookup = MethodHandles.privateLookupIn(type, MethodHandles.lookup());
            final VarHandle getter = lookup.findVarHandle(type, "memorySegment", MemorySegment.class);
            return struct -> Objects.requireNonNull((MemorySegment) getter.get(type.cast(struct)), "memorySegment");
        } catch (ReflectiveOperationException e) {
            throw new WGPUException("Could not build struct segment fetcher for " + type.getName(), e);
        }
    }

    private static MethodHandle buildConstructor(Class<? extends WGPUStruct> type) {
        try {
            final MethodHandles.Lookup lookup = MethodHandles.privateLookupIn(type, MethodHandles.lookup());
            return Objects.requireNonNull(
                    lookup.findConstructor(type, MethodType.methodType(void.class, MemorySegment.class)),
                    "constructor");
        } catch (ReflectiveOperationException e) {
            throw new WGPUException("Could not build struct segment placer for " + type.getName(), e);
        }
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
        final Class<T> nonNullType = Objects.requireNonNull(type, "type");
        try {
            final MethodHandle ctor = CONSTRUCTORS.get(nonNullType);
            if (ctor == null) {
                throw new WGPUException("No struct segment placer registered for " + nonNullType.getName());
            }
            return nonNullType.cast(ctor.invoke(Objects.requireNonNull(segment, "segment")));
        } catch (Throwable t) {
            throw new WGPUException("Could not place struct from segment." + nonNullType.getName(), t);
        }
    }

}
