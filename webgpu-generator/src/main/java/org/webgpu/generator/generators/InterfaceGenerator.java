package org.webgpu.generator.generators;

import java.util.List;

import javax.lang.model.element.Modifier;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.webgpu.generator.domain.YamlModel;

import com.palantir.javapoet.JavaFile;
import com.palantir.javapoet.MethodSpec;
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
            var typeSpecBuilder = TypeSpec.interfaceBuilder(i.getName()).addJavadoc(i.getDoc())
                    .addSuperinterface(Passport.class);

            for (var m : i.getMethods()) {
                var methodSpecBuilder = MethodSpec.methodBuilder(m.getName()).addJavadoc(m.getDoc());

                for (var a : m.getArgs()) {
                    methodSpecBuilder.addParameter(Utils.map(a.getType()), a.getName());
                }

                m.getReturns().ifPresent(r -> {
                    methodSpecBuilder.returns(Utils.map(r.getType()));
                });
                methodSpecBuilder.addModifiers(Modifier.PUBLIC, Modifier.ABSTRACT);
                typeSpecBuilder.addMethod(methodSpecBuilder.build());

            }

            return typeSpecBuilder.build();
        }).map(ts -> JavaFile.builder(packageName, ts).build()).toList();

    }
}
