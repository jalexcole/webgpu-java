module org.webgpu.api {
    requires org.webgpu.annotations;
    exports org.webgpu.api;

    uses org.webgpu.api.InstanceBuilder;
    uses org.webgpu.api.BoolBuilder;
    uses org.webgpu.api.StatusBuilder;
}