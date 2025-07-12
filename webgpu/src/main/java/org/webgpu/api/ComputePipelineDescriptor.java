package org.webgpu.api;

import java.lang.foreign.MemorySegment;

import org.webgpu.extract.webgpu_h;

public class ComputePipelineDescriptor implements PipelineDescriptorBase {
    private MemorySegment ptr;

    public MemorySegment ptr() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'ptr'");
    }

    /**
     * Describes the compute shader entry point of the pipeline.
     * 
     * @return
     * {@see https://www.w3.org/TR/webgpu/#dictdef-gpucomputepipelinedescriptor}
     */
    public ProgramableStage compute() {
        throw new UnsupportedOperationException("Unimplemented method 'compute'");
    }

}
