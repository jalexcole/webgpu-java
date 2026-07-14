package org.webgpu.generator.generators;

import java.lang.foreign.MemorySegment;
import java.util.Set;

import javax.lang.model.element.Modifier;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.webgpu.generator.domain.GpuStruct;
import org.webgpu.generator.domain.YamlModel;

import com.palantir.javapoet.JavaFile;
import com.palantir.javapoet.MethodSpec;
import com.palantir.javapoet.ParameterSpec;
import com.palantir.javapoet.TypeSpec;

public class StructSpiGenerator {
    private final YamlModel yamlModel;
    private final String packageName;
    private static final String SPI_PACKAGE = "spi";

    private static final Logger logger = LoggerFactory.getLogger(StructSpiGenerator.class);

    public StructSpiGenerator(YamlModel yamlModel, String packageName) {
        this.yamlModel = yamlModel;
        this.packageName = packageName;
    }

    public Set<JavaFile> generate() {
        return yamlModel.getStructs().stream().map(this::create).collect(java.util.stream.Collectors.toSet());
    }

    public JavaFile create(GpuStruct struct) {
        TypeSpec.Builder typeSpecBuilder = TypeSpec.interfaceBuilder(Utils.toPascalCase(struct.getName()) + "Provider");
        typeSpecBuilder.addModifiers(javax.lang.model.element.Modifier.PUBLIC);
        typeSpecBuilder.addMethod(MethodSpec.methodBuilder("initializer")
                .addModifiers(Modifier.PUBLIC, Modifier.ABSTRACT)
                .returns(MemorySegment.class)
                .build());

        // creating getter methods for each member of the struct
        for (var member : struct.getMembers()) {
            typeSpecBuilder.addMethod(MethodSpec.methodBuilder(Utils.toCamelCase(member.getName()))
                    .addParameter(ParameterSpec.builder(MemorySegment.class, "structPtr")
                        .build())
                    .addModifiers(Modifier.PUBLIC, Modifier.ABSTRACT)
                    .returns(Utils.map(member.getType()))
                    .build());
        }

        // creating setter methods for each member of the struct.
        struct.getMembers().forEach(m -> {
            typeSpecBuilder.addMethod(MethodSpec.methodBuilder(Utils.toCamelCase(m.getName()))
                    .addParameter(ParameterSpec.builder(MemorySegment.class, "structPtr")
                        .build())
                    .addParameter(Utils.map(m.getType()), Utils.toCamelCase(m.getName()))
                    .addModifiers(Modifier.PUBLIC, Modifier.ABSTRACT)
                    .build());
        });

        return JavaFile.builder(packageName + "." + SPI_PACKAGE, typeSpecBuilder.build()).build();
    }

}
