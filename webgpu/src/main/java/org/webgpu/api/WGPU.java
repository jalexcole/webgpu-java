package org.webgpu.api;

import java.lang.foreign.Arena;
import java.lang.foreign.Linker;
import java.lang.foreign.MemorySegment;
import org.jspecify.annotations.Nullable;
import org.webgpu.extract.webgpu_h;
import org.webgpu.impl.InstanceImpl;

public class WGPU {

    public static Arena arena = Arena.ofShared();

    @SuppressWarnings("preview")
    static final Linker NATIVE_LINKER = Linker.nativeLinker();
    static {
        try {

            System.load("/Users/alex/dev/webgpu-java/webgpu/src/test/resources/libwgpu_native.dylib");
        } catch (SecurityException e) {
            System.out.println(e.getMessage());
        } catch (final UnsatisfiedLinkError e) {
            System.out.println(e.getMessage());
        }
    }

    @SuppressWarnings("preview")
    public static Instance createInstance(@Nullable InstanceDescriptor descriptor) {
        if (WGPU.arena == null) {
            try {
                @SuppressWarnings("preview")
                Arena arena = Arena.ofAuto();
                WGPU.arena = arena;
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        return new InstanceImpl(
                webgpu_h.wgpuCreateInstance(descriptor != null ? descriptor.address() : MemorySegment.NULL),
                WGPU.arena);

    }

}
