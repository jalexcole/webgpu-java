package org.webgpu.api;

import java.util.Arrays;

import org.webgpu.foreign.webgpu_h;

public enum QueryType {

    OCCLUSION(webgpu_h.WGPUQueryType_Occlusion()),
    TIMESTAMP(webgpu_h.WGPUQueryType_Timestamp()),
    FORCE32(webgpu_h.WGPUQueryType_Force32());

    private final int value;

    QueryType(int value) {
        this.value = value;
    }

    public int value() {
        return value;
    }

    public static QueryType fromValue(int value) {
        for (QueryType level : QueryType.values()) {
            if (level.value == value) {
                return level;
            }
        }
        throw new IllegalArgumentException("Invalid value: " + value + ". Must be one of: " + Arrays.toString(QueryType.values()));
    }
}