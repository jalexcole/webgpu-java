package org.webgpu.impl.spi;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;
import java.util.EnumSet;
import java.util.Set;

import org.webgpu.api.BlendComponent;
import org.webgpu.api.BlendFactor;
import org.webgpu.api.BlendOperation;
import org.webgpu.api.BlendState;
import org.webgpu.api.ColorWriteMask;
import org.webgpu.api.TextureFormat;
import org.webgpu.api.spi.ColorTargetStateProvider;
import org.webgpu.impl.util.BitPacker;
import org.webgpu.panama.WGPUBlendState;
import org.webgpu.panama.WGPUColorTargetState;

public class ColorTargetStateProviderImpl implements ColorTargetStateProvider {

    private final Arena arena = Arena.ofAuto();

    @Override
    public MemorySegment initializer() {
        return WGPUColorTargetState.allocate(arena);
    }

    @Override
    public TextureFormat format(MemorySegment structPtr) {
        return TextureFormat.values()[WGPUColorTargetState.format(structPtr)];
    }

    @Override
    public BlendState blend(MemorySegment structPtr) {
        var blendPtr = WGPUColorTargetState.blend(structPtr);
        if (blendPtr == null || blendPtr.equals(MemorySegment.NULL)) {
            return null;
        }

        var blendState = new BlendState();
        var nativeBlendState = WGPUBlendState.color(blendPtr);
        var colorComponent = new BlendComponent();
        colorComponent
                .operation(BlendOperation.values()[org.webgpu.panama.WGPUBlendComponent.operation(nativeBlendState)]);
        colorComponent
                .srcFactor(BlendFactor.values()[org.webgpu.panama.WGPUBlendComponent.srcFactor(nativeBlendState)]);
        colorComponent
                .dstFactor(BlendFactor.values()[org.webgpu.panama.WGPUBlendComponent.dstFactor(nativeBlendState)]);

        var alphaComponent = new BlendComponent();
        var alphaBlend = WGPUBlendState.alpha(blendPtr);
        alphaComponent.operation(BlendOperation.values()[org.webgpu.panama.WGPUBlendComponent.operation(alphaBlend)]);
        alphaComponent.srcFactor(BlendFactor.values()[org.webgpu.panama.WGPUBlendComponent.srcFactor(alphaBlend)]);
        alphaComponent.dstFactor(BlendFactor.values()[org.webgpu.panama.WGPUBlendComponent.dstFactor(alphaBlend)]);

        blendState.color(colorComponent);
        blendState.alpha(alphaComponent);
        return blendState;
    }

    @Override
    public EnumSet<ColorWriteMask> writeMask(MemorySegment structPtr) {
        var writeMask = BitPacker.unpack(WGPUColorTargetState.writeMask(structPtr), ColorWriteMask.class);
        return writeMask instanceof EnumSet<ColorWriteMask> enumSet ? enumSet : EnumSet.copyOf(writeMask);
    }

    @Override
    public void format(MemorySegment structPtr, TextureFormat format) {
        throw new UnsupportedOperationException("Unimplemented method 'format'");
    }

    @Override
    public void blend(MemorySegment structPtr, BlendState blend) {
        throw new UnsupportedOperationException("Unimplemented method 'blend'");
    }

    @Override
    public void writeMask(MemorySegment structPtr, Set<ColorWriteMask> writeMask) {
        throw new UnsupportedOperationException("Unimplemented method 'writeMask'");
    }
}