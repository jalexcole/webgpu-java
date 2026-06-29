package org.webgpu.util;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.ValueLayout;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.webgpu.panama.foreign.WGPULogCallback;
import org.webgpu.panama.foreign.WGPUStringView;
import org.webgpu.panama.foreign.webgpu_h;

public class LoggerUtil {
    private static final Logger logger = LoggerFactory.getLogger(LoggerUtil.class);
    private static final Logger loggerWGPU = LoggerFactory.getLogger("WGPU");
    private static boolean initialized = false;
    private static final Arena arena = Arena.global();

    public static void initialize() {
        // Initialize logger here if needed

        if (!initialized) {
            loggable();
            initialized = true;
        }
    }

    private static void loggable() {
        final MemorySegment callbackHandlePtr = WGPULogCallback.allocate(new WGPULogCallback.Function() {
            @Override
            public void apply(int level, MemorySegment message, MemorySegment userdata) {
                logger.info("Initializing WGPU logger...");
                logger.info("Reading message as bytebuffer: {} ", message.asByteBuffer());
                String msg;
                try (Arena callbackArena = Arena.ofConfined()) {
                    msg = (message != null && message.address() != 0)
                            ? StringView.map(message)
                            : "(no message from native)";
                } catch (Exception ex) {
                    msg = "(failed to extract message: " + ex.getMessage() + ")";
                }

                if (level == webgpu_h.WGPULogLevel_Error()) {
                    loggerWGPU.error(msg);
                } else if (level == webgpu_h.WGPULogLevel_Warn()) {
                    loggerWGPU.warn(msg);
                } else if (level == webgpu_h.WGPULogLevel_Info()) {
                    loggerWGPU.info(msg);
                } else if (level == webgpu_h.WGPULogLevel_Debug()) {
                    loggerWGPU.debug(msg);
                } else if (level == webgpu_h.WGPULogLevel_Trace()) {
                    loggerWGPU.trace(msg);
                } else if (level == webgpu_h.WGPULogLevel_Off()) {
                    loggerWGPU.info("WGPU logging turned off.");
                } else {
                    throw new IllegalArgumentException("Unknown log level: " + level);
                }

            }
        }, arena);

        final var stringViewPtr = WGPUStringView.allocate(arena);
        final var userDataPtr = arena.allocate(ValueLayout.ADDRESS);

        if (loggerWGPU.isErrorEnabled()) {
            logger.trace("Logger initialized");
            WGPULogCallback.invoke(callbackHandlePtr, webgpu_h.WGPULogLevel_Error(), stringViewPtr, userDataPtr);
        } else if (loggerWGPU.isWarnEnabled()) {
            logger.trace("Logger initialized");
            WGPULogCallback.invoke(callbackHandlePtr, webgpu_h.WGPULogLevel_Warn(), stringViewPtr, userDataPtr);
        } else if (loggerWGPU.isInfoEnabled()) {
            logger.trace("Logger initialized");
            WGPULogCallback.invoke(callbackHandlePtr, webgpu_h.WGPULogLevel_Info(), stringViewPtr, userDataPtr);
        } else if (loggerWGPU.isDebugEnabled()) {
            logger.trace("Logger initialized");
            WGPULogCallback.invoke(callbackHandlePtr, webgpu_h.WGPULogLevel_Debug(), stringViewPtr, userDataPtr);
        } else if (loggerWGPU.isTraceEnabled()) {
            logger.trace("Logger initialized");
            WGPULogCallback.invoke(callbackHandlePtr, webgpu_h.WGPULogLevel_Trace(), stringViewPtr, userDataPtr);
        }
    }

}
