package org.webgpu.impl;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.logging.Logger;

import org.junit.jupiter.api.Test;
import org.webgpu.api.Instance;
import org.webgpu.api.InstanceDescriptor;
import org.webgpu.api.InstanceFeatureName;
import org.webgpu.api.InstanceLimits;
import org.webgpu.api.WGPU;

public class InstanceImplTest {

    private static final Logger logger = Logger.getLogger(InstanceImplTest.class.getName());

    @Test
    public void create() {
        Instance instance = WGPU.createInstance(null);
        logger.info("Create Instance:" + instance.toString());
        assertNotNull(instance);
    }

    @Test
    public void createWithDescriptor() {
        InstanceDescriptor descriptor = new InstanceDescriptor(new InstanceFeatureName[0], new InstanceLimits(0));
        Instance instance = WGPU.createInstance(descriptor);
        logger.info("Create Instance:" + instance.toString());
        assertNotNull(instance);
    }


}
