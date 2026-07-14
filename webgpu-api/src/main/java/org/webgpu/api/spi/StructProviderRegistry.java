package org.webgpu.api.spi;

public interface StructProviderRegistry {
    
    public <T> T get(Class<T> provider);

}
