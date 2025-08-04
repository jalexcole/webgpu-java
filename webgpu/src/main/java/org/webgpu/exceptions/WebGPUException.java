package org.webgpu.exceptions;

public class WebGPUException extends RuntimeException {
    public WebGPUException(String errorMessage) {
        super(errorMessage);
    }
}
