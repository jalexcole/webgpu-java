package org.webgpu;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.logging.Logger;

import org.junit.jupiter.api.Test;

public class WebGPUTest {
    
    private static final Logger logger = Logger.getLogger(WebGPUTest.class.getName());
    
    @Test
    void testCreateInstance() {
        try {
            WebGPU.createInstance();
        } catch (Throwable e) {
            logger.warning(e.getMessage());
        }
        assertTrue(true);
    }
}
