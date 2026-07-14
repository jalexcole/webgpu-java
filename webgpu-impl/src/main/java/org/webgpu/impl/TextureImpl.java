package org.webgpu.impl;

import java.lang.foreign.MemorySegment;
import java.util.BitSet;
import java.util.EnumSet;

import org.jspecify.annotations.NullMarked;
import org.webgpu.api.Texture;
import org.webgpu.api.TextureDimension;
import org.webgpu.api.TextureFormat;
import org.webgpu.api.TextureUsage;
import org.webgpu.api.TextureView;
import org.webgpu.api.TextureViewDescriptor;
import org.webgpu.api.TextureViewDimension;
import org.webgpu.impl.util.StructTools;
import org.webgpu.panama.webgpu_h;

@NullMarked
public class TextureImpl implements Texture {

	private final MemorySegment memorySegment;
	private boolean destroyed = false;

	public TextureImpl(MemorySegment memorySegment) {
		this.memorySegment = memorySegment;
	}

	@Override
	public TextureView createView(TextureViewDescriptor descriptor) {
		var descriptorPtr = StructTools.fetchSegment(descriptor);
		var textureViewPtr = webgpu_h.wgpuTextureCreateView(this.memorySegment, descriptorPtr);
		return new TextureViewImpl(textureViewPtr);
	}

	@Override
	public void setLabel(String label) {
		throw new UnsupportedOperationException("Unimplemented method 'setLabel'");
	}

	@Override
	public int getWidth() {
		return webgpu_h.wgpuTextureGetWidth(memorySegment);
	}

	@Override
	public int getHeight() {
		return webgpu_h.wgpuTextureGetHeight(memorySegment);
	}

	@Override
	public int getDepthOrArrayLayers() {
		return webgpu_h.wgpuTextureGetDepthOrArrayLayers(memorySegment);
	
	}

	@Override
	public int getMipLevelCount() {
		return webgpu_h.wgpuTextureGetMipLevelCount(memorySegment);
	}

	@Override
	public int getSampleCount() {
		return webgpu_h.wgpuTextureGetSampleCount(memorySegment);
	}

	@Override
	public TextureDimension getDimension() {
		var dimensionValue = webgpu_h.wgpuTextureGetDimension(memorySegment);
		return TextureDimension.values()[dimensionValue];
	}

	@Override
	public TextureViewDimension getTextureBindingViewDimension() {
		var viewDimensionValue = webgpu_h.wgpuTextureGetTextureBindingViewDimension(memorySegment);
		return TextureViewDimension.values()[viewDimensionValue];
	}

	@Override
	public TextureFormat getFormat() {
		var formatValue = webgpu_h.wgpuTextureGetFormat(memorySegment);
		return TextureFormat.values()[formatValue];
	}

	@Override
	public EnumSet<TextureUsage> getUsage() {
		final long usageValue = webgpu_h.wgpuTextureGetUsage(memorySegment);

		if (usageValue == 0) {
			return EnumSet.of(TextureUsage.NONE);
		}
		final long[] longs = new long[1];
		longs[0] = usageValue;
		final BitSet bitSet = BitSet.valueOf(longs);

		@SuppressWarnings("null")
		final EnumSet<TextureUsage> textureUsages = EnumSet.noneOf(TextureUsage.class);

		for (int i = 0; i < TextureUsage.values().length - 1; i++) {
			if (bitSet.get(i)) {
				textureUsages.add(TextureUsage.values()[i + 1]);
			}
		}

		return textureUsages;
	}

	@Override
	public void destroy() {
		if (!destroyed) {
			webgpu_h.wgpuTextureDestroy(memorySegment);
			destroyed = true;
		}
	}
    
}
