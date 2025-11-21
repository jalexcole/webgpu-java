package org.webgpu.api;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;

public class WGPUTest {


    @Test
    void testCreateInstance_NullDescriptor() {
        var nullDescriptorInstance = WGPU.createInstance(null);

        assertNotNull(nullDescriptorInstance);

        var descriptorInstance = new InstanceDescriptor();
        assertNotNull(WGPU.createInstance(descriptorInstance));
    }

    @Test
    void testCreateInstance_WithDescriptor() {
        var descriptor = new InstanceDescriptor();
        var instance = WGPU.createInstance(descriptor);

        assertNotNull(instance);
    }
   
}
