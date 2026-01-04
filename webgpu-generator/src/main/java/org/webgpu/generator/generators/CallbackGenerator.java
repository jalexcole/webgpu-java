package org.webgpu.generator.generators;

import java.util.List;

import javax.lang.model.element.Modifier;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.webgpu.generator.domain.YamlModel;

import com.palantir.javapoet.JavaFile;
import com.palantir.javapoet.MethodSpec;
import com.palantir.javapoet.TypeName;
import com.palantir.javapoet.TypeSpec;

import jpassport.Passport;

public class CallbackGenerator {
    private static final Logger logger = LoggerFactory.getLogger(CallbackGenerator.class);
    private String packageName;

    public CallbackGenerator(String packageName) {
        this.packageName = packageName;
    }

    public List<JavaFile> generateCallbacks(YamlModel yamlModel) {

        yamlModel.getCallbacks().stream().forEach(e -> logger.info("Generated callback: {}", e.getName()));

        return yamlModel.getCallbacks().stream().map(c -> {

            MethodSpec.Builder callbackMethodBuilder = MethodSpec.methodBuilder("invoke")
                    .addModifiers(Modifier.PUBLIC, Modifier.ABSTRACT)

                    .returns(void.class);

            for (var a : c.getArgs()) {
                final TypeName typeName;
                if (a.getType().contains("bitflag.")) {
                    typeName = Utils.boxEnumSet(Utils.map(a.getType()));
                } else {
                    typeName = Utils.map(a.getType());
                }
                
                callbackMethodBuilder.addParameter(typeName, a.getName());
            }

            var callbackMethod = callbackMethodBuilder.build();

            TypeSpec callbackSpec = TypeSpec.interfaceBuilder(Utils.toPascalCase(c.getName()))
                    .addJavadoc(c.getDoc())
                    .addModifiers(Modifier.PUBLIC)

                    .addAnnotation(FunctionalInterface.class)

                    .addMethod(callbackMethod)
                    .addSuperinterface(Passport.class)
                    .build();
            logger.info("Created callback interface: \n{}", callbackSpec);
            return callbackSpec;
        }).map(typeSpec -> JavaFile.builder(packageName, typeSpec).build()).toList();
    }
}
