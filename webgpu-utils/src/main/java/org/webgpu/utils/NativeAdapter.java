package org.webgpu.utils;

public interface NativeAdapter<T, U> {
    

    public U adapt(T t);
}
