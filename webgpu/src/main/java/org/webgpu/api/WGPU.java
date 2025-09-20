package org.webgpu.api;

import java.lang.foreign.Arena;
import java.lang.foreign.Linker;
import java.lang.foreign.MemorySegment;
import java.util.logging.Logger;

import org.jspecify.annotations.Nullable;
import org.webgpu.extract.webgpu_h;
import org.webgpu.impl.InstanceImpl;

public class WGPU {
    private static final Logger logger = Logger.getLogger(WGPU.class.getName());
    public static Arena arena = Arena.ofShared();

    @SuppressWarnings("preview")
    static final Linker NATIVE_LINKER = Linker.nativeLinker();
    static {
        try {

            System.load("/home/alex/Downloads/webgpu-java/webgpu-panama/target/downloads-unzipped/lib/libwgpu_native.so");
        } catch (SecurityException e) {
            logger.severe(e.getMessage());
        } catch (final UnsatisfiedLinkError e) {
            logger.severe(e.getMessage());
        } catch(final Exception e) {
            logger.severe(e.getMessage());
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
