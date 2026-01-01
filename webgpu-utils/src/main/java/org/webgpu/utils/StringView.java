package org.webgpu.utils;

import jpassport.annotations.Ptr;

public record StringView(@Ptr byte[] data, int size) {
    
}
