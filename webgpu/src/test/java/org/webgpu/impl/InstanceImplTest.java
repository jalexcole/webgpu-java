package org.webgpu.impl;

import org.junit.jupiter.api.Test;
import org.webgpu.api.Instance;
import org.webgpu.api.WGPU;

public class InstanceImplTest {

    @Test
    void testClose() {
        try (Instance instance = WGPU.createInstance(null)) {
            instance.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Test
    void testRequestAdapter() {
        try (Instance instance = WGPU.createInstance(null)) {
            instance.requestAdapter(null);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
