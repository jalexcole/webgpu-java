package org.webgpu.api;

import java.lang.foreign.MemorySegment;

import org.jspecify.annotations.NonNull;
import org.webgpu.exceptions.RequestAdaptorError;
import org.webgpu.extract.webgpu_h;



public class WebGPUInstance {
    @SuppressWarnings("preview")
    private MemorySegment memorySegment;

    WebGPUInstance(@SuppressWarnings("preview") MemorySegment memorySegment) {
        this.memorySegment = memorySegment;
    }

    /**
     * Retrieves an Adapter which matches the given RequestAdapterOptions.
     * 
     * Some options are “soft”, so treated as non-mandatory. Others are “hard”.
     * 
     * If no adapters are found that satisfy all the “hard” options, an error is
     * returned.
     * 
     * When targeting WebGL2, a compatible_surface must be specified; using
     * RequestAdapterOptions::default() will not succeed.
     * 
     * @return
     * @throws RequestAdaptorError
     */
    public Adapter requestAdapter() throws RequestAdaptorError {
        // webgpu_h.wgpuInstanceRequestAdapter(memorySegment);
        throw new UnsupportedOperationException("Unimplemented method 'requestAdapter'");
    }

    /**
     * Retrieves an Adapter which matches the given RequestAdapterOptions.
     * 
     * Some options are “soft”, so treated as non-mandatory. Others are “hard”.
     * 
     * If no adapters are found that satisfy all the “hard” options, an error is
     * returned.
     * 
     * When targeting WebGL2, a compatible_surface must be specified; using
     * RequestAdapterOptions::default() will not succeed.
     * 
     * @param options
     * @return
     * @throws RequestAdaptorError
     */
    public Adapter requestAdapter(@NonNull RequestAdapterOptions options) throws RequestAdaptorError {
        throw new UnsupportedOperationException("Unimplemented method 'requestAdapter'");
    }

    /**
     * @return The memory address of the instance.
     */
    public long address() {
        return memorySegment.address();
    }

    
}
