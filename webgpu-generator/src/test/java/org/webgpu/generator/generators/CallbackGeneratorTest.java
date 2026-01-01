package org.webgpu.generator.generators;

import java.io.File;

import org.junit.jupiter.api.Test;
import org.webgpu.generator.domain.YamlModel;

import tools.jackson.databind.ObjectMapper;
import tools.jackson.dataformat.yaml.YAMLFactory;

public class CallbackGeneratorTest {
    
    @Test
    public void test() {
        final ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());
        var yaml = objectMapper.readTree(new File("../wgpu-native/ffi/webgpu-headers/webgpu.yml"));
        // System.out.println(yaml.toPrettyString());

        YamlModel yamlModel = objectMapper.convertValue(yaml, YamlModel.class);

        // System.out.println(yamlModel);
        CallbackGenerator callbackGenerator = new CallbackGenerator("org.webgpu.generator");
        var enumFiles = callbackGenerator.generateCallbacks(yamlModel);
    }
}
