package org.webgpu.api;

public enum FeatureName {
    UNDEFINED(0),
    DEPTH_CLIP_CONTROL(1),
    DEPTH32FLOAT(2),
    TIMESTAMP_QUERY(3),
    PIPELINE_STATISTICS_QUERY(4),
    TEXTURE_COMPRESSION_BC(5),
    TEXTURE_COMPRESSION_ETC2(6),
    TEXTURE_COMPRESSION_ASTC(7),
    INDIRECT_FIRST_INSTANCE(8),
    SHADER_F16(9),
    RG11B10UFLOAT(10),
    RG11B10UFLOAT_RENDERABLE(11),
    BGR10A2UNORM(12),
    FLOAT32_FILTERABLE(13),
    FLOAT32_BLENDABLE(14),
    CLIP_DISTANCES(15),
    DUAL_SOURCE_BLENDING(16),
    FORCE32(0x7FFFFFFF);

    private final int value;

    FeatureName(int value) {
        this.value = value;
    }

    public int value() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'value'");
    }

    public static FeatureName fromValue(int value) {
        if (value == 0) {
            return UNDEFINED;
        } else if (value == 1) {
            return DEPTH_CLIP_CONTROL;
        } else if (value == 2) {
            return DEPTH32FLOAT;
        } else if (value == 3) {
            return TIMESTAMP_QUERY;
        } else if (value == 4) {
            return PIPELINE_STATISTICS_QUERY;
        } else if (value == 5) {
            return TEXTURE_COMPRESSION_BC;
        } else if (value == 6) {
            return TEXTURE_COMPRESSION_ETC2;
        } else if (value == 7) {
            return TEXTURE_COMPRESSION_ASTC;
        } else if (value == 8) {
            return INDIRECT_FIRST_INSTANCE;
        } else if (value == 9) {
            return SHADER_F16;
        } else if (value == 10) {
            return RG11B10UFLOAT;
        } else if (value == 11) {
            return RG11B10UFLOAT_RENDERABLE;
        } else if (value == 12) {
            return BGR10A2UNORM;
        } else if (value == 13) {
            return FLOAT32_FILTERABLE;
        } else if (value == 14) {
            return FLOAT32_BLENDABLE;
        } else if (value == 15) {
            return CLIP_DISTANCES;
        } else if (value == 16) {
            return DUAL_SOURCE_BLENDING;
        } else if (value == 0x7FFFFFFF) {
            return FORCE32;
        }
        throw new IllegalArgumentException("Unknown value: " + value);
        
    }

}
