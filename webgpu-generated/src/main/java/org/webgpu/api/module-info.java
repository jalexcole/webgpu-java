module org.webgpu.api {
    exports org.webgpu.api;

    requires org.webgpu.utils;

    uses org.webgpu.api.InstanceBuilder;
    uses org.webgpu.api.BoolBuilder;
    uses org.webgpu.api.StatusBuilder;
}