module org.webgpu.api {
    requires org.webgpu.annotations;

    exports org.webgpu.api;
    exports org.webgpu.api.spi to org.webgpu.impl;

    uses org.webgpu.api.spi.InstanceInjector;
}