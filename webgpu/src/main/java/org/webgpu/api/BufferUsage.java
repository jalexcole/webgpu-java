package org.webgpu.api;

import java.util.Arrays;

import org.webgpu.foreign.webgpu_h;

public enum BufferUsage {
    NONE(0L),
    MAP_READ(1L),
    MAP_WRITE(2L),
    COPY_SRC(4L),
    COPY_DST(8L),
    INDEX(10L),
    VERTEX(20L),
    UNIFORM(40L),
    STORAGE(80L),
    INDIRECT(100L),
    QUERY_RESOLVE(200L);
            
    private final long value;

    BufferUsage(long value) {
        this.value = value;
    }

    public long value() {
        return value;
    }

    public static BufferUsage fromValue(long value) {
        for (BufferUsage level : BufferUsage.values()) {
            if (level.value == value) {
                return level;
            }
        }
        throw new IllegalArgumentException("Invalid value: " + value + ". Must be one of: " + Arrays.toString(BufferUsage.values()));
    }
}
