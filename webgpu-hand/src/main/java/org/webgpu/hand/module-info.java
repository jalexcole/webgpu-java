module hand {
    requires webgpu.api;
    requires webgpu.panama;
    provides org.webgpu.api.InstanceBuilder with org.webgpu.hand.spi.DefaultInstanceBuilder;
}
