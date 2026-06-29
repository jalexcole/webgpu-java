package org.webgpu.api;

import org.webgpu.panama.foreign.webgpu_h;

/**
 * The {@link VertexFormat} of a vertex attribute indicates how data from a
 * vertex buffer will be interpreted and exposed to the shader. The name of the
 * format specifies the order of components, bits per component, and vertex
 * data type for the component
 */
public enum VertexFormat {
    U_INT_8(webgpu_h.WGPUVertexFormat_Uint8()),
    U_INT_8_2(webgpu_h.WGPUVertexFormat_Uint8x2()),
    U_INT_8_4(webgpu_h.WGPUVertexFormat_Uint8x4()),
    S_INT_8(webgpu_h.WGPUVertexFormat_Sint8()),
    S_INT_8_2(webgpu_h.WGPUVertexFormat_Sint8x2()),
    S_INT_8_4(webgpu_h.WGPUVertexFormat_Sint8x4()),
    U_INT_16(webgpu_h.WGPUVertexFormat_Uint16()),
    U_INT_16_2(webgpu_h.WGPUVertexFormat_Uint16x2()),
    U_INT_16_4(webgpu_h.WGPUVertexFormat_Uint16x4()),
    S_INT_16(webgpu_h.WGPUVertexFormat_Sint16()),
    S_INT_16_2(webgpu_h.WGPUVertexFormat_Sint16x2()),
    S_INT_16_4(webgpu_h.WGPUVertexFormat_Sint16x4()),
    U_NORM_16(webgpu_h.WGPUVertexFormat_Unorm16()),
    U_NORM_16_2(webgpu_h.WGPUVertexFormat_Unorm16x2()),
    U_NORM_16_4(webgpu_h.WGPUVertexFormat_Unorm16x4()),
    S_NORM_16(webgpu_h.WGPUVertexFormat_Snorm16()),
    S_NORM_16_2(webgpu_h.WGPUVertexFormat_Snorm16x2()),
    S_NORM_16_4(webgpu_h.WGPUVertexFormat_Snorm16x4()),
    FLOAT16(webgpu_h.WGPUVertexFormat_Float16()),
    FLOAT_16_2(webgpu_h.WGPUVertexFormat_Float16x2()),
    FLOAT_16x4(webgpu_h.WGPUVertexFormat_Float16x4()),
    FLOAT_32(webgpu_h.WGPUVertexFormat_Float32()),
    FLOAT_32_2(webgpu_h.WGPUVertexFormat_Float32x2()),
    FLOAT_32_3(webgpu_h.WGPUVertexFormat_Float32x3()),
    FLOAT_32_4(webgpu_h.WGPUVertexFormat_Float32x4()),
    U_INT_32(webgpu_h.WGPUVertexFormat_Uint32()),
    U_INT_32_2(webgpu_h.WGPUVertexFormat_Uint32x2()),
    U_INT_32_4(webgpu_h.WGPUVertexFormat_Uint32x4()),
    S_INT_32(webgpu_h.WGPUVertexFormat_Sint32()),
    S_INT_32_2(webgpu_h.WGPUVertexFormat_Sint32x2()),
    S_INT_32_3(webgpu_h.WGPUVertexFormat_Sint32x3()),
    S_INT_32_4(webgpu_h.WGPUVertexFormat_Sint32x4()),
    U_NORM_10_10_10_2(webgpu_h.WGPUVertexFormat_Unorm10_10_10_2()),
    U_NORM_8_4_BGRA(webgpu_h.WGPUVertexFormat_Unorm8x4BGRA()),
    FORCE_32(webgpu_h.WGPUVertexFormat_Force32());

    private final int value;

    VertexFormat(int value) {
        this.value = value;
    }

    public int value() {
        return value;
    }

    public static VertexFormat fromValue(int value) {
        for (VertexFormat format : VertexFormat.values()) {
            if (format.value == value) {
                return format;
            }
        }
        return null;
    }
}
