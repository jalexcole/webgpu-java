package org.webgpu.generator.generators;

import java.util.ArrayList;
import java.util.List;

import javax.lang.model.element.Modifier;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.webgpu.annotations.Bitflag;
import org.webgpu.generator.domain.GpuBitflag;
import org.webgpu.generator.domain.YamlModel;
import com.palantir.javapoet.FieldSpec;
import com.palantir.javapoet.JavaFile;
import com.palantir.javapoet.MethodSpec;
import com.palantir.javapoet.TypeName;
import com.palantir.javapoet.TypeSpec;

public class BitflagGenerator {

    private YamlModel yamlModel;
    private String packageName;
    private static final Logger logger = LoggerFactory.getLogger(BitflagGenerator.class);

    public BitflagGenerator(YamlModel yamlModel, String packageName) {
        this.yamlModel = yamlModel;
        this.packageName = packageName;
    }

    public List<JavaFile> generate() {
        List<JavaFile> javaFiles = new ArrayList<>();

        yamlModel.getBitflags().stream().map(this::generateBitflag)
                .map(ts -> JavaFile.builder(packageName, ts).build()).forEach(javaFiles::add);

        if (!yamlModel.getBitflags().isEmpty()) {
            javaFiles.add(JavaFile.builder(packageName, generateWGPUBitflag()).build());
        }

        return javaFiles;
    }

    private TypeSpec generateBitflag(GpuBitflag gpuBitflag) {
        var bitFlagBuilder = TypeSpec.enumBuilder(Utils.toPascalCase(gpuBitflag.getName()))
                .addModifiers(Modifier.PUBLIC)
                .addJavadoc(gpuBitflag.getDoc()).addAnnotation(Bitflag.class).addSuperinterface(Utils.map("BitFlag"));
        bitFlagBuilder.addSuperinterface(Utils.map("WGPUBitflag"));
        for (int i = 0; i < gpuBitflag.getEntries().size(); i++) {
            logger.info("Generated bitflag: {}", gpuBitflag.getEntries().get(i).getName());
            bitFlagBuilder.addEnumConstant(gpuBitflag.getEntries().get(i).getName().toUpperCase(),
                    TypeSpec.anonymousClassBuilder("$L", (i != 0 ? 1 << (i - 1) : 0)).build());
        }

        bitFlagBuilder.addField(FieldSpec.builder(TypeName.LONG, "value", Modifier.PRIVATE, Modifier.FINAL).build());
        bitFlagBuilder.addMethod(MethodSpec.constructorBuilder().addParameter(TypeName.LONG, "value")
                .addCode("this.value = value;").addModifiers(Modifier.PRIVATE).build());
        bitFlagBuilder.addMethod(MethodSpec.methodBuilder("value").addModifiers(Modifier.PUBLIC)
                .addAnnotation(Override.class).returns(TypeName.LONG)
                .addStatement("return value").build());

        return bitFlagBuilder.build();
    }
    
    private TypeSpec generateWGPUBitflag() {
        var builder = TypeSpec.interfaceBuilder("WGPUBitflag");

        builder.addModifiers(Modifier.PUBLIC, Modifier.SEALED);
        yamlModel.getBitflags().forEach(flag -> {
            builder.addPermittedSubclass(Utils.map(Utils.toPascalCase(flag.getName())));
        });

        builder.addMethod(MethodSpec.methodBuilder("value").addModifiers(Modifier.PUBLIC, Modifier.ABSTRACT)
                .returns(TypeName.LONG).build());

        return builder.build();


    }

}
