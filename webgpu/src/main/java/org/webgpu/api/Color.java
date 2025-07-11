package org.webgpu.api;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;

import org.webgpu.extract.WGPUColor;

public class Color implements ObjectBase {
    private MemorySegment colorPtr;

    public Color() {
        try {
            Arena arena = Arena.ofAuto();
            colorPtr = WGPUColor.allocate(arena);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
            
        
    }
    
    public Color(float r, float g, float b, float a) {
        try  {
            Arena arena = Arena.ofAuto();
            colorPtr = WGPUColor.allocate(arena);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        
        WGPUColor.r(ptr(), r);
        WGPUColor.g(ptr(), g);
        WGPUColor.b(ptr(), b);
        WGPUColor.a(ptr(), a);
    }

    public float r() {
        return (float) WGPUColor.r(ptr());
    }
    
    public float g() {
        return (float) WGPUColor.g(ptr());
    }
    
    public float b() {
        return (float) WGPUColor.b(ptr());
    }
    
    public float a() {
        return (float) WGPUColor.a(ptr());
    }

    @Override
    public MemorySegment ptr() {
        return colorPtr;
    }

    @Override
    public String toString() {
        return "Color{" +
                "r=" + r() +
                ", g=" + g() +
                ", b=" + b() +
                ", a=" + a() +
                '}';
    }

    
}