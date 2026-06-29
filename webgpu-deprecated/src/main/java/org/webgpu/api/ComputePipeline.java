package org.webgpu.api;


public interface ComputePipeline extends PipelineBase, ObjectBase {
    

    public BindGroupLayout getBindGroupLayout(int groupIndex);

    public void setLabel(String label);

    public void addRef();

    public void release();
}
