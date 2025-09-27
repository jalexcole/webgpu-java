package org.webgpu.util;

import org.junit.jupiter.api.Test;
import org.webgpu.api.WGPU;

public class LoggerUtilTest {
    @Test
    void testInitialize() {
        final var device = WGPU.createInstance(null);
        LoggerUtil.initialize();
    }
}
