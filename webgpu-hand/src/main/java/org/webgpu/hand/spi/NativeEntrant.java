package org.webgpu.hand.spi;

public abstract class NativeEntrant {

    static {
        System.loadLibrary("libwebgpu_native");
    }

}
