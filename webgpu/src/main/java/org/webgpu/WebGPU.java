package org.webgpu;

import java.lang.foreign.MemorySegment;
import java.util.Map;

import org.jspecify.annotations.NonNull;
import org.webgpu.extract.webgpu_h;



public class WebGPU {
    static {
        try {
            System.load("/Users/alex/dev/webgpu-java/webgpu/src/main/resources/libwgpu_native.dylib");
        } catch (SecurityException e) {
            System.out.println(e.getMessage());
        } catch (final UnsatisfiedLinkError e) {
            System.out.println(e.getMessage());
        }
    }

    private WebGPU() {
       var descriptor = webgpu_h.wgpuCreateInstance$descriptor();

       

    }

    public static WebGPUInstance createInstance() {
        return new WebGPUInstance(webgpu_h.wgpuCreateInstance(MemorySegment.NULL));
    }

    public static WebGPUInstance createInstance(@NonNull InstanceDescriptor descriptor) {
        return new WebGPUInstance(webgpu_h.wgpuCreateInstance(descriptor.address()));
    }

    public static void instanceRequestAdapter(WebGPUInstance instance) {
        // webgpu_h.wgpuInstanceRequestAdapter(null, null, null, null)
    }

    public static Adapter requestAdapterSync(WebGPUInstance instance) {
        
        throw new UnsupportedOperationException("Unimplemented method 'requestAdapterSync'");
    }

    



    public static void main(String[] args) {
        System.out.println("Hello World!");

        new WebGPU();
        WebGPUInstance instance = WebGPU.createInstance();
    }
}