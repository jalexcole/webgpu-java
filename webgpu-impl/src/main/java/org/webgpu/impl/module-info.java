
import org.webgpu.api.spi.StructProviderRegistry;
import org.webgpu.api.spi.WGPUProvider;
import org.webgpu.impl.spi.WGPUProviderImpl;
import org.webgpu.impl.spi.WGPUStructProviderRegistry;

module org.webgpu.impl {
    requires org.jspecify;
    requires org.webgpu.annotations;
    requires org.webgpu.api;
    requires org.webgpu.panama;
    requires java.logging;
    requires panama;

    provides WGPUProvider with WGPUProviderImpl;
    provides StructProviderRegistry with WGPUStructProviderRegistry;
}
