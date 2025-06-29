package org.webgpu.gpu;

public interface GPUBufferUsage {
    public static final long MAP_READ      = 0x0001;
    public static final long MAP_WRITE     = 0x0002;
    public static final long COPY_SRC      = 0x0004;
    public static final long COPY_DST      = 0x0008;
    public static final long INDEX         = 0x0010;
    public static final long VERTEX        = 0x0020;
    public static final long UNIFORM       = 0x0040;
    public static final long STORAGE       = 0x0080;
    public static final long INDIRECT      = 0x0100;
    public static final long QUERY_RESOLVE = 0x0200;
    
}
