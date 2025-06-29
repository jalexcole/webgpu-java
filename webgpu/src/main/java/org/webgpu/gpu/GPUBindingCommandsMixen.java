package org.webgpu.gpu;

import java.util.Optional;

public interface GPUBindingCommandsMixen {
    void setBindGroup(int index, GPUBindGroup bindGroup,
        Optional<GPUBufferDynamicOffset[]> dynamicOffsets);

    void setBindGroup(int index, GPUBindGroup bindGroup,
        int[] dynamicOffsetsData,
        long dynamicOffsetsDataStart,
        int dynamicOffsetsDataLength);
}
