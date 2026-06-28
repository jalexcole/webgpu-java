package org.webgpu.impl.spi;

import org.webgpu.panama.NativeLibraryLoader;

public abstract class NativeEntrant {

    static {
        NativeLibraryLoader.loadLibrary();
    }

}
