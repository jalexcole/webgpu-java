package org.webgpu.hand;

import org.junit.jupiter.api.Test;
import org.webgpu.api.Instance;
import org.webgpu.api.WGPU;

public class HandInstanceTest {
    
    @Test
    public void create() {
        Instance instance = WGPU.createInstance(null);
    }
}
