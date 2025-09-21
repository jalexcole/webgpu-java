package org.webgpu.api;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.ValueLayout;

import org.webgpu.panama.foreign.WGPUSurfaceConfiguration;
import org.webgpu.impl.DeviceImpl;

public final class SurfaceConfiguration {

    private final MemorySegment ptr;

    public SurfaceConfiguration() {
        try {
            Arena arena = Arena.ofAuto();
            ptr = WGPUSurfaceConfiguration.allocate(arena);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public final Device device() {
        MemorySegment deviceSegment = WGPUSurfaceConfiguration.device(ptr);
        return new DeviceImpl(deviceSegment, Arena.ofAuto());
    }

    public final void setDevice(Device device) {
        MemorySegment deviceSegment = device.ptr();
        WGPUSurfaceConfiguration.device(ptr, deviceSegment);
    }

    public final TextureFormat format() {
        return TextureFormat.fromValue(WGPUSurfaceConfiguration.format(ptr));
    }

    public final void setFormat(TextureFormat format) {
        WGPUSurfaceConfiguration.format(ptr, format.value());
    }

    public final TextureUsage usage() {
        return TextureUsage.fromValue(WGPUSurfaceConfiguration.usage(ptr));
    }

    public final void setUsage(TextureUsage usage) {
        WGPUSurfaceConfiguration.usage(ptr, usage.value());
    }

    public final int width() {
        return WGPUSurfaceConfiguration.width(ptr);
    }

    public final void setWidth(int width) {
        WGPUSurfaceConfiguration.width(ptr, width);
    }

    public final int height() {
        return WGPUSurfaceConfiguration.height(ptr);
    }

    public final void setHeight(int height) {
        WGPUSurfaceConfiguration.height(ptr, height);
    }

    public final long viewFormatCount() {
        return WGPUSurfaceConfiguration.viewFormatCount(ptr);
    }

    public final void setViewFormatCount(long viewFormatCount) {
        WGPUSurfaceConfiguration.viewFormatCount(ptr, viewFormatCount);
    }

    public final TextureFormat[] viewFormats() {
        final long count = viewFormatCount();
        final TextureFormat[] formats = new TextureFormat[(int) count];

        final MemorySegment viewFormatsSegment = WGPUSurfaceConfiguration.viewFormats(ptr);

        for (int i = 0; i < count; i++) {
            formats[i] = TextureFormat.fromValue(viewFormatsSegment.get(ValueLayout.JAVA_INT, i * Integer.BYTES));
        }

        return formats;
    }

    public final void setViewFormats(TextureFormat[] viewFormats) {
        final long count = viewFormats.length;
        final MemorySegment viewFormatsSegment = WGPUSurfaceConfiguration.viewFormats(ptr);

        for (int i = 0; i < count; i++) {
            viewFormatsSegment.set(ValueLayout.JAVA_INT, i * Integer.BYTES, viewFormats[i].value());
        }

        WGPUSurfaceConfiguration.viewFormatCount(ptr, count);
        WGPUSurfaceConfiguration.viewFormats(ptr, viewFormatsSegment);
    }

    public final CompositeAlphaMode alphaMode() {
        return CompositeAlphaMode.fromValue(WGPUSurfaceConfiguration.alphaMode(ptr));
    }

    public final void setAlphaMode(CompositeAlphaMode alphaMode) {
        WGPUSurfaceConfiguration.alphaMode(ptr, alphaMode.value());
    }

    public final PresentMode presentMode() {
        return PresentMode.fromValue(WGPUSurfaceConfiguration.presentMode(ptr));
    }

    public final void setPresentMode(PresentMode presentMode) {
        WGPUSurfaceConfiguration.presentMode(ptr, presentMode.value());
    }

    public MemorySegment ptr() {
        return ptr;
    }

}
