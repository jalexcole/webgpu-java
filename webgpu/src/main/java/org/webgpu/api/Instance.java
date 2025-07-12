package org.webgpu.api;

import java.util.concurrent.Future;

import org.jspecify.annotations.Nullable;
import org.webgpu.exceptions.RequestAdaptorError;

public interface Instance extends AutoCloseable {
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
     * @return Adapter
     * @throws RequestAdaptorError
     */
    public Future<Adapter> requestAdapter(@Nullable RequestAdapterOptions options) throws RequestAdaptorError;
}
