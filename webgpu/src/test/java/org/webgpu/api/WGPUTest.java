package org.webgpu.api;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.concurrent.ExecutionException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.webgpu.api.InstanceDescriptor;
import org.webgpu.api.WGPU;
import org.webgpu.extract.webgpu_h;
import org.webgpu.impl.AdapterImpl;
import org.webgpu.impl.InstanceImpl;

public class WGPUTest {


    @Test
    void testCreateInstance() {
        var nullDescriptorInstance = WGPU.createInstance(null);

        assertNotNull(nullDescriptorInstance);

        var descriptorInstance = new InstanceDescriptor();
        assertNotNull(WGPU.createInstance(descriptorInstance));
    }
   
}
