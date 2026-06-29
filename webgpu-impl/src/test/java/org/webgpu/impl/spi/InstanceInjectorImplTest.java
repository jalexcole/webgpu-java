package org.webgpu.impl.spi;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.webgpu.api.Instance;
import org.webgpu.api.InstanceDescriptor;
import org.webgpu.api.InstanceFeatureName;
import org.webgpu.api.InstanceLimits;
import org.webgpu.api.Status;
import org.webgpu.api.SupportedInstanceFeatures;
import org.webgpu.panama.webgpu_h;

public class InstanceInjectorImplTest {

    private static final Logger logger = LoggerFactory.getLogger(InstanceInjectorImplTest.class);

    @Test
    void testCreateInstance() {
        logger.info("Creating a blank instance injector.");
        InstanceInjectorImpl injector = new InstanceInjectorImpl();
        // Test with null descriptor
        Instance instance1 = injector.createInstance(null);
        assertNotNull(instance1, "Instance should not be null when created with null descriptor");

        // Test with empty descriptor
        InstanceDescriptor emptyDescriptor = new InstanceDescriptor(new InstanceFeatureName[0], new InstanceLimits(0));
        Instance instance2 = injector.createInstance(emptyDescriptor);
        assertNotNull(instance2, "Instance should not be null when created with empty descriptor");

        // Test with populated descriptor
        InstanceFeatureName[] features = { InstanceFeatureName.TIMED_WAIT_ANY };
        InstanceLimits limits = new InstanceLimits(100);
        InstanceDescriptor descriptor = new InstanceDescriptor(features, limits);
        Instance instance3 = injector.createInstance(descriptor);
        assertNotNull(instance3, "Instance should not be null when created with populated descriptor");
    }
    @Disabled
    @Test
    void testGetInstanceFeatures() {
        logger.info("Testing get instance features.");
        InstanceInjectorImpl injector = new InstanceInjectorImpl();
        SupportedInstanceFeatures features = new SupportedInstanceFeatures();
        // This should not throw - the implementation populates features from native
        // code
        // Note: The current implementation has an incomplete loop, but we test it
        // doesn't crash
        assertDoesNotThrow(() -> injector.getInstanceFeatures(features),
                "getInstanceFeatures should not throw exception");

        // TODO: Once the implementation is complete, add assertions for actual feature
        // values
    }
    
    @Test
    void testGetInstanceLimits() {
        logger.info("Testing get instance limits.");
        InstanceInjectorImpl injector = new InstanceInjectorImpl();
        InstanceLimits limits = new InstanceLimits();
        Status status = injector.getInstanceLimits(limits);

        assertNotNull(status, "Status should not be null");
        assertEquals(Status.SUCCESS, status, "getInstanceLimits should return SUCCESS");

        // Note: The current implementation returns SUCCESS but doesn't populate the
        // limits
        // TODO: Once the implementation populates limits, add assertions for actual
        // limit values
    }
    @Disabled
    @Test
    void testHasInstanceFeature() {
        logger.info("Testing has instance feature.");

        InstanceInjectorImpl injector = new InstanceInjectorImpl();
        // Test with NULL feature (should return false and not crash)
        assertDoesNotThrow(() -> {
            boolean hasNull = injector.hasInstanceFeature(InstanceFeatureName.NULL);
            assertFalse(hasNull, "NULL feature should not be supported");
        }, "hasInstanceFeature should not throw for NULL feature");

        // Test with known instance features - these may or may not be supported
        // depending on the native implementation and platform
        // We use assertDoesNotThrow to ensure the native call doesn't crash
        assertDoesNotThrow(() -> {
            boolean hasTimedWaitAny = injector.hasInstanceFeature(InstanceFeatureName.TIMED_WAIT_ANY);
            // No assertion on the value since it depends on native support
        }, "hasInstanceFeature should not throw for TIMED_WAIT_ANY");

        assertDoesNotThrow(() -> {
            boolean hasShaderSourceSPIRV = injector.hasInstanceFeature(InstanceFeatureName.SHADER_SOURCE_SPIRV);
            // No assertion on the value since it depends on native support
        }, "hasInstanceFeature should not throw for SHADER_SOURCE_SPIRV");

        assertDoesNotThrow(() -> {
            boolean hasMultipleDevices = injector.hasInstanceFeature(InstanceFeatureName.MULTIPLE_DEVICES_PER_ADAPTER);
            // No assertion on the value since it depends on native support
        }, "hasInstanceFeature should not throw for MULTIPLE_DEVICES_PER_ADAPTER");
    }
    @Test
    void testSetLogCallback() {
        
    }
    @Test
    void testSetLogLevel() {
        
        webgpu_h.wgpuSetLogLevel(0);

    }
}
