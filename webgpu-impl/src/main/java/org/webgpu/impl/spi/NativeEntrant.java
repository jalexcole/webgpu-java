package org.webgpu.impl.spi;

public abstract class NativeEntrant {

    static {
        System.loadLibrary("wgpu_native");
    }

}
