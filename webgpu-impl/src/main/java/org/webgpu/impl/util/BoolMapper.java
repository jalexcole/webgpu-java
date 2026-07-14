package org.webgpu.impl.util;

import org.webgpu.api.exceptions.WGPUException;
import org.webgpu.panama.webgpu_h;

public class BoolMapper {
    
    

    public static int map(boolean bool) {
        if (bool) {
            return webgpu_h.WGPU_TRUE();
        } else {
            return webgpu_h.WGPU_FALSE();
        }
    }

    public static boolean map(int value) {
        if (value == webgpu_h.WGPU_TRUE()) {
            return true;
        }

        if (value == webgpu_h.WGPU_FALSE()) {
            return false;
        }

        throw new WGPUException("");
    }

    private BoolMapper() {
        /* This utility class should not be instantiated */
    }

}
