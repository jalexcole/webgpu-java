package org.webgpu.impl;

import java.lang.foreign.MemorySegment;
import java.util.concurrent.Future;

import org.webgpu.api.CompilationInfo;
import org.webgpu.api.ShaderModule;
import org.webgpu.panama.foreign.webgpu_h;

public record ShaderModuleImpl(MemorySegment ptr) implements ShaderModule {

    @Override
    public Future<CompilationInfo> getCompilationInfo() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getCompilationInfo'");
    }

    @Override
    public void setLabel(String label) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setLabel'");
    }

    @Override
    public void addRef() {
        webgpu_h.wgpuShaderModuleAddRef(ptr);
    }

    @Override
    public void release() {
        webgpu_h.wgpuShaderModuleRelease(ptr);
    }

}
