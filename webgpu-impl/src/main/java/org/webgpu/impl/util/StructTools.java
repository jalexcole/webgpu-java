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

    

}
