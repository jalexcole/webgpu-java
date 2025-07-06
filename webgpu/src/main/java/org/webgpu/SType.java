package org.webgpu;

import org.webgpu.extract.webgpu_h;

public enum SType {
    SHADER_SOURCE_SPIRV(webgpu_h.WGPUSType_ShaderSourceSPIRV()),
    SHADER_SOURCE_WGSL(webgpu_h.WGPUSType_ShaderSourceWGSL()),
    RENDER_PASS_MAX_DRAW_COUNT(webgpu_h.WGPUSType_RenderPassMaxDrawCount()),
    SURFACE_SOURCE_METAL_LAYER(webgpu_h.WGPUSType_SurfaceSourceMetalLayer()),
    SURFACE_SOURCE_WINDOWS_HWND(webgpu_h.WGPUSType_SurfaceSourceWindowsHWND()),
    SURFACE_SOURCE_XLIB_WINDOW(webgpu_h.WGPUSType_SurfaceSourceXlibWindow()),
    SURFACE_SOURCE_WAYLAND_SURFACE(webgpu_h.WGPUSType_SurfaceSourceWaylandSurface()),
    SURFACE_SOURCE_ANDROID_SURFACE(webgpu_h.WGPUSType_SurfaceSourceAndroidNativeWindow()),
    SURFACE_SOURCE_XCB_WINDOW(webgpu_h.WGPUSType_SurfaceSourceXCBWindow()),
    FORCE_32(webgpu_h.WGPUSType_Force32());

    public final int value;

    SType(int value) {
        this.value = value;
    }
}