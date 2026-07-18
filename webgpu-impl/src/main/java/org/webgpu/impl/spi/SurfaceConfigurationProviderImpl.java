package org.webgpu.impl.spi;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;
import java.util.Set;

import org.webgpu.api.CompositeAlphaMode;
import org.webgpu.api.Device;
import org.webgpu.api.PresentMode;
import org.webgpu.api.TextureFormat;
import org.webgpu.api.TextureUsage;
import org.webgpu.api.spi.SurfaceConfigurationProvider;
import org.webgpu.impl.DeviceImpl;
import org.webgpu.panama.WGPUSurfaceConfiguration;

/**
 * SurfaceConfigurationProviderImpl
 */
public class SurfaceConfigurationProviderImpl implements SurfaceConfigurationProvider {
    private final Arena arena = Arena.ofAuto();

    @Override
    public MemorySegment initializer() {
        return WGPUSurfaceConfiguration.allocate(arena);
    }

    @Override
    public Device device(MemorySegment structPtr) {
        return new DeviceImpl(WGPUSurfaceConfiguration.device(structPtr));
    }

    @Override
    public TextureFormat format(MemorySegment structPtr) {
        return TextureFormat.values()[WGPUSurfaceConfiguration.format(structPtr)];
    }

    @Override
    public Set<TextureUsage> usage(MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'usage'");
    }

    @Override
    public int width(MemorySegment structPtr) {
        return WGPUSurfaceConfiguration.width(structPtr);
    }

    @Override
    public int height(MemorySegment structPtr) {
        return WGPUSurfaceConfiguration.height(structPtr);
    }

    @Override
    public TextureFormat[] viewFormats(MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'viewFormats'");
    }

    @Override
    public CompositeAlphaMode alphaMode(MemorySegment structPtr) {
        return CompositeAlphaMode.values()[WGPUSurfaceConfiguration.alphaMode(structPtr)];
    }

    @Override
    public PresentMode presentMode(MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'presentMode'");
    }

    @Override
    public void device(MemorySegment structPtr, Device device) {
        WGPUSurfaceConfiguration.device(structPtr, ((DeviceImpl) device).ptr());
    }

    @Override
    public void format(MemorySegment structPtr, TextureFormat format) {
        WGPUSurfaceConfiguration.format(structPtr, format.value());
    }

    @Override
    public void usage(MemorySegment structPtr, Set<TextureUsage> usage) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'usage'");
    }

    @Override
    public void width(MemorySegment structPtr, int width) {
        WGPUSurfaceConfiguration.width(structPtr, width);
    }

    @Override
    public void height(MemorySegment structPtr, int height) {
        WGPUSurfaceConfiguration.height(structPtr, height);
    }

    @Override
    public void viewFormats(MemorySegment structPtr, TextureFormat[] viewFormats) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'viewFormats'");
    }

    @Override
    public void alphaMode(MemorySegment structPtr, CompositeAlphaMode alphaMode) {
        WGPUSurfaceConfiguration.alphaMode(structPtr, alphaMode.value());
    }

    @Override
    public void presentMode(MemorySegment structPtr, PresentMode presentMode) {
        WGPUSurfaceConfiguration.presentMode(structPtr, presentMode.value());
    }

}
