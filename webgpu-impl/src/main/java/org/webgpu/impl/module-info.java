module org.webgpu.impl {
    requires org.webgpu.annotations;
    requires org.webgpu.api;
    requires org.webgpu.panama;
    requires java.logging;

    

    provides org.webgpu.api.spi.InstanceInjector with org.webgpu.impl.spi.InstanceInjectorImpl;
}
