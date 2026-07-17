package org.webgpu.panama;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.lang.foreign.Arena;
import java.lang.foreign.Linker;
import java.lang.foreign.SymbolLookup;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

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
        WGPUAdapterInfo.allocate(Arena.ofAuto());
    }

    // @Test
    public void testloadLibrary() throws IOException {
        final var path = Path.of("/", "opt", "homebrew", "lib", "libwgpu_native.dylib");
        assertTrue(path.toFile().exists(), "Library file does not exist: " + path);
        final var file = path.toFile();
        assertTrue(file.canRead(), "Library file is not readable: " + path);
        System.loadLibrary("wgpu_native");
        System.load(path.toString());

        final SymbolLookup SYMBOL_LOOKUP = SymbolLookup
                .libraryLookup(System.mapLibraryName("wgpu_native"), Arena.ofAuto())
                .or(SymbolLookup.loaderLookup())
                .or(Linker.nativeLinker().defaultLookup());
    }

    @Test
    public void testloadLibrary2() throws IOException {
        final var path = Path.of("/", "opt", "homebrew", "lib", "libwgpu_native.dylib");
        Path original = Path.of("/opt/homebrew/lib/libwgpu_native.dylib");

        Path temp = Files.createTempFile("libwgpu_native-", ".dylib");

        Files.copy(original, temp, StandardCopyOption.REPLACE_EXISTING);

        temp.toFile().deleteOnExit();

        // Load the copied library

        // System.load(temp.toAbsolutePath().toString());
        System.loadLibrary("wgpu_native");
        final SymbolLookup SYMBOL_LOOKUP = SymbolLookup
                .libraryLookup(temp, Arena.ofAuto())
                .or(SymbolLookup.loaderLookup())
                .or(Linker.nativeLinker().defaultLookup());

        WGPUAdapterInfo.allocate(Arena.ofAuto());
    }
}
