package org.webgpu.api;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;

public class WGPUTest {


    @Test
    void testCreateInstance() {
        var nullDescriptorInstance = WGPU.createInstance(null);

        assertNotNull(nullDescriptorInstance);

        var descriptorInstance = new InstanceDescriptor();
        assertNotNull(WGPU.createInstance(descriptorInstance));
    }
   
}
