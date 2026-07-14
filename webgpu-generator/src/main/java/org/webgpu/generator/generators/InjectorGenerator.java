package org.webgpu.generator.generators;

import javax.lang.model.element.Modifier;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.webgpu.generator.domain.YamlModel;

import com.palantir.javapoet.JavaFile;
import com.palantir.javapoet.MethodSpec;
import com.palantir.javapoet.TypeName;
import com.palantir.javapoet.TypeSpec;

public class InjectorGenerator {
    private final YamlModel yamlModel;
    private final String packageName;

    public static final String PROVIDER_CLASS_NAME = "WGPUProvider";
    public final String injectorFieldName = "INSTANCE_INJECTOR";

    private static final Logger logger = LoggerFactory.getLogger(InjectorGenerator.class);

    public InjectorGenerator(YamlModel yamlModel, String packageName) {
        this.yamlModel = yamlModel;
        this.packageName = packageName;
    }

    public JavaFile generate() {

        var injectorBuilder = TypeSpec.interfaceBuilder(PROVIDER_CLASS_NAME);

        addFunctions(injectorBuilder);

        injectorBuilder.addModifiers(Modifier.PUBLIC);
        return JavaFile.builder(packageName + ".spi", injectorBuilder.build()).build();
    }

    public void addFunctions(TypeSpec.Builder wgpuBuilder) {
        yamlModel.getFunctions().forEach(e -> logger.info("Generated function: {}", e.getName()));
        yamlModel.getFunctions().forEach(f -> {
            MethodSpec.Builder methodBuilder = MethodSpec.methodBuilder(Utils.toCamelCase(f.getName()))
                    .addModifiers(Modifier.PUBLIC, Modifier.ABSTRACT);

            final TypeName returnType = f.getReturns().map(r -> Utils.map(r.getType())).orElse(TypeName.VOID);

            for (var a : f.getArgs()) {

                if (a.getPointer().isPresent()) {
                    methodBuilder.addParameter(Utils.map(a.getType())
                            .annotated(Utils.mapPointer(a.getPointer().get())), Utils.toCamelCase(a.getName()));
                } else {
                    methodBuilder.addParameter(Utils.map(a.getType()), a.getName());
                }

            }
            f.getReturns().ifPresent(r -> methodBuilder.returns(Utils.map(r.getType())));

            wgpuBuilder.addMethod(methodBuilder.build());
        });
    }
}
