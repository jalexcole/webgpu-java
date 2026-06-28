import org.webgpu.impl.spi.DefaultInstanceBuilder;

module org.webgpu.impl {
    requires org.webgpu.api;
    requires org.webgpu.panama;
    provides org.webgpu.api.InstanceBuilder with DefaultInstanceBuilder;
}
