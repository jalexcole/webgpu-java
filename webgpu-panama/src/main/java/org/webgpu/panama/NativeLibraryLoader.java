package org.webgpu.panama;

import java.lang.foreign.*;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

/**
 * Centralized native library loader for WebGPU.
 * Handles loading from JAR resources and system library fallback.
 */
public final class NativeLibraryLoader {

    private static final Arena LIBRARY_ARENA = Arena.global();
    private static final String LIBRARY_NAME = "wgpu_native";

    private NativeLibraryLoader() {
        // Utility class
    }

    /**
     * Creates a SymbolLookup for the WebGPU native library.
     * First tries to load from JAR resources, then falls back to system lookup.
     * Supports all platforms that have ever run Java (Windows, Linux, macOS, Solaris, AIX, etc.)
     *
     * @return a SymbolLookup configured for wgpu_native
     */
    public static SymbolLookup createWebGPULookup() {
        SymbolLookup lookup;

        // First, try to load from resources (bundled in JAR)
        try {
            String mappedLibName = System.mapLibraryName(LIBRARY_NAME);
            String libPath = "/resources/natives/" + mappedLibName;
            try (var is = NativeLibraryLoader.class.getResourceAsStream(libPath)) {
                if (is != null) {
                    // Extract file extension from the platform-mapped library name
                    int lastDot = mappedLibName.lastIndexOf('.');
                    String extension = lastDot > 0 ? mappedLibName.substring(lastDot) : "";
                    var tempFile = Files.createTempFile("wgpu_native_", extension);
                    tempFile.toFile().deleteOnExit();
                    Files.copy(is, tempFile, StandardCopyOption.REPLACE_EXISTING);
                    lookup = SymbolLookup.libraryLookup(tempFile.toAbsolutePath().toString(), LIBRARY_ARENA);
                } else {
                    lookup = null;
                }
            }
        } catch (Exception e) {
            lookup = null;
        }

        // Fallback to system library lookup
        if (lookup == null) {
            lookup = SymbolLookup.libraryLookup(System.mapLibraryName(LIBRARY_NAME), LIBRARY_ARENA)
                    .or(SymbolLookup.loaderLookup())
                    .or(Linker.nativeLinker().defaultLookup());
        }

        return lookup;
    }

    /**
     * Loads the WebGPU native library into the JVM.
     * First tries to load from JAR resources, then falls back to system library loading.
     * Supports all platforms that have ever run Java (Windows, Linux, macOS, Solaris, AIX, etc.)
     */
    public static void loadLibrary() {
        // First, try to load from resources (bundled in JAR)
        try {
            String mappedLibName = System.mapLibraryName(LIBRARY_NAME);
            String libPath = "/resources/natives/" + mappedLibName;
            try (var is = NativeLibraryLoader.class.getResourceAsStream(libPath)) {
                if (is != null) {
                    // Extract file extension from the platform-mapped library name
                    int lastDot = mappedLibName.lastIndexOf('.');
                    String extension = lastDot > 0 ? mappedLibName.substring(lastDot) : "";
                    var tempFile = Files.createTempFile("wgpu_native_", extension);
                    tempFile.toFile().deleteOnExit();
                    Files.copy(is, tempFile, StandardCopyOption.REPLACE_EXISTING);
                    System.load(tempFile.toAbsolutePath().toString());
                    return;
                }
            }
        } catch (Exception e) {
            // Fall through to system loading
        }

        // Fallback to system library loading
        System.loadLibrary(LIBRARY_NAME);
    }

    /**
     * Gets the library arena used for symbol lookups.
     * 
     * @return the Arena instance
     */
    public static Arena getLibraryArena() {
        return LIBRARY_ARENA;
    }
}
