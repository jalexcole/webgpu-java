import org.jspecify.annotations.NullMarked;

@NullMarked
module org.webgpu.api {
    requires org.webgpu.annotations;
    requires org.jspecify;
    exports org.webgpu.api;
    exports org.webgpu.api.exceptions;
    exports org.webgpu.api.spi;

    uses org.webgpu.api.spi.WGPUProvider;
    uses org.webgpu.api.spi.StructProviderRegistry;
}