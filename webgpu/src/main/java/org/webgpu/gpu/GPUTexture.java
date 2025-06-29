package org.webgpu.gpu;

import java.util.Optional;

/**
 * A texture is made up of 1d, 2d, or 3d arrays of data which can contain
 * multiple values per-element to represent things like colors. Textures can be
 * read and written in many ways, depending on the GPUTextureUsage they are
 * created with. For example, textures can be sampled, read, and written from
 * render and compute pipeline shaders, and they can be written by render pass
 * outputs. Internally, textures are often stored in GPU memory with a layout
 * optimized for multidimensional access rather than linear access.
 * 
 * One texture consists of one or more texture subresources, each uniquely
 * identified by a mipmap level and, for 2d textures only, array layer and
 * aspect.
 * 
 * A texture subresource is a subresource: each can be used in different
 * internal usages within a single usage scope.
 * 
 * Each subresource in a mipmap level is approximately half the size, in each
 * spatial dimension, of the corresponding resource in the lesser level (see
 * logical miplevel-specific texture extent). The subresource in level 0 has the
 * dimensions of the texture itself. Smaller levels are typically used to store
 * lower resolution versions of the same image. GPUSampler and WGSL provide
 * facilities for selecting and interpolating between levels of detail,
 * explicitly or automatically.
 * 
 * A "2d" texture may be an array of array layers. Each subresource in a layer
 * is the same size as the corresponding resources in other layers. For non-2d
 * textures, all subresources have an array layer index of 0.
 * 
 * Each subresource has an aspect. Color textures have just one aspect: color.
 * Depth-or-stencil format textures may have multiple aspects: a depth aspect, a
 * stencil aspect, or both, and may be used in special ways, such as in
 * depthStencilAttachment and in "depth" bindings.
 * 
 * A "3d" texture may have multiple slices, each being the two-dimensional image
 * at a particular z value in the texture. Slices are not separate subresources.
 */
public interface GPUTexture extends GPUObjectBase{
    public GPUTextureView createView(Optional<GPUTextureViewDescriptor> descriptor);

    void destroy();

    // readonly attribute
    public GPUIntegerCoordinateOut width();
    // readonly attribute
    public GPUIntegerCoordinateOut height();
    // readonly attribute
    public GPUIntegerCoordinateOut depthOrArrayLayers();
    // readonly attribute
    public GPUIntegerCoordinateOut mipLevelCount();
    // readonly attribute
    public int sampleCount();
    // readonly attribute
    public GPUTextureDimension dimension();
    // readonly attribute
    public GPUTextureFormat format();
    // readonly attribute
    public GPUFlagsConstant usage();
}
