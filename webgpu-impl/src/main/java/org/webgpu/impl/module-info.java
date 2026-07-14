
import org.webgpu.impl.spi.WGPUStructProviderRegistry;

module org.webgpu.impl {
    requires org.jspecify;
    requires org.webgpu.annotations;
    requires org.webgpu.api;
    requires org.webgpu.panama;
    requires java.logging;

    provides org.webgpu.api.spi.WGPUProvider with org.webgpu.impl.spi.WGPUProviderImpl;
    provides org.webgpu.api.spi.StructProviderRegistry with WGPUStructProviderRegistry;
}
