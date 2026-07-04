package org.webgpu.impl;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.lang.foreign.MemorySegment;
import java.util.logging.Logger;

import org.junit.jupiter.api.Test;
import org.webgpu.api.Instance;
import org.webgpu.api.InstanceDescriptor;
import org.webgpu.api.InstanceFeatureName;
import org.webgpu.api.InstanceLimits;
import org.webgpu.api.RequestAdapterOptions;
import org.webgpu.api.WGPU;
import org.webgpu.impl.spi.InstanceInjectorImpl;

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

    @Test
    void testCreateSurface() {
        
    }

    @Test
    void testGetWGSLLanguageFeatures() {
        
    }

    @Test
    void testHasWGSLLanguageFeature() {
        
    }

    @Test
    void testProcessEvents() {
        
    }

    @Test
    void testRequestAdapter() {
        InstanceInjectorImpl injector = new InstanceInjectorImpl();

        InstanceImpl instance = (InstanceImpl) injector.createInstance(null);
        
        instance.requestAdapter((status, adapter, message) -> {
            logger.info("Request Adapter Callback: status=" + status + ", adapter=" + adapter + ", message=" + message);
            assertNotNull(status);
            assertNotNull(adapter);
            assertNotNull(message);
            assertFalse(((AdapterImpl) adapter).ptr().equals(MemorySegment.NULL));
        }, new RequestAdapterOptions());
    }

    @Test
    void testWaitAny() {
        
    }

    @Test
    void testRequestAdapter2() {
        
    }




}
