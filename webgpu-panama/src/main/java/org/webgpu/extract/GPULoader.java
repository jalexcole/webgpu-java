package org.webgpu.foriegn;


import java.net.URISyntaxException;
import java.nio.file.Path;

public class GPULoader {
    static {
        ClassLoader loader = GPULoader.class.getClassLoader();
        var nativeResources = loader.getResource("resources/natives/");
        final Path path;
		try {
            path = Path.of(nativeResources.toURI());
            for (var file : path.toFile().listFiles()) {
                if (file.isFile()) {
                    System.out.println(file.getName());
                    System.load(file.getAbsolutePath());
                }
            }
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
        

        

    }

    public static void initialize() {
        // does nothing.
    }

    public static void main(String[] args) {
        GPULoader.initialize();
    }
}
