package org.webgpu.panama;

import java.lang.foreign.Arena;

import org.junit.jupiter.api.Test;

public class NativeLibraryLoaderTest {
    
    @Test
    public void createWebGPULookupTest() {
        NativeLibraryLoader.createWebGPULookup();
    }
    @Test
    public void getLibraryArenaTest() {
        NativeLibraryLoader.getLibraryArena();
    }
    @Test
    public void loadLibraryTest() {
        NativeLibraryLoader.loadLibrary();
        WGPUAdapterInfo.allocate(Arena.ofAuto()) ;
    }
}
