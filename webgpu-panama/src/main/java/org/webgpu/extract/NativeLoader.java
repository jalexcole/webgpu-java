package org.webgpu.foriegn;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class NativeLoader {
    public static void loadLibraryFromResources(String resourcePath) {
        try {
            // Get the resource as a stream
            InputStream in = NativeLoader.class.getResourceAsStream(resourcePath);
            if (in == null) {
                throw new IllegalArgumentException("Library not found in resources: " + resourcePath);
            }

            // Create a temporary file
            File tempLib = File.createTempFile("libtemp", ".dylib"); // Use `.so` or `.dll` as needed
            tempLib.deleteOnExit();

            // Write the contents to the temp file
            try (FileOutputStream out = new FileOutputStream(tempLib)) {
                in.transferTo(out);
            }

            // Load the library
            System.load(tempLib.getAbsolutePath());
        } catch (IOException e) {
            throw new RuntimeException("Failed to load native library", e);
        }
    }
}