package org.webgpu.api.exceptions;

public class WebGPUException extends RuntimeException {
    public WebGPUException(String message) {
        super(message);
    }

    public WebGPUException(String message, Throwable cause) {
        super(message, cause);
    }

    public WebGPUException(Throwable cause) {
        super(cause);
    }

    
    
}
