package org.webgpu.impl;

import java.lang.foreign.MemorySegment;
import java.util.EnumSet;

import org.webgpu.api.Texture;
import org.webgpu.api.TextureDimension;
import org.webgpu.api.TextureFormat;
import org.webgpu.api.TextureUsage;
import org.webgpu.api.TextureView;
import org.webgpu.api.TextureViewDescriptor;
import org.webgpu.api.TextureViewDimension;

public class TextureImpl implements Texture {

	private final MemorySegment memorySegment;

	public TextureImpl(MemorySegment memorySegment) {
		this.memorySegment = memorySegment;
	}

	@Override
	public TextureView createView(TextureViewDescriptor descriptor) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'createView'");
	}

	@Override
	public void setLabel(String label) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'setLabel'");
	}

	@Override
	public int getWidth() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'getWidth'");
	}

	@Override
	public int getHeight() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'getHeight'");
	}

	@Override
	public int getDepthOrArrayLayers() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'getDepthOrArrayLayers'");
	}

	@Override
	public int getMipLevelCount() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'getMipLevelCount'");
	}

	@Override
	public int getSampleCount() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'getSampleCount'");
	}

	@Override
	public TextureDimension getDimension() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'getDimension'");
	}

	@Override
	public TextureViewDimension getTextureBindingViewDimension() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'getTextureBindingViewDimension'");
	}

	@Override
	public TextureFormat getFormat() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'getFormat'");
	}

	@Override
	public EnumSet<TextureUsage> getUsage() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'getUsage'");
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'destroy'");
	}
    
}
