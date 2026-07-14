package org.webgpu.api.exceptions;

public class WGPUException extends RuntimeException {
    public WGPUException(String message) {
        super(message);
    }

    public WGPUException(String message, Throwable cause) {
        super(message, cause);
    }

    public WGPUException(Throwable cause) {
        super(cause);
    }
}
