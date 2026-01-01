package org.webgpu.generator.generators;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.webgpu.generator.domain.YamlModel;

import com.palantir.javapoet.JavaFile;
import com.palantir.javapoet.TypeSpec;

import jpassport.Passport;

public class InterfaceGenerator {
    private final YamlModel yamlModel;
    private final String packageName;
    private static final Logger logger = LoggerFactory.getLogger(InterfaceGenerator.class);

    public InterfaceGenerator(YamlModel yamlModel, String packageName) {
        this.yamlModel = yamlModel;
        this.packageName = packageName;
    }

    public List<JavaFile> generate() {

        return yamlModel.getObjects().stream().map(i -> {
            return TypeSpec.interfaceBuilder(i.getName()).addJavadoc(i.getDoc()).addSuperinterface(Passport.class)
                    .build();
        }).map(ts -> JavaFile.builder(packageName, ts).build()).toList();

    }
}
