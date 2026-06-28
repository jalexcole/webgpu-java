module org.webgpu.impl {
    requires org.webgpu.annotations;
    requires org.webgpu.api;
    requires org.webgpu.panama;
    provides org.webgpu.api.InstanceBuilder with org.webgpu.impl.spi.DefaultInstanceBuilder;
    provides org.webgpu.api.BoolBuilder with org.webgpu.impl.spi.DefaultBoolBuilder;
    provides org.webgpu.api.StatusBuilder with org.webgpu.impl.spi.DefaultStatusBuilder;
}
