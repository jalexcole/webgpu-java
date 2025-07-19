package org.webgpu.api;



public interface ComputePassEncoder extends ObjectBase, CommandsMixin, DebugCommandsMixin, BindingCommandsMixin{

    public void setPipeline(ComputePipeline pipeline);
    
    public default void dispatchWorkgroups(int workgroupCountX) {
        dispatchWorkgroups(workgroupCountX, 1, 1);
    }

    public void dispatchWorkgroups(int workgroupCountX, int workgroupCountY, int workgroupCountZ);
    
    public void dispatchWorkgroupsIndirect(Buffer indirectBuffer, long indirectOffset);

    public void end();
}
