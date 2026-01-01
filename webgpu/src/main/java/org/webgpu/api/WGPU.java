package org.webgpu.api;

import java.lang.foreign.Arena;
import java.lang.foreign.Linker;
import java.lang.foreign.MemorySegment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.jspecify.annotations.Nullable;
import org.webgpu.panama.foreign.webgpu_h;
import org.webgpu.impl.InstanceImpl;

public class WGPU {

    public static Arena arena = Arena.global();
    private static final Logger logger = LoggerFactory.getLogger(WGPU.class.getName());
    @SuppressWarnings("preview")
    static final Linker NATIVE_LINKER = Linker.nativeLinker();
    static {
        try {

            // System.load("/Users/alex/dev/webgpu-java/webgpu/src/test/resources/libwgpu_native.dylib");
            System.load("/usr/local/lib/libwgpu_native.dylib");
        } catch (UnsatisfiedLinkError | Exception e) {
            logger.error(e.getMessage());
        }  
    }

    @SuppressWarnings("preview")
    public static Instance createInstance(@Nullable InstanceDescriptor descriptor) {
        if (WGPU.arena == null) {
            try {
                @SuppressWarnings("preview")
                Arena arena = Arena.global();
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
