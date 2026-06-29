package org.webgpu.generator.generators;

import javax.lang.model.element.Modifier;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.webgpu.generator.domain.YamlModel;
import org.webgpu.generator.domain.GpuStruct;
import org.webgpu.generator.domain.GpuStruct.Member;

import com.palantir.javapoet.CodeBlock;
import com.palantir.javapoet.FieldSpec;
import com.palantir.javapoet.JavaFile;
import com.palantir.javapoet.MethodSpec;
import com.palantir.javapoet.ParameterSpec;
import com.palantir.javapoet.TypeSpec;

public class StructGenerator {

    private final YamlModel yamlModel;
    private final String packageName;

    private static final Logger logger = LoggerFactory.getLogger(StructGenerator.class);

    public StructGenerator(YamlModel yamlModel, String packageName) {
        this.yamlModel = yamlModel;
        this.packageName = packageName;
    }

    public List<JavaFile> generate() {

        yamlModel.getStructs().forEach(e -> logger.info("Generated struct: {}", e.getName()));

        return yamlModel.getStructs().stream().map(e -> {
            return generateStructClass(e);
        }).map(ts -> JavaFile.builder(packageName, ts).build()).toList();

    }

    private TypeSpec generateStructRecord(GpuStruct e) {
        TypeSpec.Builder structSpecBuilder = TypeSpec.recordBuilder(Utils.toPascalCase(e.getName()))
                .addJavadoc(e.getDoc());

        MethodSpec.Builder constructorBuilder = MethodSpec.constructorBuilder();
        for (Member f : e.getMembers()) {
            final ParameterSpec.Builder parameterSpecBuilder = ParameterSpec
                    .builder(Utils.map(f.getType()), Utils.toCamelCase(f.getName())).addJavadoc(f.getDoc());
                    
            constructorBuilder.addParameter(
                    parameterSpecBuilder.build());
        }

        structSpecBuilder.recordConstructor(constructorBuilder.build());
        structSpecBuilder.addModifiers(Modifier.PUBLIC);
        return structSpecBuilder.build();
    }

    private TypeSpec generateStructClass(GpuStruct e) {
        final TypeSpec.Builder structSpecBuilder = TypeSpec.classBuilder(Utils.toPascalCase(e.getName()))
                .addJavadoc(e.getDoc());

        MethodSpec.Builder constructorBuilder = MethodSpec.constructorBuilder();
        constructorBuilder.addModifiers(Modifier.PUBLIC);
        for (Member f : e.getMembers()) {
            final ParameterSpec.Builder parameterSpecBuilder = ParameterSpec
                    .builder(Utils.map(f.getType()), Utils.toCamelCase(f.getName())).addJavadoc(f.getDoc());

            constructorBuilder.addParameter(
                    parameterSpecBuilder.build());
        }

        

        structSpecBuilder.addMethod(constructorBuilder.build());

        if (!e.getMembers().isEmpty()) {
            structSpecBuilder.addMethod(MethodSpec.constructorBuilder().addModifiers(Modifier.PUBLIC).build());
        }
        // Adding Fields.
        e.getMembers().forEach(m -> {
            final FieldSpec field = FieldSpec
                    .builder(Utils.map(m.getType()), Utils.toCamelCase(m.getName()), Modifier.PRIVATE)
                    // .initializer(CodeBlock.of("new $T()", Utils.map(m.getType())))
                    .build();
            
            structSpecBuilder.addField(field);
        });

        // Adding getters
        e.getMembers().forEach(m -> {
            final MethodSpec.Builder methodBuilder = MethodSpec.methodBuilder(Utils.toCamelCase(m.getName()))
                    .addModifiers(Modifier.PUBLIC)
                    .returns(Utils.map(m.getType()));
            methodBuilder.addStatement("return this.$N", Utils.toCamelCase(m.getName()));
            structSpecBuilder.addMethod(methodBuilder.build());
        });

        // Adding setters
        e.getMembers().forEach(m -> {
            final MethodSpec.Builder methodBuilder = MethodSpec.methodBuilder(Utils.toCamelCase(m.getName()))
                    .addModifiers(Modifier.PUBLIC)
                    .returns(void.class)
                    .addParameter(Utils.map(m.getType()), Utils.toCamelCase(m.getName()));
            methodBuilder.addStatement("this.$N = $N", Utils.toCamelCase(m.getName()), Utils.toCamelCase(m.getName()));
            structSpecBuilder.addMethod(methodBuilder.build());
        });



        structSpecBuilder.addModifiers(Modifier.PUBLIC);
        return structSpecBuilder.build();
    }
}
