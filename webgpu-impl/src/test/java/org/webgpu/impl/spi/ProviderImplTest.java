package org.webgpu.impl.spi;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;

import org.junit.jupiter.api.Test;
import org.webgpu.api.BlendFactor;
import org.webgpu.api.BlendOperation;
import org.webgpu.api.BufferBindingType;
import org.webgpu.panama.WGPUBlendComponent;
import org.webgpu.panama.WGPUBufferBindingLayout;

class ProviderImplTest {

    @Test
    void bufferBindingLayoutProviderMapsStructFields() {
        try (Arena arena = Arena.ofConfined()) {
            MemorySegment struct = WGPUBufferBindingLayout.allocate(arena);
            WGPUBufferBindingLayout.type(struct, BufferBindingType.UNIFORM.ordinal());
            WGPUBufferBindingLayout.hasDynamicOffset(struct, 1);
            WGPUBufferBindingLayout.minBindingSize(struct, 512L);

            BufferBindingLayoutProviderImpl provider = new BufferBindingLayoutProviderImpl();

            assertEquals(BufferBindingType.UNIFORM, provider.type(struct));
            assertTrue(provider.hasDynamicOffset(struct));
            assertEquals(512L, provider.minBindingSize(struct));
        }
    }

    @Test
    void blendComponentProviderMapsStructFields() {
        try (Arena arena = Arena.ofConfined()) {
            MemorySegment struct = WGPUBlendComponent.allocate(arena);
            WGPUBlendComponent.operation(struct, BlendOperation.ADD.ordinal());
            WGPUBlendComponent.srcFactor(struct, BlendFactor.ONE.ordinal());
            WGPUBlendComponent.dstFactor(struct, BlendFactor.ZERO.ordinal());

            BlendComponentProviderImpl provider = new BlendComponentProviderImpl();

            assertEquals(BlendOperation.ADD, provider.operation(struct));
            assertEquals(BlendFactor.ONE, provider.srcFactor(struct));
            assertEquals(BlendFactor.ZERO, provider.dstFactor(struct));
        }
    }
}
