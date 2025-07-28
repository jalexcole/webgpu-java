package org.webgpu.impl;

import java.util.logging.Logger;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.webgpu.api.BackendType;
import org.webgpu.api.Instance;
import org.webgpu.api.RequestAdapterOptions;
import org.webgpu.api.WGPU;

public class InstanceImplTest {
    private static final Logger logger = Logger.getLogger(InstanceImplTest.class.getName());

    @BeforeAll
    static void beforeAll() {
        System.setProperty("WGPU_LOG", "debug");
        System.setProperty("WGPU_BACKEND", "opengl"); // or vulkan / dx12
    }

    @Test
    void testClose() {
        try (Instance instance = WGPU.createInstance(null)) {
            instance.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Test
    void testRequestAdapterFuture() {
        try (Instance instance = WGPU.createInstance(null)) {
            instance.requestAdapter(null);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void testRequestAdapter() throws InterruptedException {
        try (Instance instance = WGPU.createInstance(null)) {
            instance.requestAdapter(null).get();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Test
    void testRequestAdapterWithOptions() {
        RequestAdapterOptions options = new RequestAdapterOptions();
        options.forceFallbackAdapter(false);
        options.backendType(BackendType.UNDEFINED);
        String string = options.toString();

        logger.info(string);
        try (Instance instance = WGPU.createInstance(null)) {

            var adapter = instance.requestAdapter(options).get();
        } catch (Exception e) {
            System.err.println(options);
            throw new RuntimeException(e);
        }
    }
}
