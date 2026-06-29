package org.webgpu.util;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.concurrent.ExecutionException;

import org.junit.jupiter.api.Test;
import org.webgpu.api.InstanceDescriptor;
import org.webgpu.api.WGPU;
import org.webgpu.exceptions.RequestAdaptorError;

public class LoggerUtilTest {
    @Test
    void testInitialize() throws InterruptedException, ExecutionException, RequestAdaptorError {
        final var device = WGPU.createInstance(new InstanceDescriptor());
        LoggerUtil.initialize();

        device.requestAdapter(null).get().requestDevice(null).get();

        assertTrue(true);
    }
}
