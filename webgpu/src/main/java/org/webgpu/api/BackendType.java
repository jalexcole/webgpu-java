package org.webgpu.api;

import org.webgpu.extract.webgpu_h;

public enum BackendType {
    UNDEFINED(webgpu_h.WGPUBackendType_Undefined()),
    NULL(webgpu_h.WGPUBackendType_Null()),
    WEBGPU(webgpu_h.WGPUBackendType_WebGPU()),
    D3D11(webgpu_h.WGPUBackendType_D3D11()),
    D3D12(webgpu_h.WGPUBackendType_D3D12()),
    Metal(webgpu_h.WGPUBackendType_Metal()),
    Vulkan(webgpu_h.WGPUBackendType_Vulkan()),
    OpenGL(webgpu_h.WGPUBackendType_OpenGL()),
    OpenGLES(webgpu_h.WGPUBackendType_OpenGLES());

    private final int value;

    BackendType(int value) {
        this.value = value;
    }

    public int value() {
        return value;
    }
}
