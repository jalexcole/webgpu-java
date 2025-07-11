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

}
