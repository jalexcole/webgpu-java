package org.webgpu.impl;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.logging.Logger;

import org.junit.jupiter.api.Test;
import org.webgpu.api.Instance;
import org.webgpu.api.InstanceDescriptor;
import org.webgpu.api.WGPU;

public class InstanceImplTest {

    private static final Logger logger = Logger.getLogger(InstanceImplTest.class.getName());

    @Test
    public void create() {
        Instance instance = WGPU.createInstance(null);
        logger.info("Create Instance:" + instance.toString());
        assertNotNull(instance);
    }


}
