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
 * {@snippet lang = c
 * : * typedef void (*WGPUProcRenderPassEncoderExecuteBundles)(WGPURenderPassEncoder, size_t, const WGPURenderBundle *)
 * }
 */
public class WGPUProcRenderPassEncoderExecuteBundles {

    WGPUProcRenderPassEncoderExecuteBundles() {
        // Should not be called directly
    }

    /**
     * The function pointer signature, expressed as a functional interface
     */
    public interface Function {
        void apply(MemorySegment renderPassEncoder, long bundleCount, MemorySegment bundles);
    }

    private static final FunctionDescriptor $DESC = FunctionDescriptor.ofVoid(
            webgpu_h.C_POINTER,
            webgpu_h.C_LONG,
            webgpu_h.C_POINTER);

    /**
     * The descriptor of this function pointer
     */
    public static FunctionDescriptor descriptor() {
        return $DESC;
    }

    private static final MethodHandle UP$MH = webgpu_h
            .upcallHandle(WGPUProcRenderPassEncoderExecuteBundles.Function.class, "apply", $DESC);

    /**
     * Allocates a new upcall stub, whose implementation is defined by {@code fi}.
     * The lifetime of the returned segment is managed by {@code arena}
     */
    public static MemorySegment allocate(WGPUProcRenderPassEncoderExecuteBundles.Function fi, Arena arena) {
        return Linker.nativeLinker().upcallStub(UP$MH.bindTo(fi), $DESC, arena);
    }

    private static final MethodHandle DOWN$MH = Linker.nativeLinker().downcallHandle($DESC);

    /**
     * Invoke the upcall stub {@code funcPtr}, with given parameters
     */
    public static void invoke(MemorySegment funcPtr, MemorySegment renderPassEncoder, long bundleCount,
            MemorySegment bundles) {
        try {
            DOWN$MH.invokeExact(funcPtr, renderPassEncoder, bundleCount, bundles);
        } catch (Throwable ex$) {
            throw new AssertionError("should not reach here", ex$);
        }
    }
}
