package org.webgpu.generator.generators;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.webgpu.generator.domain.YamlModel;
import org.webgpu.generator.domain.GpuStruct.Member;

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
        
        yamlModel.getStructs().stream().forEach(e -> logger.info("Generated struct: {}", e.getName()));


        return yamlModel.getStructs().stream().map(e -> {
            TypeSpec.Builder structSpecBuilder = TypeSpec.recordBuilder(Utils.toPascalCase(e.getName())).addJavadoc(e.getDoc());
            
            
            MethodSpec.Builder constructorBuilder = MethodSpec.constructorBuilder();
            for (Member f : e.getMembers()) {
                constructorBuilder.addParameter(
                        ParameterSpec.builder(Utils.map(f.getType()), f.getName()).addJavadoc(f.getDoc()).build());
            }

            structSpecBuilder.recordConstructor(constructorBuilder.build());
            
            return structSpecBuilder.build();
        }).map(ts -> JavaFile.builder(packageName, ts).build()).toList();

    }
}
