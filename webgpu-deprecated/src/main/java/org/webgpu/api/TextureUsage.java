package org.webgpu.api;

public enum TextureUsage {
    NONE(0l),
    COPY_SRC(1L),
    COPY_DST(2L),
    TEXTURE_BINDING(4L),
    STORAGE_BINDING(8L),
    RENDER_ATTACHMENT(10L);

    private final long value;

    TextureUsage(long value) {
        this.value = value;
    }

    public long value() {
        return value;
    }

    public static TextureUsage fromValue(long value) {
        if (value == NONE.value)
            return NONE;
        if (value == COPY_SRC.value)
            return COPY_SRC;
        if (value == COPY_DST.value)
            return COPY_DST;
        if (value == TEXTURE_BINDING.value)
            return TEXTURE_BINDING;
        if (value == STORAGE_BINDING.value)
            return STORAGE_BINDING;
        if (value == RENDER_ATTACHMENT.value)
            return RENDER_ATTACHMENT;

        throw new IllegalArgumentException("Invalid TextureUsage value: " + value);
    }
}
