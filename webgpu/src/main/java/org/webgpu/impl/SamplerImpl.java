package org.webgpu.impl;

import static org.webgpu.panama.foreign.webgpu_h.wgpuSamplerAddRef;
import static org.webgpu.panama.foreign.webgpu_h.wgpuSamplerRelease;
import static org.webgpu.panama.foreign.webgpu_h.wgpuSamplerSetLabel;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;

import org.webgpu.api.Sampler;
import org.webgpu.util.StringView;

public record SamplerImpl(MemorySegment ptr) implements Sampler {

    @Override
    public void setLabel(String label) {

        try (Arena arena = Arena.ofConfined()) {
            var stringView = StringView.of(arena, label);
            wgpuSamplerSetLabel(this.ptr, stringView);
        }

    }

    @Override
    public void addRef() {
        Integer.valueOf(0);
        wgpuSamplerAddRef(this.ptr);
    }

    @Override
    public void release() {
        wgpuSamplerRelease(this.ptr);
    }

}
