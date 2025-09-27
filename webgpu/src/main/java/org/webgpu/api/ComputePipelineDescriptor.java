package org.webgpu.api;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;
import java.util.Optional;

import org.webgpu.panama.foreign.WGPUComputePipelineDescriptor;
import org.webgpu.impl.PipelineLayoutImpl;
import org.webgpu.util.StringView;

public class ComputePipelineDescriptor implements PipelineDescriptorBase {
    private MemorySegment ptr;

    public ComputePipelineDescriptor() {
        Arena arena = Arena.ofAuto();
        ptr = WGPUComputePipelineDescriptor.allocate(arena);
    }

    public MemorySegment ptr() {
        return ptr;
    }

    public Optional<ChainedStruct> nextInChain() {
        return Optional.of(new ChainedStruct(WGPUComputePipelineDescriptor.nextInChain(ptr)));
    }

    public void setLabel(String label) {
        try (Arena arena = Arena.ofConfined()) {
            var stringView = StringView.of(arena, label);
            WGPUComputePipelineDescriptor.label(ptr, stringView);
        }
    }

    public String label() {
        return StringView.map(WGPUComputePipelineDescriptor.label(ptr));
    }

    public PipelineLayout layout() {
        return new PipelineLayoutImpl(WGPUComputePipelineDescriptor.layout(ptr));
    }

    /**
     * Describes the compute shader entry point of the pipeline.
     * 
     * @return
     *         {@see https://www.w3.org/TR/webgpu/#dictdef-gpucomputepipelinedescriptor}
     */
    public ComputeState compute() {

        throw new UnsupportedOperationException("Unimplemented method 'compute'");
    }

}
