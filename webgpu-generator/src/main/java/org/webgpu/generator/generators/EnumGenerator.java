package org.webgpu.generator.generators;

import java.util.List;

import com.palantir.javapoet.JavaFile;
import com.palantir.javapoet.TypeSpec;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.webgpu.generator.domain.YamlModel;

public class EnumGenerator {


    private YamlModel yamlModel;
	private String packageName;

    private static final Logger logger = LoggerFactory.getLogger(EnumGenerator.class);

    public EnumGenerator(YamlModel yamlModel, String packageName) {
        this.yamlModel = yamlModel;
        this.packageName = packageName;
    }
    

    public List<JavaFile> generate() {

        yamlModel.getEnums().stream().forEach(e -> logger.info("Generated enum: {}", e.getName()));

        return yamlModel.getEnums().stream().map(e -> {
            return TypeSpec.enumBuilder(e.getName()).addJavadoc(e.getDoc()).build();
        }).map(ts -> JavaFile.builder(packageName, ts).build()).toList();
    }
}
