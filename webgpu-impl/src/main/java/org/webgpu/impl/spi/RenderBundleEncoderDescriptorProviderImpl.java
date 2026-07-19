package org.webgpu.impl.spi;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.ValueLayout;

import org.webgpu.api.TextureFormat;
import org.webgpu.api.spi.RenderBundleEncoderDescriptorProvider;
import org.webgpu.impl.util.StringViewMapper;
import org.webgpu.panama.WGPURenderBundleEncoderDescriptor;
import org.webgpu.panama.webgpu_h;

/**
 * RenderBundleEncoderDescriptorProviderImpl
 */
public class RenderBundleEncoderDescriptorProviderImpl implements RenderBundleEncoderDescriptorProvider {
    private final Arena arena = Arena.ofAuto();

    @Override
    public MemorySegment initializer() {
        return WGPURenderBundleEncoderDescriptor.allocate(arena);
    }

    @Override
    public String label(MemorySegment structPtr) {
        return StringViewMapper.map(WGPURenderBundleEncoderDescriptor.label(structPtr));
    }

    @Override
    public TextureFormat[] colorFormats(MemorySegment structPtr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'colorFormats'");
    }

    @Override
    public TextureFormat depthStencilFormat(MemorySegment structPtr) {
        final int depthStencilFormatValue = WGPURenderBundleEncoderDescriptor.depthStencilFormat(structPtr);
        return TextureFormat.values()[depthStencilFormatValue];
    }

    @Override
    public int sampleCount(MemorySegment structPtr) {
        return WGPURenderBundleEncoderDescriptor.sampleCount(structPtr);
    }

    @Override
    public boolean depthReadOnly(MemorySegment structPtr) {
        return WGPURenderBundleEncoderDescriptor.depthReadOnly(structPtr) == webgpu_h.WGPU_TRUE();
    }

    @Override
    public boolean stencilReadOnly(MemorySegment structPtr) {
        return WGPURenderBundleEncoderDescriptor.stencilReadOnly(structPtr) == webgpu_h.WGPU_TRUE();
    }

    @Override
    public void label(MemorySegment structPtr, String label) {
        final MemorySegment labelSegment = StringViewMapper.map(label, arena);
        WGPURenderBundleEncoderDescriptor.label(structPtr, labelSegment);
    }

    @Override
    public void colorFormats(MemorySegment structPtr, TextureFormat[] colorFormats) {
        if (colorFormats == null || colorFormats.length == 0) {
            WGPURenderBundleEncoderDescriptor.colorFormats(structPtr, MemorySegment.NULL);
            WGPURenderBundleEncoderDescriptor.colorFormatCount(structPtr, 0);
            return;
        }
        final MemorySegment colorFormatsPtr = arena.allocate(ValueLayout.JAVA_INT, colorFormats.length);
        for (int i = 0; i < colorFormats.length; i++) {
            colorFormatsPtr.setAtIndex(ValueLayout.JAVA_INT, i, colorFormats[i].value());
        }
        WGPURenderBundleEncoderDescriptor.colorFormats(structPtr, colorFormatsPtr);
        WGPURenderBundleEncoderDescriptor.colorFormatCount(structPtr, colorFormats.length);
    }

    @Override
    public void depthStencilFormat(MemorySegment structPtr, TextureFormat depthStencilFormat) {
        WGPURenderBundleEncoderDescriptor.depthStencilFormat(structPtr, depthStencilFormat.value());
    }

    @Override
    public void sampleCount(MemorySegment structPtr, int sampleCount) {
        WGPURenderBundleEncoderDescriptor.sampleCount(structPtr, sampleCount);
    }

    @Override
    public void depthReadOnly(MemorySegment structPtr, boolean depthReadOnly) {
        WGPURenderBundleEncoderDescriptor.depthReadOnly(structPtr,
                depthReadOnly ? webgpu_h.WGPU_TRUE() : webgpu_h.WGPU_FALSE());
    }

    @Override
    public void stencilReadOnly(MemorySegment structPtr, boolean stencilReadOnly) {
        WGPURenderBundleEncoderDescriptor.stencilReadOnly(structPtr,
                stencilReadOnly ? webgpu_h.WGPU_TRUE() : webgpu_h.WGPU_FALSE());
    }

}
