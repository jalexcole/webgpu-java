package org.webgpu.generator.generators;

import java.util.List;

import javax.lang.model.element.Modifier;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.webgpu.generator.domain.YamlModel;

import com.palantir.javapoet.ClassName;
import com.palantir.javapoet.JavaFile;
import com.palantir.javapoet.MethodSpec;
import com.palantir.javapoet.TypeName;
import com.palantir.javapoet.TypeSpec;

public class CallbackGenerator {
    private static final Logger logger = LoggerFactory.getLogger(CallbackGenerator.class);
    private String packageName;

    public CallbackGenerator(String packageName) {
        this.packageName = packageName;
    }

    public List<JavaFile> generateCallbacks(YamlModel yamlModel) {

        yamlModel.getCallbacks().stream().forEach(e -> logger.info("Generated callback: {}", e.getName()));

        return yamlModel.getCallbacks().stream().map(c -> {

            var callbackMethodBuilder = MethodSpec.methodBuilder("invoke")
                    .addModifiers(Modifier.PUBLIC, Modifier.ABSTRACT)

                    .returns(void.class);

            for (var a : c.getArgs()) {
                callbackMethodBuilder.addParameter(Utils.map(a.getType()), a.getName());
            }

            var callbackMethod = callbackMethodBuilder.build();

            TypeSpec callbackSpec = TypeSpec.interfaceBuilder(c.getName())
                    .addJavadoc(c.getDoc())
                    .addModifiers(Modifier.PUBLIC)

                    .addAnnotation(FunctionalInterface.class)

                    .addMethod(callbackMethod)
                    .build();
            logger.info("Created callback interface: \n{}", callbackSpec);
            return callbackSpec;
        }).map(typeSpec -> JavaFile.builder(packageName, typeSpec).build()).toList();
    }

    private TypeName mapType(String type) {
        logger.info("Mapping type: {}", type);
        String fixedType = type.replace("enum.", "");
        fixedType = fixedType.replace("object.", "fixedType");
        fixedType = fixedType.replace("struct.", "fixedType");
        return switch (type) {
            case "void" -> TypeName.VOID;
            case "int" -> TypeName.INT;
            case "long" -> TypeName.LONG;
            case "float" -> TypeName.FLOAT;
            case "double" -> TypeName.DOUBLE;
            case "boolean" -> TypeName.BOOLEAN;
            case "String" -> ClassName.get(String.class);
            default -> ClassName.get(packageName, fixedType);
        };
    }
}
