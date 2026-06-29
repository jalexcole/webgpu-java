package org.webgpu.exceptions;

public class AdapterConsumedException extends RuntimeException {
    public AdapterConsumedException() {
        super("Adapter has been consumed by creating a device,and cannot be used anymore.");
    }

    public AdapterConsumedException(String message) {
        super(message);
    }

    public AdapterConsumedException(String message, Throwable cause) {
        super(message, cause);
    }

    public AdapterConsumedException(Throwable cause) {
        super(cause);
    }
}
