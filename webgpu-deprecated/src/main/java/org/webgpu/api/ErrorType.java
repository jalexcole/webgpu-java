package org.webgpu.api;

public enum ErrorType {
    NO_ERROR(1),
    VALIDATION(2),
    
    OUT_OF_MEMORY(3),
        
    INTERNAL(4),
    UNKNOWN(5);

    private final int value;

    ErrorType(int value) {
        this.value = value;
    }

    public int value() {
        return value;
    }
}
