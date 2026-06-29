package org.webgpu.api;

import java.util.concurrent.Future;

public interface ShaderModule {

    public Future<CompilationInfo> getCompilationInfo();

    public void setLabel(String label);

    public void addRef();

    public void release();

}
