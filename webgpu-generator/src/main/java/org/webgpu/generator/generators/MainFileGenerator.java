package org.webgpu.generator.generators;

import javax.lang.model.element.Modifier;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.webgpu.generator.domain.YamlModel;

import com.palantir.javapoet.CodeBlock;
import com.palantir.javapoet.FieldSpec;
import com.palantir.javapoet.JavaFile;
import com.palantir.javapoet.TypeName;
import com.palantir.javapoet.TypeSpec;

public class MainFileGenerator {

    private final YamlModel yamlModel;
    private final String packageName;

    private static final Logger logger = LoggerFactory.getLogger(MainFileGenerator.class);

    public MainFileGenerator(YamlModel yamlModel, String packageName) {
        this.yamlModel = yamlModel;
        this.packageName = packageName;
    }

    public JavaFile generate() {

        var wgpuBuilder = TypeSpec.classBuilder("WGPU");
        addConstants(wgpuBuilder);

        return JavaFile.builder(packageName, wgpuBuilder.build()).build();
    }

    private void addConstants(TypeSpec.Builder wgpuBuilder) {

        yamlModel.getConstants().stream().forEach(e -> logger.info("Generated constant: {}", e.getName()));

        yamlModel.getConstants().stream().forEach(e -> {

            var fieldSpec = switch (e.getValue()) {
                case "uint32_max" -> FieldSpec
                        .builder(TypeName.INT, Utils.toScreamingSnakeCase(e.getName()), Modifier.PUBLIC, Modifier.STATIC, Modifier.FINAL)
                        .addJavadoc(e.getDoc()).initializer(CodeBlock.of("Integer.MAX_VALUE")).build();

                case "uint64_max" -> FieldSpec
                        .builder(TypeName.LONG, Utils.toScreamingSnakeCase(e.getName()), Modifier.PUBLIC, Modifier.STATIC, Modifier.FINAL)
                        .addJavadoc(e.getDoc()).initializer(CodeBlock.of("Long.MAX_VALUE")).build();

                case "usize_max" ->
                    FieldSpec.builder(TypeName.INT, Utils.toScreamingSnakeCase(e.getName()), Modifier.PUBLIC, Modifier.STATIC, Modifier.FINAL)
                            .addJavadoc(e.getDoc()).initializer(CodeBlock.of("Integer.MAX_VALUE")).build();

                default -> throw new IllegalStateException("Unknown constant value: " + e.getValue());
            };

            wgpuBuilder.addField(fieldSpec);

        });
    }
}
