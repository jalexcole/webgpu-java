package org.webgpu;

public class WebGPU {
    static {
        System.loadLibrary("Dawn");
    }

    WebGPU() {

    }

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
}